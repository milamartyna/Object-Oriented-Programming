package agh.ics.oop;

public record Grass(Vector2d position) implements IMapElement {

    @Override
    public String toString() {
        return "*";
    }

}
