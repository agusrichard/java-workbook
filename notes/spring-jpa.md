# Spring Data JPA

</br>

## List of Contents:
### 1. [Working with Relationships in Spring Data REST](#content-1)

</br>

---


## Contents:

## [Working with Relationships in Spring Data REST](https://www.baeldung.com/spring-data-rest-relationships) <span id="content-1"></span>

### One-to-One Relationship
- The data model, Library:
  ```java
  @Entity
  public class Library {

      @Id
      @GeneratedValue
      private long id;

      @Column
      private String name;

      @OneToOne
      @JoinColumn(name = "address_id")
      @RestResource(path = "libraryAddress", rel="address")
      private Address address;
      
      // standard constructor, getters, setters
  }
  ```
- The data model, Address:
  ```java
  @Entity
  public class Address {

      @Id
      @GeneratedValue
      private long id;

      @Column(nullable = false)
      private String location;

      @OneToOne(mappedBy = "address")
      private Library library;

      // standard constructor, getters, setters
  }
  ```
- The repositories:
  ```java
  public interface LibraryRepository extends CrudRepository<Library, Long> {}

  public interface AddressRepository extends CrudRepository<Address, Long> {}
  ```

### One-to-Many Relationship
- The data model Book:
  ```java
  @Entity
  public class Book {

      @Id
      @GeneratedValue
      private long id;
      
      @Column(nullable=false)
      private String title;
      
      @ManyToOne
      @JoinColumn(name="library_id")
      private Library library;
      
      // standard constructor, getter, setter
  }
  ```
- The data model Library:
  ```java
  public class Library {
   
      //...
   
      @OneToMany(mappedBy = "library")
      private List<Book> books;
   
      //...
   
  }
  ```
- Repository:
  ```java
  public interface BookRepository extends CrudRepository<Book, Long> { }
  ```

### Many-to-Many Relationship
- The data model Author:
  ```java
  @Entity
  public class Author {

      @Id
      @GeneratedValue
      private long id;

      @Column(nullable = false)
      private String name;

      @ManyToMany(cascade = CascadeType.ALL)
      @JoinTable(name = "book_author", 
        joinColumns = @JoinColumn(name = "book_id", referencedColumnName = "id"), 
        inverseJoinColumns = @JoinColumn(name = "author_id", 
        referencedColumnName = "id"))
      private List<Book> books;

      //standard constructors, getters, setters
  }
  ```
- The data model Book:
  ```java
  public class Book {
   
      //...
   
      @ManyToMany(mappedBy = "books")
      private List<Author> authors;
   
      //...
  }
  ```
- Repository:
  ```java
  public interface AuthorRepository extends CrudRepository<Author, Long> { }
  ```



**[⬆ back to top](#list-of-contents)**

</br>

---

## References:
- https://www.baeldung.com/spring-data-rest-relationships