package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class Animal implements IMapElement{

    private final IWorldMap map;
    private MapDirection direction;
    private Vector2d position;
    private final List<IPositionChangeObserver> observers = new ArrayList<>();

    public Animal(IWorldMap map){
        this(map, new Vector2d(2, 2));
    }

    public Animal(IWorldMap map, Vector2d initialPosition){
        this.map = map;
        this.position = initialPosition;
        this.direction = MapDirection.NORTH;
        this.map.place(this);
    }

    @Override
    public String toString(){
        return switch (this.direction){
            case NORTH -> "N";
            case EAST -> "E";
            case SOUTH -> "S";
            case WEST -> "W";
        };
    }

    @Override
    public String getImagePath() {
        return "src/main/resources/" + this.direction + ".png";
    }

    @Override
    public Vector2d position() {
        return this.position;
    }

    public boolean isAt(Vector2d position){
        return this.position.equals(position);
    }

    public boolean isFacing(MapDirection direction){
        return this.direction.equals(direction);
    }

    public void move(MoveDirection direction){

        Vector2d oldPosition = this.position;
        Vector2d newPosition = this.position;

        switch (direction) {
            case RIGHT -> this.direction = this.direction.next();
            case LEFT -> this.direction = this.direction.previous();
            case FORWARD -> newPosition = this.position.add(this.direction.toUnitVector());
            case BACKWARD -> newPosition = this.position.add(this.direction.toUnitVector().opposite());
        }

        if (this.map.canMoveTo(newPosition)) {
            this.position = newPosition;
            this.positionChanged(oldPosition, newPosition);
        }

    }

    public void addObserver(IPositionChangeObserver observer){
        this.observers.add(observer);
    }

    private void removeObserver(IPositionChangeObserver observer){
        this.observers.remove(observer);
    }

    private void positionChanged(Vector2d oldPosition, Vector2d newPosition){
        for(IPositionChangeObserver observer : observers){
            observer.positionChanged(this, oldPosition, newPosition);
        }
    }

}
