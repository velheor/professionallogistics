FROM tomcat:9.0.36
MAINTAINER velheor
EXPOSE 8080
COPY /build/libs/professionallogistics-0.0.1-SNAPSHOT.war /usr/local/tomcat/webapps/
CMD ["catalina.sh","run"]