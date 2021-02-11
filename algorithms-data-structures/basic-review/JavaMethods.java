public class JavaMethods {
  public static void main(String[] args) {
    System.out.println("Saskia Nurul Azhima");
    sayHi("Sekardayu Hana Pradiani");
    System.out.println(addition(1, 2));
    System.out.println(factorial(10));
;  }

  public static void sayHi(String name) {
    System.out.println("Hi.... My name is " + name);
  }

  public static int addition(int a, int b) {
    return a + b;
  }

  public static int factorial(int num) {
    if (num < 2) {
      return num;
    }

    return num * factorial(num - 1);
  }
}