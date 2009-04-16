DESCRIPTION = "A console URL download utility featuring HTTP, FTP, and more."
SECTION = "console/network"
DEPENDS = ""
PR = "r7"
LICENSE = "GPL"

SRC_URI = "${GNU_MIRROR}/wget/wget-${PV}.tar.gz \
	   file://m4macros.patch;patch=1 \
	   file://autotools.patch;patch=1 \
           file://ipv6-fix.patch;patch=1"
S = "${WORKDIR}/wget-${PV}"

inherit autotools gettext

# Disable checking for SSL since that searches the system paths
EXTRA_OECONF = "--enable-ipv6 --without-ssl"

# The unslung kernel does not support ipv6
EXTRA_OECONF_unslung = "--without-ssl"
# SlugOS kernels do not support ipv6. Can be loaded as a module.
EXTRA_OECONF_slugos = "--without-ssl"

do_configure () {
	if [ ! -e acinclude.m4 ]; then
		mv aclocal.m4 acinclude.m4
	fi
	rm -f libtool.m4
	autotools_do_configure
}

do_install () {
	autotools_do_install
	mv ${D}${bindir}/wget ${D}${bindir}/wget.${PN}
}

pkg_postinst_${PN} () {
	update-alternatives --install ${bindir}/wget wget wget.${PN} 100
}

pkg_prerm_${PN} () {
	update-alternatives --remove wget wget.${PN}
}
