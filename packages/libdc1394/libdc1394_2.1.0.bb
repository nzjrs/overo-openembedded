DESCRIPTION = "libdc1394"
HOMEPAGE = "http://sourceforge.net/projects/libdc1394"
SECTION = "libs"
LICENSE = "LGPLv2"
PR = "r1"

DEPENDS = "libusb1 libraw1394"

EXTRA_OECONF = "--disable-doxygen-docs"
SRC_URI = "${SOURCEFORGE_MIRROR}/libdc1394/libdc1394-${PV}.tar.gz"

inherit autotools
