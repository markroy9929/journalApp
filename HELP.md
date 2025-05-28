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

## OLD files
```java
package net.engineeringdigest.journalApp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


// REST API stands for Representational State Transfer Application Programming Interface
// HTTP verb + URL
// HTTP verb: GET-read, PUT-modify, POST-create, DELETE     |  URL: endoint localhost:80/netflix/plans
@RestController
class MyClass {

    @GetMapping("abc")
    public String sayHello() {
        return "Hello";
    }
}



package net.engineeringdigest.journalApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController  // @Bean bna dega
public class Car {

    @Autowired  // Dependency injection
    private Dog dog;  // Field injection

    @GetMapping("/ok")
    public String ok() {
        return dog.fun();
    }
}




package net.engineeringdigest.journalApp;

import org.springframework.stereotype.Component;


// @Bean bna dega, bean ko class pr nahi lagate, @Bean ko function pr lagate hai
@Component  // IOC container apne paas ye class rakh lega, also known as application context
public class Dog {

    public String fun(){
        return "Dog class ke andar fun - something";
    }
}


```

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
  
## L 18  
### Spring Security  
Spring Security is a powerful and highly customizable security framework that is often used in Spring Boot applications to handle authentication and authorization.  
### Authentication  
The process of verifying a user's identity (e.g., username and password)  
### Authorization  
The process of granting or denying access to specific resources or actions based on the authenticated user's roles and permissions.  
### Configuration  
Once the dependency is added, Spring Boot's autoconfiguration feature will automatically apply security to the application.  
By default, Spring Security uses HTTP Basic Authentication.  
### HTTP Basic Authentication  
The client sends an Authorization header Authorization: Basic <encoded-string> The server decodes the string, extracts the username and password, and verifies them. If they're correct, access is granted. Otherwise, an "Unauthorized" response is sent back  
### Encoding  
Credentials are combined into a string like username:password which is then encoded using Base64  
By default, all endpoints will be secured. Spring Security will generate a default user with a random password that is printed in the console logs on startup.  
you can also configure username & password in your application.properties  
`spring.security.user.name=user`  
`spring.security.user.password=password`  
### Customize Authentication  
@EnableWebSecurity  
This annotation signals Spring to enable its web security support. This is what makes your application secured. It's used in conjunction with @Configuration.  
SecurityConfig extends WebSecurityConfigurerAdapter

WebSecurityConfigurerAdapter is a utility class in the Spring Security framework that provides default configurations and allows customization of certain features. By extending it, you can configure and customize Spring Security for your application needs.  
configure method provides a way to configure how requests are secured. It defines how request matching should be done and what security actions should be applied.  
  
`http.authorizeRequests()`: This tells Spring Security to start authorizing the requests.  
`.antMatchers("/hello").permitAll()`: This part specifies that HTTP requests matching the path /hello should be permitted (allowed) for all users, whether they are authenticated or not.  
`.anyRequest().authenticated()`: This is a more general matcher that specifies any request (not already matched by previous matchers) should be authenticated, meaning users have to provide valid credentials to access these endpoints.  
`.and()`: This is a method to join several configurations. It helps to continue the configuration from the root (HttpSecurity).  
`.formLogin()`: This enables form-based authentication. By default, it will provide a form for the user to enter their username and password. If the user is not authenticated and they try to access a secured endpoint, they'll be redirected to the default login form.  

You can access /hello without any authentication. However, if you try to access another endpoint, you'll be redirected to a login form.  
When we use the .formLogin() method in our security configuration without specifying .loginPage("/custom-path"), the default login page becomes active.  
Spring Security provides an in-built controller that handles the /login path. This controller is responsible for rendering the default login form when a GET request is made to /login.  
By default, Spring Security also provides logout functionality. When .logout() is configured, a POST request to /logout will log the user out and invalidate their session.  
### Basic Authentication, by its design, is stateless.  
Some applications do mix Basic Authentication with session management for various reasons. This isn't standard behavior and requires additional setup and logic. In such scenarios, once the user's credentials are verified via Basic Authentication, a session might be established, and the client is provided a session cookie. This way, the client won't need to send the Authorization header with every request, and the server can rely on the session cookie to identify the authenticated user.  
  
When you log in with Spring Security, it manages your authentication across multiple requests, despite HTTP being stateless.  
1. Session Creation: After successful authentication, an HTTP session is formed. Your authentication details are stored in this session.  
2. Session Cookie: A JSESSIONID cookie is sent to your browser, which gets sent back with subsequent requests, helping the server recognize your session.  
3. SecurityContext: Using the JSESSIONID, Spring Security fetches your authentication details for each request.  
4. Session Timeout: Sessions have a limited life. If you're inactive past this limit, you're logged out.  
5. Logout: When logging out, your session ends, and the related cookie is removed.  
6. Remember-Me: Spring Security can remember you even after the session ends using a different persistent cookie (typically have a longer lifespan).  
In essence, Spring Security leverages sessions and cookies, mainly JSESSIONID, to ensure you remain authenticated across requests.  

We want our Spring Boot application to authenticate users based on their credentials stored in a MongoDB database.  
This means that our users and their passwords (hashed) will be stored in MongoDB, and when a user tries to log in, the system should check the provided credentials against what's stored in the database.  

A User entity to represent the user data model.  
A repository UserRepository to interact with MongoDB.  
UserDetailsService implementation to fetch user details.  
A configuration SecurityConfig to integrate everything with Spring Security.  
  
## L 22  
### Class Path  
Class Path is a list of jar(s) and directories, which are used by JVM, JVM needs bytecode, bytecode is stored in class path, class path is a method of telling JVM that here are files, find here.  
Class path contains .class files, jars, configuration files.  
application.properties syntax is key=value, we can give configurations by another method YAML.  
### YAML  
YAML ain't markup language, file ext .yml  
  
## L 24  
There are two types of testing: Unit testing and Integration testing.  
Unit testing ka matlab hai, ki jaise koi API banai hai, usme multiple components hai, like 4 function = 4 conponents, multiple components ki individual testing, is called test driven development.  
### JUnit- Java Unit  
  
## L 27
### LOG  
logging is an essential aspect of application development that allows developers to monitor and troubleshoot their applications.  
Spring Boot supports various logging frameworks, such as Logback, Log4j2, and Java Util Logging (JUL)  
### Logback:  
A popular logging framework that serves as the default in many Spring Boot applications. It offers a flexible configuration and good performance.  
### Log4j2:  
Another widely used logging framework with features such as asynchronous logging and support for various output formats.  
### Java Util Logging (JUL):  
The default logging framework included in the Java Standard Edition. While it's less feature-rich than some third-party frameworks, it is straightforward and is part of the Java platform.  

Spring Boot comes with a default logging configuration that uses Logback as the default logging implementation. It provides a good balance between simplicity and flexibility.  
The default configuration is embedded within the Spring Boot libraries, and it may not be visible in your project's source code.  
If you want to customize the logging configuration, you can create your own logback-spring.xml or logback.xml file in the src/main/resources directory. When Spring Boot detects this file in your project, it will use it instead of the default configuration.  
### logging levels  
Logging levels help in categorizing log statements based on their severity. The common logging levels are
TRACE
DEBUG
INFO
WARN
ERROR  
We can set the desired logging level for specific packages or classes, allowing them to control the amount of information logged at runtime.  
By default, logging is enabled for INFO WARN ERROR  
Spring Boot provides annotations like @Slf4j & @Log4j2 that you can use to automatically inject logger instances into your classes  
### Slf4j  
Simple Logging Facade for Java (SLF4J) provides a Java logging API by means of a simple facade pattern. 
Slf4j is logging abstraction framework, with help of this we can talk to underlying implementation.  
Spring Boot allows us to configure logging using properties or YAML files  
### logback.XML  
Same can be achieved by XML  
<configuration>
    <!-- Appender and Logger configurations go here-->
</configuration>
The <configuration> element is the root element of the logback.xml file. All Logback configuration is enclosed within this element.  
  
## L41  
### Kafka  
Open-source distributed event streaming platform  
Kafka is designed to handle data that is constantly being generated and needs to be processed as it comes in, without delays  
Kafka ensures flow of data from source to destination should be smooth  
maan lo user like kr re hai, to 1 million per sec direct calls ja ri hai to notification service, maan lo bich me kafka daal diya, ab 1 million call kafka ko jayengi, but vo jo data hai (jo kafka ko diya gaya hai) vo toot jayega (distributed) across multiple servers, aur usko parallelly consume kra jayega, to yaha scalability aur fault tolerance achieve ho rh hai, system decouple ho gaya hai, asynchronous achieve ho rh hai.  
kafka cluster: group of kafka brokers (1,2,3,4),  
kafka broker: server on which kafka is running,  
kafka producer: write new data into kafka cluster,  
kafka consumer: use krega, data utha lega,  
zookeper: keeps track of kafka cluster health,  
kafka connect: import/send data from external entity (db,file,..) (declarative integration, no code written) (source se jayega data kafka cluster ke andar, agar fetch krna hai to sync se jayega sink me) movement of data in or out of kafka cluster,  
kafka stream: functionalities for data transformation.  
  
🟢 INSTALLATION COMMANDS  
```shell
zookeeper-server-start.bat ..\..\config\zookeeper.properties

kafka-server-start.bat ..\..\config\server.properties

kafka-topics.bat --create --topic my-topic --bootstrap-server localhost:9092 --replication-factor 1 --partitions 3

kafka-console-producer.bat --broker-list localhost:9092 --topic my-topic

kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic my-topic --from-beginning
```
  
### Kafka topic  
Named container for similar events. Unique identifier of a topic is its name.  
Example: Student topic will have student related data, Food Topic will have food related data.  
They are like tables in a database.  
They live inside a broker.  
Producer produce a message into the topic (ultimately to partitions in round robin fashion) or directly to the partitions. Consumer poll continuously for new messages using the topic name.  
Partition - A topic is partitioned and distributed to Kafka brokers in round robin fashion to achieve distributed system.  
Replication factor - A partition is replicated by this factor and it is replicated in another broker to prevent fault tolerance.  

### Partitions  
topic is split into several parts which are known as the partitions of the topic.  
Partitions is where actually the message is located inside the topic.  
Therefore, while creating a topic, we need to specify the number of partitions (the number is arbitrary and can be changed later).  
Each partition is an ordered, immutable sequence of records.  
Each partition is independent of each other.  
Each message gets stored into partitions with an incremental id known as its Offset value.  
Ordering is there only at partition level. (so if data is to be stored in order then do it on same partition)  
Partition continuously grows (offset increases) as new records are produced.  
All the records exist in distributed log file.  
  
two things - key and value, key is optional  
We can send message with key or without key.  
When sending messages with key, ordering will be maintained as they will be in the same partition.  
Without key we can not guarantee the ordering of message as consumer poll the messages from all the partitions at the same time.  
  
🟢 SENDING MESSAGES COMMANDS(key-ordered)  
```shell
zookeeper-server-start.bat ..\..\config\zookeeper.properties

kafka-server-start.bat ..\..\config\server.properties

kafka-topics.bat --create --topic foods --bootstrap-server localhost:9092 --replication-factor 1 --partitions 4

kafka-console-producer.bat --broker-list localhost:9092 --topic foods --property "key.separator=-" --property "parse.key=true"

kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic foods --from-beginning -property "key.separator=-" --property "print.key=false"
```
  
### CONSUMER OFFSET & CONSUMER GROUPS  
Consumer Offset: Position of a consumer in a specific partition of a topic. It represents the latest message, consumer has read.  
When a consumer group reads messages from a topic, each member of the group maintains its own offset and updates it as it consumes messages  
what is _consumer_offset: _consumer_offset is a built-in topic in Apache Kafka that keeps track of the latest offset committed for each partition of each consumer group.  
The topic is internal to the Kafka cluster and not meant to be read or written to directly by clients. Instead, the offset information is stored in the topic and updated by the Kafka broker to reflect the position of each consumer in each partition.  
The information in _consumer_offset is used by Kafka to maintain the reliability of the consumer groups and to ensure that messages are not lost or duplicated.  

There is a separate __consumer_offsets topic created for each consumer group. So if you have 2 consumer groups containing 4 consumers each, you will have a total of 2 __consumer_offsets topics created.  
The __consumer_offsets topic is used to store the current offset of each consumer in each partition for a given consumer group. Each consumer in the group updates its own offset for the partitions it is assigned in the __consumer_offsets topic, and the group coordinator uses this information to manage the assignment of partitions to consumers and to ensure that each partition is being consumed by exactly one consumer in the group.  

When a consumer joins a consumer group, it sends a join request to the group coordinator.  
The group coordinator determines which partitions the consumer should be assigned based on the number of consumers in the group and the current assignment of partitions to consumers.  
The group coordinator then sends a new assignment of partitions to the consumer, which includes the set of partitions that the consumer is responsible for consuming.  
The consumer starts consuming data from the assigned partitions.  

It is important to note that consumers in a consumer group are always assigned partitions in a "sticky" fashion, meaning that a consumer will continue to be assigned the same partitions as long as it remains in the group. This allows consumers to maintain their position in the topic and continue processing where they left off, even after a rebalance.  
  
### SEGMENTS COMMIT LOG & RETENTION POLICY  
Segments: set of messages (Segment size: size define kr sakte hai)  
Commit log: actual data that kafka producer produces
Retention policy: by partition size(1GB) oldest file will be deleted, time based policy(7days), 7 days old file will be deleted.  
by default time based retention policy, log.retention.hours=168 (i.e 7 Days)  
Kafka cluster: Group of kafka brokers
kafka broker: kafka-server-start.bat ..\..\config\server.properties
broker.id=0
broker.id=1
broker.id=2
each broker is leader of any 1 partition 
  
## L 42  
### JWT  
JSON Web Token: JWT is a way to securely transmit information between parties as a JSON object  
JWT is a compact, URL-safe token that can carry information between parties.  
A JWT is a string consisting of three parts, separated by dots  
Header, Payload, Signature  
### Header  
The header typically consists of two parts: the type of the token (JWT) and the signing algorithm being used, such as HMAC SHA256 or RSA.  
```json
{ 
    "alg": "HS256",
    "typ": "JWT"
}
```
### Payload  
The payload contains the claims. Claims are statements about an entity (typically, the user) and additional metadata.  
```json
{
  "email": "email@gmail.com",
  "name": "John Doe"
}
```
### Signature  
The signature is used to verify that the sender of the JWT is who it says it is and to ensure that the message wasn't changed along the way.  
To create the signature part, you have to take the encoded header, the encoded payload, a secret, the algorithm specified in the header, and sign that.  
```
HMACSHA256(
  secret, 
  base64UrlEncode(header) + "." + base64UrlEncode(payload) 
)
```
JWT is stateless  

## L 46  
### OpenAPI Specification  
It defines a standardized format for describing APIs comprehensively  
### Swagger  
Tools used to implement the OpenAPI specification  
Swagger is an open-source framework used for designing, building, documenting, and consuming RESTful APIs. It provides a standardized way to describe the structure of an API, making it easier for developers to understand, integrate, and consume the API.  
### Springfox  
Springfox is a Java library used to integrate Swagger with Spring Boot applications. It automatically generates Swagger documentation from your Spring controllers and models.  
springfox-boot-starter: A starter dependency to quickly set up and integrate Springfox into a Spring Boot project.  
### Springdoc OpenAPI  
Springdoc OpenAPI is an alternative to Springfox. It is designed to generate API documentation from Spring Boot applications using the OpenAPI 3 specification, which is the latest iteration of the Swagger specification.  
springdoc-openapi-ui: A module that integrates Spring Boot applications with Swagger Ul using the OpenAPI 3 specification.  
| FEATURE            | SPRINGFOX               | SPRINGDOC OPENAPI  |
| ------------------ | ----------------------- | ------------------ |
| OPENAPI VERSION    | 2 AND 3                 | 3                  |
| PERFORMANCE        | LOWER                   | HIGHER             |
| DEVELOPMENT STATUS | MATURE, BUT LESS ACTIVE | ACTIVE DEVELOPMENT |
If you are using Spring Boot 3.x then please use below dependency
```
		<dependency>
			<groupId>org.springdoc</groupId>
			<artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
			<version>2.5.0</version>
		</dependency>
```
springdoc.swagger-ui.path = /docs  
```http://localhost:8080/journal/v3/api-docs``` The/v3/api-docs endpoint provides the JSON representation of API's documentation, which can be used by Swagger UI to generate interactive API documentation.  
OpenAPI definition: This is the title of our API documentation. It can be customized  
It scans our Spring Boot application for REST controllers and generates the corresponding API documentation  
It automatically generates API documentation without additional configuration  
Springdoc OpenAPI also scans our application for classes that are used as request bodies or response bodies.  
  
## L 47  
### OAuth2: Open Authorization 2.0
new version of OAuth 1.0  
Sign-in with Google  

------------------------------------------------------------------------------------------------------------------------
run daily:
```
c:; cd 'c:\Users\ANKIT\Documents\Intellij\journalApp'; git add -A; git commit -m "additional commit May 2025"; git push;
```
<!-- 
git init
git add .
git commit -m "april 2025"
git branch -M main
git remote add origin https://github.com/ankitT20/journalApp.git
git push -u origin main
 -->
> Course Deadline was 22 April 2025,
> After extension need to finish by 12 May

> extension Calendar-  
> 23 April: done #27 @ 5pm , learned everything about Logback.xml and Logback,SLF4J...  
> 24 April: done #28 @ 5pm , sonarcube kra, sonarlint plugin dala jo SonarQube IDE ho gya, SonarCloud kra github se import  
> 25 April: done #29 @ 6pm, Calling External API kra, weather API, Quotes api  
> 26 April: done #30 @ 12pm, Weather API me hi Post ka example kra, I implemented the entire quotes service on my own, works fine now!!, done #32 @ 6pm pipedream dekha, Elevenlabs kra, curl lagai postman me text to speach, @Service (business logic) kra.  
> 27 April: done #33 @ 2pm, @Value(${}) annotation class me constants hta kr properties/yml likha, done #34 @ 2pm, @PostConstruct AppCache kra mongoDB se  
> 28 April: done #35 @ 6pm, MongoTemplate, Criteria, Query kra  
> 29 April: done #36 @ 7pm, Java mail sender,gmail SMTP kra,done #37 @ 8pm,Scheduling kri Cron se  
> 30 April: done #37 @ 6pm, sentiment enum bna diya, aur user scheduler me mail bhej diya  
> 1 May: done #39 @ 10pm, redis kra wsl pr, StringRedisSerializer kra, weather aur quotes api me lagaya, sudo service redis-server start
> 2 May: done #40 @ 1am, redis cloud kra, wsl ka redis hata diya  
> 3 May: kuch ni bs 10 min kafka padha  
> 4 May: done #41 half video, Kafka ki theory kri, local system pr install run kra, commands , key ordered kra   
> 5 May: done #41 @ 2am, implemented kafka email sentimentAnalysis service  
> 6 May: done #42 @ 1am, JWT Auth kra, login aur spring context holder me JWT kra, done #43 @ 7pm, Kafka Fallback  
> 7 May: done #44 @ 5pm, application.yml placeholders, railway pr deploy kra  
> 8 May: nothing  
> 9 May: nothing  
> 10 May: done #45 @ 4pm, kusho AI se sari api test krdi
> 11 May: done #46 @ 12pm, Swagger kra  
> 12 May: done #47 @ 5am, PLAYLIST COMPLETED !!! FINISHED **  
