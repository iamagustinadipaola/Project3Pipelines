FROM node:16.14-alpine

WORKDIR /Frontend

COPY . .

RUN npm install

RUN npm run build

CMD ["npm", "start"]