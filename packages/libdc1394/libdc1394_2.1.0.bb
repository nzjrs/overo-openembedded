DESCRIPTION = "1394-based DC Control Library"
HOMEPAGE = "http://sourceforge.net/projects/libdc1394"
SECTION = "libs"
LICENSE = "LGPLv2"
PR = "r1"

DEPENDS = "libusb1 libraw1394"
EXTRA_OECONF = "--disable-doxygen-docs"

SRC_URI = " \
    ${SOURCEFORGE_MIRROR}/libdc1394/libdc1394-${PV}.tar.gz \
    file://configure-use-pkgconfig-to-find-libraw1394.patch;patch=1 \
"

inherit autotools pkgconfig
