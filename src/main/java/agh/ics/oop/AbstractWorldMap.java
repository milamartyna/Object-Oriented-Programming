package agh.ics.oop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

abstract class AbstractWorldMap implements IWorldMap, IPositionChangeObserver{

    protected Vector2d startMap;
    protected Vector2d endMap;
    protected HashMap<Vector2d, IMapElement> elementsOnTheMap;
    protected MapVisualiser mapVisualiser;

    public AbstractWorldMap(){
        this.mapVisualiser = new MapVisualiser(this);
        this.elementsOnTheMap = new HashMap<>();
    }

    protected abstract Vector2d getEndMap();

    protected abstract Vector2d getStartMap();

    @Override
    public Object objectAt(Vector2d position) {
        if(this.elementsOnTheMap.containsKey(position)){
            return this.elementsOnTheMap.get(position);
        }
        return null;
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return this.objectAt(position) != null;
    }

    @Override
    public String toString(){
        return this.mapVisualiser.draw(getStartMap(), getEndMap());
    }

    @Override
    public void positionChanged(Animal animal, Vector2d oldPosition, Vector2d newPosition){
        IMapElement element = elementsOnTheMap.get(oldPosition);
        elementsOnTheMap.remove(oldPosition);
        elementsOnTheMap.put(newPosition, element);
    }

}
