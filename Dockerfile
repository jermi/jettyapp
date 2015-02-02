FROM maven:3.2.5-jdk-8-onbuild
MAINTAINER kkoziel
CMD ["mvn", "clean", "install"]
