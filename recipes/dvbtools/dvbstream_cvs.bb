SECTION = "console/multimedia"
PRIORITY = "optional"
LICENSE = "GPLV2"
DEPENDS = "libxml2"
PV = "0.0+cvs${SRCDATE}"

SRC_URI = "cvs://anonymous@dvbtools.cvs.sourceforge.net/cvsroot/dvbtools;module=dvbstream"
S = "${WORKDIR}/dvbstream"

CFLAGS_append = " -D_GNU_SOURCE"

do_install() {
	mkdir -p ${D}${bindir}
	for i in dvbstream dumprtp ts_filter rtpfeed; do install -m 0755 $i ${D}${bindir}/; done
}
