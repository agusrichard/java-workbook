# Intermediate Java programming

<br />

## List of Contents:
### 1. [Inheritance and abstraction](#content-1)
### 2. [Interfaces](#content-2)
### 3. [Nested classes](#content-3)
### 4. [Collections](#content-4)


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

### Using interfaces
- An interface defines a new reference data type. That means that you can refer to an interface anywhere you would refer to a class, such as when you cast, as illustrated by the following code snippet from a main() method you can add to Adult:
  ```java
  public static void main(String[] args) {
      ...
      Adult anAdult = new Adult();
      anAdult.talk();
      Human aHuman = (Human) anAdult;
      aHuman.talk();
  }
  ```
- Both calls to talk() will display Spoke. on the console. Why? Because an Adult is a Human once it implements that interface.
- You can cast an Adult as a Human, then call methods defined by the interface, just as you can cast anAdult to Person and call Person methods on it.
-  Consider this code somewhere in our system:
  ```java
  public static void main(String[] args) {
      ...
      Human aHuman = getHuman();
      aHuman.move();
  }
  ```
- Is the Human an Adult or a Baby? We don’t have to care. As long as whatever we get back from getPerson() is of type Human, we can call move() on it and expect it to respond accordingly. We don’t even have to care if the classes implementing the interface are in the same hierarchy.

### Why interfaces?
- There are three primary reasons for using interfaces:
  - To create convenient or descriptive namespaces.
  - To relate classes in different hierarchies.
  - To hide underlying type details from your code.
- When you create an interface to collect related constants, that interface gives you a descriptive name to use to refer to those constants.
- The Java language supports single inheritance only. In other words, a class can only be a subclass of a single superclass.
- In essence, an interface simply specifies a set of behaviors that all implementors of the interface must support.
- Example:
  ```java
  public interface Mover {
      void move();
  }
  ```

**[⬆ back to top](#list-of-contents)**

<br />

---

## [Nested classes](https://developer.ibm.com/tutorials/j-intermed/) <span id="content-3"></span>

### What’s a nested class?
- As its name suggests, a nested class in the Java language is a class declared within another class. Here’s a simple example:
- Typically, good programmers define nested classes when the nested class only makes sense within the context of the enclosing class. Some common examples include the following:
  - Event handlers within a UI class
  - Helper classes for UI components within those components
  - Adapter classes to convert the innards of one class to some other form for users of the class
- You can define a nested class as public, private, or protected. You also can define a nested class as final (to prevent it from being changed), abstract (meaning that it can’t be instantiated), or static.
- When you create a static class within another class, you’re creating what is appropriately called a nested class. A nested class is defined within another class, but can exist outside an instance of the enclosing class.
- If your nested class isn’t static, it can exist only within an instance of the enclosing class, and is more appropriately called an inner class
- In other words, all inner classes are nested classes, but not all nested classes are inner classes.
- The vast majority of the nested classes you will encounter in your career will be inner classes, rather than simply nested ones.
- Any nested class has access to all of the members of the enclosing class, even if they’re declared private.

### Defining nested classes
- You define a nested class just as you define a non-nested class, but you do it within an enclosing class. For a somewhat contrived example, let’s define a Wallet class inside Adult. While in real life you could have a Wallet apart from an Adult, it wouldn’t be all that useful, and it makes good sense that every Adult has a Wallet (or at least something to hold money, and MoneyContainer sounds a little odd).
- Example:
  ```java
  protected class Wallet {
      protected ArrayList bills = new ArrayList();
  
      protected void addBill(int aBill) {
          bills.add(new Integer(aBill));
      }
  
      protected int getMoneyTotal() {
          int total = 0;
          for (Iterator i = bills.iterator(); i.hasNext(); ) {
              Integer wrappedBill = (Integer) i.next();
              int bill = wrappedBill.intValue();
              total += bill;
          }
          return total;
      }
  }
  ```
  ```java
  public class Adult extends Person {
      protected Wallet wallet = new Wallet();
      public Adult() {
      }
      public void talk() {
          System.out.println("Spoke.");
      }
      public void acceptMoney(int aBill) {
          this.wallet.addBill(aBill);
      }
      public int moneyTotal() {
          return this.wallet.getMoneyTotal();
      }
      protected class Wallet {
          ...
      }
  }
  ```
  ```java
  Adult anAdult = new Adult();
  anAdult.acceptMoney(5);
  System.out.println("I have this much money: " + anAdult.moneyTotal());
  ```

### Simplistic event handling
- The Java language defines an event handling approach, with associated classes, that allows you to create and handle your own events. But event handling can be much simpler than that. All you really need is some logic to generate an “event” (which really doesn’t have to be an event class at all), and some logic to listen for that event and then respond appropriately.
- For example, suppose that whenever a Person moves, our system generates (or fires) a MoveEvent, which we can choose to handle or not. This will require several changes to our system. We have to:
  - Create an “application” class to launch our system and illustrate using the anonymous inner class.
  - Create a MotionListener that our application can implement, and then handle the event in the listener.
  - Add a List of listeners to Adult.
  - Add an addMotionListener() method to Adult to register a listener.
  - Add a fireMoveEvent() method to Adult so that it can tell listeners when to handle the event.
  - Add code to our application to create an Adult and register itself as a handler.
- Example:
  ```java
  public class Adult extends Person {
      protected Wallet wallet = new Wallet();
      protected ArrayList listeners = new ArrayList();
      public Adult() {
      }
      public void move() {
        super.move(); fireMoveEvent();
      }
      ...
      public void addMotionListener(MotionListener aListener) {
        listeners.add(aListener);
      }
      protected void fireMoveEvent() {
        Iterator iterator = listeners.iterator();
        while(iterator.hasNext()) {
          MotionListener listener = (MotionListener) iterator.next();
          listener.handleMove(this);
      }
      }
      protected class Wallet {
          ...
      }
  }
  ```
  ```java
  public interface MotionListener {
      public void handleMove(Adult eventSource);
  }
  ```
  ```java
  public class CommunityApplication implements MotionListener {
    public void handleMove(Adult eventSource) {
      System.out.println("This Adult moved: \n" + eventSource.toString());
    }
    public static void main(String[] args) {
      CommunityApplication application = new CommunityApplication();
      Adult anAdult = new Adult();
      anAdult.addMotionListener(application);
      anAdult.move();
    }
  }
  ```

### Anonymous inner classes
- Anonymous inner classes allow you to define a class in place, without naming it, to provide some context-specific behavior.
- Turn the previous code as anonymous inner class:
  ```java
  anAdult.addMotionListener(new MotionListener() {
    public void handleMove(Adult eventSource) {
      System.out.println("This Adult moved: \n" + eventSource.toString());
    }
  });
  ```
- Rather than having CommunityApplication implement MotionListener, we declared an unnamed (and thus anonymous) inner class of type MotionListener, and gave it an implementation of handleMove(). The fact that MotionListener is an interface, not a class, doesn’t matter. Either is acceptable.

### Using nested classes
- Use a nested class when it would make little sense to define the class outside of an enclosing class. In our example, we could have defined Wallet outside Adult without feeling too badly about it.
- But imagine something like a Personality class. Do you ever have one outside a Person instance? No, so it makes perfect sense to define it as a nested class.
- A good rule of thumb is that you should define a class as non-nested until it’s obvious that it should be nested, then refactor to nest it.
- Anonymous inner classes are the standard approach for event handlers, so use them for that purpose. In other cases, be very careful with them.
- Unless anonymous inner classes are small, focused, and familiar, they obfuscate code.


**[⬆ back to top](#list-of-contents)**

<br />

---

## [Collections](https://developer.ibm.com/tutorials/j-intermed/) <span id="content-4"></span>

### Collection interfaces and classes
- The List interface defines a navigable collection of Object elements. e.g ArrayList, Vector
- The Set interface defines a collection with no duplicate elements. e.g 	HashSet, TreeSet
- The Map interface defines a collection of key-value pairs. e.g HashMap
- All of the interfaces in the framework except Map are subinterfaces of the Collection interface, which defines the most general structure of a collection.
- Each collection consists of elements. As implementors of subinterfaces of Collection, all collections share some (intuitive) behavior:
  - Methods that describe the size of the collection (such as size() and isEmpty())
  - Methods that describe the contents of the collection (such as contains() and containsAll())
  - Methods that support manipulation of the collection’s contents (such as add(), remove(), and clear())
  - Methods that let you convert a collection to an array (such as toArray())
  - A method that lets you get an iterator on the array (iterator())

### List implementations
- Older versions of the JDK contained a class called Vector. It’s still there in newer versions, but you should use it only when you need a synchronized collection — that is, one that is thread-safe.
- When we created a Wallet nested class in this tutorial, we incorporated an ArrayList to hold an Adult‘s bills:
  ```java
  protected class Wallet {
      protected ArrayList bills = new ArrayList();
  
      protected void addBill(int aBill) {
          bills.add(new Integer(aBill));
      }
  
      protected int getMoneyTotal() {
          int total = 0;
          for (Iterator i = bills.iterator(); i.hasNext(); ) {
              Integer wrappedBill = (Integer) i.next();
              int bill = wrappedBill.intValue();
              total += bill;
          }
          return total;
      }
  }
  ```
- The getMoneyTotal() method uses an iterator to march through the list of bills and total their values.
- When you get an iterator on a collection (by calling iterator()), that iterator lets you traverse the collection using a couple of important methods, illustrated in the code above:
  - hasNext() tells you if there is another element in the collection. 
  - next() gives you that next element.
- As we discussed before, you must cast to the correct type when you extract elements from a collection using next().
- An Iterator gives us some additional capability, however. We can remove elements from our ArrayList by calling remove() (or removeAll(), or clear()), but we also can use the Iterator to do that.
- Let’s add a simplistic method to Adult called spendMoney():
  ```java
  public void spendMoney(int aBill) {
      this.wallet.removeBill(aBill);
  }
  ```
  ```java
  protected void removeBill(int aBill) {
      Iterator iterator = bills.iterator();
      while (iterator.hasNext()) {
          Integer bill = (Integer) iterator.next();
          if (bill.intValue() == aBill)
              iterator.remove();
      }
  }
  ```
- Easier to read of the same implementation:
  ```java
  protected void removeBill(int aBill) {
      bills.remove(new Integer(aBill));
  }
  ```
- Remove multiple bills at once:
  ```java
  public void spendMoney(List bills) {
      this.wallet.removeBills(bills);
  }
  ```
  ```java
  protected void removeBills(List billsToRemove) {
      this.bills.removeAll(bills);
  }
  ```
  ```java
  protected void removeBills(List billsToRemove) {
      Iterator iterator = billsToRemove.iterator();
      while (iterator.hasNext()) {
          this.bills.remove(iterator.next());
      }
  }
  ```

### Set implementations
- HashSet, which does not guarantee the order of iteration.
- TreeSet, which does.
- The Java language documentation suggests that you’ll end up using the first implementation most of the time.
- In general, if you need to make sure the elements in your Set are in a certain order when you traverse it with an iterator, use the second implementation.
- Otherwise, the first will do. The ordering of elements in a TreeSet (which, by the way, implements the SortedSet interface) is called the natural ordering; this means that, most of the time, you should be able to order the elements based on an equals() comparison.
- Suppose that each Adult has a set of nicknames. We really don’t care what order they’re in, but duplicates wouldn’t make much sense. We could use a HashSet to hold them. First, we add an instance variable:
  ```java
  protected Set nicknames = new HashSet();
  ```
- Add method:
  ```java
  public void addNickname(String aNickname) {
      nicknames.add(aNickname);
  }
  ```
- Now try running this code:
  ```java
  Adult anAdult = new Adult();
  anAdult.addNickname("Bobby");
  anAdult.addNickname("Bob");
  anAdult.addNickname("Bobby");
  System.out.println(anAdult.nicknames);
  ```

### Map implementations
- A Map is a collection of key-value pairs. It cannot contain duplicate keys. Each key must map to a single value, but that value can be of any type.
- You can think of a map as a named List. Imagine a List where each element has a name you can use to extract that element directly.
- The key can be anything of type Object, as can the value. Once again, that means you can’t store primitives directly in a Map (do you hate primitives yet?). Instead, you have to use the primitive wrapper classes to store the values.
- Although this is a financially risky strategy, we’re going to give each Adult a set of admittedly simplistic credit cards. Each will have a name and a balance (initially 0). First, we add an instance variable:
  ```java
  protected Map creditCards = new HashMap();
  ```
- Then we add a method to add a credit card to the Map:
  ```java
  public void addCreditCard(String aCardName) {
      creditCards.put(aCardName, new Double(0));
  }
  ```
- Retrieve the balance of the card:
  ```java
  public double getBalanceFor(String cardName) {
      Double balance = (Double) creditCards.get(cardName);
      return balance.doubleValue();
  }
  ```
- Charging the balance:
  ```java
  public void charge(String cardName, double amount) {
      Double balance = (Double) creditCards.get(cardName);
      double primitiveBalance = balance.doubleValue();
      primitiveBalance += amount;
      balance = new Double(primitiveBalance);
  
      creditCards.put(cardName, balance);
  }
  ```

### The Collections class
- Frequently used method in Java:
  - copy
  - sort
- The first method lets you copy the contents of one collection to another, like this:
  ```java
  List source = new ArrayList();
  source.add("one");
  source.add("two");
  List target = new ArrayList();
  target.add("three");
  target.add("four");
  
  Collections.copy(target, source);
  System.out.println(target);
  ```
- This code copies source into target. The target has to be the same size as the source, so you can’t copy a List into an empty List.
- Then we override compareTo() to compare two Adult instances. We’ll keep the comparison simplistic for our example, so it’s less work:
  ```java
  public int compareTo(Object other) {
      final int LESS_THAN = -1;
      final int EQUAL = 0;
      final int GREATER_THAN = 1;
  
      Adult otherAdult = (Adult) other;
      if ( this == otherAdult ) return EQUAL;
  
      int comparison = this.firstname.compareTo(otherAdult.firstname);
      if (comparison != EQUAL) return comparison;
  
      comparison = this.lastname.compareTo(otherAdult.lastname);
      if (comparison != EQUAL) return comparison;
  
      return EQUAL;
  }
  ```
  
### Using collections
- Despite what many professionals may believe, there are very few hard and fast rules about which classes to use in any given situation. In my personal experience, in the vast majority of the times I’ve used collections, an ArrayList or a HashMap (remember, a Map isn’t a true collection) did the trick. That will probably be the same in your experience. Here are some rules of thumb, some more obvious than others:
  - When you think you need a collection, start with a List, then let the code tell you if you need another type.
  - If you need a unique grouping of things, use a Set.
  - If the iteration order is important when traversing a collection, use the Tree... flavors of collections, where available.
  - Avoid using Vector, unless you need its synchronization capability.
  - Don’t worry about optimization until (and unless) performance becomes an issue.



**[⬆ back to top](#list-of-contents)**

<br />

---

## References:
- https://developer.ibm.com/tutorials/j-intermed/
