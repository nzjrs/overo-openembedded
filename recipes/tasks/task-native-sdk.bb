DESCRIPTION = "Packages required for native (on-device) SDK"
LICENSE = "MIT"
DEPENDS = "virtual/libc gcc binutils make patch patchutils diffstat diffutils automake flex bison gawk sed grep"
RDEPENDS = "gcc-symlinks g++-symlinks cpp cpp-symlinks binutils-symlinks \
	    make virtual-libc-dev \
	    task-proper-tools perl-modules flex flex-dev bison gawk sed grep autoconf automake make \
	    patch patchutils diffstat diffutils libstdc++-dev"

RECOMMENDS = " g77-symlinks gfortran-symlinks "

PR = "r6"

ALLOW_EMPTY = "1"
PACKAGES = "${PN}"
