DESCRIPTION = "Simple Video Viewer"
HOMEPAGE = "http://github.com/nzjrs/simple-video-viewer/tree/master"
LICENSE = "GPLv2"
SECTION = "x/games"
PRIORITY = "optional"

DEPENDS="libv4l gtk+"

PR = "r2"

SRCREV = "ef1670ba799c407ce52f2e1d53ae655124072af6"
SRC_URI = "git://github.com/nzjrs/simple-video-viewer.git;protocol=git;branch=master"

S = "${WORKDIR}/git"

inherit autotools
