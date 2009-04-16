DESCRIPTION = "Startup scripts that start Xserver, WM, and terminal"
SECTION = "x11/misc"
PRIORITY = "optional"
LICENSE = "MIT"
DEPENDS = "virtual/xserver"
RDEPENDS = "gpe-dm"

PR = "r0"

#adjust rdepends to refer those apps you start in 98xStandardApps
RDEPENDS += " xterm"

SRC_URI = " \
    file://99xStartXsession \
    file://99xWindowManager \
"

do_install_append() {
	install -d ${D}${sysconfdir}/X11/Xinit.d
	install -d ${D}${sysconfdir}/X11/Xsession.d

    install -m 0755 ${WORKDIR}/99xStartXsession ${D}${sysconfdir}/X11/Xinit.d/
    install -m 0755 ${WORKDIR}/99xWindowManager ${D}${sysconfdir}/X11/Xsession.d/

    echo "#!/bin/sh" > ${WORKDIR}/98xStandardApps
    echo "xterm &" >> ${WORKDIR}/98xStandardApps

    install -m 0755 ${WORKDIR}/98xStandardApps ${D}${sysconfdir}/X11/Xsession.d/
}


#CONFFILES = " \
#    ${D}${sysconfdir}/X11/Xinit.d/99xStartXsession \
#    ${D}${sysconfdir}/X11/Xsession.d/99xWindowManager \
#    ${D}${sysconfdir}/X11/Xsession.d/98xStandardApps \
#"


