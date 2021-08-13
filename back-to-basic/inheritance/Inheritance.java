package inheritance;

public class Inheritance {
  public static void main(String[] args) {
    System.out.println("Samantha");
    Animal animal = new Animal();
    Animal dog = new Dog("Samantha");
    animal.makeSound();
    dog.makeSound();
  }
}

class Animal {
  public void makeSound() {
    System.out.println("I am an animal");
  }
}

class Dog extends Animal {
  private String name;

  Dog() {
    this.name = "I don't know my name";
  }

  Dog(String name) {
    this.name = name;
  }

  @Override
  public void makeSound() {
    super.makeSound();
    System.out.println(this.name + " " + "Woof woof");
  }
}