require monotone.inc

PR = "r0"

SRC_URI = "http://venge.net/monotone/downloads/monotone-${PV}.tar.gz \
           file://txt2c-cross.patch;patch=1 \
           file://cryptopp-endianness.patch;patch=1"

ALTERNATIVE_PRIORITY = "50"
