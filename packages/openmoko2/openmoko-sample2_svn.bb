DESCRIPTION = "The OpenMoko Sample Project"
SECTION = "openmoko/applications"
DEPENDS = "libmokoui2 intltool gconf"
PV = "0.0.1+svnr${SRCREV}"
PR = "r0"

inherit openmoko2

PACKAGES += "${PN}-src"
# path should match the toolchain path
FILES_${PN}-src = "/usr/local/openmoko"
PACKAGE_ARCH_${PN}-src = "all"

do_configure_prepend() {
	install -d ${WORKDIR}/source
	cp -a ${S} ${WORKDIR}/source/
	find ${WORKDIR}/source -name ".svn"|xargs rm -rf
}

do_install_append() {
	install -d ${D}/usr/local/openmoko/source/
	cp -a ${WORKDIR}/source/* ${D}/usr/local/openmoko/source/
}
