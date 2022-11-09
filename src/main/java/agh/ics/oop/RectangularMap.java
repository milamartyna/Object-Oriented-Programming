package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class RectangularMap implements IWorldMap{

    private final List<Animal> animalsOnTheMap = new ArrayList<>();
    final private Vector2d endMap;
    final private Vector2d startMap = new Vector2d(0, 0);
    final MapVisualiser mapVisualiser = new MapVisualiser(this);

    public RectangularMap(int width, int height){
        this.endMap = new Vector2d(width - 1, height - 1);
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return position.precedes(endMap) && position.follows(startMap) && !this.isOccupied(position);
    }

    @Override
    public boolean place(Animal animal) {
        if(this.canMoveTo(animal.getPosition())){
            animalsOnTheMap.add(animal);
            return true;
        }
        return false;
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return this.objectAt(position) != null;
    }

    @Override
    public Object objectAt(Vector2d position) {
        for(Animal placedAnimal: animalsOnTheMap){
            if(position.equals(placedAnimal.getPosition())){
                return placedAnimal;
            }
        }
        return null;
    }

    @Override
    public String toString(){
        return this.mapVisualiser.draw(startMap, endMap);
    }

}
