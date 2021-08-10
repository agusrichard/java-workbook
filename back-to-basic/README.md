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
### 10. [Java - Decision Making](#content-10)
### 11. [Java - Numbers Class](#content-11)
### 12. [Java - Character Class](#content-12)
### 13. [Java - Strings Class](#content-13)
### 14. [Java - Arrays](#content-14)
### 15. [Java - Date and Time](#content-15)
### 16. [Java - Regular Expressions](#content-16)
### 17. [Java - Methods](#content-17)
### 18. [Java - Exceptions](#content-18)
### 19. [Java - Inner classes](#content-19)


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

## [Java - Decision Making](https://www.tutorialspoint.com/java/java_decision_making.htm) <span id="content-10"></span>

### Introduction
- Decision making diagram:
  ![decision-making](https://www.tutorialspoint.com/java/images/decision_making.jpg)
- 4 decision making statements:
  - `if` statement
  - `if... else` statement
  - `nested if` statement
  - `switch` statement

### The ? : Operator
- Conditional operator or ternary operator
- Basic syntax:
  ```java
  Exp1 ? Exp2 : Exp3;
  ```


**[⬆ back to top](#list-of-contents)**

</br>

---

## [Java - Numbers Class](https://www.tutorialspoint.com/java/java_numbers.htm) <span id="content-11"></span>

### Introduction
- Wrapper class of numbers (wrapper for the primitive data types):
  - Byte
  - Double
  - Float
  - Integer
  - Short
  - Long
- Converting primitive data types into object is called boxing, and this is taken care by the compiler.
- The Wrapper object will be converted back to a primitive data type, and this process is called unboxing
- Example:
  ```java
  public class Test {

     public static void main(String args[]) {
        Integer x = 5; // boxes int to an Integer object
        x =  x + 10;   // unboxes the Integer to a int
        System.out.println(x); 
     }
  }
  ```

**[⬆ back to top](#list-of-contents)**

</br>

---

## [Java - Character Class](https://www.tutorialspoint.com/java/java_characters.htm) <span id="content-12"></span>

### Introduction
- Example:
  ```java
  char ch = 'a';

  // Unicode for uppercase Greek omega character
  char uniChar = '\u039A'; 

  // an array of chars
  char[] charArray ={ 'a', 'b', 'c', 'd', 'e' }; 
  ```
- Syntax:
  ```java
  Character ch = new Character('a');
  ```
- Example:
  ```java
  // Here following primitive char 'a'
  // is boxed into the Character object ch
  Character ch = 'a';

  // Here primitive 'x' is boxed for method test,
  // return is unboxed to char 'c'
  char c = test('x');
  ```
  ```java
  public class Test {

     public static void main(String args[]) {
        System.out.println("She said \"Hello!\" to me.");
     }
  }
  ````


**[⬆ back to top](#list-of-contents)**

</br>

---

## [Java - Strings Class](https://www.tutorialspoint.com/java/java_strings.htm) <span id="content-13"></span>

### Introduction
- Strings, which are widely used in Java programming, are a sequence of characters.

### Create Strings
- Syntax:
  ```java
  String greeting = "Hello world!";
  ```
- Example:
  ```java
  public class StringDemo {

     public static void main(String args[]) {
        char[] helloArray = { 'h', 'e', 'l', 'l', 'o', '.' };
        String helloString = new String(helloArray);  
        System.out.println( helloString );
     }
  }
  ```
- The String class is immutable, so that once it is created a String object cannot be changed. If there is a necessity to make a lot of modifications to Strings of characters, then you should use String Buffer & String Builder.


### String Length
- Methods used to obtain information about an object are known as accessor methods. 
- One accessor method that you can use with strings is the length() method, which returns the number of characters contained in the string object.
- Example:
  ```java
  public class StringDemo {

     public static void main(String args[]) {
        String palindrome = "Dot saw I was Tod";
        int len = palindrome.length();
        System.out.println( "String Length is : " + len );
     }
  }
  ```

### Concatenating Strings
- Several ways to concatenate strings
  ```java
  string1.concat(string2);

  "My name is ".concat("Zara");

  "Hello," + " world" + "!";
  ```
  ```java
  public class StringDemo {

     public static void main(String args[]) {
        String string1 = "saw I was ";
        System.out.println("Dot " + string1 + "Tod");
     }
  }
  ```

### Creating Format Strings
- Example:
  ```java
  String fs;
  fs = String.format("The value of the float variable is " +
                     "%f, while the value of the integer " +
                     "variable is %d, and the string " +
                     "is %s", floatVar, intVar, stringVar);
  System.out.println(fs);
  ```

**[⬆ back to top](#list-of-contents)**

</br>

---

## [Java - Arrays](https://www.tutorialspoint.com/java/java_arrays.htm) <span id="content-14"></span>

### Declaring Array Variables
- How we can declare an array:
  ```java
  dataType[] arrayRefVar;   // preferred way.
  or
  dataType arrayRefVar[];  // works but not preferred way.
  ```
  ```java
  double[] myList;   // preferred way.
  or
  double myList[];   // works but not preferred way.
  ```

### Creating Arrays
- Syntax:
  ```java
  dataType[] arrayRefVar = new dataType[arraySize];

  dataType[] arrayRefVar = {value0, value1, ..., valuek};
  ```
- Example:
  ```java
  double[] myList = new double[10];
  ```


### Processing Arrays
- Example:
  ```java
  public class TestArray {

     public static void main(String[] args) {
        double[] myList = {1.9, 2.9, 3.4, 3.5};

        // Print all the array elements
        for (int i = 0; i < myList.length; i++) {
           System.out.println(myList[i] + " ");
        }
       
        // Summing all elements
        double total = 0;
        for (int i = 0; i < myList.length; i++) {
           total += myList[i];
        }
        System.out.println("Total is " + total);
        
        // Finding the largest element
        double max = myList[0];
        for (int i = 1; i < myList.length; i++) {
           if (myList[i] > max) max = myList[i];
        }
        System.out.println("Max is " + max);  
     }
  }
  ```

### The foreach Loops
- Example:
  ```java
  public class TestArray {

     public static void main(String[] args) {
        double[] myList = {1.9, 2.9, 3.4, 3.5};

        // Print all the array elements
        for (double element: myList) {
           System.out.println(element);
        }
     }
  }
  ```


### Passing Arrays to Methods
- Example:
  ```java
  public static void printArray(int[] array) {
     for (int i = 0; i < array.length; i++) {
        System.out.print(array[i] + " ");
     }
  }
  ```

### Returning an Array from a Method
- Example:
  ```java
  public static int[] reverse(int[] list) {
     int[] result = new int[list.length];

     for (int i = 0, j = result.length - 1; i < list.length; i++, j--) {
        result[j] = list[i];
     }
     return result;
  }
  ```


**[⬆ back to top](#list-of-contents)**

</br>

---

## [Java - Date and Time](https://www.tutorialspoint.com/java/java_date_time.htm) <span id="content-15"></span>


### Introduction
- `Date( ) `: This constructor initializes the object with the current date and time.
- `Date(long millisec)` : This constructor accepts an argument that equals the number of milliseconds that have elapsed since midnight, January 1, 1970.


### Getting Current Date and Time
- Example:
  ```java
  import java.util.Date;
  public class DateDemo {

     public static void main(String args[]) {
        // Instantiate a Date object
        Date date = new Date();

        // display time and date using toString()
        System.out.println(date.toString());
     }
  }
  ```


### Date Comparison
- You can use getTime( ) to obtain the number of milliseconds that have elapsed since midnight, January 1, 1970, for both objects and then compare these two values.
- You can use the methods before( ), after( ), and equals( ). Because the 12th of the month comes before the 18th, for example, new Date(99, 2, 12).before(new Date (99, 2, 18)) returns true.
- You can use the compareTo( ) method, which is defined by the Comparable interface and implemented by Date.

### Date Formatting Using SimpleDateFormat
- Example:
  ```java
  import java.util.*;
  import java.text.*;

  public class DateDemo {

     public static void main(String args[]) {
        Date dNow = new Date( );
        SimpleDateFormat ft = 
        new SimpleDateFormat ("E yyyy.MM.dd 'at' hh:mm:ss a zzz");

        System.out.println("Current Date: " + ft.format(dNow));
     }
  }
  ```


### Date Formatting Using printf
- Example:
  ```java
  import java.util.Date;
  public class DateDemo {

     public static void main(String args[]) {
        // Instantiate a Date object
        Date date = new Date();

        // display time and date
        String str = String.format("Current Date/Time : %tc", date );

        System.out.printf(str);
     }
  }
  ```
  ```java
  import java.util.Date;
  public class DateDemo {

     public static void main(String args[]) {
        // Instantiate a Date object
        Date date = new Date();
    
        // display time and date
        System.out.printf("%1$s %2$tB %2$td, %2$tY", "Due date:", date);
     }
  }
  ```
  ```java
  import java.util.Date;
  public class DateDemo {

     public static void main(String args[]) {
        // Instantiate a Date object
        Date date = new Date();
    
        // display formatted date
        System.out.printf("%s %tB %<te, %<tY", "Due date:", date);
     }
  }
  ```

### Parsing Strings into Dates
- Example:
  ```java
  import java.util.*;
  import java.text.*;
    
  public class DateDemo {

     public static void main(String args[]) {
        SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd"); 
        String input = args.length == 0 ? "1818-11-11" : args[0]; 

        System.out.print(input + " Parses as "); 
        Date t;
        try {
           t = ft.parse(input); 
           System.out.println(t); 
        } catch (ParseException e) { 
           System.out.println("Unparseable using " + ft); 
        }
     }
  }
  ```

### Sleeping for a While
- Example:
  ```java
  import java.util.*;
  public class SleepDemo {

    public static void main(String args[]) {
      try { 
         System.out.println(new Date( ) + "\n"); 
         Thread.sleep(5*60*10); 
         System.out.println(new Date( ) + "\n"); 
      } catch (Exception e) {
         System.out.println("Got an exception!"); 
      }
    }
  }
  ```

### Measuring Elapsed Time
- Example:
  ```java
  import java.util.*;
  public class DiffDemo {

     public static void main(String args[]) {
        try {
           long start = System.currentTimeMillis( );
           System.out.println(new Date( ) + "\n");
           
           Thread.sleep(5*60*10);
           System.out.println(new Date( ) + "\n");
           
           long end = System.currentTimeMillis( );
           long diff = end - start;
           System.out.println("Difference is : " + diff);
        } catch (Exception e) {
           System.out.println("Got an exception!");
        }
     }
  }
  ```


**[⬆ back to top](#list-of-contents)**

</br>

---

## [Java - Regular Expressions](https://www.tutorialspoint.com/java/java_regular_expressions.htm) <span id="content-16"></span>

> Note: I left out several important things to be read and written later on.

### Introduction
- Java provides the java.util.regex package for pattern matching with regular expressions.
- A regular expression is a special sequence of characters that helps you match or find other strings or sets of strings, using a specialized syntax held in a pattern. They can be used to search, edit, or manipulate text and data.
- The java.util.regex package primarily consists of the following three classes −
  - Pattern Class − A Pattern object is a compiled representation of a regular expression.
  - Matcher Class − A Matcher object is the engine that interprets the pattern and performs match operations against an input string.
  - PatternSyntaxException − A PatternSyntaxException object is an unchecked exception that indicates a syntax error in a regular expression pattern.


### Capturing Groups
- Capturing groups are a way to treat multiple characters as a single unit. 
- Example:
  ```java
  import java.util.regex.Matcher;
  import java.util.regex.Pattern;

  public class RegexMatches {

     public static void main( String args[] ) {
        // String to be scanned to find the pattern.
        String line = "This order was placed for QT3000! OK?";
        String pattern = "(.*)(\\d+)(.*)";

        // Create a Pattern object
        Pattern r = Pattern.compile(pattern);

        // Now create matcher object.
        Matcher m = r.matcher(line);
        if (m.find( )) {
           System.out.println("Found value: " + m.group(0) );
           System.out.println("Found value: " + m.group(1) );
           System.out.println("Found value: " + m.group(2) );
        }else {
           System.out.println("NO MATCH");
        }
     }
  }
  ```

### Replacement Methods
- Example:
  ```java
  import java.util.regex.Matcher;
  import java.util.regex.Pattern;

  public class RegexMatches {

     private static final String REGEX = "\\bcat\\b";
     private static final String INPUT = "cat cat cat cattie cat";

     public static void main( String args[] ) {
        Pattern p = Pattern.compile(REGEX);
        Matcher m = p.matcher(INPUT);   // get a matcher object
        int count = 0;

        while(m.find()) {
           count++;
           System.out.println("Match number "+count);
           System.out.println("start(): "+m.start());
           System.out.println("end(): "+m.end());
        }
     }
  }
  ```
  ```java
  import java.util.regex.Matcher;
  import java.util.regex.Pattern;

  public class RegexMatches {

     private static final String REGEX = "foo";
     private static final String INPUT = "fooooooooooooooooo";
     private static Pattern pattern;
     private static Matcher matcher;

     public static void main( String args[] ) {
        pattern = Pattern.compile(REGEX);
        matcher = pattern.matcher(INPUT);

        System.out.println("Current REGEX is: "+REGEX);
        System.out.println("Current INPUT is: "+INPUT);

        System.out.println("lookingAt(): "+matcher.lookingAt());
        System.out.println("matches(): "+matcher.matches());
     }
  }
  ```
  ```java
  import java.util.regex.Matcher;
  import java.util.regex.Pattern;

  public class RegexMatches {

     private static String REGEX = "dog";
     private static String INPUT = "The dog says meow. " + "All dogs say meow.";
     private static String REPLACE = "cat";

     public static void main(String[] args) {
        Pattern p = Pattern.compile(REGEX);
        
        // get a matcher object
        Matcher m = p.matcher(INPUT); 
        INPUT = m.replaceAll(REPLACE);
        System.out.println(INPUT);
     }
  }
  ```
  ```java
  import java.util.regex.Matcher;
  import java.util.regex.Pattern;

  public class RegexMatches {

     private static String REGEX = "a*b";
     private static String INPUT = "aabfooaabfooabfoob";
     private static String REPLACE = "-";
     public static void main(String[] args) {

        Pattern p = Pattern.compile(REGEX);
        
        // get a matcher object
        Matcher m = p.matcher(INPUT);
        StringBuffer sb = new StringBuffer();
        while(m.find()) {
           m.appendReplacement(sb, REPLACE);
        }
        m.appendTail(sb);
        System.out.println(sb.toString());
     }
  }
  ```

**[⬆ back to top](#list-of-contents)**

</br>

---

## [Java - Methods](https://www.tutorialspoint.com/java/java_methods.htm) <span id="content-17"></span>


### Introduction
- A Java method is a collection of statements that are grouped together to perform an operation.


### Creating method
- Basic example:
  ```java
  public static int methodName(int a, int b) {
     // body
  }
  ```
- Syntax:
  ```java
  modifier returnType nameOfMethod (Parameter List) {
     // method body
  }
  ```
- Example:
  ```java
  /** the snippet returns the minimum between two numbers */
  public static int minFunction(int n1, int n2) {
     int min;
     if (n1 > n2)
        min = n2;
     else
        min = n1;

     return min; 
  }
  ```

### Method Calling
- For using a method, it should be called. There are two ways in which a method is called i.e., method returns a value or returning nothing (no return value).
- Example:
  ```java
  public class ExampleMinNumber {
   
     public static void main(String[] args) {
        int a = 11;
        int b = 6;
        int c = minFunction(a, b);
        System.out.println("Minimum Value = " + c);
     }

     /** returns the minimum of two numbers */
     public static int minFunction(int n1, int n2) {
        int min;
        if (n1 > n2)
           min = n2;
        else
           min = n1;

        return min; 
     }
  }
  ```

### The `void` Keyword
- The void keyword allows us to create methods which do not return a value.
- Example:
  ```java
  public class ExampleVoid {

     public static void main(String[] args) {
        methodRankPoints(255.7);
     }

     public static void methodRankPoints(double points) {
        if (points >= 202.5) {
           System.out.println("Rank:A1");
        }else if (points >= 122.4) {
           System.out.println("Rank:A2");
        }else {
           System.out.println("Rank:A3");
        }
     }
  }
  ```

### Passing Parameters by Value
- Parameters can be passed by value or by reference.
- Example:
  ```java
  public class swappingExample {

     public static void main(String[] args) {
        int a = 30;
        int b = 45;
        System.out.println("Before swapping, a = " + a + " and b = " + b);

        // Invoke the swap method
        swapFunction(a, b);
        System.out.println("\n**Now, Before and After swapping values will be same here**:");
        System.out.println("After swapping, a = " + a + " and b is " + b);
     }

     public static void swapFunction(int a, int b) {
        System.out.println("Before swapping(Inside), a = " + a + " b = " + b);
        
        // Swap n1 with n2
        int c = a;
        a = b;
        b = c;
        System.out.println("After swapping(Inside), a = " + a + " b = " + b);
     }
  }
  ```


### Method Overloading
- When a class has two or more methods by the same name but different parameters, it is known as method overloading.
- It is different from overriding. In overriding, a method has the same method name, type, number of parameters, etc.
- Example:
  ```java
  public class ExampleOverloading {

     public static void main(String[] args) {
        int a = 11;
        int b = 6;
        double c = 7.3;
        double d = 9.4;
        int result1 = minFunction(a, b);
        
        // same function name with different parameters
        double result2 = minFunction(c, d);
        System.out.println("Minimum Value = " + result1);
        System.out.println("Minimum Value = " + result2);
     }

     // for integer
     public static int minFunction(int n1, int n2) {
        int min;
        if (n1 > n2)
           min = n2;
        else
           min = n1;

        return min; 
     }
     
     // for double
     public static double minFunction(double n1, double n2) {
       double min;
        if (n1 > n2)
           min = n2;
        else
           min = n1;

        return min; 
     }
  }
  ```

### Using Command-Line Arguments
- Example:
  ```java
  public class CommandLine {

     public static void main(String args[]) { 
        for(int i = 0; i<args.length; i++) {
           System.out.println("args[" + i + "]: " +  args[i]);
        }
     }
  }
  ```

### The `this` keyword
- `this` is a keyword in Java which is used as a reference to the object of the current class, with in an instance method or a constructor. Using this you can refer the members of a class such as constructors, variables and methods.
- Diagram:
  ![this keyword-diagram](https://www.tutorialspoint.com/java/images/this.jpg)
- Example:
  ```java
  class Student {
     int age;   
     Student(int age) {
        this.age = age;	
     }
  }
  ```
  ```java
  class Student {
     int age
     Student() {
        this(20);
     }
     
     Student(int age) {
        this.age = age;	
     }
  }
  ```
  ```java
  public class This_Example {
     // Instance variable num
     int num = 10;
  	
     This_Example() {
        System.out.println("This is an example program on keyword this");	
     }

     This_Example(int num) {
        // Invoking the default constructor
        this();
        
        // Assigning the local variable num to the instance variable num
        this.num = num;	   
     }
     
     public void greet() {
        System.out.println("Hi Welcome to Tutorialspoint");
     }
        
     public void print() {
        // Local variable num
        int num = 20;
        
        // Printing the local variable
        System.out.println("value of local variable num is : "+num);
        
        // Printing the instance variable
        System.out.println("value of instance variable num is : "+this.num);
        
        // Invoking the greet method of a class
        this.greet();     
     }
     
     public static void main(String[] args) {
        // Instantiating the class
        This_Example obj1 = new This_Example();
        
        // Invoking the print method
        obj1.print();
  	  
        // Passing a new value to the num variable through parametrized constructor
        This_Example obj2 = new This_Example(30);
        
        // Invoking the print method again
        obj2.print(); 
     }
  }
  ```

### Variable Arguments(var-args)
- Example:
  ```java
  public class VarargsDemo {

     public static void main(String args[]) {
        // Call method with variable args  
  	   printMax(34, 3, 3, 2, 56.5);
        printMax(new double[]{1, 2, 3});
     }

     public static void printMax( double... numbers) {
        if (numbers.length == 0) {
           System.out.println("No argument passed");
           return;
        }

        double result = numbers[0];

        for (int i = 1; i <  numbers.length; i++)
        if (numbers[i] >  result)
        result = numbers[i];
        System.out.println("The max value is " + result);
     }
  }
  ```

### The finalize( ) Method
- It is possible to define a method that will be called just before an object's final destruction by the garbage collector. This method is called finalize( ), and it can be used to ensure that an object terminates cleanly.


**[⬆ back to top](#list-of-contents)**

</br>

---

## [Java - Exceptions](https://www.tutorialspoint.com/java/java_exceptions.htm) <span id="content-18"></span>


### Introduction
- An exception (or exceptional event) is a problem that arises during the execution of a program. 
- When an Exception occurs the normal flow of the program is disrupted and the program/Application terminates abnormally, which is not recommended, therefore, these exceptions are to be handled.
- Three categories of Exceptions: 
- Checked exceptions − A checked exception is an exception that is checked (notified) by the compiler at compilation-time, these are also called as compile time exceptions.
  - Example:
    ```java
    import java.io.File;
    import java.io.FileReader;

    public class FilenotFound_Demo {

       public static void main(String args[]) {		
          File file = new File("E://file.txt");
          FileReader fr = new FileReader(file); 
    // If file.txt is not exists then this process willl throw an FileNotFoundException
    ```
- Unchecked exceptions − An unchecked exception is an exception that occurs at the time of execution. These are also called as Runtime Exceptions.
  - Example:
    ```java
    public class Unchecked_Demo {
   
       public static void main(String args[]) {
          int num[] = {1, 2, 3, 4};
          System.out.println(num[5]);
       }
    }
    // Because num only have 4 elements, but we tried to access the 5th element, then this will throw an exception of ArrayIndexOutOfBoundsException
    ```
- Errors − These are not exceptions at all, but problems that arise beyond the control of the user or the programmer. Errors are typically ignored in your code because you can rarely do anything about an error. For example, if a stack overflow occurs, an error will arise.

### Exception Hierarchy
- Errors are abnormal conditions that happen in case of severe failures, these are not handled by the Java programs.
- Errors are generated to indicate errors generated by the runtime environment.
- Hierarchy:
  ![exceptions-hierarchy](https://www.tutorialspoint.com/java/images/exceptions1.jpg)

### Catching Exceptions
- A method catches an exception using a combination of the try and catch keywords.
- Syntax:
  ```java
  try {
     // Protected code
  } catch (ExceptionName e1) {
     // Catch block
  }
  ```
- Every try block should be immediately followed either by a catch block or finally block.
- A catch statement involves declaring the type of exception you are trying to catch.
- Example:
  ```java
  // File Name : ExcepTest.java
  import java.io.*;

  public class ExcepTest {

     public static void main(String args[]) {
        try {
           int a[] = new int[2];
           System.out.println("Access element three :" + a[3]);
        } catch (ArrayIndexOutOfBoundsException e) {
           System.out.println("Exception thrown  :" + e);
        }
        System.out.println("Out of the block");
     }
  }
  ```

### Multiple Catch Blocks
- Syntax:
  ```java
  try {
     // Protected code
  } catch (ExceptionType1 e1) {
     // Catch block
  } catch (ExceptionType2 e2) {
     // Catch block
  } catch (ExceptionType3 e3) {
     // Catch block
  }
  ```
- Example:
  ```java
  try {
     file = new FileInputStream(fileName);
     x = (byte) file.read();
  } catch (IOException i) {
     i.printStackTrace();
     return -1;
  } catch (FileNotFoundException f) // Not valid! {
     f.printStackTrace();
     return -1;
  }
  ```

### Catching Multiple Type of Exceptions
- Example:
  ```java
  catch (IOException|FileNotFoundException ex) {
   logger.log(ex);
   throw ex;
  ```

### The Throws/Throw Keywords
- If a method does not handle a checked exception, the method must declare it using the throws keyword. The throws keyword appears at the end of a method's signature.
- Example:
  ```java
  import java.io.*;
  public class className {

     public void deposit(double amount) throws RemoteException {
        // Method implementation
        throw new RemoteException();
     }
     // Remainder of class definition
  }
  ```
  ```java
  import java.io.*;
  public class className {

     public void withdraw(double amount) throws RemoteException, 
        InsufficientFundsException {
        // Method implementation
     }
     // Remainder of class definition
  }
  ```


### The Finally Block
- The finally block follows a try block or a catch block. A finally block of code always executes, irrespective of occurrence of an Exception.
- Example:
  ```java
  try {
     // Protected code
  } catch (ExceptionType1 e1) {
     // Catch block
  } catch (ExceptionType2 e2) {
     // Catch block
  } catch (ExceptionType3 e3) {
     // Catch block
  }finally {
     // The finally block always executes.
  }
  ```
  ```java
  public class ExcepTest {

     public static void main(String args[]) {
        int a[] = new int[2];
        try {
           System.out.println("Access element three :" + a[3]);
        } catch (ArrayIndexOutOfBoundsException e) {
           System.out.println("Exception thrown  :" + e);
        }finally {
           a[0] = 6;
           System.out.println("First element value: " + a[0]);
           System.out.println("The finally statement is executed");
        }
     }
  }
  ```

### The try-with-resources
- Example:
  ```java
  import java.io.File;
  import java.io.FileReader;
  import java.io.IOException;

  public class ReadData_Demo {

     public static void main(String args[]) {
        FileReader fr = null;		
        try {
           File file = new File("file.txt");
           fr = new FileReader(file); char [] a = new char[50];
           fr.read(a);   // reads the content to the array
           for(char c : a)
           System.out.print(c);   // prints the characters one by one
        } catch (IOException e) {
           e.printStackTrace();
        }finally {
           try {
              fr.close();
           } catch (IOException ex) {		
              ex.printStackTrace();
           }
        }
     }
  }
  ```
- `try-with-resources`, also referred as automatic resource management, is a new exception handling mechanism that was introduced in Java 7, which automatically closes the resources used within the try catch block.
- Syntax:
  ```java
  try(FileReader fr = new FileReader("file path")) {
     // use the resource
     } catch () {
        // body of catch 
     }
  }
  ```
- Example:
  ```java
  import java.io.FileReader;
  import java.io.IOException;

  public class Try_withDemo {

     public static void main(String args[]) {
        try(FileReader fr = new FileReader("E://file.txt")) {
           char [] a = new char[50];
           fr.read(a);   // reads the contentto the array
           for(char c : a)
           System.out.print(c);   // prints the characters one by one
        } catch (IOException e) {
           e.printStackTrace();
        }
     }
  }
  ```
- Keep this in mind while working with `try-with-resources` statement:
  - To use a class with try-with-resources statement it should implement AutoCloseable interface and the close() method of it gets invoked automatically at runtime.
  - You can declare more than one class in try-with-resources statement.
  - While you declare multiple classes in the try block of try-with-resources statement these classes are closed in reverse order.
  - Except the declaration of resources within the parenthesis everything is the same as normal try/catch block of a try block.
  - The resource declared in try gets instantiated just before the start of the try-block.
  - The resource declared at the try block is implicitly declared as final.

### User-defined Exceptions
- Syntax:
  ```java
  class MyException extends Exception {
  }
  ```
- Example:
  ```java
  // File Name InsufficientFundsException.java
  import java.io.*;

  public class InsufficientFundsException extends Exception {
     private double amount;
     
     public InsufficientFundsException(double amount) {
        this.amount = amount;
     }
     
     public double getAmount() {
        return amount;
     }
  }
  ```
  ```java
  // File Name CheckingAccount.java
  import java.io.*;

  public class CheckingAccount {
     private double balance;
     private int number;
     
     public CheckingAccount(int number) {
        this.number = number;
     }
     
     public void deposit(double amount) {
        balance += amount;
     }
     
     public void withdraw(double amount) throws InsufficientFundsException {
        if(amount <= balance) {
           balance -= amount;
        }else {
           double needs = amount - balance;
           throw new InsufficientFundsException(needs);
        }
     }
     
     public double getBalance() {
        return balance;
     }
     
     public int getNumber() {
        return number;
     }
  }
  ```
  ```java
  // File Name BankDemo.java
  public class BankDemo {

     public static void main(String [] args) {
        CheckingAccount c = new CheckingAccount(101);
        System.out.println("Depositing $500...");
        c.deposit(500.00);
        
        try {
           System.out.println("\nWithdrawing $100...");
           c.withdraw(100.00);
           System.out.println("\nWithdrawing $600...");
           c.withdraw(600.00);
        } catch (InsufficientFundsException e) {
           System.out.println("Sorry, but you are short $" + e.getAmount());
           e.printStackTrace();
        }
     }
  }
  ```


**[⬆ back to top](#list-of-contents)**

</br>

---

## [Java - Inner classes](https://www.tutorialspoint.com/java/java_innerclasses.htm) <span id="content-19"></span>

### Introduction
- Syntax:
  ```java
  class Outer_Demo {
     class Inner_Demo {
     }
  }
  ```

### Inner Classes (Non-static Nested Classes)
- We know a class cannot be associated with the access modifier private, but if we have the class as a member of other class, then the inner class can be made private.
- Inner classes are of three types depending on how and where you define them. They are −
  - Inner Class
  - Method-local Inner Class
  - Anonymous Inner Class
  
#### Inner Class
- Creating an inner class is quite simple. You just need to write a class within a class. Unlike a class, an inner class can be private and once you declare an inner class private, it cannot be accessed from an object outside the class.
- Example:
  ```java
  class Outer_Demo {
     int num;
     
     // inner class
     private class Inner_Demo {
        public void print() {
           System.out.println("This is an inner class");
        }
     }
     
     // Accessing he inner class from the method within
     void display_Inner() {
        Inner_Demo inner = new Inner_Demo();
        inner.print();
     }
  }
     
  public class My_class {

     public static void main(String args[]) {
        // Instantiating the outer class 
        Outer_Demo outer = new Outer_Demo();
        
        // Accessing the display_Inner() method.
        outer.display_Inner();
     }
  }
  ```

#### Accessing the Private Members
- Example:
  ```java
  class Outer_Demo {
     // private variable of the outer class
     private int num = 175;  
     
     // inner class
     public class Inner_Demo {
        public int getNum() {
           System.out.println("This is the getnum method of the inner class");
           return num;
        }
     }
  }

  public class My_class2 {

     public static void main(String args[]) {
        // Instantiating the outer class
        Outer_Demo outer = new Outer_Demo();
        
        // Instantiating the inner class
        Outer_Demo.Inner_Demo inner = outer.new Inner_Demo();
        System.out.println(inner.getNum());
     }
  }
  ```

#### Method-local Inner Class
- In Java, we can write a class within a method and this will be a local type. Like local variables, the scope of the inner class is restricted within the method.
- Example:
  ```java
  public class Outerclass {
     // instance method of the outer class 
     void my_Method() {
        int num = 23;

        // method-local inner class
        class MethodInner_Demo {
           public void print() {
              System.out.println("This is method inner class "+num);	   
           }   
        } // end of inner class
  	   
        // Accessing the inner class
        MethodInner_Demo inner = new MethodInner_Demo();
        inner.print();
     }
     
     public static void main(String args[]) {
        Outerclass outer = new Outerclass();
        outer.my_Method();	   	   
     }
  }
  ```


#### Anonymous Inner Class
- An inner class declared without a class name is known as an anonymous inner class.
- Example:
  ```java
  abstract class AnonymousInner {
     public abstract void mymethod();
  }

  public class Outer_class {

     public static void main(String args[]) {
        AnonymousInner inner = new AnonymousInner() {
           public void mymethod() {
              System.out.println("This is an example of anonymous inner class");
           }
        };
        inner.mymethod();	
     }
  }
  ```

### Anonymous Inner Class as Argument
- Generally, if a method accepts an object of an interface, an abstract class, or a concrete class, then we can implement the interface, extend the abstract class, and pass the object to the method. If it is a class, then we can directly pass it to the method.
- Example:
  ```java
  // interface
  interface Message {
     String greet();
  }

  public class My_class {
     // method which accepts the object of interface Message
     public void displayMessage(Message m) {
        System.out.println(m.greet() +
           ", This is an example of anonymous inner class as an argument");  
     }

     public static void main(String args[]) {
        // Instantiating the class
        My_class obj = new My_class();

        // Passing an anonymous inner class as an argument
        obj.displayMessage(new Message() {
           public String greet() {
              return "Hello";
           }
        });
     }
  }
  ```

### Static Nested Class
- A static inner class is a nested class which is a static member of the outer class. It can be accessed without instantiating the outer class, using other static members.
- Example:
  ```java
  public class Outer {
     static class Nested_Demo {
        public void my_method() {
           System.out.println("This is my nested class");
        }
     }
     
     public static void main(String args[]) {
        Outer.Nested_Demo nested = new Outer.Nested_Demo();	 
        nested.my_method();
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
- https://www.tutorialspoint.com/java/java_decision_making.htm
- https://www.tutorialspoint.com/java/java_numbers.htm
- https://www.tutorialspoint.com/java/java_characters.htm
- https://www.tutorialspoint.com/java/java_strings.htm
- https://www.tutorialspoint.com/java/java_arrays.htm
- https://www.tutorialspoint.com/java/java_date_time.htm
- https://www.tutorialspoint.com/java/java_regular_expressions.htm
- https://www.tutorialspoint.com/java/java_exceptions.htm
- https://www.tutorialspoint.com/java/java_innerclasses.htm