# Spring Boot Note

</br>

## List of Contents:
### 1. [Building a RESTful Web Service](#content-1)
### 2. [7 Things to Know for Getting Started With Spring Boot](#content-2)

</br>

---


## Contents:

## [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/#scratch) <span id="content-1"></span>

### Starting with Spring Initialize
- We can initialize our project using Sprint Initialize!


### Create a Resource Representation Class
- The service will handle `GET` requests for` /greeting`, optionally with a name parameter in the query string.
- The GET request should return a 200 OK response with JSON in the body that represents a greeting. It should resemble the following output:
  ```json
  {
      "id": 1,
      "content": "Hello, World!"
  }
  ```
- To model the greeting representation, create a resource representation class. To do so, provide a plain old Java object with fields, constructors, and accessors for the id and content data, as the following listing (from src/main/java/com/example/restservice/Greeting.java) shows:
  ```java
  package com.example.restservice;

  public class Greeting {

  	private final long id;
  	private final String content;

  	public Greeting(long id, String content) {
  		this.id = id;
  		this.content = content;
  	}

  	public long getId() {
  		return id;
  	}

  	public String getContent() {
  		return content;
  	}
  }
  ```

### Create a Resource Controller
- In Spring’s approach to building RESTful web services, HTTP requests are handled by a controller.
- These components are identified by the @RestController annotation, and the GreetingController shown in the following listing (from src/main/java/com/example/restservice/GreetingController.java) handles GET requests for /greeting by returning a new instance of the Greeting class:
  ```java
  package com.example.restservice;

  import java.util.concurrent.atomic.AtomicLong;

  import org.springframework.web.bind.annotation.GetMapping;
  import org.springframework.web.bind.annotation.RequestParam;
  import org.springframework.web.bind.annotation.RestController;

  @RestController
  public class GreetingController {

  	private static final String template = "Hello, %s!";
  	private final AtomicLong counter = new AtomicLong();

  	@GetMapping("/greeting")
  	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
  		return new Greeting(counter.incrementAndGet(), String.format(template, name));
  	}
  }
  ```
- The `@GetMapping` annotation ensures that HTTP GET requests to `/greeting` are mapped to the `greeting()` method.
- There are companion annotations for other HTTP verbs (e.g. `@PostMapping` for `POST`). There is also a `@RequestMapping` annotation that they all derive from, and can serve as a synonym (e.g. `@RequestMapping(method=GET)`).
- `@RequestParam` binds the value of the query string parameter `name` into the `name` parameter of the `greeting()` method. If the `name` parameter is absent in the request, the `defaultValue` of `World` is used.
- A key difference between a traditional MVC controller and the RESTful web service controller shown earlier is the way that the HTTP response body is created.
- Rather than relying on a view technology to perform server-side rendering of the greeting data to HTML, this RESTful web service controller populates and returns a Greeting object. The object data will be written directly to the HTTP response as JSON.
- This code uses Spring `@RestController` annotation, which marks the class as a controller where every method returns a domain object instead of a view. It is shorthand for including both `@Controller` and `@ResponseBody`.
- The `Greeting` object must be converted to JSON. Thanks to Spring’s HTTP message converter support, you need not do this conversion manually. Because Jackson 2 is on the classpath, Spring’s `MappingJackson2HttpMessageConverter` is automatically chosen to convert the Greeting instance to JSON.
- @SpringBootApplication is a convenience annotation that adds all of the following:
  - `@Configuration`: Tags the class as a source of bean definitions for the application context.
  - `@EnableAutoConfiguration`: Tells Spring Boot to start adding beans based on classpath settings, other beans, and various property settings. For example, if spring-webmvc is on the classpath, this annotation flags the application as a web application and activates key behaviors, such as setting up a `DispatcherServlet`.
  - `@ComponentScan`: Tells Spring to look for other components, configurations, and services in the com/example package, letting it find the controllers.
- The `main()` method uses Spring Boot’s `SpringApplication.run()` method to launch an application.


### Build an executable JAR
- You can run the application from the command line with Gradle or Maven. You can also build a single executable JAR file that contains all the necessary dependencies, classes, and resources and run that.
- Building an executable jar makes it easy to ship, version, and deploy the service as an application throughout the development lifecycle, across different environments, and so forth.
- If you use Gradle, you can run the application by using `./gradlew bootRun`. Alternatively, you can build the JAR file by using `./gradlew build` and then run the JAR file, as follows:
  ```shell
  java -jar build/libs/gs-rest-service-0.1.0.jar
  ```

**[⬆ back to top](#list-of-contents)**

</br>

---

## [7 Things to Know for Getting Started With Spring Boot](https://dzone.com/articles/7-things-to-know-getting-started-with-spring-boot) <span id="content-2"></span>

### Understanding Spring Boot's Architecture
- The building blocks of Spring Boot are:
  - Spring Boot Starter Projects
  - Spring Boot Starter Parent
  - Auto Configuration


### Spring Boot vs. Spring MVC vs. Spring
- Spring Boot does not compete with Spring or Spring MVC. It makes it easy to use them.

### Spring Framework
- The most important feature of Spring Framework is Dependency Injection. At the core of all Spring Modules is Dependency Injection or IOC — Inversion of Control.
- When DI or IOC is used properly, we can develop loosely coupled applications. And loosely coupled applications can be easily unit tested.

### Spring MVC
- Spring MVC provides a decoupled way of developing web applications. With simple concepts like Dispatcher Servlet, ModelAndView, and View Resolver, it makes it easy to develop web applications.
  

### Spring Boot
- The problem with Spring and Spring MVC is the amount of configuration that is needed.
- Spring Boot solves this problem through a combination of Auto Configuration and Starter Projects. Spring Boot also provides a few features to make building production-ready applications faster.


### Spring Boot Auto Configuration
- Spring and Spring MVC applications have a lot of XML or Java Bean Configuration.
- Spring Boot looks at a) Frameworks available on the CLASSPATH b) Existing configurations for the application. Based on these, Spring Boot provides the basic configuration needed to configure the application with these frameworks. This is called Auto Configuration.


### Spring Boot Starter Projects
- Starters are a set of convenient dependency descriptors that you can include in your application. You get a one-stop-shop for all the Spring and related technology that you need, without having to hunt through sample code and copy paste loads of dependency descriptors. For example, if you want to get started using Spring and JPA for database access, just include the spring-boot-starter-data-jpa dependency in your project, and you are good to go
- If you want to develop a web application or an application to expose RESTful services, Spring Boot Start Web is the starter to pick.
- This is a wide variety of components that are typically used to develop web applications.
  - Spring — core, beans, context, AOP
  - Web MVC — (Spring MVC)
  - Jackson — for JSON Binding
  - Validation — Hibernate Validator, Validation API
  - Embedded Servlet Container — Tomcat
  - Logging — logback, slf4j
- Spring Boot provides a wide range of starter projects. Spring Initializr suppports all of them and more.

### Spring Boot Starter Parent
- All Spring Boot projects typically use spring-boot-starter-parent as the parent in the pom.xml.
- Parent POMs allow you to manage the following things for multiple child projects and modules:
  - Configuration: Java version and other properties
  - Depedency Management: Version of dependencies
  - Default plugin configuration


### Spring Initializr: Create Spring Boot Projects at F1 Speed
- Spring Initializr is great tool to bootstrap your Spring Boot projects.
- It allows you to create a varied range of Spring Boot-based applications from a very simple UI. Some of the types of applications you can bootstrap are:
  - Web applications
  - Restful applications
  - Batch applications
- As shown in the image above, the following steps have to be taken:
  - Launch Spring Initializr (http://start.spring.io/)
  - Click the Generate Project button at the bottom of the page.
  - Import the project into Eclipse.


### Spring Boot and Embedded Servers
- For example, for a Spring Boot Application, you can generate an application JAR that contains Embedded Tomcat. You can run a web application as a normal Java application!
- An embedded server implies that our deployable unit contains the binaries for the server (for example, tomcat.jar).
- Tomcat is the default embedded server for Spring Boot.


### Spring Data
- Spring Data’s mission is to provide a familiar and consistent, Spring-based programming model for data access while still retaining the special traits of the underlying data store. It makes it easy to use data access technologies, relational and non-relational databases, map-reduce frameworks, and cloud-based data services.
- Some of the sub modules in Spring Data are:
  - Spring Data JPA — relational databases
  - Spring Data MongoDB
  - Spring Data REST — Expose awesome REST APIs around Spring Data Repositories


**[⬆ back to top](#list-of-contents)**

</br>

---

## References:
- https://spring.io/guides/gs/rest-service/#scratch
- https://dzone.com/articles/7-things-to-know-getting-started-with-spring-boot