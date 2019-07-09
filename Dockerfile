ARG WAR_NAME="netflixWatchlistApp.war"
ARG WILDFLY_VERSION=10.1.0.Final

FROM maven:latest AS build_env
COPY . .
RUN mvn package

FROM jboss/wildfly:${WILDFLY_VERSION}
COPY --from=build_env ./target/${WAR_NAME} /opt/jboss/wildfly/standalone/deployments/
EXPOSE 8080
