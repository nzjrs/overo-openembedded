require linux-omap1.inc

PR = "r2"

SRC_URI = "git://source.mvista.com/git/linux-omap-2.6.git;protocol=http;tag=c6051183c597b6a0fa73cdb59aac852c6148c5b6 \
           file://another-ide-cs-ids.patch;patch=1 \
           file://defconfig"

S = "${WORKDIR}/git"

KERNEL_RELEASE = "2.6.18-omap1"