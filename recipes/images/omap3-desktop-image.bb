# X11 demo image for omap3

require omap3-console-image.bb

IMAGE_LINGUAS = "de-de fr-fr en-gb en-us pt-br es-es"

ANGSTROM_EXTRA_INSTALL ?= ""

SPLASH ?= "psplash"
#SPLASH ?= "exquisite exquisite-themes exquisite-theme-angstrom"

APPS = " \
  abiword \
  cheese \
  claws-mail \
  evince \
  exhibit \
#  ekiga \
  empathy \
  firefox \
  gimp \
  gnome-games \
  gnome-mplayer \
  gnumeric \
  gpe-scap \
  gpe-soundbite \
  jaaa \
  midori \
  nautilus \
  numptyphysics \
  pidgin \
  swfdec \
  swfdec-mozilla \
  synergy \
  vnc \
  x11vnc \
  angstrom-x11vnc-xinit \
  xmms \
  xterm \
 "

E_CONFIG = " \
  e-wm-config-angstrom \
  e-wm-config-illume \
  e-wm-config-standard \
  e-wm-config-netbook \
  e-wm-config-default \
  e-wm-config-minimalist \
  e-wm-config-scaleable \
 "

E_MODULES = " \
  news \
  places \
 "

E17 = " \
  e-wm \
  entrance \
  e-wm-sysactions \
  ${E_CONFIG} \
  ${E_MODULES} \
 "

FONTS = " \
  ttf-dejavu-common \
  ttf-dejavu-sans \
  ttf-dejavu-serif \
  ttf-dejavu-sans-mono \
 "  

MEDIA = " \
#  bigbuckbunny-180 \
 "

PRINT = " \
  cups \
  gnome-cups-manager \
  gtk-printbackend-cups \
 "

SETTINGS = " \
  connman-gnome \
  gnome-bluetooth \
  gpe-conf \
  gpe-package \
 "

XSERVER_BASE = " \
  ${XSERVER} \
  dbus-x11 \
  fontconfig-utils \
  gnome-icon-theme angstrom-gnome-icon-theme-enable \
  gnome-themes \
  gtk-theme-clearlooks \
  gtk-engine-clearlooks \
  gpe-dm \
  gpe-session-scripts \
  hicolor-icon-theme \
  mime-support \
  xauth \
  xdg-utils \
  xhost \
  xset \
  xlsfonts \
  xrefresh \
 "

IMAGE_INSTALL += " \
  ${APPS} \
  ${E17} \
  ${FONTS} \
  ${MEDIA} \
  ${PRINT} \
  ${SETTINGS} \
  ${SPLASH} \
  ${XSERVER_BASE} \
 "

IMAGE_INSTALL_append_beagleboard = " \
  libgles-omap3-demos \
#  task-gstreamer-ti \ 
"

