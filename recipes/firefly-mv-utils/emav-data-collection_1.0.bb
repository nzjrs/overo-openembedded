DESCRIPTION = "Test Utilities for Firefly MV Cameras"
HOMEPAGE = "http://github.com/nzjrs/firefly-mv/tree/master"
SECTION = "console/utils"
PRIORITY = "optional"
LICENSE = "GPL"
PR = "r2"

DEPENDS = "libdc1394 gtk+"

#FIXME: Why are these lines necessary?, why isnt pkg-config in the
#Makefile sufficient?
CFLAGS_append = " $(pkg-config --cflags gtk+-2.0)"
LIBS_append = " $(pkg-config --libs gtk+-2.0)"

SRCREV = "c754f5c91b5f591e0dd6b8f5e49d776ec66aa08f"
SRC_URI = "git://github.com/nzjrs/firefly-mv.git;protocol=git;branch=emav09"

inherit pkgconfig

S = "${WORKDIR}/git"

do_compile() {
	oe_runmake -f Makefile.ppz
}

do_install () {
	install -d ${D}${bindir}
	install -m 0755 pprz-record ${D}${bindir}/
	install -m 0755 pprz-play ${D}${bindir}/
	install -m 0755 pprz-to-image-files ${D}${bindir}/
}
