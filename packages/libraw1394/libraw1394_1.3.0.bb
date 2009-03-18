DESCRIPTION = "IEEE 1394 for Linux"
HOMEPAGE = "http://www.linux1394.org"
SECTION = "libs"
LICENSE = "LGPLv2"
PR = "r3"

SRC_URI = "http://www.linux1394.org/dl/libraw1394-${PV}.tar.gz"

do_stage() {
    autotools_stage_all
}

inherit autotools pkgconfig lib_package
