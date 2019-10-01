FROM maven:3.5.2-jdk-8-alpine
COPY pom.xml /tmp/
COPY bin /tmp/bin/
COPY src /tmp/src/
WORKDIR /tmp/
RUN /tmp/bin/setup.sh