DESCRIPTION = "Hello world kernel module"
HOMEPAGE = "http://tldp.org/LDP/lkmpg/2.6/html/hello2.html"
SECTION = "kernel/modules"
PRIORITY = "optional"
LICENSE = "GPL"
PR = "r1"

SRC_URI = " \
  file://hello.c \
  file://Makefile \
"

S = "${WORKDIR}"

inherit module

do_compile () {
        unset CFLAGS CPPFLAGS CXXFLAGS LDFLAGS
        oe_runmake 'KERNELDIR=${STAGING_KERNEL_DIR}' \
                   'CC=${KERNEL_CC}' \
                   'LD=${KERNEL_LD}'
}

do_install() {
        install -d ${D}${base_libdir}/modules/${KERNEL_VERSION}/kernel/drivers/misc
        install -m 0644 *${KERNEL_OBJECT_SUFFIX} ${D}${base_libdir}/modules/${KERNEL_VERSION}/kernel/drivers/misc
}
