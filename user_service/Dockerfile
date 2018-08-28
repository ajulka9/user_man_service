FROM java:8

MAINTAINER ajulka

ENV TZ GMT

RUN mkdir -p /app/data
RUN mkdir -p /app/data/out

RUN echo| which unzip
# install app

COPY build/distributions/UserService-1.0-SNAPSHOT.zip /app/data

RUN unzip /app/data/UserService-1.0-SNAPSHOT.zip -d /app/data/out

CMD ./app/data/out/UserService-1.0-SNAPSHOT/bin/UserService