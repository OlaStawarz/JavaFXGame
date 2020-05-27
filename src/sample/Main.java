package sample;

import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import javafx.scene.shape.Shape;
import javafx.util.Duration;

import java.util.ArrayList;

public class Main extends Application
{
    private Stage window;
    private Rectangle r;
    private Scene scene1, scene2, scene3;
    private double newX = 0;
    private Shapes shapes = new Shapes();
    private ArrayList<Shape> drop = new ArrayList<>();
    private Label labelCount;
    private int counter = 0;
    private Pane layout2, layout3;
    private Label label;
    public AnimationTimer timer;



    @Override
    public void start(Stage primaryStage) throws Exception{

        window = primaryStage;
        VBox layout1 = new VBox(20);
        Button button3 = new Button("Ilosc");
        Button button2 = new Button("Szybkosc");
        Label label1 = new Label("Welcome in first scene");

        layout1.getChildren().addAll(label1, button2, button3);
        scene1 = new Scene(layout1, 200, 200);

        layout3 = new Pane();
        scene3 = new Scene(layout3, 800, 600);

        layout2 = new Pane();
        scene2 = new Scene(layout2, 800, 600);

        r = shapes.rectangle();
        layout2.getChildren().add(r);
        layout3.getChildren().add(r);

        button2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                 /*       layout3 = new Pane();
                scene3 = new Scene(layout3, 800, 600);
                r = shapes.rectangle();
                layout3.getChildren().add(r);
                window.setScene(scene3);
                addLabel(layout3);
                move(scene3);
                TimeLine(layout3);
                AnimationTimer timer;
                timer = new AnimationTimer(){

                    @Override
                    public void handle(long arg0){
                        gameUpdate(layout3);
                    }
                };
                timer.start(); */
            }
        });

        button3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                layout2 = new Pane();
                scene2 = new Scene(layout2, 800, 600);
                r = shapes.rectangle();
                layout2.getChildren().add(r);
                window.setScene(scene2);
                addLabel(layout2);
                move(scene2);
                TimeLine(layout2);
                AnimationTimer timer;
                timer = new AnimationTimer(){

                    @Override
                    public void handle(long arg0){
                        gameUpdate(layout2);
                    }
                };
                timer.start();

            }
        });

        window.setScene(scene1);
        window.show();

    }

    private void gameUpdate(Pane x) {

        double speed = 1; //szybkość spadania
        //System.out.println(root.getLayoutX());
        for (int i = 0; i < drop.size(); i++) {
            (drop.get(i)).setLayoutY(( drop.get(i)).getLayoutY() + speed + (drop.get(i)).getLayoutY() / 600);

            //System.out.println(drop.get(i).getLayoutY());
            if ((drop.get(i).getLayoutY() > x.getLayoutY() + r.getY())
                    && drop.get(i).getLayoutX() > (newX + 264) && drop.get(i).getLayoutX() < (newX + 264 + 70)) {
                //if (drop.get(i).getFill() == Color.GREEN) {

                counter++;
                labelCount.setText(Integer.toString(counter));
                //}
                x.getChildren().remove((drop.get(i)));
                drop.remove(i);
            }
        }
    }

    private void addLabel(Pane x){
        label = new Label("Counter: ");
        label.setFont(new javafx.scene.text.Font("Arial", 30));
        label.setTranslateX(610);
        label.setTranslateY(100);
        x.getChildren().add(label);

        labelCount = new Label("0");
        labelCount.setFont(new Font("Arial", 30));
        labelCount.setTranslateX(730);
        labelCount.setTranslateY(100);
        x.getChildren().add(labelCount);
    }

    private void TimeLine(Pane x){
        double falling = 4000; //określenie częstotliwości spadania (ms)
        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(falling), event -> {
            //speed += falling / 10000;
            int random = (int)(Math.random() * 100);
            if(random < 30)
                drop.add(shapes.circle());
            else if (random > 30 && random < 60)
                drop.add(shapes.square());
            else
                drop.add(shapes.triangle());
            x.getChildren().add((drop.get(drop.size() - 1)));

        }));
        timeline.setCycleCount(1000);
        timeline.play();
    }

    private void move(Scene x){
        x.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.RIGHT) {
                if (newX != 264) {
                    newX = newX + 8;
                    r.setTranslateX(newX);
                }
            } else if (e.getCode() == KeyCode.LEFT) {
                if (newX != -264) {
                    newX = newX - 8;
                    r.setTranslateX(newX);
                }
            }

        });
    }

    public static void main(String[] args) {
        launch(args);
    }

}
