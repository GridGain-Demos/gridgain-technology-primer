#!/bin/sh

#
#  Copyright (C) GridGain Systems. All Rights Reserved.
#  _________        _____ __________________        _____
#  __  ____/___________(_)______  /__  ____/______ ____(_)_______
#  _  / __  __  ___/__  / _  __  / _  / __  _  __ `/__  / __  __ \
#  / /_/ /  _  /    _  /  / /_/ /  / /_/ /  / /_/ / _  /  _  / / /
#  \____/   /_/     /_/   \_,__/   \____/   \__,_/  /_/   /_/ /_/
#

if [ "$1" = 'cli' ]; then
  shift
  exec sh "$GRIDGAIN_CLI_HOME"/bin/gridgain9 "$@"
fi

. ${GRIDGAIN_HOME}/lib/bootstrap-functions.sh

LOGGING_JAVA_OPTS="-Djava.util.logging.config.file=${GRIDGAIN_HOME}/etc/gridgain.java.util.logging.properties"

JAVA_MEMORY_OPTIONS="-Xmx${JVM_MAX_MEM} -Xms${JVM_MIN_MEM}"

JAVA_GC_OPTIONS="-XX:+Use${JVM_GC} -XX:G1HeapRegionSize=${JVM_G1HeapRegionSize}"

CMD="${JAVACMD} \
  ${COMMON_JAVA_OPTS} \
  ${LOGGING_JAVA_OPTS} \
  ${JAVA_MEMORY_OPTIONS} \
  ${JAVA_GC_OPTIONS} \
  ${GRIDGAIN9_EXTRA_JVM_ARGS} \
  ${CLASSPATH}"

exec $CMD "$@"
