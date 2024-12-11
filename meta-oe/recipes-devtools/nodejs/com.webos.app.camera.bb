# Copyright (c) 2021-2024 LG Electronics, Inc.

SUMMARY = "Camera application"
AUTHOR = "VINH VAN LE <vinh5.le@lge.com>"
SECTION = "webos/apps"

LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = " \
    file://LICENSE;md5=86d3f3a95c324c9479bd8986968f4327 \
    file://oss-pkg-info.yaml;md5=3072ffcf5bdbbc376ed21c9d378d14d5 \
"

PV = "0.0.1-18"
SRCREV = "62dac33d771e4a3b14bf740dccf3323793211231"
# WEBOS_VERSION = "0.0.1-17_79c8e8c4390b97abdf4616474d463babaec40557"
PV = "0.0.1-17"
SRCREV = "79c8e8c4390b97abdf4616474d463babaec40557"

SRC_URI = "git://github.com/webosose/com.webos.app.camera;protocol=https;branch=master"
S = "${WORKDIR}/git"

DEPENDS = "enact-dev-native nodejs-native"

export PSEUDO_DEBUG = "nfoPcvdDyerpswikVx"

do_configure() {
    :
}

do_compile[network] = "1"
do_compile() {
    ${STAGING_BINDIR_NATIVE}/npm install
}

do_install() {
    ${STAGING_BINDIR_NATIVE}/node ${STAGING_DIR_NATIVE}/opt/cli/bin/enact.js pack -o ${D}/test
}

FILES:${PN} += "test"

# to make sure this isn't cached in sstate-cache after showing just a warning in package_qa
# http://errors.yoctoproject.org/Errors/Details/739941/
ERROR_QA:append = " host-user-contaminated"

# buildpaths in "sources" tmp/work/core2-64-oe-linux/com.webos.app.minimal/1.0/package/test/main.js.map
# https://github.com/webpack/webpack/issues/15274
ERROR_QA:remove = " buildpaths"
