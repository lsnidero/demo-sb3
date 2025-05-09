FROM registry.redhat.io/ubi8/openjdk-21:1.21-1.1743444280
COPY target/demo-0.0.1-SNAPSHOT.jar /deployments/app.jar
