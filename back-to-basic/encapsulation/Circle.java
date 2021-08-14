package encapsulation;

public class Circle {
  private String name;
  private double radius;
  private String color;

  public Circle(String name, double radius, String color) {
    this.name = name;
    this.radius = radius;
    this.color = color;
  }

  public String getName() {
    return name;
  }

  public String getColor() {
    return color;
  }

  public double getRadius() {
    return radius;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public void setRadius(double radius) {
    this.radius = radius;
  }
}
