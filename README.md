# Name

Onliner clone

# Description

Web application that allows the user to buy online goods from various sellers.
It copies the functionality of this [site](https://catalog.onliner.by/).

## Dependencies

Spring WebMVC
Spring ORM
Java Servlet API
MySQL Connector
Hibernate ORM Hibernate Core
Tomcat DBCP
Thymeleaf
Hibernate Validator Engine
slf4j + log4j
JUnit 5
Mockito JUnit Jupiter 
Hamcrest
String Test

## Features

1. Seller and user registration
2. User authentication and authorization
3. Assigning a role to a user
3. Product creation
4. Viewing the product catalog

# Installation

## Requirements

JDK 11
Maven
MySQL 5+
Apache Tomcat 9

## Specific steps

Clone the repository

```bash
git clone https://github.com/simonpirko/onliner-spring-c51.git
```

Set up application server

```bash
URL: "http://localhost:8080/"
Application context: "/"
```

Create a database 

```bash
Name: onliner_clone_db
```

Set up datasourse in HibernateConfiguration class

Change the path to the log file in log4j.properties
