FROM maven:3.9.4-eclipse-temurin-17 AS build

WORKDIR /app

# Копируем весь проект целиком
COPY . .

# Собираем весь проект (многомодульный)
RUN mvn clean package -DskipTests

FROM openjdk:17-alpine

RUN apk add --no-cache curl && addgroup -S appuser && adduser -S appuser -G appuser

WORKDIR /app

# Копируем собранный jar из нужного модуля, например config-server
COPY --from=build /app/cloud-config-server/target/*.jar app.jar

RUN chown appuser:appuser app.jar

USER appuser

EXPOSE 8888

ENTRYPOINT ["java", "-jar", "app.jar"]
