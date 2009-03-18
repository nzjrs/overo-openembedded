DESCRIPTION = "Test Utilities for Firefly MV Cameras"
HOMEPAGE = "http://github.com/nzjrs/firefly-mv/tree/master"
SECTION = "console/utils"
PRIORITY = "optional"
LICENSE = "GPL"
PR = "r2"

DEPENDS = "libdc1394"

SRCREV = "1abb76a05095c846111e08adbbe003857b5e86d7"
SRC_URI = "git://github.com/nzjrs/firefly-mv.git;protocol=git;branch=master"

inherit pkgconfig

S = "${WORKDIR}/git"

do_compile() {
	oe_runmake camls record-gray
}

do_install () {
	install -d ${D}${bindir}
	install -m 0755 camls ${D}${bindir}/
	install -m 0755 record-gray ${D}${bindir}/
}
