# FROM maven:3.9-eclipse-temurin-21

# # LABEL MAINTAINER="email"
# # LABEL APPLICATION="Healthcheck Application"

# WORKDIR /app

# COPY mvnw .
# COPY mvnw.cmd .
# COPY pom.xml .

# COPY .mvn .mvn
# COPY src src

# RUN mvn package -Dmaven.test.skip=true

# ENV PORT=8080

# EXPOSE ${PORT}

# HEALTHCHECK --interval=30s --timeout=30s --start-period=5s --retries=3 CMD curl -s -f http://localhost:8080/demo/healthz || exit 1

# ENTRYPOINT SERVER_PORT=${PORT} java -jar target/d18-lecture-0.0.1-SNAPSHOT.jar

FROM maven:3.9-eclipse-temurin-21 AS builder

# LABEL MAINTAINER="email"
LABEL APPLICATION="Healthcheck Application"

ARG APP_DIR=/app

WORKDIR ${APP_DIR}

COPY mvnw .
COPY mvnw.cmd .
COPY pom.xml .

COPY .mvn .mvn
COPY src src

RUN mvn package -Dmaven.test.skip=true

FROM openjdk:21-jdk

ARG APP_DIR2=/JD
WORKDIR ${APP_DIR2}

COPY --from=builder /app/target/d18-lecture-0.0.1-SNAPSHOT.jar healthcheck.jar

ENTRYPOINT [ "java", "-jar", "healthcheck.jar" ]

EXPOSE 8080

HEALTHCHECK --interval=30s --timeout=30s --start-period=5s --retries=3 CMD curl -s -f http://localhost:8080/demo/healthz || exit 1
