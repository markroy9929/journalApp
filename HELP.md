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
  
## L 12  
Client ---Request---> Server ---Response(Http status code)---> Client  
### HTTP status code  
An HTTP status code is a three-digit numeric code returned by a web server as part of the response to an HTTP request made by a client  
These status codes are used to convey information about the result or status of the requested operation.  
HTTP status codes are grouped into five categories based on their first digit  
### 1xx (Informational)  
These status codes indicate that the request was received and understood, and the server is continuing to process it. These are typically used for informational purposes and rarely seen in practice.  
### 2xx (Successful)  
These status codes indicate that the request was successfully received, understood, and processed by the server  
Example:  
200 0K: The request has been successfully processed, and the server is returning the requested resource.  
201 Created: The request has been fulfilled, and a new resource has been created as a result.  
204 No Content: The request was successful, but there is no response body (typically used for operations that don't return data, like a successful deletion).  
### 3xx (Redirection)  
These status codes indicate that further action is needed to complete the request. They are used when the client needs to take additional steps to access the requested resource.  
Example:  
301 Moved Permanently: The requested resource has been permanently moved to a different URL.  
302 Found : The HTTP status code 302 indicates that the requested resource has been temporarily moved to a different URL. When a server sends a response with a 302 status code, it typically includes a Location header field that specifies the new temporary URL where the client should redirect to.  
304 Not Modified: The client's cached version of the requested resource is still valid, so the server sends this status code to indicate that the client can use its cached copy.  
### 4xx (Client Error)  
These status codes indicate that there was an error on the client's part, such as a malformed request or authentication issues.  
Example:  
400 Bad Request: The server cannot understand or process the client's request due to invalid syntax or other client-side issues.  
401 Unauthorized: The client needs to provide authentication credentials to access the requested resource.  
403 Forbidden: The client is authenticated, but it does not have permission to access the requested resource.  
### 5xx (Server Error)  
These status codes indicate that there was an error on the server's part while trying to fulfill the request.  
Example:  
500 Internal Server Error: A generic error message indicating that something went wrong on the server, and the server could not handle the request.  
502 Bad Gateway: The server acting as a gateway or proxy received an invalid response from an upstream server.  
503 Service Unavailable: The server is currently unable to handle the request due to temporary overloading or maintenance.  
  
### ResponseEntity  
The ResponseEntity class is part of the Spring Framework and is commonly used in Spring Boot applications to customize the HTTP response.  
It provides methods for setting the response status, headers, and body. You can use it to return different types of data in your controller methods, such as JSON, XML, or even HTML.  
You can use generics with ResponseEntity to specify the type of data you are returning.  
  
## L 13  
### Lombok  
Lombok is a popular library in the Java ecosystem, often used in Spring Boot applications.  
It aims to reduce the boilerplate code that developers have to write, such as getters, setters, constructors, and more.  
Lombok achieves this by generating this code automatically during compilation, based on annotations you add to your Java classes.  
Lombok generates bytecode for methods like getters, setters, constructors, equals(), hashCode(), and toString(), as specified by the annotations used in your code. This generated code is added to the compiled class files (.class files).  
The Java Compiler compiles your classes, including the generated code. This means that the generated methods become part of your compiled class files.  
When you run your application, the generated methods are available for use, just like any other methods in your classes.  

