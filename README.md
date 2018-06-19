# springboot-profile management tool

Spring Boot profile management tool is demonstrating how to implement basic User profile operations with a `Profile` and `Address` entity.

## What's inside 
This project is based on the [Spring Boot](http://projects.spring.io/spring-boot/) project and uses these packages :
- Maven
- Spring Core
- Spring Data JPA(MySQL)
- Spring MVC (Tomcat)
- Mockito


## Installation 
The project is created with Maven, so you just need to import it to your IDE and build the project to resolve the dependencies

## Database configuration 
Create a MySQL database with the name `springbootdb` and add the credentials to `/resources/application.properties`.  
The default ones are :

```
spring.datasource.url=jdbc:mysql://localhost:8080/springbootdb
spring.datasource.username=root
spring.datasource.password=
spring.jpa.hibernate.ddl-auto=update
```

## Usage 
Run the project through the IDE or command line


run this command in the command line:
```
mvn spring-boot:run
```
