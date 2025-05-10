FROM openjdk:17-jdk-slim

WORKDIR /app

COPY target/algocave-data-align-0.0.1-SNAPSHOT.jar app.jar

ENV JAVA_OPTS="-Xms200m -Xmx200m -Djava.security.egd=file:/dev/./urandom"
ENV ARGS=""

EXPOSE 8091

ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar app.jar $ARGS"]