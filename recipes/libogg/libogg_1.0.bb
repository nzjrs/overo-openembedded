SECTION = "libs"
DESCRIPTION = "libogg is the bitstream and framing library \
for the Ogg project. It provides functions which are \
necessary to codec libraries like libvorbis."
LICENSE = "BSD"
PR = "r1"

SRC_URI = "http://www.vorbis.com/files/${PV}/unix/libogg-${PV}.tar.gz"

inherit autotools pkgconfig

do_stage () {
	oe_libinstall -a -so -C src libogg ${STAGING_LIBDIR}

	install -d ${STAGING_INCDIR}/ogg
	(cd ${S}/include/ogg; cp config_types.h ogg.h os_types.h ${STAGING_INCDIR}/ogg/)
	install -m 0644 ${S}/ogg.m4 ${STAGING_DATADIR}/aclocal/
}
