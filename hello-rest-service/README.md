# A Note for My Hello World Project

## Starting with Spring Initialize
- We can initialize our project using Sprint Initialize!


## Create a Resource Representation Class
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


## Build an executable JAR
- You can run the application from the command line with Gradle or Maven. You can also build a single executable JAR file that contains all the necessary dependencies, classes, and resources and run that.
- Building an executable jar makes it easy to ship, version, and deploy the service as an application throughout the development lifecycle, across different environments, and so forth.
- If you use Gradle, you can run the application by using `./gradlew bootRun`. Alternatively, you can build the JAR file by using `./gradlew build` and then run the JAR file, as follows:
  ```shell
  java -jar build/libs/gs-rest-service-0.1.0.jar
  ```