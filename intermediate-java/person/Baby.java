package person;

public class Baby extends Person implements Mover {
    public Baby() {}

    public void move() {
        System.out.println("I am crawling like a baby");
    }
}