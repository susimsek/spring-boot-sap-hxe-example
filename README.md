# Spring Boot Sap Hana Express Example
> Spring Boot Sap Hana Express Example
>
<img src="https://github.com/susimsek/spring-boot-sap-hxe-example/blob/main/images/spring-boot-sap-hxe-example.png" alt="Spring Boot Sap Hana Express Example" width="100%" height="100%"/> 

## Prerequisites

* Minimum 10 GB Memory
* Minimum 4 CPU
* Linux Kernel 4.x
* Docker 19.03+
* Docker Compose 1.25+

## Sap Hana Express Installation

```sh
cd vagrant/docker-compose-setup
```

```sh
sudo chmod u+x install_hxe.sh
```

```sh
sudo ./install_hxe.sh
```

## Build Docker Image

```sh
./mvnw compile jib:dockerBuild
```

## Installation

```sh
docker-compose up -d 
```

## Installation Using Vagrant for Docker-Compose Deployment

<img src="https://github.com/susimsek/spring-boot-sap-hxe-example/blob/main/images/vagrant-installation.png" alt="Spring Boot Vagrant Installation" width="100%" height="100%"/> 

### Prerequisites for Docker-Compose Deployment

* Vagrant 2.2+
* Virtualbox or Hyperv

```sh
vagrant up
```

```sh
vagrant ssh
```

```sh
cd vagrant/docker-compose-setup
```

```sh
sudo chmod u+x *.sh
```

```sh
./install-prereqs.sh
```

```sh
exit
```

```sh
vagrant ssh
```

```sh
docker-compose up -d 
```

You can access the SpringDoc Openapi from the following url.

http://localhost:9090/api

## Used Technologies

* Spring Boot 2.5.2
* Sap Hana Express Edition 2.00.054.00.20210603.1 
* Spring Native
* Spring Boot Web
* Spring Boot Jpa
* Ngdbc
* SpringDoc Openapi Ui
* Spring Boot Actuator
* Maven Clean Plugin
* Maven Enforcer Plugin
* Logback
* Lombok
* Dev Tools
* Spring Boot Test

## SpringDoc OpenApi

> You can access the SpringDoc Openapi from the following url.

http://localhost:9090/api

<img src="https://github.com/susimsek/spring-boot-sap-hxe-example/blob/main/images/springdoc-openapi.png" alt="SpringDoc Openapi" width="100%" height="100%"/> 