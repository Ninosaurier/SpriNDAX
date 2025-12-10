FROM alpine:latest

ENV HELPER_SCRIPTS_FOLDER=/usr/share/scripts
ENV ANGULAR_WEB_PATH=/var/www/frontend/

WORKDIR ${ANGULAR_WEB_PATH}

RUN mkdir -p -v ${HELPER_SCRIPTS_FOLDER}
COPY initAngularProject.sh /usr/share/scripts

## add `/app/node_modules/.bin` to $PATH
#ENV PATH /var/www/react/node_modules/.bin:$PATH
RUN apk add --update nodejs npm
RUN npm install -g @angular/cli --force
RUN npm install npm -g --force

# RUN npm install -g react-scripts
#RUN npm install -g create-react-app
#RUN npm cache clean --force

EXPOSE 4200
