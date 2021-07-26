# Back to Basic -- Java Tutorial Notes

</br>

## List of Contents:
### 1. [Java Tutorial](#content-1)
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

## References:
- https://www.tutorialspoint.com/java/index.htm
- https://www.tutorialspoint.com/java/java_basic_syntax.htm