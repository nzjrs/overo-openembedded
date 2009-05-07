DESCRIPTION = "LatencyTOP - Measuring and fixing latency"
HOMEPAGE = "http://www.latencytop.org"
SECTION = "console/tests"
LICENSE = "LGPLv2"
PR = "r0"

DEPENDS = "ncurses"

#Fix the GNU_HAS QA build error
TARGET_CC_ARCH += " ${LDFLAGS}"

SRC_URI = " \
    http://www.latencytop.org/download/latencytop-${PV}.tar.gz \
    file://dont-hardcode-gcc.patch;patch=1 \
"

do_configure() {
    # We do not build ncurses with wide char support
    sed -i -e "s/lncursesw/lncurses/" ${S}/Makefile
}

do_install() {
	oe_runmake DESTDIR="${D}" install
}

do_stage() {
	oe_runmake DESTDIR="${STAGING_DIR_TARGET}" install
}

