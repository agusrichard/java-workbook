## Design Patterns


<br />

## List of Contents:
### 1. [Design Patterns Every Developer Should Know](#content-1)

<br />

---

## Contents:

## [Design Patterns Every Developer Should Know](https://medium.datadriveninvestor.com/design-patterns-every-developer-should-know-3d34ae482c3) <span id="content-1"></span>

### Iterator
- Objects that traverse collections
- Snippet:
    ```java
    Iterator iterator = list.createIterator();
    while(iterator.hasNext()){
        System.out.println(iterator.next());
    }
    ```
- Singletons are used to implement comparators as they don’t require a state.

### Singleton
- A class has only a single instance
- Singleton pattern is implemented when we need only one instance of a class.
- Implementation
  - Create a single private static instance of the class.
  -  Make the constructor private so that it cannot be called from outside the class.
  -  Create a public static method getInstance() that allows access to the single instance of the class.
- Snippet:
  ```java
  public class Car{
     private static Car car = null;
     
     private Car(){
     }
     public static Car getInstance(){
         if(car==null) car = new Car(); //lazy instantiation
         return car;
     }
  }
  ```
  
### Flyweight
- A class has only one instance of each unique state
- Flyweight pattern is used to ensure that a class has only one instance of a particular state.
- This pattern is similar to singleton but the key difference is that we have one instance for each unique object state.
- Snippet:
  ```java
  public class Flyweight{
      private static Map<KeyType,Flyweight> instances = new HashMap<>();
      private Flyweight(...){...}
      public static Flyweight getInstance(KeyType key){
          if(!instances.containsKey(key))
              instances.put(key,new Flyweight(key));
          return instances.get(key);
      }
  } 
  ```

### Adapter
- An object that fits another object in a given interface
- Adapter design pattern is used when we have an object that contains functionality which we need but not in the way we want.
- An adapter helps us bridge the provided and the desired functionality.
- Snippet:
  ```java
  public interface Animal{
     public void move();
  }
  public class Lion implements Animal{
     public void move(){...}
  }
  public class TigerToy(){
     public void roll(){...}
  }
  public class TigerToyAdapter(){
     TigerToy tiger;
     
     public TigerToyAdapter(TigerToy tiger){
        this.tiger = tiger;
     }
     public void move(){
        tiger.roll();
     }
  }
  class Main{
     public static void main(String args[]){
        Lion lion = new Lion();
        TigerToyAdapter tiger= new TigerToyAdapter(new TigerToy());
        lion.move();
        tiger.move();
     }
  }
  ```

### Strategy
- Objects that hold different algorithms to solve a problem
- In strategy pattern, a class behaviour can be changed at runtime by creating objects that represent various strategies and a context object whose behaviour varies as per strategy object.
- Snippet:
  ```java
  public interface Strategy{
     public int perform(int num1,int num2);
  }
  public class Add implements Strategy{
     @Override
     public int perform(int num1,int num2){
         return num1+num2;
     }
  }
  public class Subtract implements Strategy{
    @Override
     public int perform(int num1,int num2){
         return num1-num2;
     }
  }
  public class Context{
     private Strategy strategy;
     public Context(Strategy strategy){
         this.strategy = strategy;
     }
     public int perform(int num1,int num2){
         return strategy.perform(num1,num2);
     }
  }
  public class Main{
     public static void main(String args[]){
         Context context = new Context(new Add());
         System.out.println(context.perform(1,2));
         context = new Context(new Subtract());
         System.out.println(context.perform(1,2));
     }
  }
  ```

### Facade
- Hiding the complexities of the system and providing a simplified interface to the client
- Fascade design pattern helps us to unify a set of interfaces in a subsystem and provides a high-level interface that makes the subsystem easier to use.
- Snippet:
  ```java
  class CallCenter{
      NetworkTeam net;
      BillingTeam bill;
      RoamingTeam roam;
      AccountTeam account;
      public CallCenter(...){...}
      public void handleCalls(int option){
          switch(option){
              case 1:
                  net.handleNetwork();
                  break;
              case 2:
                 ...
          }
      }
  }
  class Main{
      public static void main(String args[]){
          CallCenter callCenter = new CallCenter();
          callCenter.handleCalls(1);
     }
  }
  ```


**[⬆ back to top](#list-of-contents)**

<br />

---

## References:
- https://medium.datadriveninvestor.com/design-patterns-every-developer-should-know-3d34ae482c3
