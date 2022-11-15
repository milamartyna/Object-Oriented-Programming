package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

abstract class AbstractWorldMap implements IWorldMap{

    protected Vector2d startMap;
    protected Vector2d endMap;
    protected List<IMapElement> elementsOnTheMap;
    protected MapVisualiser mapVisualiser;

    public AbstractWorldMap(){
        this.mapVisualiser = new MapVisualiser(this);
        this.elementsOnTheMap = new ArrayList<>();
    }

    protected abstract Vector2d getEndMap();

    protected abstract Vector2d getStartMap();

    @Override
    public Object objectAt(Vector2d position) {
        for(IMapElement element : elementsOnTheMap){
            if(position.equals(element.position())){
                return element;
            }
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

}
