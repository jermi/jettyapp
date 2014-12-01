FROM turbovote/oracle-jdk-7
MAINTAINER kkoziel

ENV http_proxy "http://10.56.3.1:8080/"
RUN apt-get update
RUN apt-get install openjdk-7-jdk -y || echo "error skip"
RUN apt-get install git maven -y

RUN git clone https://github.com/jermi/jettyapp
RUN cd jettyapp && mvn clean install package
ENTRYPOINT ["/usr/bin/java", "-jar", "target/jettyapp-1.2.0.RC2.war"]

EXPOSE 8080
