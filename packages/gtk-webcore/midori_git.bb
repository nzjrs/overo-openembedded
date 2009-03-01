require midori.inc

DEPENDS += "python-native python-docutils-native"

# increment PR every time SRCREV is updated!
PR = "r0"
PV = "0.1.2+${PR}+gitr${SRCREV}"

SRC_URI = "http://git.xfce.org/kalikiana/midori/snapshot/midori-${SRCREV}.tar.bz2"
S = "${WORKDIR}/midori-${SRCREV}"

do_configure() {
	./configure \
            --prefix=${prefix} \
            --bindir=${bindir} \
            --sbindir=${sbindir} \
            --libexecdir=${libexecdir} \
            --datadir=${datadir} \
            --sysconfdir=${sysconfdir} \
            --sharedstatedir=${sharedstatedir} \
            --localstatedir=${localstatedir} \
            --libdir=${libdir} \
            --includedir=${includedir} \
            --infodir=${infodir} \
            --mandir=${mandir} \
            ${EXTRA_OECONF} 
 
	sed -i /LINK_CC/d ./_build_/c4che/default.cache.py 
	echo "LINK_CC = '${CXX}'" >>  ./_build_/c4che/default.cache.py
}



