package agh.ics.oop;

public class World {
    public static void main(String[] args) {
//        System.out.println("Start");
//        Direction[] directions = change(args);
//        run(directions);
//        System.out.println("Stop");
        Vector2d position1 = new Vector2d(1, 2);
        System.out.println(position1);
        Vector2d position2 = new Vector2d(-2, 1);
        System.out.println(position2);
        System.out.println(position1.add(position2));
//        System.out.println(MapDirection.EAST);
//        System.out.println(MapDirection.SOUTH.previous());
//        System.out.println(MapDirection.WEST.next());
//        System.out.println(MapDirection.NORTH.toUnitVector());

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


