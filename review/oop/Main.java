package oop;

public class Main {
    private int x, y;

    public static void main(String[] args) {
        Main myObj = new Main();
        System.out.println(myObj.getX());
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }
}
