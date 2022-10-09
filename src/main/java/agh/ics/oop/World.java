package agh.ics.oop;

public class World {
    public static void main(String[] args) {
        System.out.println("Start");
        Direction[] directions = change(args);
        run(directions);
        System.out.println("Stop");
    }

    static void run(Direction[] directions) {
        for (Direction d : directions) {
            System.out.println("Zwierzak is moving " + d.name());
        }
    }

    static Direction[] change(String[] arr) {
        Direction[] directions = new Direction[arr.length];
        for (int i = 0; i < arr.length; i++) {
            switch (arr[i]) {
                case "f" -> directions[i] = Direction.FORWARD;
                case "b" -> directions[i] = Direction.BACKWARD;
                case "l" -> directions[i] = Direction.LEFT;
                case "r" -> directions[i] = Direction.RIGHT;
            }
        }
        return directions;
    }
}


