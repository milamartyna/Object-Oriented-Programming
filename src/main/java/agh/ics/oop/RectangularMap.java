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
    public boolean place(Animal animal) {
        if(this.canMoveTo(animal.position())){
            elementsOnTheMap.add(animal);
            return true;
        }
        return false;
    }

    @Override
    protected Vector2d getStartMap() {
        return this.startMap;
    }

    @Override
    protected Vector2d getEndMap() {
        return this.endMap;
    }

}
