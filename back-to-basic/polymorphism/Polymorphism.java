package polymorphism;

public class Polymorphism {
  public static void main(String[] args) {
    Person sekar = new Person("Sekardayu Hana Pradiani", 23);

    String[] languages = { "Java", "Python", "Go", "JavaScript", "Haskell" };
    Person richard = new Programmer("Agus Richard", 23, languages, 100);
    System.out.println(sekar.introduce());
    System.out.println(richard.introduce());
  }
}
