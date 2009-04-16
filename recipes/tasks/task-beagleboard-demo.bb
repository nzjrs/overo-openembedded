DESCRIPTION = "Task for Beagleboard-demo-image"

PR = "r7"

inherit task 

ECONFIG ?= "places e-wm-config-angstrom e-wm-config-default"

RDEPENDS_${PN} = "\
    task-proper-tools \
    task-base-extended \
    angstrom-x11-base-depends \
    angstrom-gpe-task-base \
    angstrom-gpe-task-settings \
    angstrom-zeroconf-audio \
    angstrom-led-config \ 
    gpe-scap \
    psplash \
    mime-support e-wm ${ECONFIG} exhibit \
    xterm xmms \
    firefox midori \
    swfdec-mozilla \
    hicolor-icon-theme gnome-icon-theme \
    jaaa nmap iperf gnuplot \
    abiword \
    gnumeric \
    gimp \
    powertop oprofile \
    pidgin \
#    irssi \
    mplayer \
    gnome-games \
    rt73-firmware zd1211-firmware \
    stalonetray \
	synergy \
	x11vnc angstrom-x11vnc-xinit \
	angstrom-gnome-icon-theme-enable \
	openssh-scp openssh-ssh \
	picodlp-control \
	connman-gnome \
"

# Install all kernel modules
RRECOMMENDS_${PN} += "kernel-modules"

PACKAGE_ARCH = "${MACHINE_ARCH}"
RRECOMMENDS_${PN}_append_armv7a = " omapfbplay"

