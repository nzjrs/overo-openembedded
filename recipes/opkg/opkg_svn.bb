require opkg.inc

PR = "r2"

PACKAGES =+ "libopkg-dev libopkg"

FILES_libopkg-dev = "${libdir}/*.a ${libdir}/*.la ${libdir}/*.so"
FILES_libopkg = "${libdir}/*.so.*"

# Define a variable to allow distros to run configure earlier.
# (for example, to enable loading of ethernet kernel modules before networking starts)
OPKG_INIT_POSITION = "98"
OPKG_INIT_POSITION_slugos = "41"

pkg_postinst_${PN} () {
#!/bin/sh
if [ "x$D" != "x" ]; then
	install -d $D${sysconfdir}/rcS.d
	# this happens at S98 where our good 'ole packages script used to run
	echo "#!/bin/sh
opkg-cl configure
rm -f ${sysconfdir}/rcS.d/S${OPKG_INIT_POSITION}configure
" > $D${sysconfdir}/rcS.d/S${OPKG_INIT_POSITION}configure
	chmod 0755 $D${sysconfdir}/rcS.d/S${OPKG_INIT_POSITION}configure
fi

update-alternatives --install ${bindir}/opkg opkg ${bindir}/opkg-cl 100
}

pkg_postrm_${PN} () {
#!/bin/sh
update-alternatives --remove opkg ${bindir}/opkg-cl
}

