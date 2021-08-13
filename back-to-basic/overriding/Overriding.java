package overriding;

public class Overriding {
  public static void main(String[] args) {
    Animal animal = new Animal();
    Animal dog = new Dog();

    animal.makeSound();
    dog.makeSound();
    // dog.bark();
  }
}

class Animal {
  public void makeSound() {
    System.out.println("I am an animal");
  }
}

class Dog extends Animal {
  public void makeSound() {
    System.out.println("Woof woof!");
  }

  public void bark() {
    System.out.println("Woof woof!");
  }
}