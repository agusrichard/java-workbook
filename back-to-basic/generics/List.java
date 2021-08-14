package generics;

public class List<T> {
  private T[] elements;

  public List(T[] elements) {
    this.elements = elements;
  }

  public T[] getElements() {
    return elements;
  }

  public void setElements(T[] elements) {
    this.elements = elements;
  }

  public void print() {
    for (T element : this.elements) {
      System.out.println(element);
    }
  }
}
