package agh.ics.oop;

public class Animal implements IMapElement{

    private final IWorldMap map;
    private MapDirection direction;
    private Vector2d position;

    public Animal(IWorldMap map){
        this.map = map;
        this.direction = MapDirection.NORTH;
    }

    public Animal(IWorldMap map, Vector2d initialPosition){
        this.map = map;
        this.position = initialPosition;
        this.direction = MapDirection.NORTH;
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
            if(this.map instanceof GrassField){
                ((GrassField) this.map).freeUpGrassSpot(oldPosition);
                ((GrassField) this.map).animalEatsGrass(this);
            }
        }

    }

}
