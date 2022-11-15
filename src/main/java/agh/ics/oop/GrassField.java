package agh.ics.oop;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GrassField extends AbstractWorldMap {

    private List<Vector2d> unoccupiedGrassSpots = new ArrayList<>();
    private final int grassCoordinate;
    private final Vector2d startGrass = new Vector2d(0, 0);
    private final Vector2d endGrass;

    public GrassField(int grassSpotsCount){
        super();

        this.grassCoordinate = (int)Math.sqrt(grassSpotsCount * 10);
        this.endGrass = new Vector2d(this.grassCoordinate, this.grassCoordinate);
        this.fillEmptyGrassSpotsList();
        this.putGrassOnTheField(grassSpotsCount);

        this.startMap = new Vector2d(this.grassCoordinate, this.grassCoordinate);
        this.endMap = new Vector2d(0 ,0);
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return !this.isOccupied(position) || this.objectAt(position) instanceof Grass;
    }

    @Override
    public boolean place(Animal animal) {
        if(this.canMoveTo(animal.position())){
            this.animalEatsGrass(animal);
            this.elementsOnTheMap.add(animal);
            return true;
        }
        return false;
    }

    public void animalEatsGrass(Animal animal){
        Vector2d animalPosition = animal.position();

        if(isPositionOnTheGrassTerritory(animalPosition)) {
            Object objectOnTheAnimalPosition = objectAt(animalPosition);
            if(objectOnTheAnimalPosition instanceof Grass) {
                this.elementsOnTheMap.remove(objectOnTheAnimalPosition);
                putGrassOnTheField(1);
            }
            this.unoccupiedGrassSpots.remove(animalPosition);
        }
    }

    public void freeUpGrassSpot(Vector2d position){
        if(isPositionOnTheGrassTerritory(position)){
            this.unoccupiedGrassSpots.add(position);
        }
    }

    @Override
    protected Vector2d getStartMap() {
        for(IMapElement element : elementsOnTheMap){
            this.startMap = this.startMap.lowerLeft(element.position());
        }
        return this.startMap;
    }

    @Override
    protected Vector2d getEndMap() {
        for(IMapElement element : elementsOnTheMap){
            this.endMap = this.endMap.upperRight(element.position());
        }
        return this.endMap;
    }

    private void fillEmptyGrassSpotsList(){
        for(int i = 0; i <= this.grassCoordinate; i++){
            for(int j = 0; j <= this.grassCoordinate; j++){
                this.unoccupiedGrassSpots.add(new Vector2d(i, j));
            }
        }
    }

    private void putGrassOnTheField(int grassSpotsCount){
        Collections.shuffle(this.unoccupiedGrassSpots);
        int length = this.unoccupiedGrassSpots.size();
        int startIndex = grassSpotsCount - 1;

        for(int i = 0; i < grassSpotsCount; i++){
            if(i >= length){
                startIndex = i - 1;
                break;
            }
            Grass grass = new Grass(this.unoccupiedGrassSpots.get(i));
            this.elementsOnTheMap.add(grass);
        }
        this.unoccupiedGrassSpots = this.unoccupiedGrassSpots.subList(startIndex, length - 1);
    }

    private boolean isPositionOnTheGrassTerritory(Vector2d position){
        return position.follows(this.startGrass) && position.precedes(this.endGrass);
    }

}
