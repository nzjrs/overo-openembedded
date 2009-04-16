DESCRIPTION = "Icecast source client"
LICENSE = "GPLv2"

DEPENDS = "libvorbis libogg libxml2 libshout"

PR = "r1"

SRC_URI = "http://downloads.us.xiph.org/releases/ices/ices-${PV}.tar.gz"

S = "${WORKDIR}/ices-${PV}"
inherit autotools

