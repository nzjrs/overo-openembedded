DESCRIPTION = "USB Device Firmware Upgrade utility"
SECTION = "devel"
AUTHOR = "Harald Welte <laforge@openmoko.org>"
LICENSE = "GPL"
PV = "0.1+svnr${SRCREV}"
PR = "r2"

DEPENDS = "libusb usbpath"

SRC_URI = "svn://svn.openmoko.org/trunk/src/host/;module=dfu-util;proto=http"
S = "${WORKDIR}/dfu-util"

inherit autotools

do_stage() {
	autotools_stage_all
}
