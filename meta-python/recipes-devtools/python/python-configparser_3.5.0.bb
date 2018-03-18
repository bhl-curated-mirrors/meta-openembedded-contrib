SUMMARY = "This library brings the updated configparser from Python 3.5 to Python 2.6-3.5."
HOMEPAGE = "http://docs.python.org/3/library/configparser.html"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://PKG-INFO;md5=e7815f36e34184848c8639864f43184e"

SRC_URI[md5sum] = "cfdd915a5b7a6c09917a64a573140538"
SRC_URI[sha256sum] = "5308b47021bc2340965c371f0f058cc6971a04502638d4244225c49d80db273a"

inherit pypi setuptools

RDEPENDS_${PN} += "python-core"


