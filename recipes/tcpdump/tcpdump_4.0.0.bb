DESCRIPTION = "A sophisticated network protocol analyzer"
HOMEPAGE = "http://www.tcpdump.org/"
LICENSE = "BSD"
SECTION = "console/network"
PRIORITY = "optional"
DEPENDS = "libpcap"
PR = "r1"

SRC_URI = "http://www.tcpdump.org/release/tcpdump-${PV}.tar.gz \
           file://tcpdump_configure_no_-O2.patch;patch=1 \
           file://no-ipv6-tcpdump4.patch;patch=1 \
           file://0001-minimal-IEEE802.15.4-allowed.patch;patch=1"

inherit autotools
# ac_cv_linux_vers=${ac_cv_linux_vers=2}

EXTRA_OECONF = "--without-crypto"

do_configure() {
	gnu-configize
    autoconf
	oe_runconf
        sed -i 's:/usr/lib:${STAGING_LIBDIR}:' ./Makefile
        sed -i 's:/usr/include:${STAGING_INCDIR}:' ./Makefile
}
