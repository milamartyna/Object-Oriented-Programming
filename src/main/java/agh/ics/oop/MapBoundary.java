package agh.ics.oop;

import java.util.SortedSet;
import java.util.TreeSet;


public class MapBoundary implements IPositionChangeObserver{

    SortedSet<Vector2d> setOnXAxis = new TreeSet<>(new MapElementComparatorX());
    SortedSet<Vector2d> setOnYAxis = new TreeSet<>(new MapElementComparatorY());

    @Override
    public void positionChanged(IMapElement element, Vector2d oldPosition, Vector2d newPosition) {
        setOnXAxis.remove(oldPosition);
        setOnYAxis.remove(oldPosition);
        setOnXAxis.add(newPosition);
        setOnYAxis.add(newPosition);
    }

    public void add(IMapElement element){
        setOnXAxis.add(element.position());
        setOnYAxis.add(element.position());
    }

    public void remove(IMapElement element){
        setOnXAxis.remove(element.position());
        setOnYAxis.remove(element.position());
    }

    public Vector2d getEndMap(){
        return new Vector2d(setOnXAxis.last().x(), setOnYAxis.last().y());
    }

    public Vector2d getStartMap(){
        return new Vector2d(setOnXAxis.first().x(), setOnYAxis.first().y());
    }

}
