package person;

public class Main {
    public static void main(String[] args) {
        Adult anAdult = new Adult();
        doingSomeMove(anAdult);
    }

    public static void doingSomeMove(Mover mover) {
        mover.move();
    }
}