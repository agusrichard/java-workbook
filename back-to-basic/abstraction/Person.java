package abstraction;

public abstract class Person {
  private String name;
  private int age;

  protected Person() {
    this.name = "No name";
    this.age = -1;
  }

  protected Person(String name, int age) {
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

  public abstract String introduce();
}
