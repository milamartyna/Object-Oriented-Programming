package agh.ics.oop;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Vector;

import static org.junit.jupiter.api.Assertions.*;

class AnimalTest {

    private final OptionsParser parser = new OptionsParser();

    @Test
    void shouldHaveCorrectDirection() {
        Animal animal = new Animal();

        List<MoveDirection> changeDirection = parser.parse(new String[]{"l", "right", "r", "r"});
        MapDirection[] correctDirections = new MapDirection[] {
                MapDirection.WEST, MapDirection.NORTH, MapDirection.EAST, MapDirection.SOUTH
        };

        for(int i = 0; i < correctDirections.length; i++){
            animal.move(changeDirection.get(i));
            assertTrue(animal.isFacing(correctDirections[i]));
        }

    }

    @Test
    void shouldMovePositions(){
        Animal animal = new Animal();

        List<MoveDirection> changePosition = parser.parse(new String[]{"f", "r", "f", "r", "b", "l", "b"});
        Vector2d[] correctPositions = new Vector2d[]{
                new Vector2d(2, 3), new Vector2d(3, 3), new Vector2d(3, 4), new Vector2d(2, 4)
        };

        int k = 0;
        for (MoveDirection change : changePosition) {
            animal.move(change);
            if (change == MoveDirection.FORWARD || change == MoveDirection.BACKWARD) {
                assertTrue(animal.isAt(correctPositions[k]));
                k++;
            }
        }
    }

    @Test
    void shouldStayInTheMap(){
        Animal animal = new Animal();

        List<MoveDirection> changePosition = parser.parse(new String[]{"l", "f", "f", "f", "l", "b", "b", "b"});
        Vector2d[] correctPositions = new Vector2d[]{
                new Vector2d(1, 2), new Vector2d(0, 2), new Vector2d(0, 2), new Vector2d(0, 3),
                new Vector2d(0, 4), new Vector2d(0, 4)
        };

        int k = 0;
        for (MoveDirection change : changePosition) {
            animal.move(change);
            if (change == MoveDirection.FORWARD || change == MoveDirection.BACKWARD) {
                assertTrue(animal.isAt(correctPositions[k]));
                k++;
            }
        }
    }

}