package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RectangularMapTest {

    private final RectangularMap map = new RectangularMap(5, 5);
    private final Animal[] animals = new Animal[]{
            new Animal(map, new Vector2d(2, 2)),
            new Animal(map, new Vector2d(3, 4)),
            new Animal(map, new Vector2d(3, 4)),
            new Animal(map, new Vector2d(5, 2))
    };

    @Test
    void shouldPlaceAnimalsCorrectly() {
        for(Animal animal : animals){
            map.place(animal);
        }
        assertTrue(map.isOccupied(new Vector2d(2, 2)));
        assertTrue(map.isOccupied(new Vector2d(3, 4)));
        assertFalse(map.isOccupied(new Vector2d(5, 2)));
    }

    @Test
    void shouldKnowWhatObjectAt(){
        Animal animal = new Animal(map,new Vector2d(1, 4));
        map.place(animal);
        assertEquals(animal, map.objectAt(animal.position()));
    }

}