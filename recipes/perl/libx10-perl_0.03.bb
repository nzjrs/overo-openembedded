DESCRIPTION = "X10 support for Perl."
SECTION = "libs"
LICENSE = "Artistic|GPL"
PR = "r0"

SRC_URI = "http://search.cpan.org/CPAN/authors/id/R/RO/ROBF/X10-0.03.tar.gz"

S = "${WORKDIR}/X10-${PV}"

inherit cpan
