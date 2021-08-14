package interfaces;

public class RunInterface {
  public static void main(String[] args) {
    Circle myCircle = new Circle("Sherlock", 21);
    myCircle.draw();
    myCircle.erase();
  }
}
