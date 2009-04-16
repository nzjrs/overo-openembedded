inherit gpe

DEPENDS = "gtk+ librsvg"
SECTION = "gpe"
PRIORITY = "optional"
LICENSE = "GPL"
PR = "r2"

SRC_URI += "file://splash-p.svg file://splash-l.svg"

FILES_${PN} += "${datadir}/gpe"

do_install_append() {
	install -m 0644 ${WORKDIR}/splash-p.svg ${D}${datadir}/gpe/splash-p.svg
	install -m 0644 ${WORKDIR}/splash-l.svg ${D}${datadir}/gpe/splash-l.svg
	mv ${D}${sysconfdir}/rcS.d/S00bootsplash ${D}${sysconfdir}/rcS.d/S02bootsplash
}

