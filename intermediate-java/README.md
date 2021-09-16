# Intermediate Java programming

<br />

## List of Contents:
### 1. [Inheritance and abstraction](#content-1)
### 2. [Interfaces](#content-2)



<br />

---

## Contents:

## [Inheritance and abstraction](https://developer.ibm.com/tutorials/j-intermed/) <span id="content-1"></span>

### What’s inheritance?
- Classes in Java code exist in hierarchies. Classes above a given class in a hierarchy are superclasses of that class.
- The class Object is at the top of every class’s hierarchy. In other words, every class is a subclass of (and inherits from) Object.
- Example:
    ```java
    public class Adult {
        protected int age = 0;
        protected String firstname = "firstname";
        protected String lastname = "lastname";
        protected String gender = "MALE";
        protected int progress = 0;
    
        public Adult() { }
        public void move() {
            System.out.println("Moved.");
        }
        public void talk() {
            System.out.println("Spoke.");
        }
    }
    ```
- Our Adult class implicitly inherits from Object. That’s assumed for any class, so you don’t have to type extends Object in the class definition.
- In this case, it means that Adult can see and use the following from any of its superclasses (we have only one at the moment):
  - public methods and variables
  - protected methods and variables
  - Package protected methods and variables (that is, those without an access specifier), if the superclass is in the same package as Adult
- Constructors are special. They aren’t full-fledged OO members, so they aren’t inherited.
- If a subclass overrides a method or variable from the superclass — if the subclass implements a member with the same name, in other words — that hides the superclass’s member.
- o be accurate, overriding a variable hides it, and overriding a method simply overrides it, but the effect is the same: The overridden member is essentially hidden. You can still get to the members of the superclass by using the super keyword:
  ```java
  super.hiddenMemberName
  ```
- In the case of Adult, all it inherits at the moment are the methods on Object (toString(), for example). So, the following code snippet is perfectly acceptable:
  ```java
  Adult anAdult = new Adult();
  anAdult.toString();
  ```
- For example, our Adult constructor actually looks like this at runtime, even though we didn’t type anything in the body:
  ```java
  public Adult() {
      super();
  }
  ```

### Defining a class hierarchy
- Example:
  ```java
  public class Baby {
      protected int age = 0;
      protected String firstname = "firstname";
      protected String lastname = "lastname";
      protected String gender = "MALE";
      protected int progress = 0;
  
      public Baby() {
      }
      public void move() {
          System.out.println("Moved.");
      }
      public void talk() {
          System.out.println("Spoke.");
      }
  }
  ```
- Our Adult and Baby classes look very similar. In fact, they’re almost identical. That kind of code duplication makes maintaining code more painful than it needs to be.
- Refactored:
  ```java
  public class Person {
      protected int age = 0;
      protected String firstname = "firstname";
      protected String lastname = "lastname";
      protected String gender = "MALE";
      protected int progress = 0;
      public Person() {
      }
      public void move() {
          System.out.println("Moved.");
      }
      public void talk() {
          System.out.println("Spoke.");
      }
  }
  ```

### Abstraction
- In an OO context, abstraction refers to the act of generalizing data and behavior to a type higher up the hierarchy than the current class. When you move variables or methods from a subclass to a superclass, you’re abstracting those members.
- An abstract class is a class that can’t be instantiated. For example, you might create a class called Animal. It makes no sense to instantiate such a class: In practice, you’d only want to create instances of a concrete class like Dog.

### Using abstraction
- Our Person class contains some method behavior that we don’t know we need yet. Let’s remove it and force subclasses to implement that behavior polymorphically.
- Example:
  ```java
  public abstract class Person {
      ...
      abstract void move();
      abstract void talk();
  }
  
  public class Adult extends Person {
      public Adult() {
      }
      public void move() {
          System.out.println("Walked.");
      }
      public void talk() {
          System.out.println("Spoke.");
      }
  }
  
  public class Baby extends Person {
      public Baby() {
      }
      public void move() {
          System.out.println("Crawled.");
      }
      public void talk() {
          System.out.println("Gurgled.");
      }
  }
  ```
- When you declare a method to be abstract, you require subclasses to implement the method, or to be abstract themselves and pass along the implementation responsibility to their subclasses.
- Simply declare the ones you don’t want to implement as abstract, and don’t provide a method body. If a subclass fails to implement an abstract method from a superclass, the compiler will complain.

### Refactoring to abstract behavior
- Example:
  ```java
  public class Adult extends Person {
      ...
      public void move() {
          this.progress++;
      }
       ...
  }
  
  public class Baby extends Person {
      ...
      public void move() {
          this.progress++;
      }
      ...
  }
  ```
- Now each class updates its instance variable to reflect some progress being made whenever we call move(). But notice that the behavior is the same again. It makes sense to refactor the code to remove this code duplication. The most likely refactoring is to move move() to Person.
- You often see classes and methods change as your system grows, and sometimes you end up with code duplication that you can refactor to superclasses.
- You might even do that, decide it was a mistake, and put the behavior back down in the subclasses. You simply can’t know the right place for all behavior at the beginning of the development process. You learn the right place for behavior as you go.
- Refactored:
  ```java
  public abstract class Person {
      ...
      public void move() {
          this.progress++;
      }
      public abstract void talk();
  }
  
  public class Adult extends Person {
      public Adult() {
      }
      public void talk() {
          System.out.println("Spoke.");
      }
  }
  
  public class Baby extends Person {
      public Baby() {
      }
      public void talk() {
          System.out.println("Gurgled.");
      }
  }
  ```

### When to abstract … and when not to
- First, don’t abstract first. Wait until the code tells you that you should. It is almost always better to refactor your way to an abstraction than to assume that you need it at the outset. Don’t assume that you need a hierarchy. Many Java programmers overuse hierarchies.
- Second, resist the use of abstract classes when you can. They’re not bad; they’re just restrictive.
- We used an abstract class to force our subclasses to implement certain behavior.
- Your code will be easier to understand if it isn’t made up of complex hierarchies with a mix of overridden and implemented methods.
- You might have a method defined three or four classes up the chain. By the time you use it in a sub-sub-sub-subclass, you might have to hunt to discover what that method does. That can make debugging frustrating.
- Third, do use a hierarchy and/or abstract classes when it’s smart to do so. There are many coding patterns that make use of the Java language abstract method and abstract class concepts, such as the Gang of Four Template Method pattern (see Resources).
- Fourth, understand the price you pay when you use a hierarchy prematurely. It really can lead you down the wrong path quickly, because having the classes there, named as they are, with the methods they have, makes it very easy to assume all of that should be as it is. Maybe that hierarchy made sense when you created it, but it might not make sense anymore. Inertia can make it resistant to change.


**[⬆ back to top](#list-of-contents)**

<br />

## [Interfaces](https://developer.ibm.com/tutorials/j-intermed/) <span id="content-2"></span>

### What’s an interface?
- The Java language includes the concept of an interface, which is simply a named set of publicly available behaviors and/or constant data elements for which an implementer of that interface must provide code.
- In essence (and to the Java compiler), an interface defines a new data type, and it’s one of the more powerful features of the language.
- Other classes implement the interface, which means that they can use any constants in that interface by name, and that they must specify behavior for the method definitions in the interface.

### Defining interfaces
- Example:
  ```javascript
  public interface interfaceName {
      final constantTypeconstantName = constantValue;
      ...
      returnValueTypemethodName( arguments );
      ...
  }
  ```
- An interface declaration looks very similar to a class declaration, except that you use the interface keyword.
- You can name the interface anything you want, as long as the name is valid, but by convention interface names look like class names. You can include constants, method declarations, or both in an interface.
- Constants defined in an interface look like constants defined in classes. The public and static keywords are assumed for constants defined in an interface, so you don’t have to type them. (final is assumed as well, but most programmers type it out anyway).
- Methods defined in an interface look different (generally speaking) from methods defined in classes, because methods in an interface have no implementation.
- Any implementer of the interface is responsible for supplying the body of the method. The public and abstract keywords are assumed for methods, so you don’t have to type them.
- Interface extends another interface
  ```java
  public interface interfaceName extends superinterfaceName, ... {
      interface body...
  }
  ```
- Example:
  ```java
  public interface Human {
      final String GENDER_MALE = "MALE";
      final String GENDER_FEMALE = "FEMALE";
      void move();
      void talk();
  }
  ```

### Implementing interfaces
- To use an interface, you simply implement it, which means providing behavior for the methods defined in the interface. You do that with the implements keyword:
  ```java
  public class className extends superclassName implements
     interfaceName, ... {
      class body
  }
  ```
- By convention, the extends clause (if there is one) comes first, followed by the implements clause. You can implement more than one interface by listing the interface names separated by commas.
- Example:
  ```java
  public abstract class Person implements Human {
      protected int age = 0;
      protected String firstname = "firstname";
      protected String lastname = "lastname";
      protected String gender = Human.GENDER_MALE;
      protected int progress = 0;
      public void move() {
          this.progress++;
      }
  }
  ```
- When we implement the interface, we provide behavior for the methods. We have to implement those methods with signatures that match the ones in the interface, with the addition of the public access modifier.
- But we’ve implemented only move() on Person. Don’t we have to implement talk()? No, because Person is an abstract class, and the abstract keyword is assumed for methods in an interface.
- That means any abstract class implementing the interface can implement what it wants, and ignore the rest. If it does not implement one or more methods, it passes that responsibility on to its subclasses. In our Person class, we chose to implement move() and not talk(), but we could have chosen to implement neither.
- The instance variables in our class aren’t defined in the interface. Some helpful constants are, and we can reference them by name in any class that implements the interface, as we did when we initialized gender.
- It’s also quite common to see interfaces that contain only constants. If that’s the case, you don’t have to implement the interface to use those constants. Simply import the interface (if the interface and the implementing class are in the same package, you don’t even have to do that) and reference the constants like this:
- How to use interface which contains constants:
  ```java
  interfaceName.constantName
  ```




**[⬆ back to top](#list-of-contents)**

<br />

---
## References:
- https://developer.ibm.com/tutorials/j-intermed/
