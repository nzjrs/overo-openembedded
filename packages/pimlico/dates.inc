DESCRIPTION = "Dates is a calendar application."
LICENSE = "LGPL"
SECTION = "x11"
DEPENDS = "glib-2.0 gtk+ libglade eds-dbus"
RDEPENDS = "libedata-cal"
RCONFLICTS_${PN} = "openmoko-dates"

inherit autotools pkgconfig gtk-icon-cache

# EXTRA_OECONF = "--disable-debug"
EXTRA_OECONF = "--enable-owl=true"

FILES_${PN} += "${datadir}/pixmaps/dates.png"

do_install_append () {
	install -d ${D}/${datadir}/pixmaps
	install -m 0644 ${D}/${datadir}/icons/hicolor/48x48/apps/dates.png ${D}/${datadir}/pixmaps/
}

PRIVATE_LIBS = "libgtkdatesview.so.0"