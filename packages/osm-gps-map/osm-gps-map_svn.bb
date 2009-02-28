require osm-gps-map.inc

PV = "0.1+svnr${SRCREV}"

DEFAULT_PREFERENCE = "-1"

SRC_URI = "svn://open.grcnz.com/svn/albatross/branches/groundstation;module=osm-gps-map;proto=https;rev=692"

S = "${WORKDIR}/osm-gps-map"


