package abstraction;

public class Abstraction {
  public static void main(String[] args) {
    String[] languages = { "Java", "Python", "Go", "JavaScript", "Haskell" };
    Person richard = new Programmer("Agus Richard", 23, languages, 100);
    System.out.println(richard.introduce());
  }
}
