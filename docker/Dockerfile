# Copyright (C) GridGain Systems. All Rights Reserved.
# _________        _____ __________________        _____
# __  ____/___________(_)______  /__  ____/______ ____(_)_______
# _  / __  __  ___/__  / _  __  / _  / __  _  __ `/__  / __  __ \
# / /_/ /  _  /    _  /  / /_/ /  / /_/ /  / /_/ / _  /  _  / / /
# \____/   /_/     /_/   \_,__/   \____/   \__,_/  /_/   /_/ /_/

ARG JDK_VERSION=17
FROM arm64v8/eclipse-temurin:${JDK_VERSION} AS jre-build

RUN $JAVA_HOME/bin/jlink \
         --add-modules ALL-MODULE-PATH \
         --strip-debug \
         --no-man-pages \
         --no-header-files \
         --compress=2 \
         --output /javaruntime

# Same base image as eclipse-temurin
FROM ubuntu:24.04

ENV JAVA_HOME=/opt/java/openjdk
ENV PATH="${JAVA_HOME}/bin:${PATH}"
COPY --from=jre-build /javaruntime $JAVA_HOME

# Set default memory and GC configuration
ENV JVM_MAX_MEM="16g"
ENV JVM_MIN_MEM="16g"

ENV JVM_GC="G1GC"
ENV JVM_G1HeapRegionSize="32M"

ENV GRIDGAIN9_EXTRA_JVM_ARGS=""

# Copy and setup DB app
ENV GRIDGAIN_HOME=/opt/gridgain

ENV LIBS_DIR=$GRIDGAIN_HOME/lib

ENV GRIDGAIN_NODE_NAME=defaultNode
ENV GRIDGAIN_WORK_DIR=$GRIDGAIN_HOME/work
ENV GRIDGAIN_CONFIG_PATH=$GRIDGAIN_HOME/etc/gridgain-config.conf

RUN groupadd --gid 1001 gridgain \
    && useradd -m --gid 1001 --uid 1001 gridgain \
    && mkdir -p $GRIDGAIN_HOME \
    && chown -R gridgain:gridgain $GRIDGAIN_HOME

COPY --chown=gridgain dist/db $GRIDGAIN_HOME

EXPOSE 3344 10300 10800

# Copy CLI app
ENV GRIDGAIN_CLI_HOME=/opt/gridgain9cli

COPY --chown=gridgain dist/cli $GRIDGAIN_CLI_HOME

# Copy entrypoint script
COPY --chown=gridgain docker-entrypoint.sh /usr/local/bin/docker-entrypoint.sh

# Make sure the locale is UTF-8 so that CLI prints tables correctly
ENV LANG=C.UTF-8
ENV LC_ALL=C.UTF-8

USER gridgain
WORKDIR $GRIDGAIN_HOME

ENTRYPOINT ["/usr/local/bin/docker-entrypoint.sh"]
