DESCRIPTION = "EFL FSO wrapper library"
SECTION = "e/libs"
LICENSE = "GPLv2"
DEPENDS = "ecore edbus"
PV = "0.0.0+svnr${SRCREV}"
PR = "r2"

SRC_URI = "svn://svn.om.vptt.ch/trunk/;proto=http;module=libefso"
S = "${WORKDIR}/libefso"

inherit autotools pkgconfig

do_stage () {
        install -m 0644  src/lib/efso.h ${STAGING_INCDIR}/efso.h
        oe_libinstall -a -so -C src/lib libefso ${STAGING_LIBDIR}
        autotools_stage_all
}
