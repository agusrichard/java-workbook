# Back to Basic -- Java Tutorial Notes

</br>

## List of Contents:
### 1. [Java Tutorial](#content-1)
### 2. [Java - Basic Syntax](#content-2)
### 2. [Java - Basic Syntax](#content-2)




</br>

---

## Contents:

## [Java Tutorial](https://www.tutorialspoint.com/java/index.htm) <span id="content-1"></span>

- Java is a high-level programming language originally developed by Sun Microsystems and released in 1995.
- Unlike many other programming languages including C and C++, when Java is compiled, it is not compiled into platform specific machine, rather into platform independent byte code. This byte code is distributed over the web and interpreted by the Virtual Machine (JVM) on whichever platform it is being run on.


</br>

---

## [Java - Basic Syntax](https://www.tutorialspoint.com/java/java_basic_syntax.htm) <span id="content-2"></span>

- Object − Objects have states and behaviors. Example: A dog has states - color, name, breed as well as behavior such as wagging their tail, barking, eating. An object is an instance of a class.
- Class − A class can be defined as a template/blueprint that describes the behavior/state that the object of its type supports.
- Methods − A method is basically a behavior. A class can contain many methods. It is in methods where the logics are written, data is manipulated and all the actions are executed.
- Instance Variables − Each object has its unique set of instance variables. An object's state is created by the values assigned to these instance variables.


### Basic Syntax
- Case Sensitivity − Java is case sensitive, which means identifier Hello and hello would have different meaning in Java.
- Class Names − For all class names the first letter should be in Upper Case. If several words are used to form a name of the class, each inner word's first letter should be in Upper Case. Example: class MyFirstJavaClass
- Method Names − All method names should start with a Lower Case letter. If several words are used to form the name of the method, then each inner word's first letter should be in Upper Case. Example: public void myMethodName() </br>
- Program File Name − Name of the program file should exactly match the class name.
  When saving the file, you should save it using the class name (Remember Java is case sensitive) and append '.java' to the end of the name (if the file name and the class name do not match, your program will not compile). </br>
  But please make a note that in case you do not have a public class present in the file then file name can be different than class name. It is also not mandatory to have a public class in the file. </br>
  Example: Assume 'MyFirstJavaProgram' is the class name. Then the file should be saved as 'MyFirstJavaProgram.java'
- public static void main(String args[]) − Java program processing starts from the main() method which is a mandatory part of every Java program.


### Java Identifiers
- All identifiers should begin with a letter (A to Z or a to z), currency character ($) or an underscore (_).
- After the first character, identifiers can have any combination of characters.
- A key word cannot be used as an identifier.
- Most importantly, identifiers are case sensitive.
- Examples of legal identifiers: age, $salary, _value, __1_value.
- Examples of illegal identifiers: 123abc, -salary.
- Snippet: </br>
  ```java
  class FreshJuice {
    enum FreshJuiceSize {
      SMALL, MEDIUM, LARGE
    }

    FreshJuiceSize size;
  }

  public class FreshJuiceTest {
    public static void main(String[] args) {
      FreshJuice juice = new FreshJuice();
      juice.size = FreshJuice.FreshJuiceSize.SMALL;
      System.out.println("Size: " + juice.size);
    }
  }
  ```
- Comments: </br>
  ```java
  public class MyFirstJavaProgram {

    /* This is my first java program.
    * This will print 'Hello World' as the output
    * This is an example of multi-line comments.
    */

    public static void main(String []args) {
      // This is an example of single line comment
      /* This is also an example of single line comment. */
      System.out.println("Hello World");
    }
  }
  ```

</br>

---

## [Java - Object and Classes](https://www.tutorialspoint.com/java/java_object_classes.htm) <span id="content-3"></span>

### Intro
- Java supports the following OOP concepts:
  - Polymorphism
  - Inheritance
  - Encapsulation
  - Abstraction
  - Classes
  - Objects
  - Instance
  - Method
  - Message Passing
- Object − Objects have states and behaviors. Example: A dog has states - color, name, breed as well as behaviors – wagging the tail, barking, eating. An object is an instance of a class.
- Class − A class can be defined as a template/blueprint that describes the behavior/state that the object of its type support.


### Objects in Java
- Software objects also have a state and a behavior.
- A software object's state is stored in fields and behavior is shown via methods.
- So in software development, methods operate on the internal state of an object and the object-to-object communication is done via methods.


### Classes in Java
- A class is a blueprint from which individual objects are created. Example: </br>
  ```java
  public class Dog {
     String breed;
     int age;
     String color;

     void barking() {
     }

     void hungry() {
     }

     void sleeping() {
     }
  }
  ```
- A class can contain any of the following variable types.
  - Local variables − Variables defined inside methods, constructors or blocks are called local variables. The variable will be declared and initialized within the method and the variable will be destroyed when the method has completed.
  - Instance variables − Instance variables are variables within a class but outside any method. These variables are initialized when the class is instantiated. Instance variables can be accessed from inside any method, constructor or blocks of that particular class.
  - Class variables − Class variables are variables declared within a class, outside any method, with the static keyword.


### Constructors
- Every class has a constructor. If we do not explicitly write a constructor for a class, the Java compiler builds a default constructor for that class.
- Each time a new object is created, at least one constructor will be invoked.
- The main rule of constructors is that they should have the same name as the class.
- A class can have more than one constructor.
- Example: </br>
  ```java
  public class Puppy {
    public Puppy() {
    }

    public Puppy(String name) {
      // This constructor has one parameter, name.
    }
  }
  ```
- Java also supports Singleton Classes where you would be able to create only one instance of a class.

### Creating an Object
- There are three steps when creating an object from a class:
  - Declaration − A variable declaration with a variable name with an object type.
  - Instantiation − The 'new' keyword is used to create the object.
  - Initialization − The 'new' keyword is followed by a call to a constructor. This call initializes the new object.
- Example: </br>
  ```java
  public class Puppy {
     public Puppy(String name) {
        // This constructor has one parameter, name.
        System.out.println("Passed Name is :" + name );
     }

     public static void main(String []args) {
        // Following statement would create an object myPuppy
        Puppy myPuppy = new Puppy( "tommy" );
     }
  }
  ```

### Accessing Instance Variables and Methods
- Example: </br>
  ```java
  public class Puppy {
     int puppyAge;

     public Puppy(String name) {
        // This constructor has one parameter, name.
        System.out.println("Name chosen is :" + name );
     }

     public void setAge( int age ) {
        puppyAge = age;
     }

     public int getAge( ) {
        System.out.println("Puppy's age is :" + puppyAge );
        return puppyAge;
     }

     public static void main(String []args) {
        /* Object creation */
        Puppy myPuppy = new Puppy( "tommy" );

        /* Call class method to set puppy's age */
        myPuppy.setAge( 2 );

        /* Call another class method to get puppy's age */
        myPuppy.getAge( );

        /* You can access instance variable as follows as well */
        System.out.println("Variable Value :" + myPuppy.puppyAge );
     }
  }
  ```

### Source File Declaration Rules
- There can be only one public class per source file.
- A source file can have multiple non-public classes.
- The public class name should be the name of the source file as well which should be appended by .java at the end. For example: the class name is public class Employee{} then the source file should be as Employee.java.
- If the class is defined inside a package, then the package statement should be the first statement in the source file.
- If import statements are present, then they must be written between the package statement and the class declaration. If there are no package statements, then the import statement should be the first line in the source file.
- Import and package statements will imply to all the classes present in the source file. It is not possible to declare different import and/or package statements to different classes in the source file.

### Java Package
- In simple words, it is a way of categorizing the classes and interfaces.

### Import Statements
- Import statement is a way of giving the proper location for the compiler to find that particular class.
- For example, the following line would ask the compiler to load all the classes available in directory java_installation/java/io −</br>
  ```shell
  import java.io.*;
  ```

### A Simple Case Study
- First example: </br>
  ```java
  import java.io.*;
  public class Employee {

     String name;
     int age;
     String designation;
     double salary;

     // This is the constructor of the class Employee
     public Employee(String name) {
        this.name = name;
     }

     // Assign the age of the Employee  to the variable age.
     public void empAge(int empAge) {
        age = empAge;
     }

     /* Assign the designation to the variable designation.*/
     public void empDesignation(String empDesig) {
        designation = empDesig;
     }

     /* Assign the salary to the variable	salary.*/
     public void empSalary(double empSalary) {
        salary = empSalary;
     }

     /* Print the Employee details */
     public void printEmployee() {
        System.out.println("Name:"+ name );
        System.out.println("Age:" + age );
        System.out.println("Designation:" + designation );
        System.out.println("Salary:" + salary);
     }
  }
  ```

</br>

---

## [Java - Constructors](https://www.tutorialspoint.com/java/java_constructors.htm) <span id="content-4"></span>

### Introduction
- A constructor initializes an object when it is created.
- However, constructors have no explicit return type.
- Typically, you will use a constructor to give initial values to the instance variables defined by the class, or to perform any other start-up procedures required to create a fully formed object.
- Basic syntax: </br>
  ```java
  class ClassName {
     ClassName() {
     }
  }
  ```
- Java allows two types of constructors namely −
  - No argument Constructors
  - Parameterized Constructors

### No argument Constructors
- Example: </br>
  ```java
  public class MyClass {
     Int num;
     MyClass() {
        num = 100;
     }
  }

  public class ConsDemo {
     public static void main(String args[]) {
        MyClass t1 = new MyClass();
        MyClass t2 = new MyClass();
        System.out.println(t1.num + " " + t2.num);
     }
  }
  ```

### Parameterized Constructors
- Example: </br>
  ```java
  // A simple constructor.
  class MyClass {
     int x;
     
     // Following is the constructor
     MyClass(int i ) {
        x = i;
     }
  }

  public class ConsDemo {
     public static void main(String args[]) {
        MyClass t1 = new MyClass( 10 );
        MyClass t2 = new MyClass( 20 );
        System.out.println(t1.x + " " + t2.x);
     }
  }
  ```

:arrow_up: Back to top


</br>

---

## References:
- https://www.tutorialspoint.com/java/index.htm
- https://www.tutorialspoint.com/java/java_basic_syntax.htm
- https://www.tutorialspoint.com/java/java_object_classes.htm
- https://www.tutorialspoint.com/java/java_constructors.htm
