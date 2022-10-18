package agh.ics.oop;

public enum Direction {
    FORWARD,
    BACKWARD,
    RIGHT,
    LEFT;

    @Override
    public String toString(){
        return switch(this){
            case FORWARD -> "do przodu";
            case BACKWARD -> "do tyłu";
            case RIGHT -> "w prawo";
            case LEFT -> "w lewo";
        };
    }

}
