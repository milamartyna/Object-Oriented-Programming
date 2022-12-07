package agh.ics.oop;

import agh.ics.oop.gui.App;

import java.util.ArrayList;
import java.util.List;

public class SimulationEngine implements IEngine, Runnable{

    private final IWorldMap map;
    private List<MoveDirection> moves;
    private final List<Animal> animals = new ArrayList<>();
    private App app;
    private int timeDelay;

    public SimulationEngine(List<MoveDirection> directions, IWorldMap map, Vector2d[] initialPositions){
        this.map = map;
        this.moves = directions;

        for (Vector2d initialPosition : initialPositions) {
            Animal animal = new Animal(this.map, initialPosition);
            this.animals.add(animal);
        }
    }

    public SimulationEngine(IWorldMap map, Vector2d[] initialPositions, App app, int timeDelay){
        this.app = app;
        this.map = map;
        this.timeDelay = timeDelay;
        for (Vector2d initialPosition : initialPositions) {
            Animal animal = new Animal(this.map, initialPosition);
            this.animals.add(animal);
            animal.addObserver(app);
        }
    }

    @Override
    public void run() {
        int n = this.animals.size();
        for(int i = 0; i < this.moves.size(); i++){
            this.animals.get(i % n).move(moves.get(i));

            try{
                Thread.sleep(this.timeDelay);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void setMoves(List<MoveDirection> directions){
        this.moves = directions;
    }

}
