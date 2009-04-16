DESCRIPTION = "Swfdec plugin for browsers using NPAPI. Swfdec is a decoder/renderer for Macromedia Flash animations."
LICENSE = "LGPL"

DEPENDS = "gst-ffmpeg swfdec gstreamer libsoup-2.4 pango cairo liboil zlib gtk+ alsa-lib \
           ${@base_conditional('ENTERPRISE_DISTRO', '1', '', 'libmad', d)}"
RDEPENDS = "gst-ffmpeg"

SRC_URI = "http://swfdec.freedesktop.org/download/swfdec-mozilla/0.9/${P}.tar.gz \
"

inherit autotools pkgconfig 

do_stage() {
	autotools_stage_all
}

FILES_${PN} += "${datadir}/icons ${libdir}/mozilla/plugins/*.so"
FILES_${PN}-dev += "${libdir}/mozilla/plugins/*a"
FILES_${PN}-dbg += "${libdir}/mozilla/plugins/.debug"

