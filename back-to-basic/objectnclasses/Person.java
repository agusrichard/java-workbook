package objectnclasses;

public class Person {
  private String name;
  private int age;

  public Person() {
    this.name = "";
    this.age = 0;
  }

  public Person(String name, int age) {
    this.name = name;
    this.age = age;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public void introduce() {
    System.out.println("My name is " + this.name + " and I am " + this.age + " years old.");
  }
}