DESCRIPTION = "Test Utilities for Firefly MV Cameras"
HOMEPAGE = "http://github.com/nzjrs/firefly-mv/tree/master"
SECTION = "console/utils"
PRIORITY = "optional"
LICENSE = "GPL"
PR = "r0"

DEPENDS = "libdc1394 gtk+"

#FIXME: Why are these lines necessary?, why isnt pkg-config in the
#Makefile sufficient?
CFLAGS_append = " $(pkg-config --cflags gtk+-2.0)"
LIBS_append = " $(pkg-config --libs gtk+-2.0)"

SRCREV = "c5525373ed46b5b2c5fe21c4ed4c95558bef069c"
SRC_URI = "git://github.com/nzjrs/firefly-mv.git;protocol=git;branch=emav09"

inherit pkgconfig

S = "${WORKDIR}/git"

do_compile() {
	oe_runmake -f Makefile.ppz
}

do_install () {
	install -d ${D}${bindir}
	install -m 0755 pprz-record ${D}${bindir}/
	install -m 0755 pprz-play ${D}${bindir}/
}
