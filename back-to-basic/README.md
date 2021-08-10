# Back to Basic -- Java Tutorial Notes

</br>

## List of Contents:
### 1. [Java Tutorial](#content-1)
### 2. [Java - Basic Syntax](#content-2)
### 3. [Java - Object and Classes](#content-3)
### 4. [Java - Constructors](#content-4)
### 5. [Java - Basic Datatypes](#content-5)
### 6. [Java - Variable Types](#content-6)
### 7. [Java - Modifier Types](#content-7)
### 8. [Java - Basic Operators](#content-8)
### 9. [Java - Loop Control](#content-9)


</br>

---

## Contents:

## [Java Tutorial](https://www.tutorialspoint.com/java/index.htm) <span id="content-1"></span>

- Java is a high-level programming language originally developed by Sun Microsystems and released in 1995.
- Unlike many other programming languages including C and C++, when Java is compiled, it is not compiled into platform specific machine, rather into platform independent byte code. This byte code is distributed over the web and interpreted by the Virtual Machine (JVM) on whichever platform it is being run on.

**[⬆ back to top](#list-of-contents)**

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

**[⬆ back to top](#list-of-contents)**

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

**[⬆ back to top](#list-of-contents)**

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

**[⬆ back to top](#list-of-contents)**

</br>

---

## [Java - Basic Datatypes](https://www.tutorialspoint.com/java/java_basic_datatypes.htm) <span id="content-5"></span>

### Intro:
- Variables are nothing but reserved memory locations to store values. This means that when you create a variable you reserve some space in the memory.
- There are two data types available in Java:
  - Primitive Data Types
  - References/Object Data Types


### Primitive Data Types
- Eight primitive data types:
  - byte: 8 bit integer
  - short: 16 bit integer
  - int: 32 bit integer
  - long: 64 bit integer
  - float: 32 floating point
  - double: 64 floating point
  - boolean
  - char: 16 bit unicode character

### Reference Data Types
- Reference variables are created using defined constructors of the classes. They are used to access objects. These variables are declared to be of a specific type that cannot be changed. For example, Employee, Puppy, etc.
- Class objects and various type of array variables come under reference datatype.
- Default value of any reference variable is null.
- A reference variable can be used to refer any object of the declared type or any compatible type.
- Example: Animal animal = new Animal("giraffe");


### Java Literals
- A literal is a source code representation of a fixed value. They are represented directly in the code without any computation.
- Example: </br>
  ```java
  byte a = 68;
  char a = 'A';

  int decimal = 100;
  int octal = 0144;
  int hexa =  0x64;
  char a = '\u0001';
  String a = "\u0001";
  ```

**[⬆ back to top](#list-of-contents)**

</br>

---

## [Java - Variable Types](https://www.tutorialspoint.com/java/java_variable_types.htm) <span id="content-6"></span> 


### Intro
- Example: </br>
  ```java
  int a, b, c;         // Declares three ints, a, b, and c.
  int a = 10, b = 10;  // Example of initialization
  byte B = 22;         // initializes a byte type variable B.
  double pi = 3.14159; // declares and assigns a value of PI.
  char a = 'a';        // the char variable a iis initialized with value 'a'
  ```
- There are three kind of variables in java:
  - Local variables
  - Instance variables
  - Class/Static variables


### Local Variables
- Local variables are declared in methods, constructors, or blocks.
- Local variables are created when the method, constructor or block is entered and the variable will be destroyed once it exits the method, constructor, or block.
- Access modifiers cannot be used for local variables.
- Local variables are visible only within the declared method, constructor, or block.
- Local variables are implemented at stack level internally.
- There is no default value for local variables, so local variables should be declared and an initial value should be assigned before the first use.
- Example: </br>
  ```java
  public class Test {
     public void pupAge() {
        int age = 0;
        age = age + 7;
        System.out.println("Puppy age is : " + age);
     }

     public static void main(String args[]) {
        Test test = new Test();
        test.pupAge();
     }
  }
  ```
  ```java
  // This will produce an error
  public class Test {
     public void pupAge() {
        int age;
        age = age + 7;
        System.out.println("Puppy age is : " + age);
     }

     public static void main(String args[]) {
        Test test = new Test();
        test.pupAge();
     }
  }
  ```


### Instance Variables
- Instance variables are declared in a class, but outside a method, constructor or any block.
- When a space is allocated for an object in the heap, a slot for each instance variable value is created.
- Instance variables are created when an object is created with the use of the keyword 'new' and destroyed when the object is destroyed.
- Instance variables hold values that must be referenced by more than one method, constructor or block, or essential parts of an object's state that must be present throughout the class.
- Instance variables can be declared in class level before or after use.
- Access modifiers can be given for instance variables.
- The instance variables are visible for all methods, constructors and block in the class. Normally, it is recommended to make these variables private (access level). However, visibility for subclasses can be given for these variables with the use of access modifiers.
- Instance variables have default values. For numbers, the default value is 0, for Booleans it is false, and for object references it is null. Values can be assigned during the declaration or within the constructor.
- Instance variables can be accessed directly by calling the variable name inside the class. However, within static methods (when instance variables are given accessibility), they should be called using the fully qualified name. ObjectReference.VariableName.
- Example: </br>
  ```java
  import java.io.*;
  public class Employee {

     // this instance variable is visible for any child class.
     public String name;

     // salary  variable is visible in Employee class only.
     private double salary;

     // The name variable is assigned in the constructor.
     public Employee (String empName) {
        name = empName;
     }

     // The salary variable is assigned a value.
     public void setSalary(double empSal) {
        salary = empSal;
     }

     // This method prints the employee details.
     public void printEmp() {
        System.out.println("name  : " + name );
        System.out.println("salary :" + salary);
     }

     public static void main(String args[]) {
        Employee empOne = new Employee("Ransika");
        empOne.setSalary(1000);
        empOne.printEmp();
     }
  }
  ```

### Class/Static Variables
- Class variables also known as static variables are declared with the static keyword in a class, but outside a method, constructor or a block.
- There would only be one copy of each class variable per class, regardless of how many objects are created from it.
- Static variables are rarely used other than being declared as constants. Constants are variables that are declared as public/private, final, and static. Constant variables never change from their initial value.
- Static variables are stored in the static memory. It is rare to use static variables other than declared final and used as either public or private constants
- Static variables are created when the program starts and destroyed when the program stops.
- Visibility is similar to instance variables. However, most static variables are declared public since they must be available for users of the class.
- Default values are same as instance variables. For numbers, the default value is 0; for Booleans, it is false; and for object references, it is null. Values can be assigned during the declaration or within the constructor. Additionally, values can be assigned in special static initializer blocks.
- Static variables can be accessed by calling with the class name ClassName.VariableName.
- When declaring class variables as public static final, then variable names (constants) are all in upper case. If the static variables are not public and final, the naming syntax is the same as instance and local variables.
- Example: </br>
  ```java
  import java.io.*;
  public class Employee {

     // salary  variable is a private static variable
     private static double salary;

     // DEPARTMENT is a constant
     public static final String DEPARTMENT = "Development ";

     public static void main(String args[]) {
        salary = 1000;
        System.out.println(DEPARTMENT + "average salary:" + salary);
     }
  }
  ```

**[⬆ back to top](#list-of-contents)**

</br>

---

## [Java - Modifier Types](https://www.tutorialspoint.com/java/java_modifier_types.htm) <span id="content-7"></span>


### Introduction
- Java language has a wide variety of modifiers
  - Java Access Modifiers
  - Non Access Modifiers
- Example: </br>
  ```java
  public class className {
     // ...
  }

  private boolean myFlag;
  static final double weeks = 9.5;
  protected static final int BOXWIDTH = 42;

  public static void main(String[] arguments) {
     // body of method
  }
  ```

### Access Control Modifiers
- Java provides a number of access modifiers to set access levels for classes, variables, methods and constructors. The four access levels are:
  - Visible to the package, the default. No modifiers are needed.
  - Visible to the class only (private).
  - Visible to the world (public)
  - Visible to the package and all subclasses (protected).


### Non-Access Modifiers
- The static modifier for creating class methods and variables.
- The final modifier for finalizing the implementations of classes, methods, and variables.
- The abstract modifier for creating abstract classes and methods.
- The synchronized and volatile modifiers, which are used for threads.



**[⬆ back to top](#list-of-contents)**

</br>

---

## [Java - Basic Operators](https://www.tutorialspoint.com/java/java_basic_operators.htm) <span id="content-8"></span>


### Introduction
- Java provides a rich set of operators to manipulate variables.
  - Arithmetic Operators
  - Relational Operators
  - Bitwise Operators
  - Logical Operators
  - Assignment Operators
  - Misc Operators

### The Arithmetic Operators
- Addition
- Substraction
- Multiplication
- Division
- Modulus
- Increment
- Decrement


### The Relational Operators
- == (equal to)
- != (not equal to)
- \> (greater than)
- < (less than)
- \>= (greater than or equal to)
- <= (less than or equal to)

### The Bitwise Operators
- & (bitwise and)
- | (bitwise or)
- ^ (bitwise XOR)
- ~ (bitwise compliment)
- << (left shift)
- \>> (right shift)
- \>>> (zero fill right shift)>>> (zero fill right shift)

### The Logical Operators
- && (logical and)
- || (logical or)
- ! (logical not)

### The Assignment Operators
- I am pretty sure You've known this

### Miscellaneous Operators
- Conditional Operator ( ? : )
  - Conditional operator is also known as the ternary operator. 
  - Basic form: </br>
    ```java
    variable x = (expression) ? value if true : value if false
    ```
  - Example:
    ```java
    public class Test {

      public static void main(String args[]) {
        int a, b;
        a = 10;
        b = (a == 1) ? 20: 30;
        System.out.println( "Value of b is : " +  b );

        b = (a == 10) ? 20: 30;
        System.out.println( "Value of b is : " + b );
      }
    }
    ```
- `instanceof` Operator
  - This operator is used only for object reference variables. The operator checks whether the object is of a particular type (class type or interface type).
  - Basic form"
    ```java
    ( Object reference variable ) instanceof  (class/interface type)
    ```
  - Example:
    ```java
    public class Test {

      public static void main(String args[]) {

        String name = "James";

        // following will return true since name is type of String
        boolean result = name instanceof String;
        System.out.println( result );
      }
    }
    ```
    ```java
    class Vehicle {}

    public class Car extends Vehicle {

      public static void main(String args[]) {

        Vehicle a = new Car();
        boolean result =  a instanceof Car;
        System.out.println( result );
      }
    }
    ```

**[⬆ back to top](#list-of-contents)**

</br>

---

## [Java - Loop Control](https://www.tutorialspoint.com/java/java_loop_control.htm) <span id="content-1"></span>

### Introduction
- A loop statement allows us to execute a statement or group of statements multiple times and following is the general form of a loop statement in most of the programming languages </br>
  ![Loop statement](https://www.tutorialspoint.com/java/images/loop_architecture.jpg)
- There ways to write loop statement in Java:
  - `while` loop
  - `for` loop
  - `do... while` loop

### Loop Control Statements
- Loop control statements change execution from its normal sequence.
- Control statements:
  - `break` statement
  - `continue` statement


### Enhanced for loop in Java
- Syntax:
  ```java
  for(declaration : expression) {
     // Statements
  }
  ```
- Example:
  ```java
  public class Test {

     public static void main(String args[]) {
        int [] numbers = {10, 20, 30, 40, 50};

        for(int x : numbers ) {
           System.out.print( x );
           System.out.print(",");
        }
        System.out.print("\n");
        String [] names = {"James", "Larry", "Tom", "Lacy"};

        for( String name : names ) {
           System.out.print( name );
           System.out.print(",");
        }
     }
  }
  ```


**[⬆ back to top](#list-of-contents)**

</br>

---

## References:
- https://www.tutorialspoint.com/java/index.htm
- https://www.tutorialspoint.com/java/java_basic_syntax.htm
- https://www.tutorialspoint.com/java/java_object_classes.htm
- https://www.tutorialspoint.com/java/java_constructors.htm
- https://www.tutorialspoint.com/java/java_basic_datatypes.htm
- https://www.tutorialspoint.com/java/java_variable_types.htm
- https://www.tutorialspoint.com/java/java_modifier_types.htm
- https://www.tutorialspoint.com/java/java_basic_operators.htm
- https://www.tutorialspoint.com/java/java_loop_control.htm