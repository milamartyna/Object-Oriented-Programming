package agh.ics.oop;
import java.util.List;

public class World{
    public static void main(String[] args) {
        List<MoveDirection> directions = new OptionsParser().parse(args);
        IWorldMap map = new RectangularMap(10, 5);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();
        System.out.println(map);
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


