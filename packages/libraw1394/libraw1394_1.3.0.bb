DESCRIPTION = "IEEE 1394 for Linux"
HOMEPAGE = "http://www.linux1394.org"
SECTION = "libs"
LICENSE = "LGPLv2"
PR = "r1"

SRC_URI = "http://www.linux1394.org/dl/libraw1394-${PV}.tar.gz"

inherit autotools pkgconfig
