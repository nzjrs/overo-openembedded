require osm-gps-map.inc

PR = "r1"

SRC_URI = " \
    http://open.grcnz.com/downloads/osm-gps-map/osm-gps-map-${PV}.tar.gz \
    file://change-cachedir.patch;patch=1 \
    file://70osmgpsmap \
"

CONFFILES_${PN} += "${sysconfdir}/X11/Xsession.d/70osmgpsmap"

do_install_append () {
	install -d ${D}/${sysconfdir}/X11/Xsession.d
	install -m 0755 ${WORKDIR}/70osmgpsmap ${D}/${sysconfdir}/X11/Xsession.d/70osmgpsmap
}

#do_install_append () {
#	install -d ${D}/${sysconfdir}/X11/Xsession.d
#	install -m 0755 /home/john/beagle/oe/local/packages/osm-gps-map/files/70osmgpsmap ${D}/${sysconfdir}/X11/Xsession.d/70osmgpsmap
#}


