DESCRIPTION = "Test Utilities for Firefly MV Cameras"
HOMEPAGE = "http://github.com/nzjrs/firefly-mv/tree/master"
SECTION = "console/utils"
PRIORITY = "optional"
LICENSE = "GPL"
PR = "r1"

DEPENDS = "libdc1394"

SRCREV = "a72f8669a43533c66aa7efc3a44cdfc5a4b75118"
SRC_URI = "git://github.com/nzjrs/firefly-mv.git;protocol=git;branch=master"

inherit pkgconfig

S = "${WORKDIR}/git"

do_compile() {
	oe_runmake camls
}

do_install () {
	install -d ${D}${bindir}
	install -m 0755 camls ${D}${bindir}/
}
