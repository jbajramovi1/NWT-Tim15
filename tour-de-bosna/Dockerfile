FROM node:8.11
  
WORKDIR /app
ADD . /app

RUN npm install -g npm   
RUN npm install -g ember-cli

EXPOSE 4200  
EXPOSE 49152

CMD [ "ember", "server" ]
