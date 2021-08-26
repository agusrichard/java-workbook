# Java Concepts

</br>

## List of Contents:
### 1. [Java Annotations tutorial with examples](#content-1)

</br>

---


## Contents:

## [Java Annotations tutorial with examples](https://beginnersbook.com/2014/09/java-annotations/) <span id="content-1"></span>

### Introduction
- Java Annotations allow us to add metadata information into our source code, although they are not a part of the program itself.
- Annotation has no direct effect on the operation of the code they annotate (i.e. it does not affect the execution of the program).

### What’s the use of Annotations?
- Instructions to the compiler: There are three built-in annotations available in Java (`@Deprecated`, `@Override` & `@SuppressWarnings`) that can be used for giving certain instructions to the compiler.
- Compile-time instructors: Annotations can provide compile-time instructions to the compiler that can be further used by sofware build tools for generating code, XML files etc.
- Runtime instructions: We can define annotations to be available at runtime which we can access using java reflection and can be used to give instructions to the program at runtime.


### Annotations basics
- An annotation always starts with the symbol @ followed by the annotation name. The symbol @ indicates to the compiler that this is an annotation.
- Annotations can be applied to the classes, interfaces, methods and fields.
- Example:
  ```java
  @Override
  void myMethod() { 
      //Do something 
  }
  ```
- It is instructing compiler that `myMethod()` is a overriding method which is overriding the method (`myMethod()`) of super class.

### Built-in Annotations in Java
- `@Override`:
  - While overriding a method in the child class, we should use this annotation to mark that method. 
  - This makes code readable and avoid maintenance issues, such as: while changing the method signature of parent class, you must change the signature in child classes (where this annotation is being used) otherwise compiler would throw compilation error.
  - Example:
    ```java
    public class MyParentClass {

        public void justaMethod() {
            System.out.println("Parent class method");
        }
    }


    public class MyChildClass extends MyParentClass {

        @Override
        public void justaMethod() {
            System.out.println("Child class method");
        }
    }
    ```
- `@Deprecated`
  - `@Deprecated` annotation indicates that the marked element (class, method or field) is deprecated and should no longer be used.
  - When an element is deprecated, it should also be documented using the Javadoc `@deprecated` tag, as shown in the following example. Make a note of case difference with `@Deprecated` and `@deprecated`. `@deprecated` is used for documentation purpose.
  - Example:
    ```java
    /**
     * @deprecated
     * reason for why it was deprecated
     */
    @Deprecated
    public void anyMethodHere(){
        // Do something
    }
    ```
- `@SuppressWarnings`
  - This annotation instructs compiler to ignore specific warnings.
  - Example:
    ```java
    @SuppressWarnings("deprecation")
        void myMethod() {
            myObject.deprecatedMethod();
    }
    ```


### Creating Custom Annotations
- Annotations are created by using @interface, followed by annotation name as shown in the below example.
- An annotation can have elements as well. They look like methods. For example in the below code, we have four elements. We should not provide implementation for these elements.
- All annotations extends java.lang.annotation.Annotation interface. Annotations cannot include any extends clause.
- Example:
  ```java
  import java.lang.annotation.Documented;
  import java.lang.annotation.ElementType;
  import java.lang.annotation.Inherited;
  import java.lang.annotation.Retention;
  import java.lang.annotation.RetentionPolicy;
  import java.lang.annotation.Target;
   
  @Documented
  @Target(ElementType.METHOD)
  @Inherited
  @Retention(RetentionPolicy.RUNTIME)
  public @interface MyCustomAnnotation{
      int studentAge() default 18;
      String studentName();
      String stuAddress();
      String stuStream() default "CSE";
  }
  ```
- All the elements that have default values set while creating annotations can be skipped while using annotation.
- Usage example:
  ```java
  @MyCustomAnnotation(
      studentName="Chaitanya",
      stuAddress="Agra, India"
  )
  public class MyClass {
  ...
  }

  ```
- However we have to provide the values of other elements (the elements that do not have default values set) while using annotation.
- Array elements in Annotation:
  ```java
  // Definition
  @interface MyCustomAnnotation {
      int      count();
      String[] books();
  }

  // Usage:
  @MyCustomAnnotation(
      count=3,
      books={"C++", "Java"}
  )
  public class MyClass {

  }
  ```
- `@Documented`
  - `@Documented` annotation indicates that elements using this annotation should be documented by JavaDoc.
  - Example:
    ```java
    // Definition
    java.lang.annotation.Documented
    @Documented
    public @interface MyCustomAnnotation {
      //Annotation body
    }

    // Usage
    @MyCustomAnnotation
    public class MyClass { 
         //Class body
    }
    ```
  - While generating the javadoc for class MyClass, the annotation `@MyCustomAnnotation` would be included in that.
- `@Target`
  - It specifies where we can use the annotation.
  - For example: In the below code, we have defined the target type as METHOD which means the below annotation can only be used on methods.\
  - Example:
    ```java
    // Definition
    import java.lang.annotation.ElementType;
    import java.lang.annotation.Target;

    @Target({ElementType.METHOD})
    public @interface MyCustomAnnotation {

    }

    // Usage:
    public class MyClass {
       @MyCustomAnnotation
       public void myMethod()
       {
           //Doing something
       }
    }
    ```
  - If you do not define any Target type that means annotation can be applied to any element.
- `@Inherited`
  - The @Inherited annotation signals that a custom annotation used in a class should be inherited by all of its sub classes.
  - Example:
    ```java
    // Definition
    java.lang.annotation.Inherited

    @Inherited
    public @interface MyCustomAnnotation {

    }

    // Parent
    @MyCustomAnnotation
    public class MyParentClass { 
      ... 
    }

    // Child
    public class MyChildClass extends MyParentClass { 
       ... 
    }
    ```
  - Here the class MyParentClass is using annotation `@MyCustomAnnotation` which is marked with `@inherited` annotation. It means the sub class MyChildClass inherits the `@MyCustomAnnotation`.
- `@Retention`
  - It indicates how long annotations with the annotated type are to be retained.
  - Example:
    ```java
    import java.lang.annotation.Retention;
    import java.lang.annotation.RetentionPolicy;

    @Retention(RetentionPolicy.RUNTIME)
    @interface MyCustomAnnotation {
        
    }
    ```
  - `RetentionPolicy.RUNTIME`: The annotation should be available at runtime, for inspection via java reflection.



**[⬆ back to top](#list-of-contents)**

</br>

---

## References:
- https://beginnersbook.com/2014/09/java-annotations/