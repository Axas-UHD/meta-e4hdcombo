SSUMMARY = "Hardware drivers for ${MACHINE}"
SECTION = "base"
PRIORITY = "required"
LICENSE = "CLOSED"

KV = "4.10.12"
SRCDATE = "20180330"

PV = "${KV}+${SRCDATE}"
PR = "r0"

SRC_URI[md5sum] = "fb3a145307fb63db6b6a2fc12ea3bf3e"
SRC_URI[sha256sum] = "d3e97f50cd58fc6d41dcf291583dcb872ac54643c1a5f67f9e0b9410a82a6b3b"

SRC_URI = "http://222.239.254.238/e4hdcombo/drivers/ceryon-7225S-dvbdrive-${SRCDATE}.zip"

S = "${WORKDIR}"

INHIBIT_PACKAGE_STRIP = "1"

inherit module

do_compile() {
}

do_install() {
    install -d ${D}/lib/modules/${KV}/extra
    install -d ${D}/${sysconfdir}/modules-load.d
    echo "dvbdrive" >> ${D}/${sysconfdir}/modules-load.d/dvbdrive.conf
    install -m 0755 ${WORKDIR}/dvbdrive.ko ${D}/lib/modules/${KV}/extra
    install -d ${D}/etc/rcS.d
}

FILES_${PN} += "${sysconfdir}/modules-load.d/dvbdrive.conf"
