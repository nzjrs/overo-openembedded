DESCRIPTION = "ushare is a UPnP media server"
LICENSE = "GPL"
HOMEPAGE = "http://ushare.geexbox.org/"
MAINTAINER = "eFfeM <fransmeulenbroeks at yahoo dot com>"
DEPENDS = "libupnp"
SRC_URI = "http://ushare.geexbox.org/releases/ushare-0.9.7.tar.bz2"
S = "${WORKDIR}/ushare-${PV}"
PR = "r0"

inherit autotools