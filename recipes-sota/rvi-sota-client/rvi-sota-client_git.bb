DESCRIPTION = "sota-client rust recipe"
HOMEPAGE = "https://github.com/advancedtelematic/rvi_sota_client"

LICENSE = "MPL-2.0"
LIC_FILES_CHKSUM = "file://${S}/LICENSE;md5=65d26fcc2f35ea6a181ac777e42db1ea"

inherit cargo systemd

S = "${WORKDIR}/git"

# When changing this, don't forget to:
# 1) Update PV
# 2) Check that Cargo.lock hasn't changed with git diff old..new Cargo.lock
SRCREV = "e3ab3b02c7c08d61064ea11c98e59559140a8219"

# Generate with:
#   git describe --tags | cut -b2-
# or from the rvi_sota_client repo:
#   make package-version
PV = "0.2.33-39-ge3ab3b0"

BBCLASSEXTEND = "native"

FILES_${PN} = " \
/lib64 \
${bindir}/sota_client \
${bindir}/sota_sysinfo.sh \
${bindir}/sota_provision.sh \
${sysconfdir}/sota_client.version \
${sysconfdir}/sota_certificates \
${@bb.utils.contains('DISTRO_FEATURES', 'systemd', '${systemd_unitdir}/system/sota-client.service', '', d)} \
${@bb.utils.contains('DISTRO_FEATURES', 'systemd', '${systemd_unitdir}/system/sota-client-autoprovision.service', '', d)} \
"


# list of dependencies can be generated from Cargo.lock by running
#   cat Cargo.lock | sed -e '1,/metadata/ d' Cargo.lock | awk '{print "crate://crates.io/"$2 "/" $3" \\"}'
SRC_URI = " \
crate://crates.io/advapi32-sys/0.2.0 \
crate://crates.io/aho-corasick/0.6.3 \
crate://crates.io/ansi_term/0.9.0 \
crate://crates.io/antidote/1.0.0 \
crate://crates.io/atty/0.2.2 \
crate://crates.io/backtrace/0.3.2 \
crate://crates.io/backtrace-sys/0.1.11 \
crate://crates.io/base64/0.5.2 \
crate://crates.io/bit-set/0.4.0 \
crate://crates.io/bit-vec/0.4.4 \
crate://crates.io/bitflags/0.9.1 \
crate://crates.io/byteorder/1.0.0 \
crate://crates.io/bytes/0.4.4 \
crate://crates.io/cfg-if/0.1.2 \
crate://crates.io/chan/0.1.19 \
crate://crates.io/chan-signal/0.2.0 \
crate://crates.io/chrono/0.4.0 \
crate://crates.io/clap/2.25.0 \
crate://crates.io/core-foundation/0.2.3 \
crate://crates.io/core-foundation-sys/0.2.3 \
crate://crates.io/crossbeam/0.2.10 \
crate://crates.io/crypt32-sys/0.2.0 \
crate://crates.io/dbghelp-sys/0.2.0 \
crate://crates.io/dbus/0.5.3 \
crate://crates.io/dtoa/0.4.1 \
crate://crates.io/env_logger/0.4.3 \
crate://crates.io/error-chain/0.10.0 \
crate://crates.io/filetime/0.1.10 \
crate://crates.io/foreign-types/0.2.0 \
crate://crates.io/gcc/0.3.51 \
crate://crates.io/getopts/0.2.14 \
crate://crates.io/hex/0.2.0 \
crate://crates.io/httparse/1.2.3 \
crate://crates.io/hyper/0.10.12 \
crate://crates.io/hyper-native-tls/0.2.4 \
crate://crates.io/idna/0.1.2 \
crate://crates.io/iovec/0.1.0 \
crate://crates.io/itoa/0.3.1 \
crate://crates.io/kernel32-sys/0.2.2 \
crate://crates.io/language-tags/0.2.2 \
crate://crates.io/lazy_static/0.2.8 \
crate://crates.io/libc/0.2.24 \
crate://crates.io/libflate/0.1.9 \
crate://crates.io/log/0.3.8 \
crate://crates.io/maplit/0.1.4 \
crate://crates.io/matches/0.1.6 \
crate://crates.io/memchr/1.0.1 \
crate://crates.io/metadeps/1.1.2 \
crate://crates.io/mime/0.2.6 \
crate://crates.io/native-tls/0.1.4 \
crate://crates.io/net2/0.2.29 \
crate://crates.io/num/0.1.39 \
crate://crates.io/num-integer/0.1.34 \
crate://crates.io/num-iter/0.1.33 \
crate://crates.io/num-traits/0.1.39 \
crate://crates.io/num_cpus/1.6.2 \
crate://crates.io/openssl/0.9.14 \
crate://crates.io/openssl-sys/0.9.14 \
crate://crates.io/pem/0.4.0 \
crate://crates.io/percent-encoding/1.0.0 \
crate://crates.io/pkg-config/0.3.9 \
crate://crates.io/quote/0.3.15 \
crate://crates.io/rand/0.3.15 \
crate://crates.io/redox_syscall/0.1.21 \
crate://crates.io/regex/0.2.2 \
crate://crates.io/regex-syntax/0.4.1 \
crate://crates.io/reqwest/0.6.2 \
crate://crates.io/ring/0.7.1 \
crate://crates.io/rust-crypto/0.2.36 \
crate://crates.io/rustc-demangle/0.1.4 \
crate://crates.io/rustc-serialize/0.3.24 \
crate://crates.io/schannel/0.1.7 \
crate://crates.io/secur32-sys/0.2.0 \
crate://crates.io/security-framework/0.1.14 \
crate://crates.io/security-framework-sys/0.1.14 \
crate://crates.io/serde/1.0.9 \
crate://crates.io/serde_derive/1.0.9 \
crate://crates.io/serde_derive_internals/0.15.1 \
crate://crates.io/serde_json/1.0.2 \
crate://crates.io/serde_urlencoded/0.5.1 \
crate://crates.io/sha1/0.2.0 \
crate://crates.io/strsim/0.6.0 \
crate://crates.io/syn/0.11.11 \
crate://crates.io/synom/0.11.3 \
crate://crates.io/tar/0.4.13 \
crate://crates.io/tempdir/0.3.5 \
crate://crates.io/term_size/0.3.0 \
crate://crates.io/textwrap/0.6.0 \
crate://crates.io/thread_local/0.3.4 \
crate://crates.io/time/0.1.37 \
crate://crates.io/toml/0.2.1 \
crate://crates.io/toml/0.4.2 \
crate://crates.io/traitobject/0.1.0 \
crate://crates.io/tungstenite/0.2.4 \
crate://crates.io/typeable/0.1.2 \
crate://crates.io/unicase/1.4.2 \
crate://crates.io/unicode-bidi/0.3.3 \
crate://crates.io/unicode-normalization/0.1.5 \
crate://crates.io/unicode-segmentation/1.1.0 \
crate://crates.io/unicode-width/0.1.4 \
crate://crates.io/unicode-xid/0.0.4 \
crate://crates.io/unix_socket/0.5.0 \
crate://crates.io/unreachable/1.0.0 \
crate://crates.io/untrusted/0.3.2 \
crate://crates.io/url/1.5.1 \
crate://crates.io/utf-8/0.7.1 \
crate://crates.io/utf8-ranges/1.0.0 \
crate://crates.io/uuid/0.5.1 \
crate://crates.io/vec_map/0.8.0 \
crate://crates.io/version_check/0.1.2 \
crate://crates.io/void/1.0.2 \
crate://crates.io/winapi/0.2.8 \
crate://crates.io/winapi-build/0.1.1 \
crate://crates.io/ws2_32-sys/0.2.1 \
crate://crates.io/xattr/0.1.11 \
git://github.com/advancedtelematic/rvi_sota_client \
file://sota-client-autoprovision.service \
file://sota-client-ostree.service \
file://sota-client-uptane.service \
"

SRC_URI[index.md5sum] = "6a635e8a081b4d4ba4cebffd721c2d7d"
SRC_URI[index.sha256sum] = "1913c41d4b8de89a931b6f9e418f83e70a083e12e6c247e8510ee932571ebae2"

SYSTEMD_SERVICE_${PN} = "sota-client.service sota-client-autoprovision.service"

DEPENDS += " openssl openssl-native dbus "
RDEPENDS_${PN} = " libcrypto \
                   libssl \
                   bash \
                   lshw \
                   jq \
                   curl \
                   python \
                   python-json \
                   python-petname \
                   "

export SOTA_PACKED_CREDENTIALS
export SOTA_AUTOPROVISION_CREDENTIALS
export SOTA_AUTOPROVISION_URL

do_compile_prepend() {
  export SOTA_VERSION=$(make sota-version)
  cd sota-client
}

do_install() {
  ln -fs /lib ${D}/lib64

  install -d ${D}${bindir}
  install -d ${D}${sysconfdir}

  echo `git log -1 --pretty=format:%H` > ${D}${sysconfdir}/sota_client.version
  install -c ${S}/sota-client/docker/sota_certificates ${D}${sysconfdir}

  install -m 0755 target/${TARGET_SYS}/release/sota_client ${D}${bindir}
  install -m 0755 ${S}/sota-client/docker/sota_provision.sh ${D}${bindir}
  install -m 0755 ${S}/sota-client/docker/sota_sysinfo.sh ${D}${bindir}

  if ${@bb.utils.contains('DISTRO_FEATURES', 'systemd', 'true', 'false', d)}; then
    install -d ${D}/${systemd_unitdir}/system
    if [ -n "$SOTA_AUTOPROVISION_CREDENTIALS" -o -n "$SOTA_PACKED_CREDENTIALS" ]; then
      install -m 0644 ${WORKDIR}/sota-client-uptane.service ${D}/${systemd_unitdir}/system/sota-client.service
    else
      install -m 0644 ${WORKDIR}/sota-client-ostree.service ${D}/${systemd_unitdir}/system/sota-client.service
    fi
    install -m 0644 ${WORKDIR}/sota-client-autoprovision.service ${D}/${systemd_unitdir}/system/sota-client-autoprovision.service
  fi
}
