SECTION = "base"
DESCRIPTION = "Script to manage module configuration files"
LICENSE = "GPLv2"
PACKAGE_ARCH = "all"
RDEPENDS = "${@base_contains("MACHINE_FEATURES", "kernel26",  "module-init-tools-depmod","modutils-depmod",d)} "
PR = "r8"

SRC_URI = "file://update-modules"

pkg_postinst() {
if [ "x$D" != "x" ]; then
	exit 1
fi
update-modules
}

do_install() {
	install -d ${D}${sbindir}
	install ${WORKDIR}/update-modules ${D}${sbindir}
}

# The Unslung distro uses a 2.4 kernel for a machine (the NSLU2) which
# supports both 2.4 and 2.6 kernels.  Rather than forcing OE to have
# to deal with that unique legacy corner case, we just nullify the
# RDEPENDS here and handle it in the Unslung image recipe. I know this
# is ugly.  Please don't remove it unless you first make the RDEPENDS
# line at the top of this file understand that a machine can be used
# in both a 2.4 kernel distro and a 2.6 kernel distro.  Really, it's
# not worth the effort to do that, so just overlook the next line.
RDEPENDS_unslung = ""

# The SlugOS distro is testing the use of the busybox mod* utilities.
# If that works out, we should create a virtual/update-modules, and
# let the distros select if they want busybox, or some other package
# to provide it.  Until then, the following line just removes the
# unwanted dependencies for SlugOS.
RDEPENDS_slugos = ""