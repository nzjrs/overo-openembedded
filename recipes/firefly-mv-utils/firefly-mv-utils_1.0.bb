DESCRIPTION = "Test Utilities for Firefly MV Cameras"
HOMEPAGE = "http://github.com/nzjrs/firefly-mv/tree/master"
SECTION = "console/utils"
PRIORITY = "optional"
LICENSE = "GPL"
PR = "r7"

DEPENDS = "libdc1394 gtk+"

#FIXME: Why are these lines necessary?, why isnt pkg-config in the
#Makefile sufficient?
CFLAGS_append = " $(pkg-config --cflags gtk+-2.0)"
LIBS_append = " $(pkg-config --libs gtk+-2.0)"

SRCREV = "778d62c142221e878a3e09a931165bad43e97540"
SRC_URI = "git://github.com/nzjrs/firefly-mv.git;protocol=git;branch=master"

inherit pkgconfig

S = "${WORKDIR}/git"

do_compile() {
	oe_runmake
}

do_install () {
	install -d ${D}${bindir}
	install -m 0755 dc1394-camls ${D}${bindir}/
	install -m 0755 dc1394-show ${D}${bindir}/
	install -m 0755 dc1394-view ${D}${bindir}/
	install -m 0755 dc1394-record ${D}${bindir}/
	install -m 0755 dc1394-play ${D}${bindir}/
}
