FROM registry.access.redhat.com/ubi8/openjdk-8:1.16-1.1687182685
COPY CheckOperatingSystemMXBean.java /tmp
WORKDIR /tmp
RUN javac CheckOperatingSystemMXBean.java
RUN echo "Main-Class: CheckOperatingSystemMXBean" > manifest.txt
RUN jar cfm CheckOperatingSystemMXBean.jar manifest.txt CheckOperatingSystemMXBean.class
RUN cp CheckOperatingSystemMXBean.jar /deployments/app.jar
