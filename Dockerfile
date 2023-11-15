FROM bellsoft/liberica-openjdk-alpine:11.0.19
RUN apk add curl jq
WORKDIR /home/Docker_Selenium_AWS_Framework
ADD target/docker-resources ./
ADD runner.sh  runner.sh
ENTRYPOINT sh runner.sh