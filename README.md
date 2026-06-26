# SpriNDAX! A fully comprehensive Java, Angular, Nginx, MongoDb or MySQL Docker container

## Introduction

### Overview

SpriNDAX stands for:

- **Spri**ng
- **N**ginx
- **D**ocker
- **A**ngular
- **X** is a variable and stands for the database MongoDb or MySQL

This repository serves as a **clean boilerplate template** for full-stack development.
Please note that upon cloning this repository, the project directories `workDir/backend` and `workDir/frontend` are **intentionally empty**. They act as placeholders.

Once you follow the installation and build steps below, the automated setup will generate a brand-new, fresh **Spring Boot** and **Angular** project inside these folders, giving you a clean slate to start building your application immediately.

Feel free to use the repo. I always try to keep the repo up to date.

## 2. Installation

### 2.1 Clone the project

`git clone https://github.com/Ninosaurier/SpriNDAX.git`

and change the origin url with your origin:

`git remote set-url origin <Your-Repo-URL>`

### 2.2 Go in the project folder

Go to the project folder: `cd SpriNDAX`

### 2.3 Create necessary files

Add a .env for your local development. Docker will use it for the build. You can copy all necessary values from .env.example

### 2.4 Get the Spring boot application

1. Go to [Spring initializr](https://start.spring.io/).
2. Set the project on **Maven** and language on **Java**
3. Choose your Spring boot version
4. Change the project metadata or take the example data
5. Choose a Java version (Be careful! You need the same version like in the dockerfile in the folder spring!)
6. Go to dependencies and add (Or other):
    - Spring Boot DevTools
    - Spring Web
7. Generate and download it
8. Unzip the file
9. Copy all files in the folder in the project **workDir/backend/**

### 2.5 Build the docker image

Build the Docker-Images `docker compose build`.

### 2.6 Start the containers

Start the container: `docker compose up -d`.

With `docker ps` you will have the following output:

```bash
> $ docker-compose ps
Image ...                 Ports                                                Names
--------------------------------------------------------------------------------------------------
angular-sprindax-app      0.0.0.0:3000->3000/tcp, :::4200->4200/tcp            angular-sprindax-app
nginx-sprindax-app        0.0.0.0:80->80/tcp,     :::80->80/tcp, 9001/tcp      nginx-sprindax-app
spring-sprindax-app       0.0.0.0:8080->8080/tcp, :::8080->8080/tcp            spring-sprindax-app
mysql                     0.0.0.0:8081->8081/tcp, :::8081->8081/tcp, 27017/tcp mysql-sprindax-db
```

## 3. Docker Environment Note: Invalid Host Header Fix

When running the Angular development server inside Docker, you might encounter an `Invalid Host Header` error or connectivity issues between containers.

This happens because newer Angular versions include a security feature that blocks requests from unexpected hostnames (like the internal Docker service name or custom local domains).

### 3.1 Solution

To allow internal Docker communication and custom local domains, ensure that your `angular.json` includes the `allowedHosts` whitelist under the `serve`->`options`->`allowedHosts` options:

```json
"options": {
    "allowedHosts": [
        "angular"
    ],
},
```

## 4. Try it

Open your browser and make sure everything worked.
The Angular container can be accessed via the URL `http://angular.localhost` and the Spring container via `http://spring.localhost`.

## 5. Do you need MySQL? Edit the docker-compose.yml

If you need MySQl, comment out the section after "db", and enable the lines needed for the MySQL container.

## 6. Nginx logs

The logs are cached and you will find them in project folder **workDir/logs**

## 7. Useful Commands

- Shows all running containers: `docker ps`
- If you want to use the shell from the container itself: `docker exec -it <container_name> sh`

## 8. FAQ

### How can i change the user ownership? I can not edit files

- Command: `sudo chown -R $USER ./workDir/*`.

### How can I change the working directory of a Docker container?

- Please make yourself familiar with the commands of [Docker](https://docs.docker.com/compose/). Use the respective "Dockerfile" for changes. But be careful! If you change the working directory, then you must also do it in the respective configuration files of the Nginx. The **angular.conf** contains the working directory where Nginx will look for the Angular project!

## 9. License

MIT License

Copyright (c) 2026 Antonino Provenzano

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
