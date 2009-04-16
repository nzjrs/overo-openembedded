# Intel ixp4xx access library software.  Note that this has an Intel
# license which restricts its use.
HOMEPAGE = "http://www.intel.com/design/network/products/npfamily/ixp420.htm"
LICENSE = "http://www.intel.com/design/network/swsup/np_sla/ixp400.htm"
LICENSE_HOMEPAGE = "http://www.intel.com/design/network/products/npfamily/ixp425swr1.htm"
# You must download the following software to your OpenEmbedded downloads
# directory before using this package:
#
#	ixp400AccessLibrary-1_5.zip
#
# To do this go to the LICENSE_HOMEPAGE above, register/login (using a
# web browser which is supported by the login page), this will give you
# access to the web page from which you can download the software - you
# need the: "Intel® IXP400 Software and RedBoot* Boot Loader" and, from
# this the "Intel Hardware Access Software" (versions 1.5 encryption is
# not required.)
#
# Store the file with the name given below in your downloads directory
#
SRC_URI = "http://www.intel.com/Please-Read-The-BB-File/ixp400AccessLibrary-1_5.zip"
SRC_URI += "file://2.6.patch;patch=1"
S = "${WORKDIR}/ixp_osal"
PR = "r1"

COMPATIBLE_HOST = "^armeb-linux.*"
COMPATIBLE_MACHINE = "(nslu2|ixp4xx)"

inherit module

EXTRA_OEMAKE = "'CC=${KERNEL_CC}' \
		'LD=${KERNEL_LD}' \
		'AR=${AR}' \
		'IX_XSCALE_SW=${S}' \
		'IX_TARGET=linuxbe' \
		'IX_MPHY=1' \
		'IX_MPHYSINGLEPORT=1' \
		'LINUX_SRC=${STAGING_KERNEL_DIR}' \
		'LINUX_CROSS_COMPILE=${HOST_PREFIX}' \
		"

OSAL_PATH = "lib/linux/linuxbe/ixp400"
# This is a somewhat arbitrary choice:
OSAL_DIR = "${STAGING_KERNEL_DIR}/ixp_osal"

do_compile () {
	oe_runmake ${OSAL_PATH}/libosal.a ${OSAL_PATH}/ixp_osal.o
}

do_stage () {
	install -d ${OSAL_DIR}

	# First the include files, maintain the tree structure (ixp4xx-csr
	# expects the exact same tree)
	cp -RLf include ${OSAL_DIR}
	install -d ${OSAL_DIR}/os/linux
	cp -RLf os/linux/include ${OSAL_DIR}/os/linux

	# Install the library/object
	install -d ${OSAL_DIR}/${OSAL_PATH}
	rm -f ${OSAL_DIR}/libosal
	install -m 0644 ${OSAL_PATH}/libosal.a ${OSAL_DIR}/${OSAL_PATH}
	touch ${OSAL_DIR}/libosal
	rm -f ${OSAL_DIR}/module
	install -m 0644 ${OSAL_PATH}/ixp_osal.o ${OSAL_DIR}/${OSAL_PATH}
	touch ${OSAL_DIR}/module
}

# This stuff doesn't install anything...
PACKAGES = ""

do_install () {
}
