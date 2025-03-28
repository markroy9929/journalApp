# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.7.16/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.7.16/maven-plugin/reference/html/#build-image)
* [Spring Web](https://docs.spring.io/spring-boot/docs/2.7.16/reference/htmlsingle/index.html#web)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)

# Notes  
## L 10  
### ORM  
Object-Relational Mapping    
ORM is a technique used to map Java objects to database tables.    
It allows developers to work with databases using object-oriented programming concepts, making it easier to interact with relational database    
Consider a Java class User and a database table users.  
ORM frameworks like Hibernate can map the fields in the User class to columns in the users table, making it easier to insert, update, retrieve, and delete records.      
  
### JPA  
Java Persistence API    
A way to achieve ORM, includes interfaces and annotations that you use in your Java classes, requires a persistence provider (ORM tools) for implementation.    
  
### Persistence Provider / ORM tools  
To use JPA, you need a persistence provider. A persistence provider is a specific implementation of the JPA specification.   
Examples of JPA persistence providers include Hibernate, EclipseLink, and OpenJPA.  
These providers implement the JPA interfaces and provide the underlying functionality to interact with databases.  
  
### Spring Data JPA  
Spring Data JPA is built on top of the JPA (Java Persistence API) specification, but it is not a JPA implementation itself.  
Instead, it simplifies working with JPA by providing higher-level abstractions and utilities.  
However, to use Spring Data JPA effectively, you still need a JPA implementation, such as Hibernate, EclipseLink, or another JPA-compliant provider, to handle the actual database interactions.  
  
JPA is primarily designed for working with relational databases, where data is stored in tables with a predefined schema.  
MongoDB, on the other hand, is a NoSQL database that uses a different data model, typically based on collections of documents, which are schema-less or have flexible schemas.  
This fundamental difference in data models and storage structures is why JPA is not used with MongoDB.  
  
### Spring Data MongoDB  
In the case of MongoDB, you don't have a traditional JPA persistence provider.  
MongoDB is a NoSQL database, and Spring Data MongoDB serves as the "persistence provider" for MongoDB.  
It provides the necessary abstractions and implementations to work with MongoDB in a Spring application.  

Query Method DSL and Criteria API are two different ways to interact with a database when using Spring Data JPA for relational databases and Spring Data MongoDB for MongoDB databases.  
Spring Data JPA is a part of the Spring Framework that simplifies data access in Java applications, while Spring Data MongoDB provides similar functionality for MongoDB.  
Query Method DSL is a simple and convenient way to create queries based on method naming conventions, while the Criteria API offers a more dynamic and programmatic approach for building complex and custom queries  
  
