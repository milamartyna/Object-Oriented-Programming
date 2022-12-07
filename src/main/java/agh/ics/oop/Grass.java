package agh.ics.oop;

public record Grass(Vector2d position) implements IMapElement {

    @Override
    public String toString() {
        return "*";
    }

    @Override
    public String getImagePath() {
        return "src/main/resources/greenGrass.png";
    }


}
