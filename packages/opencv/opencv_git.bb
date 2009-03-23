DESCRIPTION = "Opencv : The Open Computer Vision Library"
HOMEPAGE = "http://sourceforge.net/projects/opencvlibrary"
SECTION = "libs"
PRIORITY = "optional"
LICENSE = "GPLv2"

ARM_INSTRUCTION_SET = "arm"

PR = "r6"

DEPENDS = "libtool jpeg zlib libpng tiff glib-2.0 gtk+ libv4l ffmpeg libdc1394"

SRCREV = "73017769e918a040a42259487888c329afd76730"
SRC_URI = "git://github.com/nzjrs/opencv.git;protocol=git;branch=dc1394"
PV = "1.1.0+git${SRCREV}"

S = "${WORKDIR}/git"

inherit distutils-base autotools pkgconfig lib_package

EXTRA_OECONF = " \
		--disable-debug \
		--with-gtk \
		--disable-apps \
		--with-swig=no \
		--with-python=no \
		--with-quicktime=no \
        --with-dc1394v2=yes \
        --with-v4l=yes \
"

export BUILD_SYS
export HOST_SYS

do_stage() {
	autotools_stage_all
}

