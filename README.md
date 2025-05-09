# Demo project for Spring Boot 

This project contains a partial implementation of the server side part of some jmeter tests.

It compiles java 17 compatible bytecode in order to use the  

In order to build the project do:


```shell
$ ./mvnw clean package && podman build  -t quay.io/rh_ee_lsnidero/sb-test-j21:latest --file Dockerfile
```
 
```shell
$ ./mvnw -P java-17 clean package && podman build  -t quay.io/rh_ee_lsnidero/sb-test-j17:latest --file Dockerfile.j17
```

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
