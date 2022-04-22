FROM openjdk:17-alpine
MAINTAINER Rodolpho T. Sotolani
ADD /target/wefin-test-rodolpho.jar /usr/src/wefin-test-rodolpho.jar

EXPOSE 8080

CMD java -Duser.timezone=America/Sao_Paulo -jar /usr/src/wefin-test-rodolpho.jar
