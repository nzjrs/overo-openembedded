DESCRIPTION = "Database access library for GPE contacts"
LICENSE = "LGPL"
SECTION = "gpe/libs"
PRIORITY = "optional"
DEPENDS = "libgpewidget libgpepimc sqlite"
MAINTAINER = "Florian Boor <florian.boor@kernelconcepts.de>"

GPE_TARBALL_SUFFIX = "bz2"

inherit autotools gpe pkgconfig

do_stage () {
	autotools_stage_all
}