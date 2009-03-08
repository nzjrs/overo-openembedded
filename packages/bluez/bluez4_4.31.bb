DESCRIPTION = "Linux Bluetooth Stack Userland V4"
SECTION = "libs"
PRIORITY = "optional"
DEPENDS = "gst-plugins-base alsa-lib libusb-compat dbus-glib"
HOMEPAGE = "http://www.bluez.org"
LICENSE = "GPL"
PR = "r3"

SRC_URI = "\
  http://www.kernel.org/pub/linux/bluetooth/bluez-${PV}.tar.gz \
  file://fix-dfutool-usb-declaration-mismatch.patch;patch=1 \
  file://sbc-thumb.patch;patch=1 \
#  file://hid2hci_usb_init.patch;patch=1 \
"    
S = "${WORKDIR}/bluez-${PV}"

inherit autotools pkgconfig

OE_LT_RPATH_ALLOW = "any"
OE_LT_RPATH_ALLOW[export] = "1"

EXTRA_OECONF = "\
  --enable-gstreamer \
  --enable-alsa \
  --enable-usb \
  --enable-netlink \
  --enable-tools \
  --enable-bccmd \
  --enable-hid2hci \
  --enable-dfutool \
  --enable-hidd \
  --enable-pandd \
  --enable-dund \
  --disable-cups \
  --enable-test \
  --enable-manpages \
  --enable-configfiles \
  --enable-initscripts \
  --disable-pcmciarules \
"

do_install_append() {
        install -m 0644 ${S}/audio/audio.conf ${D}/${sysconfdir}/bluetooth/
        install -m 0644 ${S}/network/network.conf ${D}/${sysconfdir}/bluetooth/
        install -m 0644 ${S}/input/input.conf ${D}/${sysconfdir}/bluetooth/
}

PACKAGES =+ "gst-plugin-bluez libasound-module-bluez"

FILES_gst-plugin-bluez = "${libdir}/gstreamer-0.10/lib*.so"
FILES_libasound-module-bluez = "${libdir}/alsa-lib/lib*.so"
FILES_${PN} += "${libdir}/bluetooth/plugins/*.so"
FILES_${PN}-dev += "\
  ${libdir}/bluetooth/plugins/*.la \
  ${libdir}/*/*.la \
"
FILES_${PN}-dbg += "\
  ${libdir}/bluetooth/plugins/.debug \
  ${libdir}/*/.debug \
"
