package agh.ics.oop;

import java.util.Arrays;
import java.util.List;

public class World{
    public static void main(String[] args) {
        Animal lion = new Animal();
        System.out.println(lion);

        OptionsParser parser = new OptionsParser();
        List<MoveDirection> directions = parser.parse(args);
        System.out.println(directions);

        for(MoveDirection element : directions) {
            if (element != null) {
                lion.move(element);
            }else break;
        }

        System.out.println(lion);
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


