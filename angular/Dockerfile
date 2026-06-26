FROM alpine:latest

ARG ANGULAR_PROJECT_NAME=sprindax_default_app

ENV ANGULAR_PROJECT_NAME=${ANGULAR_PROJECT_NAME}
ENV HELPER_SCRIPTS_FOLDER=/usr/share/scripts
ENV ANGULAR_WEB_PATH=/var/www/frontend

WORKDIR ${ANGULAR_WEB_PATH}

RUN apk add --update nodejs npm && \
    npm install -g @angular/cli --force && \
    npm install npm -g --force

RUN mkdir -p -v ${HELPER_SCRIPTS_FOLDER}
COPY initAngularProject.sh ${HELPER_SCRIPTS_FOLDER}/

RUN chmod +x ${HELPER_SCRIPTS_FOLDER}/initAngularProject.sh
RUN sh ${HELPER_SCRIPTS_FOLDER}/initAngularProject.sh

WORKDIR ${ANGULAR_WEB_PATH}

EXPOSE 4200