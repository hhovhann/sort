# Start with a base image containing Java runtime
FROM openjdk:8-jdk-alpine
# Add Maintainer Info
MAINTAINER hhovhann <haik.hovhanisyan@gmail.com>
## Working directory point to /usr/src/app
WORKDIR /usr/src/app
# The application's jar file
ARG JAR_FILE
ARG CUSTOM_BANNER_FILE
ARG APPLICATION_PROPERTIES_FILE
# Copy
COPY ${JAR_FILE} /usr/src/app/app.jar
COPY ${CUSTOM_BANNER_FILE} /usr/src/app/custom-banner.txt
COPY ${APPLICATION_PROPERTIES_FILE} /usr/src/app/application.properties
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar","app.jar", "Erik", "blažej", "Zdenko", "Dezider", "Blazena", "Arpád", "zdenk"]