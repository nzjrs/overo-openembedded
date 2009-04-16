DESCRIPTION = "Cyclictest - Preempt-RT testing tool"
HOMEPAGE = "http://www.kernel.org/pub/scm/linux/kernel/git/tglx/rt-tests.git"
SECTION = "console/tests"
LICENSE = "GPLv2"
PR = "r0"

#DEPENDS = "ncurses"

SRCREV = "f4e80a2fb0ed71185451ebf48bbefa534cf805dc"

SRC_URI = "\
	git://git.kernel.org/pub/scm/linux/kernel/git/tglx/rt-tests.git;protocol=git;branch=master \
"

S = "${WORKDIR}/git"

do_compile() {
	oe_runmake
}

do_install() {
	install -d ${D}${bindir}
	install -m 0755 cyclictest ${D}${bindir}/
	install -m 0755 classic_pi ${D}${bindir}/
	install -m 0755 signaltest ${D}${bindir}/
	install -m 0755 pi_stress ${D}${bindir}/
}


