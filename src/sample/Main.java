package sample;

import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.paint.Color;

import java.util.ArrayList;


public class Main extends Application {

    private double newX = 0;
    private ArrayList drop = new ArrayList();

    double speed = 1;
    double falling = 3000;
    Rectangle r;

    AnimationTimer timer;
    Pane root;
    double x;

    @Override
    public void start(Stage primaryStage) throws Exception{
        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
       root = new Pane();
        r = rectangle();
        root.getChildren().add(r);

        Scene scene = new Scene(root, 600, 600);

        scene.setOnKeyPressed(e ->{
            if(e.getCode() == KeyCode.RIGHT){
                if (newX != 265){
                    newX = newX + 8;
                    r.setTranslateX(newX);
                }
            }
            else if(e.getCode() == KeyCode.LEFT){
                if (newX != -265)
                {
                    newX = newX - 8;
                    r.setTranslateX(newX);
                }
            }

        });

      Timeline timeline = new Timeline(new KeyFrame(Duration.millis(falling), event -> {
            speed += falling / 10000;
            drop.add(circle());
            root.getChildren().add(((Node)drop.get(drop.size() -1)));
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

    private Circle circle() {
        Circle circle = new Circle();
        circle.setLayoutX(rand(0, 600));
        circle.setFill(Color.BLUE);
        circle.setLayoutY(1);
        circle.setRadius(6);
        return circle;
    }

    private Rectangle rectangle(){
        Rectangle r = new Rectangle();
        r.setX(265);
        r.setY(560);
        r.setWidth(70);
        r.setHeight(40);
        r.setArcWidth(20);
        r.setArcHeight(20);
        return r;
    }

    private int rand(int min, int max) {
        return (int)(Math.random() * max + min);
    }

    private void gameUpdate(){

        //r.getLayoutX(newX);

        for(int i = 0; i < drop.size(); i++) {
            ((Circle) drop.get(i)).setLayoutY(((Circle) drop.get(i)).getLayoutY()
                    + speed + ((Circle) drop.get(i)).getLayoutY() / 150);
           /*if((((Circle) drop.get(i)).getLayoutX() > x && ((Circle) drop.get(i)).getLayoutX() < x + 70) &&
                    ((Circle) drop.get(i)).getLayoutY() >= 400  ) {
                root.getChildren().remove(((Circle) drop.get(i)));
                drop.remove(i);
            }*/
           /* if(r.intersects(((Circle) drop.get(i)).getBoundsInLocal())) {
                root.getChildren().remove(((Circle) drop.get(i)));
                drop.remove(i);
            }*/
        }
    }


    public static void main(String[] args) {
        launch(args);
    }
}
