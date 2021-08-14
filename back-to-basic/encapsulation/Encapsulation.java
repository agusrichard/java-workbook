package encapsulation;

public class Encapsulation {
  public static void main(String[] args) {
    Circle myCircle = new Circle("Circle", 21, "red");
    System.out.println(myCircle.getName());
    System.out.println(myCircle.getRadius());
    System.out.println(myCircle.getColor());
  }
}
