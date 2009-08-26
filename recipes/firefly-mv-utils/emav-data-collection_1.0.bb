DESCRIPTION = "Test Utilities for Firefly MV Cameras"
HOMEPAGE = "http://github.com/nzjrs/firefly-mv/tree/master"
SECTION = "console/utils"
PRIORITY = "optional"
LICENSE = "GPL"
PR = "r5"

DEPENDS = "libdc1394 gtk+"

EXTRA_OECONF += " --enable-gtk"

SRCREV = "829ea00661deb1d0224dad6956604223902bbae5"
SRC_URI = "git://github.com/nzjrs/firefly-mv.git;protocol=git;branch=emav09"

S = "${WORKDIR}/git"

inherit autotools

