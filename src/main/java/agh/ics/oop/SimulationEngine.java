package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class SimulationEngine implements IEngine{

    private final IWorldMap map;
    private final List<MoveDirection> moves;
    private final List<Animal> animals = new ArrayList<>();

    public SimulationEngine(List<MoveDirection> directions, IWorldMap map, Vector2d[] initialPositions){
        this.map = map;
        this.moves = directions;

        for (Vector2d initialPosition : initialPositions) {
            Animal animal = new Animal(this.map, initialPosition);
            if(this.map.place(animal)){
                animals.add(animal);
            }
        }
    }

    @Override
    public void run() {
        int n = this.animals.size();
        for(int i = 0; i < this.moves.size(); i++){
            this.animals.get(i % n).move(moves.get(i));
        }
    }

}
