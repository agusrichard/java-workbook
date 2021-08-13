package outerclass;

public class OuterClass {
  private static class InnerClass {
    public void tellMeYourName(String name) {
      System.out.println("Hello " + name);
    }
  }

  public static void main(String[] args) {
    InnerClass something = new InnerClass();
    something.tellMeYourName("Sherlock Holmes");
  }
}
