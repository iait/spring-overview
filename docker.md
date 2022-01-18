
Docker
======

We can use the [eclipse-temurin](https://hub.docker.com/_/eclipse-temurin) image to deploy a spring boot application.
In particular, we will use the image based on the popular [Alpine Linux project](https://alpinelinux.org/). So the base of the image will be `eclipse-temurin:<version>-alpine`, where `version` correspond to the desired jdk version.

```Dockerfile
FROM eclipse-temurin:11-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]
```

There are some exploits that make possible to a user running root applications inside a container to break free from the container and compromise the host.
So, an important improvement to the Dockerfile is to run the application as a non-root user.

```Dockerfile
FROM eclipse-temurin:11-alpine
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]
```

The build now creates a spring user and a spring group to run the application. 
To build the image and run the container execute the following commands:

```
$ docker build -t spring-boot-docker .
$ docker run --name app -p 8080:8080 spring-boot-docker
```

Also, there is a clean separation between dependencies and application resources in a Spring Boot fat JAR file, and we can use that fact to improve performance.
The key is to create layers in the container filesystem. 
The layers are cached both at build time and at runtime, so we want the most frequently changing resources (usually the class and static resources in the application itself) to be layered after the more slowly changing resources. 
Thus, we use a slightly different implementation of the Dockerfile:

```Dockerfile
FROM eclipse-temurin:11-alpine
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring
ARG DEPENDENCY=target/dependency
COPY ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY ${DEPENDENCY}/META-INF /app/META-INF
COPY ${DEPENDENCY}/BOOT-INF/classes /app
ENTRYPOINT ["java","-cp","app:app/lib/*","com.example.App"]
```

This Dockerfile has a `DEPENDENCY` parameter pointing to a directory where we have to unpack the fat JAR.

Execute the following commands to create the dependency directory and unpack the fat JAR file:

```
$ mkdir -p target/dependency
$ cd target/dependency; jar -xf ../*.jar; cd -
```

Then build the docker image as before.

Note: the `ENTRYPOINT` correspond to the command to execute the application in Linux.
The command to run it on Windows is:
```
java -cp "app;app\lib\*" com.example.App
```

Lastly, you can generate the docker image directly with Maven:

```
$ mvn spring-boot:build-image -Dspring-boot.build-image.imageName=spring-boot-docker
```

You can open a shell to the image by running the following command:

```
$ docker container run -ti --entrypoint /bin/sh spring-boot-docker
$ docker container exec -ti spring-boot-docker /bin/sh
```

Improvements in [Spring Boot with Docker and Kubernetes Video](https://www.youtube.com/watch?v=Pyd9Wc5Gnd0).