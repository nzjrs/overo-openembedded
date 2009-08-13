DESCRIPTION = "Test Utilities for Firefly MV Cameras"
HOMEPAGE = "http://github.com/nzjrs/firefly-mv/tree/master"
SECTION = "console/utils"
PRIORITY = "optional"
LICENSE = "GPL"
PR = "r3"

DEPENDS = "libdc1394 gtk+"

EXTRA_OECONF += " --enable-gtk"

SRCREV = "8102d407dcbc91a0bc10b5deb0a7f385c07a8361"
SRC_URI = "git://github.com/nzjrs/firefly-mv.git;protocol=git;branch=emav09"

S = "${WORKDIR}/git"

inherit autotools

