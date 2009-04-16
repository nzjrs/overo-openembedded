# mtools OE build file
# Copyright (C) 2004-2006, Advanced Micro Devices, Inc.  All Rights Reserved
# Released under the MIT license (see packages/COPYING)

DESCRIPTION="Mtools is a collection of utilities for accessing MS-DOS disks from Unix without mounting them."
HOMEPAGE="http://mtools.linux.lu"
LICENSE="GPL"
PR = "r4"

SRC_URI="http://mtools.linux.lu/mtools-${PV}.tar.gz \
	file://m486.patch;patch=1 \
	file://mtools-makeinfo.patch;patch=1 \
	file://no-x11.patch;patch=1"

S = "${WORKDIR}/mtools-${PV}"

inherit autotools

EXTRA_OECONF = "--without-x"
