package agh.ics.oop;

public class RectangularMap extends AbstractWorldMap{

    public RectangularMap(int width, int height){
        super();
        this.startMap = new Vector2d(0, 0);
        this.endMap = new Vector2d(width - 1, height - 1);
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return position.precedes(endMap) && position.follows(startMap) && !this.isOccupied(position);
    }

    @Override
    public void place(Animal animal) {
        if(this.canMoveTo(animal.position())){
            elementsOnTheMap.put(animal.position(), animal);
            animal.addObserver(this);
        }else {
            throw new IllegalArgumentException(animal.position() + " is not a correct position");
        }
    }

    @Override
    public Vector2d getStartMap() {
        return this.startMap;
    }

    @Override
    public Vector2d getEndMap() {
        return this.endMap;
    }

}
