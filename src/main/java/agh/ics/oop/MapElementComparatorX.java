package agh.ics.oop;

import java.util.Comparator;

public class MapElementComparatorX implements Comparator<Vector2d> {

    @Override
    public int compare(Vector2d v1, Vector2d v2) {
        return v1.x() - v2.x();
    }

}
