FROM alpine:latest

RUN apk add --update openjdk21
RUN apk add --update maven
# CMD ["/bin/bash"]

WORKDIR /home/spring

RUN addgroup -S spring && adduser -h /home/spring -S spring -G spring

EXPOSE 8080