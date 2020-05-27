package sample;

import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.Scene;
import javafx.scene.shape.Shape;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.*;


public class Main extends Application {

    private double newX = 0;
    private ArrayList<Shape> drop = new ArrayList<>();
    private Rectangle r;
    private Pane root;
    private Shapes shapes = new Shapes();
    private Label label;
    private Label labelCount;
    private int counter = 0;

    @Override
    public void start(Stage primaryStage) throws Exception {
        AnimationTimer timer;
        double falling = 4000; //określenie częstotliwości spadania (ms)

        root = new Pane();
        Scene scene = new Scene(root, 800, 600);
        scene.setFill(Color.GRAY);

        r = shapes.rectangle();
        root.getChildren().add(r);

        label = new Label("Counter: ");
        label.setFont(new Font("Arial", 30));
        label.setTranslateX(610);
        label.setTranslateY(100);
        root.getChildren().add(label);

        labelCount = new Label("0");
        labelCount.setFont(new Font("Arial", 30));
        labelCount.setTranslateX(730);
        labelCount.setTranslateY(100);
        root.getChildren().add(labelCount);

        // poruszanie się koszyka
        scene.setOnKeyPressed(e -> {
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

       /* ArrayList<Shape> ksztalt = new ArrayList<>();
        ksztalt.add(shapes.prostokat());
        ksztalt.add(shapes.circle());*/

        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(falling), event -> {
            //speed += falling / 10000;
            int random = (int)(Math.random() * 100);
            if(random < 30)
                drop.add(shapes.circle());
            else if (random > 30 && random < 60)
                drop.add(shapes.square());
            else
                drop.add(shapes.triangle());
            root.getChildren().add((drop.get(drop.size() - 1)));
        }));

        timeline.setCycleCount(1000);
        timeline.play();

        timer = new AnimationTimer() {

            @Override
            public void handle(long arg0) {
                gameUpdate();
            }
        };
        timer.start();

        primaryStage.setScene(scene);
        primaryStage.show();

    }

    private void gameUpdate() {

        double speed = 1; //szybkość spadania
        //System.out.println(root.getLayoutX());
        for (int i = 0; i < drop.size(); i++) {
            (drop.get(i)).setLayoutY(( drop.get(i)).getLayoutY() + speed + (drop.get(i)).getLayoutY() / 600);

            //System.out.println(drop.get(i).getLayoutY());
            if ((drop.get(i).getLayoutY() > root.getLayoutY() + r.getY())
                    && drop.get(i).getLayoutX() > (newX + 264) && drop.get(i).getLayoutX() < (newX + 264 + 70)) {
                //if (drop.get(i).getFill() == Color.GREEN) {

                    counter++;
                    labelCount.setText(Integer.toString(counter));
                //}
                root.getChildren().remove((drop.get(i)));
                drop.remove(i);
            }
        }
    }


    public static void main(String[] args) {
        launch(args);
    }
}
