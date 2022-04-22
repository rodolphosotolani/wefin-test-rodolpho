FROM postgres:9.6
MAINTAINER Rodolpho T. Sotolani
ADD /target/pessoas-api.jar /usr/src/wefin-test-rodolpho.jar

EXPOSE 8080

CMD java -Duser.timezone=America/Sao_Paulo -jar /usr/src/wefin-test-rodolpho.jar
