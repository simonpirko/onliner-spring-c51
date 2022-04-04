# Name

Onliner clone

# Description

Web application that allows the user to buy online goods from various sellers.
It copies the functionality of this [site](https://catalog.onliner.by/).

## Dependencies

* Spring WebMVC
* Spring ORM
* Java Servlet API
* MySQL Connector
* Hibernate ORM Hibernate Core
* Tomcat DBCP
* Thymeleaf
* Hibernate Validator Engine
* slf4j + log4j
* JUnit 5
* Mockito JUnit Jupiter
* Hamcrest
* String Test

## Features

* Seller and user registration
* User authentication and authorization
* Assigning a role to a user
* Product creation
* Viewing the product catalog

# Installation

## Requirements

* JDK 11
* Maven
* MySQL 5+
* Apache Tomcat 9

## Specific steps

Clone the repository

```bash
git clone https://github.com/simonpirko/onliner-spring-c51.git
```

Download Apache Tomcat from [site](https://tomcat.apache.org/download-90.cgi) and set up application server.

Create a database and set up datasourse in datasourse.properties.

```bash
datasource.driver=com.mysql.cj.jdbc.Driver
datasource.url=jdbc:mysql://<host:port>/<database-name>
datasource.username=<username>
datasource.password=<password>
```

Change the path to the log file in log4j.properties.

```bash
log4j.appender.USER-SERVICE.File=<path-to-log-file>
```

# Project status

Active
