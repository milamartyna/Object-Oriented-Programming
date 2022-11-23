package agh.ics.oop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RectangularMapTest {

    private final RectangularMap map = new RectangularMap(5, 5);

    private final Animal animal1 = new Animal(map, new Vector2d(2, 2));
    private final Animal animal2 = new Animal(map, new Vector2d(3, 4));

    @Test
    void shouldPlaceAnimalsCorrectly() {
        assertTrue(map.isOccupied(new Vector2d(2, 2)));
        assertTrue(map.isOccupied(new Vector2d(3, 4)));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Animal(map, new Vector2d(3, 4)));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Animal(map, new Vector2d(5, 2)));
    }

    @Test
    void shouldKnowWhatObjectAt(){
        Animal animal = new Animal(map,new Vector2d(1, 4));
        assertEquals(animal, map.objectAt(animal.position()));
    }

}