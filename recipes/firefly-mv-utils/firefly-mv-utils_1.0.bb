DESCRIPTION = "Test Utilities for Firefly MV Cameras"
HOMEPAGE = "http://github.com/nzjrs/firefly-mv/tree/master"
SECTION = "console/utils"
PRIORITY = "optional"
LICENSE = "GPL"
PR = "r9"

DEPENDS = "libdc1394 gtk+"

EXTRA_OECONF += " --enable-gtk"

SRCREV = "5dc9e92246712e203985202ce49d0816e56abc20"
SRC_URI = "git://github.com/nzjrs/firefly-mv.git;protocol=git;branch=master"

S = "${WORKDIR}/git"

inherit autotools

