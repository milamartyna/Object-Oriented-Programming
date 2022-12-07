package agh.ics.oop.gui;

import agh.ics.oop.*;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.util.List;

public class App extends Application implements IPositionChangeObserver {

    private IWorldMap map;
    private Vector2d startMap;
    private Vector2d endMap;
    private int xAxisLength;
    private int yAxisLength;
    private GridPane gridPane;
    private SimulationEngine engine;
    private VBox vBox;
    private static final int TIME_DELAY = 300;

    @Override
    public void init() {

        try {
            this.map = new GrassField(10);
            Vector2d[] positions = {new Vector2d(2, 2), new Vector2d(3, 4)};
            this.engine = new SimulationEngine(map, positions, this, TIME_DELAY);
            this.gridPane = new GridPane();

        } catch (IllegalArgumentException iae){
            System.out.println(iae.getMessage());
        }

    }

    @Override
    public void start(Stage primaryStage) throws FileNotFoundException {

        Button startButton = new Button("Start");
        TextField textField = new TextField();
        HBox buttonBox = createButtonBox(startButton, textField);

        startButton.setOnAction(action -> {
            this.engine.setMoves(this.parseTextField(textField));
            Thread thread = new Thread(this.engine);
            thread.start();
        });

        this.createScene();

        VBox sceneBox = new VBox(this.gridPane, buttonBox);
        Scene scene = new Scene(sceneBox, 600, 600);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public void positionChanged(IMapElement element, Vector2d oldPosition, Vector2d newPosition){
        Platform.runLater(() -> {
            this.deleteScene();
            try {
                this.createScene();
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        });
    }

    private HBox createButtonBox(Button button, TextField textField){
        textField.setPrefWidth(200);

        HBox buttonBox = new HBox(textField, button);
        buttonBox.setPadding(new Insets(10, 10, 10, 10));
        buttonBox.setAlignment(Pos.CENTER);
        return buttonBox;
    }

    private List<MoveDirection> parseTextField(TextField textField){
        String[] parameters;
        String textInput = textField.getText();
        parameters = textInput.split(" ");
        return new OptionsParser().parse(parameters);
    }

    private void deleteScene(){
        this.gridPane.getChildren().clear();
        this.gridPane.getColumnConstraints().clear();
        this.gridPane.getRowConstraints().clear();
        this.gridPane.setGridLinesVisible(false);
    }

    private void createScene() throws FileNotFoundException {
        this.setMapBounds();
        this.setAxisLabels();
        this.setObject();
        this.setSizeOfRowsColumns();
        this.gridPane.setPadding(new Insets(10, 10, 10, 10));
        this.gridPane.setGridLinesVisible(true);
    }

    private void setAxisLabels(){

        Label xyLabel = new Label("y/x");
        this.gridPane.add(xyLabel, 0, 0);
        GridPane.setHalignment(xyLabel, HPos.CENTER);

        for(int i = 0; i < this.xAxisLength; i++){
            Label label = new Label(Integer.toString(i + this.startMap.x()));
            this.gridPane.add(label, i + 1, 0);
            GridPane.setHalignment(label, HPos.CENTER);
        }

        for(int i = 0; i < this.yAxisLength; i++){
            Label label = new Label(Integer.toString(this.endMap.y() - i));
            this.gridPane.add(label, 0, i + 1);
            GridPane.setHalignment(label, HPos.CENTER);
        }

    }

    private void setObject() throws FileNotFoundException {

        for(int i = this.startMap.x(); i <= this.endMap.x(); i++){
            for(int j = this.startMap.y(); j <= this.endMap.y(); j++){

                Vector2d position = new Vector2d(i, j);

                if(this.map.isOccupied(position)){
                    Object object = this.map.objectAt(position);
                    GuiElementBox guiElementBox = new GuiElementBox((IMapElement) object);
                    this.vBox = guiElementBox.getVBox();
                    this.gridPane.add(this.vBox, i - this.startMap.x() + 1, this.endMap.y() - j + 1);
                    GridPane.setHalignment(this.vBox, HPos.CENTER);
                }
            }
        }

    }

    private void setSizeOfRowsColumns(){
        for(int i = 0; i <= this.xAxisLength; i++){
            this.gridPane.getColumnConstraints().add(new ColumnConstraints(40));
        }

        for(int i = 0; i <= this.yAxisLength; i++){
            this.gridPane.getRowConstraints().add(new RowConstraints(40));
        }
    }

    private void setMapBounds(){
        this.startMap = map.getStartMap();
        this.endMap = map.getEndMap();
        this.xAxisLength = this.endMap.x() - this.startMap.x() + 1;
        this.yAxisLength = this.endMap.y() - this.startMap.y() + 1;
    }


}
