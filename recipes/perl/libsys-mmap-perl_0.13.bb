DESCRIPTION = "Uses mmap to map in a file as a perl variable."
SECTION = "libs"
LICENSE = "Artistic|GPL"
PR = "r0"

SRC_URI = "http://search.cpan.org/CPAN/authors/id/S/SW/SWALTERS/Sys-Mmap-0.13.tar.gz"

S = "${WORKDIR}/Sys-Mmap-${PV}"

inherit cpan
