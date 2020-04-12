####
# This Dockerfile is used in order to build a container that runs the Quarkus application in JVM mode
#
# Before building the docker image run:
#
# mvn package
#
# Then, build the image with:
#
# docker build -f src/main/docker/Dockerfile.jvm -t quarkus/quarkus-test-jvm .
#
# Then run the container using:
#
# docker run -i --rm -p 8080:8080 quarkus/quarkus-test-jvm
#
###
FROM junorr/ubuntu-graalvm-jdk-11

# Install java and the run-java script
# Also set up permissions for user `1001`
RUN mkdir /deployments 
RUN echo "#!/bin/bash\n/opt/graalvm-20-jdk-11/bin/java -jar /deployments/app.jar" > "/deployments/run-java.sh"
RUN chmod +x /deployments/run-java.sh

# Configure the JAVA_OPTIONS, you can add -XshowSettings:vm to also display the heap size.
ENV JAVA_OPTIONS="-Dquarkus.http.host=0.0.0.0 -Djava.util.logging.manager=org.jboss.logmanager.LogManager"

COPY target/quarkus-test-1.0.0-SNAPSHOT-runner.jar /deployments/app.jar

EXPOSE 8080

ENTRYPOINT [ "/deployments/run-java.sh" ]

