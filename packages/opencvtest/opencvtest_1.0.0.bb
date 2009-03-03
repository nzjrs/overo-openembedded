DESCRIPTION = "OpenCV Test Application"

PR = "r2"
DEPENDS = "opencv"

SRC_URI = " \
  file://main.cpp \
"

S = "${WORKDIR}"

do_install () {
	install -d ${D}${bindir}
    ${CXX} ${CFLAGS} ${LDFLAGS} $(pkg-config --cflags opencv) -o opencvtest main.cpp $(pkg-config --libs opencv)
	install -m 0755 opencvtest ${D}${bindir}
}


