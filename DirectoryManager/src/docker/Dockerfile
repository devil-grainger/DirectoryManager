FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]



FROM registry.access.redhat.com/ubi8/ubi-minimal:8.3 

ARG JAVA_PACKAGE=java-11-openjdk-headless
ARG RUN_JAVA_VERSION=1.3.8
ENV LANG='en_US.UTF-8' LANGUAGE='en_US:en'
# Install java and the run-java script
# Also set up permissions for user `1001`
RUN microdnf install curl ca-certificates ${JAVA_PACKAGE} \
    && microdnf update \
    && microdnf clean all \
    && mkdir /deployments \
    && chown 1001 /deployments \
    && chmod "g+rwX" /deployments \
    && chown 1001:root /deployments \
    && echo "securerandom.source=file:/dev/urandom" >> /etc/alternatives/jre/conf/security/java.security



ENV JAVA_OPTIONS="-javaagent:/deployments/lib/elastic-apm-agent-1.25.0.jar -Delastic.apm.service_name=my-cool-service -Delastic.apm.application_packages=com.conecel.claro.trans.creditcollect -Delastic.apm.server_url=http://10.0.12.51:8200"

COPY --chown=1001 target/*.jar /deployments/

# add lib for APM SERVER
# COPY --chown=1001 lib/elastic-apm-agent-1.25.0.jar /deployments/lib/

EXPOSE 8080
USER 1001

ENTRYPOINT ["java","-jar","/deployments/app.jar"]