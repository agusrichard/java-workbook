package polymorphism;

public class Programmer extends Person {
  private String[] languages;
  private int salary;

  public Programmer(String name, int age, String[] languages, int salary) {
    super(name, age);
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

  @Override
  public String introduce() {
    StringBuilder sb = new StringBuilder();
    for (String lang : languages) {
      sb.append(lang + " ");
    }
    String additionalInfo = String.format("I am good in %s and my salary is %d", sb.toString(), this.salary);

    return super.introduce() + " " + additionalInfo;
  }
}
