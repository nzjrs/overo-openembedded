require squashfs-tools_${PV}.bb

inherit native

FILESPATH = "${@base_set_filespath([ '${FILE_DIRNAME}/squashfs-tools-${PV}', '${FILE_DIRNAME}/squashfs-tools', '${FILE_DIRNAME}/files', '${FILE_DIRNAME}' ], d)}"
PACKAGES = ""

do_stage () {
	install -m 0755 mksquashfs ${STAGING_BINDIR}/
}
