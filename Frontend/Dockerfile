FROM node:latest

# Creates a new directory for frontend container
WORKDIR /frontendapp

# Moves package json into the directory 
COPY package.json /frontendapp

# Because docker can detect theres a package.json file it allows the npm install to run
RUN npm install

# Moves over all other files to directory
COPY . /frontendapp

RUN npm run build

# 3000 being react default port
EXPOSE 3000

# runs the react app, executes commands once the container has started IMPORTANT: with CMD everything is "," separated
CMD ["npm", "start"]



