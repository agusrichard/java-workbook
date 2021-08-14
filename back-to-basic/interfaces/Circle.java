package interfaces;

public class Circle implements Shape {
  private String name;
  private int radius;

  public Circle(String name, int radius) {
    this.name = name;
    this.radius = radius;
  }

  public String getName() {
    return name;
  }

  public int getRadius() {
    return radius;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setRadius(int radius) {
    this.radius = radius;
  }

  public void draw() {
    System.out.printf("I am drawing a circle with a name of %s and radius %d%n", this.name, this.radius);
  }

  public void erase() {
    System.out.println("I am sorry, but I have to erase you!");
  }
}
