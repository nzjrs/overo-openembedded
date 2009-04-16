DESCRIPTION = "Opencv : The Open Computer Vision Library"
HOMEPAGE = "http://sourceforge.net/projects/opencvlibrary"
SECTION = "libs"
PRIORITY = "optional"
LICENSE = "GPLv2"

PR = "r3"

DEPENDS = "opencv"

SRCREV = "fb7cc87ed6a7425f3edc58e2d1eb44599496ac09"
SRC_URI = "git://github.com/nzjrs/opencv.git;protocol=git;branch=libv4l"
PV = "1.1.0+git${SRCREV}"

S = "${WORKDIR}/git"

do_install() {
    cd samples/c
	install -d ${D}/${bindir}

    for i in *.c; do
        echo "compiling $i"
        ${CXX} ${CFLAGS} ${LDFLAGS} -ggdb `pkg-config --cflags opencv` -o `basename $i .c` $i `pkg-config --libs opencv`;
		install -m 0755 `basename $i .c` ${D}/${bindir}
	done
    for i in *.cpp; do
        echo "compiling $i"
        ${CXX} ${CFLAGS} ${LDFLAGS} -ggdb `pkg-config --cflags opencv` -o `basename $i .cpp` $i `pkg-config --libs opencv`;
		install -m 0755 `basename $i .cpp` ${D}/${bindir}    
	done
}

FILES_${PN} += "${bindir}"

