package person;

public class Adult extends Person implements Mover {
    public Adult() {}

    public void move() {
        System.out.println("I am walking like an adult");
    }
}