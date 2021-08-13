package polymorphism;

public class Person {
  private String name;
  private int age;

  public Person() {
    this.name = "No name";
    this.age = -1;
  }

  public Person(String name, int age) {
    this.name = name;
    this.age = age;
  }

  public int getAge() {
    return age;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public String introduce() {
    return String.format("Hello, my name is %s and I am %d years old.", this.name, this.age);
  }
}
