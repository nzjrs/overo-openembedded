DESCRIPTION = "Test Utilities for Firefly MV Cameras"
HOMEPAGE = "http://github.com/nzjrs/firefly-mv/tree/master"
SECTION = "console/utils"
PRIORITY = "optional"
LICENSE = "GPL"
PR = "r8"

DEPENDS = "libdc1394 gtk+"

EXTRA_OECONF += " --enable-gtk"

SRCREV = "ea02556c34d7e846fc1882d13a2d0ccbfc361123"
SRC_URI = "git://github.com/nzjrs/firefly-mv.git;protocol=git;branch=master"

S = "${WORKDIR}/git"

inherit autotools

