DESCRIPTION = "Kernel based automounter for linux."
SECTION = "base"
LICENSE = "GPL"

PR = "r2"

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/daemons/autofs/v4/autofs-${PV}.tar.bz2 \
           ${KERNELORG_MIRROR}/pub/linux/daemons/autofs/v4/autofs-4.1.4-misc-fixes.patch;patch=1 \
           ${KERNELORG_MIRROR}/pub/linux/daemons/autofs/v4/autofs-4.1.4-multi-parse-fix.patch;patch=1 \
           ${KERNELORG_MIRROR}/pub/linux/daemons/autofs/v4/autofs-4.1.4-non-replicated-ping.patch;patch=1 \
           file://cross.patch;patch=1 \
           file://Makefile.rules-cross.patch;patch=1 \
	   file://install.patch;patch=1 \
	   file://auto.net-sort-option-fix.patch;patch=1 \
	   file://autofs-additional-distros.patch;patch=1 \
	   file://no-bash.patch;patch=1"

inherit autotools update-rc.d

INITSCRIPT_NAME = "autofs"
INITSCRIPT_PARAMS = "defaults"

EXTRA_OEMAKE="TARGET_PREFIX=${TARGET_PREFIX}"
PARALLEL_MAKE = ""

do_configure_prepend () {
	if [ ! -e acinclude.m4 ]; then
		cp aclocal.m4 acinclude.m4
	fi
}

do_install () {
	oe_runmake 'INSTALLROOT=${D}' install
}
