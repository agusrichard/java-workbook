package generics;

public class RunGeneric {
  public static void main(String[] args) {
    String[] names = { "Bob", "Sue", "Joe" };
    Integer[] nums = { 1, 2, 3 };
    printList(names);
    printList(nums);
    System.out.println(isFirstTheSmallest(1, 2, 3));

    List<String> names1 = new List<String>(names);
    names1.print();
  }

  public static <T> void printList(T[] list) {
    for (T item : list) {
      System.out.printf("%s ", item);
    }
    System.out.println();
  }

  public static <T extends Comparable<T>> boolean isFirstTheSmallest(T x, T y, T z) {
    return x.compareTo(y) <= 0 && x.compareTo(z) <= 0;
  }
}
