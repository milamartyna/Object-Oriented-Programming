package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class OptionsParser {

    public List<MoveDirection> parse(String[] strDirections){
        List<MoveDirection> directions = new ArrayList<>();
        for (String s : strDirections) {
            switch (s) {
                case "f", "forward" -> directions.add(MoveDirection.FORWARD);
                case "b", "backward" -> directions.add(MoveDirection.BACKWARD);
                case "l", "left" -> directions.add(MoveDirection.LEFT);
                case "r", "right" -> directions.add(MoveDirection.RIGHT);
                default -> throw new IllegalArgumentException(s + " is not a legal move specification");
            }
        }
        return directions;
    }

}
