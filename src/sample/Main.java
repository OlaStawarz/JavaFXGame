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
import javafx.scene.shape.Circle;
import javafx.scene.shape.Path;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import javafx.scene.shape.Shape;
import javafx.util.Duration;

import java.awt.*;
import java.util.ArrayList;

public class Main extends Application
{
    private Stage window;
    private Rectangle r, gameOneSquare;
    private Scene scene1, scene2, scene3;
    private double newX = 0;
    private Shapes shapes = new Shapes();
    private ArrayList<Shape> drop = new ArrayList<>();
    private Label labelCountCircle, labelCountSquare, labelCountTriangle, labelCount;
    private int counterCircle = 5, counterSquare = 5, counterTriangle = 5;
    private Pane layout2, layout3;
    private Label label;
    public AnimationTimer timer;
    private Circle gameOneCircle;
    private Path gameOneTriangle;

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
                //addLabel(layout2);
                gameOne(layout2);
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

        Circle c = shapes.circle();
        Rectangle s = shapes.square();
        Path t = shapes.triangle();
        String circle = String.valueOf(c).substring(0, 1);
        String square = String.valueOf(s).substring(0, 1);
        String triangle = String.valueOf(t).substring(0, 1);

        double speed = 1; //szybkość spadania
        //System.out.println(root.getLayoutX());
        for (int i = 0; i < drop.size(); i++) {
            (drop.get(i)).setLayoutY(( drop.get(i)).getLayoutY() + speed + (drop.get(i)).getLayoutY() / 600);

            if ((drop.get(i).getLayoutY() > (r.getY() - 10)) && drop.get(i).getLayoutY() < x.getLayoutY() + 600
                    && drop.get(i).getLayoutX() > (newX + 264) && drop.get(i).getLayoutX() < (newX + 264 + 70)) {

                String object = String.valueOf(drop.get(i)).substring(0,1);
                if (object.equals(circle)) {
                    if(drop.get(i).getFill() == gameOneCircle.getFill()){
                        counterCircle--;
                        labelCountCircle.setText(Integer.toString(counterCircle));
                    } else {
                        System.out.println("PRZEGRANA - KOŁO!!!");
                    }
                } else if (object.equals(square)){
                    if(drop.get(i).getFill() == gameOneSquare.getFill()){
                        counterSquare--;
                        labelCountSquare.setText(Integer.toString(counterSquare));
                    } else {
                        System.out.println("PRZEGRANA - KWADRAT!!!");
                    }
                } else if (object.equals(triangle)){
                    if(drop.get(i).getFill() == gameOneTriangle.getFill()){
                        counterTriangle--;
                        labelCountTriangle.setText(Integer.toString(counterTriangle));
                    } else {
                        System.out.println("PRZEGRANA - TRÓJKĄT!!!");
                    }
                }
                if (counterTriangle == 0 && counterSquare == 0 && counterCircle == 0){
                    System.out.println("WYGRANA!!!");
                } else if(counterCircle < 0 || counterTriangle < 0 || counterSquare < 0){
                    System.out.println("PRZEGRANA!!!");
                }
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

    private void gameOne(Pane x){
        Label collect = new Label("Zbierz:");
        collect.setFont(new Font("Arial", 30));
        collect.setTranslateX(610);
        collect.setTranslateY(100);
        x.getChildren().add(collect);

        gameOneCircle = shapes.circle();
        gameOneCircle.setLayoutX(630);
        gameOneCircle.setLayoutY(169);
        x.getChildren().add(gameOneCircle);

        labelCountCircle = new Label("5");
        labelCountCircle.setFont(new Font("Arial", 30));
        labelCountCircle.setTranslateX(650);
        labelCountCircle.setLayoutY(150);
        x.getChildren().add(labelCountCircle);

        gameOneSquare = shapes.square();
        gameOneSquare.setLayoutX(624);
        gameOneSquare.setLayoutY(212);
        x.getChildren().add(gameOneSquare);

        labelCountSquare = new Label("5");
        labelCountSquare.setFont(new Font("Arial", 30));
        labelCountSquare.setTranslateX(650);
        labelCountSquare.setLayoutY(200);
        x.getChildren().add(labelCountSquare);

        gameOneTriangle = shapes.triangle();
        gameOneTriangle.setLayoutX(618);
        gameOneTriangle.setLayoutY(258);
        x.getChildren().add(gameOneTriangle);

        labelCountTriangle = new Label("5");
        labelCountTriangle.setFont(new Font("Arial", 30));
        labelCountTriangle.setTranslateX(650);
        labelCountTriangle.setLayoutY(250);
        x.getChildren().add(labelCountTriangle);
    }

    private void TimeLine(Pane x){
        double falling = 3000; //określenie częstotliwości spadania (ms)
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
