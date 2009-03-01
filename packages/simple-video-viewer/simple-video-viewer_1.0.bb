DESCRIPTION = "Simple Video Viewer"
HOMEPAGE = "http://github.com/nzjrs/simple-video-viewer/tree/master"
LICENSE = "GPLv2"
SECTION = "x/games"
PRIORITY = "optional"

DEPENDS="libv4l"

PR = "r1"

SRCREV = "dedf6cb62d0bfe234dae84e8e5dacdc934e59bad"
SRC_URI = "git://github.com/nzjrs/simple-video-viewer.git;protocol=git;branch=master"

S = "${WORKDIR}/git"

inherit autotools
