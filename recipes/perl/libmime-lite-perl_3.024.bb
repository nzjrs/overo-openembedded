DESCRIPTION = "Simple standalone module for generating MIME messages."
SECTION = "libs"
LICENSE = "Artistic|GPL"
PR = "r0"

RDEPENDS = "perl-module-file-spec \
            libemail-date-format-perl \
            perl-module-test-more \
            perl-module-time-local"

SRC_URI = "http://search.cpan.org/CPAN/authors/id/R/RJ/RJBS/MIME-Lite-3.024.tar.gz"

S = "${WORKDIR}/MIME-Lite-${PV}"

inherit cpan
