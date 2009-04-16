#!/bin/bash

# Angstrom feed sorting script
# This must be run in unsorted/ directory 

if [ $(basename $PWD) != "unsorted" ] ; then
	echo "Not in feed dir! Exiting"
	exit 1
fi	

if [ $(find . -name "*.ipk" | wc -l) -gt 0 ] ; then
	echo "Unsorted packages found"
else
	echo "No unsorted packages found. Exiting"
	exit 1
fi

rm Packages* >& /dev/null

# Find ipkg files in unsorted/ and remove stale ones
echo "Deleting morgue directories "
find . -name morgue | xargs rm -rf 
echo "Moving packages to the top level directory"
find */ -name  "*.ipk" -exec mv  '{}'  ./ \;

# Make a list of ipkg files already present in feeds and in unsorted
echo "Making a list of unsorted packages"
for i in $(find . -name "*.ipk") ; do basename $i ; done > files-unsorted
# Make a list of duplicates and delete those
echo "Finding duplicate packages in unsorted"
cat files-sorted files-unsorted | sort | uniq -d > files-duplicate
echo "Removing duplicate packages in unsorted"
cat files-duplicate | xargs rm -f

# Log remaining packages to a file 
find . -name "*.ipk" |grep -v dbg | grep -v -- -dev | grep -v -- -doc | grep -v angstrom-version | grep -v locale > new-files.txt
for newfile in $(cat new-files.txt | sed s:./::g) ; do
    echo "$(date -u +%s) $newfile $(basename ${PWD})" >> ../upload-full.txt
done    
tail -n 100 ../upload-full.txt > ../upload.txt

do_sort() {
archdir=$arch

case "$arch" in
	"arm-oabi")
			machines="h3600 h3800 collie simpad htcwallaby" ;;
	"armv4t")
			machines="ep93xx h6300 om-gta01 om-gta02 fic-gta01 fic-gta02" ;;
	"armv5te")
			machines="sheevaplug dm355-leopard n2100 dns323 mv2120 kuropro lspro tsx09 ts409 davinci-dvevm davinci-sffsdr neuros-osd neuros-osd2 gumstix-connex gumstix-verdex gumstix e680 a780 a1200 at91sam9263ek rokre6 rokre2 rokr-e2 akita c7x0 h2200 h3900 h4000 h5000 htcapache htctornado htcblueangel htcuniversal hx4700 nslu2le hx2000 ixp4xxle magician netbook-pro nokia770 palmt650 palmt680 palmld palmtx palmtt3 palmz72 qemuarm omap5912osk poodle spitz tosa" ;;
	"armv5teb")
			machines="ixp4xxbe nslu2be" ;;
	"armv6-novfp")
			machines="htcdiamond htckaiser htcpolaris htcraphael htcvogue" ;;	
	"armv6")	
			machines="mx31ads nokia800 " ;;
	"armv7")
			machines="" ;;
	"armv7a")
			machines="beagleboard omap3evm omap3-pandora omapzoom overo" ;;
	"avr32")
			machines="atngw100 at32stk1000" ;;
	"bfin")
			archdir="blackfin"
			machines="adsp-bf537-stamp" ;;
	"geode")
			machines="alix" ;;
	"i486")
			machines="x86" ;;
	"i586")
			machines="epia qemux86" ;;
	"i686")
			machines="guinness progear" ;;
	"iwmmxt")
			machines="" ;;
	"ppc405")	
			machines="dht-walnut" ;;
	"ppc603e")
			machines="lsppchd lsppchg efika n1200" ;;
	"ppce300c3")
			machines="mpc8313e-rdb mpc8315e-rdb" ;;
	"sparc")
			machines="" ;;
esac

echo "Sorting $arch"
for i in `find . -name  "*.ipk"| grep $arch` ; do mkdir -p ../$archdir/base/ || true ;mv $i ../$archdir/base/ ; done
        for machine in $machines ; do
                for i in `find . -name  "*_$machine.ipk"| grep $machine` ; do mkdir -p ../$archdir/machine/$machine || true ;mv $i ../$archdir/machine/$machine ; done
	done
( mkdir -p ../$archdir ; cd ../$archdir && do_index )

}

do_index() {
ipkg_tools_path="/home/angstrom/bin"
echo "Processing $(basename $PWD) packages...."

BPWD=`pwd`

mkdir -p base
cd base

mkdir -p ../debug ../perl ../python ../gstreamer ../locales/en || true

#split the feeds based on names
mv python* ../python/ >& /dev/null
mv perl* ../perl/ >& /dev/null
mv *-dbg* ../debug/ >& /dev/null
mv gst* ../gstreamer >& /dev/null

for i in ../* ; do
  if [ -d $i ]; then
      cd $i
      echo -n "building index for $i:" |sed s:\.\./::
      ${ipkg_tools_path}/ipkg-make-index -p Packages -l Packages.filelist  -m -L ../locales  . >& /tmp/index-log
      echo " DONE"
  fi
done
mkdir -p  ${BPWD}/machine
cd ${BPWD}/machine

for i in ./* ; do
  if [ -d $i ]; then
     cd $i
     echo -n "building index for machine $i:"
     ${ipkg_tools_path}/ipkg-make-index -p Packages -l Packages.filelist  -m  . >& /dev/null
     echo " DONE"
     cd ../
  fi
done

mkdir -p ${BPWD}/locales/en/
cd ${BPWD}/locales/en/
echo -n "building index for locales:"
for i in ../* ; do
  if [ -d $i ]; then
   echo -n " $i" |sed s:\.\./::
   ${ipkg_tools_path}/ipkg-make-index -p Packages -l Packages.filelist  -m . >& /dev/null;
   cd $i
  fi
 done
echo " DONE"
cd ${BPWD}

}

echo "Processing 'all' feed"
for i in `find . -name  "*.ipk"| grep _all` ; do mkdir -p ../all/ || true ;mv $i ../all/ ; done
 (mkdir -p ../all ; cd ../all && ipkg-make-index -p Packages -m . >& /dev/null ; touch Packages.sig )  

for arch in arm-oabi armv4t armv5teb armv5te armv6-novfp armv6 armv7a armv7 avr32 bfin geode i486 i586 i686 iwmmxt ppc405 ppc603e sparc ; do 
	do_sort
done

if [ "$1" != "--skip-sorted-list" ]; then
    echo "Updating list of sorted packages (takes long)"
    for i in $(find ../ -name "*.ipk"| grep -v unsorted) ; do basename $i ; done > files-sorted
fi

( cd ~/website/repo-updater ; php update.php ; rm ../repo/feeds.db* ; cp feeds.db* ../repo )

echo -n "Stripping source lines from Package files"
for i in `find .. -name Packages` ; do grep -v ^Source: $i|gzip -c9>$i.gz ;gunzip -c $i.gz>$i ; touch $i.sig ; done
echo " DONE"


