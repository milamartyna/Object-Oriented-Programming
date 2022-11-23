package agh.ics.oop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GrassFieldTest {

    private final GrassField map = new GrassField(10);
    private final Animal animal1 = new Animal(map, new Vector2d(2, 2));
    private final Animal animal2 = new Animal(map, new Vector2d(3, 4));
    private final Animal animal3 = new Animal(map, new Vector2d(15, 2));

    @Test
    void shouldPlaceAnimalsCorrectly() {
        assertTrue(map.isOccupied(new Vector2d(2, 2)));
        assertTrue(map.isOccupied(new Vector2d(3, 4)));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Animal(map, new Vector2d(3, 4)));
        assertTrue(map.isOccupied(new Vector2d(15, 2)));
    }

    @Test
    void shouldPlaceGrassCorrectly(){
        int grassCount = 0;
        for(int i = 0; i <= 10; i++){
            for(int j = 0; j <= 10; j++){
                if(map.objectAt(new Vector2d(i, j)) instanceof Grass){
                    grassCount++;
                }
            }
        }
        assertEquals(10, grassCount);
    }

    @Test
    void shouldKnowWhatObjectAt(){
        Animal animal = new Animal(map, new Vector2d(1, 8));
        assertEquals(animal, map.objectAt(animal.position()));
    }

    @Test
    void animalsShouldEatGrass(){
        for(int i = 0; i <= 10; i++){
            for(int j = 0; j <= 10; j++){
                Vector2d position = new Vector2d(i, j);
                if(map.objectAt(position) instanceof Grass){
                    Animal animal = new Animal(map, position);
                    assertTrue(map.objectAt(position) instanceof Animal);
                }
            }
        }
    }

}