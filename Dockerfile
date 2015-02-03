FROM java:8-jre
MAINTAINER kkoziel

ADD ./target/jettyapp-1.2.0.RC2.war /srv/jettyapp.war
WORKDIR /srv
ENTRYPOINT ["java", "-jar", "/srv/jettyapp.war"]

EXPOSE 8080
