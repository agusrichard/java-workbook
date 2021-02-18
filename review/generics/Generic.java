package generics;

public class Generic {
    public static void main(String[] args) {
        System.out.println("Sekardayu Hana Pradiani");
        Integer[] integerList = {1, 2, 3};
        String[] stringList = {"Sekardayu", "Hana", "Pradiani"};

        printList(integerList);
        printList(stringList);
    }

    public static <T> void printList(T[] list) {
        for (T element: list) {
            System.out.println(element);
        }
    }
}

class ComparableList<T extends Comparable<T>> {
    private T[] list;

    ComparableList(T[] args) {
        this.list = args;
    }

    public T[] get() {
        return this.list;
    }

    public void set(T[] args) {
        this.list = args;
    }
}