package agh.ics.oop;

public class Animal {

    static final Vector2d endMap = new Vector2d(4, 4);
    static final Vector2d startMap = new Vector2d(0,0);
    private MapDirection direction;
    private Vector2d position;

    public Animal(){
        this.direction = MapDirection.NORTH;
        this.position = new Vector2d(2, 2);
    }

    @Override
    public String toString(){
        return "Zwierze jest zwrócone w kierunku " + this.direction + " na współrzędnych " + this.position;
    }

    public boolean isAt(Vector2d position){
        return this.position.equals(position);
    }

    public boolean isFacing(MapDirection direction){return this.direction.equals(direction);}

    public void move(MoveDirection direction){
        switch (direction) {
            case RIGHT -> this.direction = this.direction.next();
            case LEFT -> this.direction = this.direction.previous();
            case FORWARD -> {
                Vector2d newPositionF = this.position.add(this.direction.toUnitVector());
                if (newPositionF.precedes(endMap) && newPositionF.follows(startMap)) {
                    this.position = newPositionF;
                }
            }
            case BACKWARD -> {
                Vector2d newPositionB = this.position.add(this.direction.toUnitVector().opposite());
                if (newPositionB.precedes(endMap) && newPositionB.follows(startMap)) {
                    this.position = newPositionB;
                }
            }
        }
    }

}
