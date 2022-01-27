# Spring Boot Tutorial – How to Build Fast and Modern Java Apps

## Notes:
- If you are wondering, "What is Hibernate anyways?", it is an object-relational-mapping (ORM) tool for Java that allows us to map the POJOs (Plain Old Java Object) to database tables.
- Controllers will handle the requests that are passed to this controller by the request handler and return the corresponding views, in this case.
- Services will hold the logic of our application. The best practice is to keep controllers thin by keeping the business logic in a separate place, the service classes.
- Controllers should not interact with the repositories directly, but instead call the service which will interact with the repository, perform any additional operation, and return the result to the controller.

## References:
- https://www.freecodecamp.org/news/spring-boot-tutorial-build-fast-modern-java-app/
- https://github.com/yigiterinc/amenity-reservation-system