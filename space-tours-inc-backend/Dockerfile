FROM gradle:6.7.1-jdk8-hotspot AS build
RUN mkdir -p /workspace
COPY --chown=gradle:gradle . /workspace
WORKDIR /workspace
COPY src /workspace/src
RUN gradle build --no-daemon

FROM openjdk:8-alpine
COPY --from=build /workspace/build/libs/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]
