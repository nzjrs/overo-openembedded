DESCRIPTION = "A module loading thingy for perl."
SECTION = "libs"
LICENSE = "Artistic|GPL"
PR = "r0"

RDEPENDS = "perl-module-test-more"

SRC_URI = "http://search.cpan.org/CPAN/authors/id/K/KA/KANE/Module-Load-0.16.tar.gz"

S = "${WORKDIR}/Module-Load-${PV}"

inherit cpan
