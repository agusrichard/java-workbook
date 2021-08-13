package abstraction;

public class Programmer extends Person {
  private String[] languages;
  private int salary;
  private String name;
  private int age;

  public Programmer(String name, int age, String[] languages, int salary) {
    this.name = name;
    this.age = age;
    this.languages = languages;
    this.salary = salary;
  }

  public String[] getLanguages() {
    return languages;
  }

  public int getSalary() {
    return salary;
  }

  public void setLanguages(String[] languages) {
    this.languages = languages;
  }

  public void setSalary(int salary) {
    this.salary = salary;
  }

  public String introduce() {
    StringBuilder sb = new StringBuilder();
    for (String lang : languages) {
      sb.append(lang + " ");
    }
    String mainInfo = String.format("Hello, my name is %s and I am %d years old.", this.name, this.age);

    String additionalInfo = String.format("I am good in %s and my salary is %d", sb.toString(), this.salary);

    return mainInfo + " " + additionalInfo;
  }
}
