# Demo project for Spring Boot 

This project contains a partial implementation of the server side part of some jmeter tests.

It compiles java 17 and java 21 compatible bytecode using different profiles.
Java 21 is the default profile.

## Building

In order to build the project do:

Java 21:

```shell
$ ./mvnw clean package && podman build  -t quay.io/rh_ee_lsnidero/sb-test-j21:latest --file Dockerfile
```
 
Java 17:

```shell
$ ./mvnw -P java-17 clean package && podman build  -t quay.io/rh_ee_lsnidero/sb-test-j17:latest --file Dockerfile.j17
```

Java 8:

```shell
$ podman build -t quay.io/rh_ee_lsnidero/sb-test-j8:latest --file java8/Dockerfile
```

## Starting database container

```shell
$ podman run --replace -it --name oracle-demosb -p 1521:1521 -e TZ="Europe/Rome" -e ORACLE_PASSWORD=demosb -e ORACLE_DATABASE=demosb -e APP_USER=demosb -e APP_USER_PASSWORD=demosb  docker.io/gvenzl/oracle-xe:21-slim-faststart
```

## Starting  Hazelcast container

Starting hazelcast with two nodes in multicast mode. The auto-discovery system should automatically create a cluster.
Search a line similar to this in hazelcast output:

```
2025-05-16 12:39:56,823 [ INFO] [hz.eager_cohen.priority-generic-operation.thread-0] [c.h.i.c.ClusterService]: [10.89.8.10]:5701 [dev] [5.5.0] 

Members {size:2, ver:2} [
	Member [10.89.8.9]:5701 - c9f8a334-6c98-418e-bdb3-be8aa1e50381
	Member [10.89.8.10]:5701 - 812f3e2a-55a4-425b-b26d-7a74ccfadbda this
]
```


```shell
$ podman network create --ignore  hazelnet
```


```shell
$ podman run --replace -it --name hazelcast-node1 -p 15701:5701 --net hazelnet --network-alias hazelcast-node1 -e JAVA_OPTS=-Dhazelcast.rest.enabled=true docker.io/hazelcast/hazelcast:5.5.0 
```

```shell
$ podman run --replace -it --name hazelcast-node2 -p 25701:5701 --net hazelnet --network-alias hazelcast-node2 -e JAVA_OPTS=-Dhazelcast.rest.enabled=true docker.io/hazelcast/hazelcast:5.5.0
```

Management center

```shell
$ podman run --replace -it --name hazelcast-mgmt -p 18080:8080 --net hazelnet --network-alias hazelcast-mgmt hazelcast/management-center:5.5.0
```

## Starting MongoDB container

```shell
$ podman run --replace -it --name mongodb -p 27017:27017 -e MONGO_INITDB_ROOT_USERNAME=admin -e MONGO_INITDB_ROOT_PASSWORD=admin  -e MONGO_INITDB_DATABASE=demosb  docker.io/library/mongo:8.0.9
```

## Running

Using ParallelGC

```shell
$ podman run -it -v $(pwd)/vol:/data:Z --name sb3-app --replace -m 500m --cpus=1  -p 9080:9080 -e GC_CONTAINER_OPTIONS='-XX:+UseParallelGC'  -e JAVA_MAX_MEM_RATIO=80 -e JAVA_VERBOSE=true -e GC_TIME_RATIO=10 -e JAVA_OPTS_APPEND='-XX:NativeMemoryTracking=summary -Xlog:gc*,safepoint=info:file=/data/parallel_gc_%p_%t.log:time:filecount=4,filesize=50M' -e GC_MAX_METASPACE_SIZE=256  quay.io/rh_ee_lsnidero/sb-test:java-21 
```

Using Shenandoah GC

```shell
$ podman run -it -v $(pwd)/vol:/data:Z --name sb3-app --replace -m 500m --cpus=1  -p 9080:9080 -e GC_CONTAINER_OPTIONS='-XX:+UseShenandoahGC'  -e JAVA_MAX_MEM_RATIO=80 -e JAVA_VERBOSE=true -e GC_TIME_RATIO=10 -e JAVA_OPTS_APPEND='-XX:NativeMemoryTracking=summary -Xlog:gc*,safepoint=info:file=/data/shenandoah_gc_%p_%t.log:time:filecount=4,filesize=50M' -e GC_MAX_METASPACE_SIZE=256  quay.io/rh_ee_lsnidero/sb-test:java-21
```

Using serial GC

```shell
$ podman run -it -v $(pwd)/vol:/data:Z --name sb3-app --replace -m 500m --cpus=1  -p 9080:9080 -e GC_CONTAINER_OPTIONS='-XX:+UseSerialGC'  -e JAVA_MAX_MEM_RATIO=80 -e JAVA_VERBOSE=true -e GC_TIME_RATIO=10 -e JAVA_OPTS_APPEND='-XX:NativeMemoryTracking=summary -Xlog:gc*,safepoint=info:file=/data/serial_gc_%p_%t.log:time:filecount=4,filesize=50M' -e GC_MAX_METASPACE_SIZE=256  quay.io/rh_ee_lsnidero/sb-test:java-21
```

Using G1 GC

```shell
$ podman run -it -v $(pwd)/vol:/data:Z --name sb3-app --replace -m 500m --cpus=1  -p 9080:9080 -e GC_CONTAINER_OPTIONS='-XX:+UseG1GC'  -e JAVA_MAX_MEM_RATIO=80 -e JAVA_VERBOSE=true -e GC_TIME_RATIO=10 -e JAVA_OPTS_APPEND='-XX:NativeMemoryTracking=summary -Xlog:gc*,safepoint=info:file=/data/g1_gc_%p_%t.log:time:filecount=4,filesize=50M' -e GC_MAX_METASPACE_SIZE=256  quay.io/rh_ee_lsnidero/sb-test:java-21
```


Using default 

```shell
$ podman run -it -v $(pwd)/vol:/data:Z --name sb3-app --replace -m 500m --cpus=1  -p 9080:9080 -e JAVA_VERBOSE=true -e JAVA_OPTS_APPEND='-XX:NativeMemoryTracking=summary -Xlog:gc*,safepoint=info:file=/data/default_gc_%p_%t.log:time:filecount=4,filesize=50M' -e GC_MAX_METASPACE_SIZE=256  quay.io/rh_ee_lsnidero/sb-test:java-21
```


