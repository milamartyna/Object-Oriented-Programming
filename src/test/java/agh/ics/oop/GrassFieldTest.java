package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GrassFieldTest {

    private final GrassField map = new GrassField(10);
    private final Animal[] animals = new Animal[]{
            new Animal(map, new Vector2d(2, 2)),
            new Animal(map, new Vector2d(3, 4)),
            new Animal(map, new Vector2d(3, 4)),
            new Animal(map, new Vector2d(15, 2))
    };

    @Test
    void shouldPlaceAnimalsCorrectly() {
        for(Animal animal : animals){
            map.place(animal);
        }
        assertTrue(map.isOccupied(new Vector2d(2, 2)));
        assertTrue(map.isOccupied(new Vector2d(3, 4)));
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
        map.place(animal);
        assertEquals(animal, map.objectAt(animal.position()));
    }

    @Test
    void animalsShouldEatGrass(){
        for(int i = 0; i <= 10; i++){
            for(int j = 0; j <= 10; j++){
                Vector2d position = new Vector2d(i, j);
                if(map.objectAt(position) instanceof Grass){
                    Animal animal = new Animal(map, position);
                    map.place(animal);
                    assertTrue(map.objectAt(position) instanceof Animal);
                }
            }
        }
    }

}