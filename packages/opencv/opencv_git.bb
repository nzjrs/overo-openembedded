DESCRIPTION = "Opencv : The Open Computer Vision Library"
HOMEPAGE = "http://sourceforge.net/projects/opencvlibrary"
SECTION = "libs"
PRIORITY = "optional"
LICENSE = "GPLv2"

ARM_INSTRUCTION_SET = "arm"

PR = "r2"

DEPENDS = "libtool jpeg zlib libpng tiff glib-2.0 gtk+ libv4l ffmpeg"

SRCREV = "fb7cc87ed6a7425f3edc58e2d1eb44599496ac09"
SRC_URI = "git://github.com/nzjrs/opencv.git;protocol=git;branch=libv4l"
PV = "1.1.0+git${SRCREV}"

S = "${WORKDIR}/git"

inherit distutils-base autotools pkgconfig

EXTRA_OECONF = " \
		--disable-debug \
		--with-gtk \
		--disable-apps \
		--with-swig=no \
		--with-python=no \
		"

export BUILD_SYS
export HOST_SYS

python populate_packages_prepend () {
	cv_libdir = bb.data.expand('${libdir}', d)
	cv_libdir_dbg = bb.data.expand('${libdir}/.debug', d)
	do_split_packages(d, cv_libdir, '^lib(.*)\.so$', 'lib%s-dev', 'OpenCV %s development package', extra_depends='${PN}-dev', allow_links=True)
	do_split_packages(d, cv_libdir, '^lib(.*)\.la$', 'lib%s-dev', 'OpenCV %s development package', extra_depends='${PN}-dev')
	do_split_packages(d, cv_libdir, '^lib(.*)\.a$', 'lib%s-dev', 'OpenCV %s development package', extra_depends='${PN}-dev')
	do_split_packages(d, cv_libdir, '^lib(.*)\.so\.*', 'lib%s', 'OpenCV %s library', extra_depends='', allow_links=True)
}

FILES_${PN} = ""
FILES_${PN}-doc += "${datadir}/opencv/"
FILES_${PN}-dbg += "${libdir}/.debug"
FILES_${PN}-dev = "${includedir} ${libdir}/pkgconfig"

do_stage() {
	autotools_stage_all
}

