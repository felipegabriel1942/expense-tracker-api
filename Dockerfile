FROM maven:3.8.5-openjdk-11 as build
WORKDIR /build
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:11
WORKDIR /app
COPY --from=build ./build/target/*.jar ./expensetrackerapi.jar
ENTRYPOINT java -jar expensetrackerapi.jar