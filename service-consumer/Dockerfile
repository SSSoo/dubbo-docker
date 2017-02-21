FROM anapsix/alpine-java:8_jdk
ENV REFRESHED_AT 2017-02-14
VOLUME /tmp
COPY *.jar app.jar
RUN sh -c 'touch /app.jar'
CMD ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]