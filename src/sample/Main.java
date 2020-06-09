package sample;

import java.io.*;
import javafx.animation.AnimationTimer;
import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.HBox;
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
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.util.Pair;

import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;

public class Main extends Application
{
    private Stage window;
    private Rectangle r, gameOneSquare;
    private Scene scene1, scene2, scene3, scene4, scene5;
    private double newX = 0;
    private Shapes shapes = new Shapes();
    private ArrayList<Shape> drop = new ArrayList<>();
    private ArrayList<Pair> users = new ArrayList<>();
    private Label labelCountCircle, labelCountSquare, labelCountTriangle, labelCount;
    private int counterCircle = 5, counterSquare = 5, counterTriangle = 5, counterSpeed = 0;
    private Pane layout2, layout3;
    private Label label;
    public AnimationTimer timer;
    private Circle gameOneCircle;
    private Path gameOneTriangle;
    public double speed = 1; //szybkość spadania
    public double falling;
    private  TextField name;
    Pair<String, Integer> u;
    private Timeline timelineCollect, timelineReflex;
    private AnimationTimer timer_collect, timer_reflex;



    @Override
    public void start(Stage primaryStage) throws Exception{

        window = primaryStage;
        Pane layoutMain = new Pane();
        Button buttonReflex = new Button("REFLEKS");
        Button buttonCollect = new Button("ZBIERANIE");

        Button buttonRank = new Button("Ranking");
        buttonRank.setTranslateX(10);
        Label labelName = new Label("Imię: ");
        Label labelGame = new Label("Wybierz tryb rozgrywki: ");
        name = new TextField();

        labelName.setTranslateX(180);
        labelName.setTranslateY(200);
        labelName.setFont(new Font("Verdana", 20));
        labelGame.setTranslateX(170);
        labelGame.setTranslateY(250);
        labelGame.setFont(new Font("Verdana", 20));
        name.setTranslateX(250);
        name.setTranslateY(200);
        buttonReflex.setMinSize(100, 50);
        buttonReflex.setTranslateX(190);
        buttonReflex.setTranslateY(300);
        //button2.setFont(new Font("Verdana", 20));
        buttonCollect.setTranslateX(300);
        buttonCollect.setTranslateY(300);
        //button3.setFont(new Font("Verdana", 20));
        buttonCollect.setMinSize(100, 50);

        buttonRank.setMinSize(100, 50);
        buttonRank.setTranslateX(250);
        buttonRank.setTranslateY(400);

        layoutMain.getChildren().addAll(labelName, labelGame, name, buttonReflex, buttonCollect, buttonRank);
        scene1 = new Scene(layoutMain, 600, 600);

        layout2 = new Pane();
        scene2 = new Scene(layout2, 800, 600);

        layout3 = new Pane();
        scene3 = new Scene(layout3, 800, 600);

        r = shapes.rectangle();
        layout2.getChildren().add(r);
        layout3.getChildren().add(r);

        Pane layout4 = new Pane();
        Button buttonNewGame_Collect = new Button("Nowa gra");
        Button buttonMainMenu = new Button("Powrót do głównego menu");
        buttonNewGame_Collect.setMinSize(80, 50);
        buttonNewGame_Collect.setTranslateX(60);
        buttonNewGame_Collect.setTranslateY(150);
        //button2.setFont(new Font("Verdana", 20));
        buttonMainMenu.setTranslateX(180);
        buttonMainMenu.setTranslateY(150);
        //button3.setFont(new Font("Verdana", 20));
        buttonMainMenu.setMinSize(80, 50);
        Label labelLost = new Label("Wygląda na to, że przegrałeś. ");
        Label labelLost1 = new Label("Wybierz jedną z poniższych opcji:");
        labelLost.setTranslateX(50);
        labelLost.setTranslateY(50);
        labelLost.setFont(new Font("Verdana", 20));
        labelLost1.setTranslateX(30);
        labelLost1.setTranslateY(100);
        labelLost1.setFont(new Font("Verdana", 20));
        layout4.getChildren().addAll(labelLost, labelLost1, buttonNewGame_Collect, buttonMainMenu);
        scene4 = new Scene(layout4, 400, 220);

      /*  Pane layout5 = new Pane();
        Button buttonNewGame_Reflex = new Button("Nowa gra");
        buttonNewGame_Reflex.setMinSize(80, 50);
        buttonNewGame_Reflex.setTranslateX(60);
        buttonNewGame_Reflex.setTranslateY(150);
        layout5.getChildren().addAll(labelLost, labelLost1, buttonNewGame_Reflex, buttonMainMenu);
        scene5 = new Scene(layout4, 400, 220);
*/
        buttonReflex.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                layout3 = new Pane();
                scene3 = new Scene(layout3, 800, 600);
                r = shapes.rectangle();
                layout3.getChildren().add(r);
                window.setScene(scene3);
                addLabel(layout3);
                move(scene3);
                TimeLine_reflex(layout3);
                //AnimationTimer timer;
                timer_reflex = new AnimationTimer(){
                    @Override
                    public void handle(long arg0){
                        gameUpdate_Reflex(layout3);
                    }
                };
                timer_reflex.start();
            }
        });

        buttonCollect.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                layout2.getChildren().clear();
                r = shapes.rectangle();
                layout2.getChildren().add(r);
                window.setScene(scene2);
                newX = 0;
                gameCollect(layout2);
                move(scene2);
                TimeLine_collect(layout2);
                timer_collect = new AnimationTimer(){

                    @Override
                    public void handle(long arg0){
                        gameUpdate_Collect(layout2);
                    }
                };
                timer_collect.start();
            }
        });

        buttonNewGame_Collect.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                timelineCollect.stop();
                layout2.getChildren().clear();
                r = shapes.rectangle();
                layout2.getChildren().add(r);
                window.setScene(scene2);
                newX = 0;
                gameCollect(layout2);
                move(scene2);
                TimeLine_collect(layout2);

                timer_collect = new AnimationTimer(){

                    @Override
                    public void handle(long arg0){
                        gameUpdate_Collect(layout2);
                    }
                };
                timer_collect.start();

            }
        });


        buttonMainMenu.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                timelineCollect.stop();
                window.setScene(scene1);
                window.show();

            }
        });

        window.setScene(scene1);
        window.show();


    }

    private void gameUpdate_Reflex(Pane x) {

        for (int i = 0; i < drop.size(); i++) {
            (drop.get(i)).setLayoutY((drop.get(i)).getLayoutY() + speed + (drop.get(i)).getLayoutY() / 600);
            if ((drop.get(i).getLayoutY() > (r.getY() - 10)) && drop.get(i).getLayoutY() < x.getLayoutY() + 600
                    && drop.get(i).getLayoutX() > (newX + 264) && drop.get(i).getLayoutX() < (newX + 264 + 70)) {
                counterSpeed++;
                labelCount.setText(String.valueOf(counterSpeed));
                x.getChildren().remove((drop.get(i)));
                drop.remove(i);
            } else {
                u = new Pair<>(name.getText(), counterSpeed);
                users.add(u);
            }
        }
    }

    private void gameUpdate_Collect(Pane x) {

        Circle c = shapes.circle();
        Rectangle s = shapes.square();
        Path t = shapes.triangle();
        String circle = String.valueOf(c).substring(0, 1);
        String square = String.valueOf(s).substring(0, 1);
        String triangle = String.valueOf(t).substring(0, 1);
        speed = 1;
        for (int i = 0; i < drop.size(); i++) {
            (drop.get(i)).setLayoutY((drop.get(i)).getLayoutY() + speed + (drop.get(i)).getLayoutY() / 600);

            if ((drop.get(i).getLayoutY() > (r.getY() - 10)) && drop.get(i).getLayoutY() < x.getLayoutY() + 600
                    && drop.get(i).getLayoutX() > (newX + 264) && drop.get(i).getLayoutX() < (newX + 264 + 70)) {

                String object = String.valueOf(drop.get(i)).substring(0, 1);
                if (object.equals(circle)) {
                    if (drop.get(i).getFill() == gameOneCircle.getFill()) {
                        counterCircle--;
                        labelCountCircle.setText(Integer.toString(counterCircle));
                    } else {
                        System.out.println("PRZEGRANA - KOŁO!!!");
                        layout2.getChildren().clear();
                        timer_collect.stop();
                        window.setScene(scene4);
                        window.show();
                    }
                } else if (object.equals(square)) {
                    if (drop.get(i).getFill() == gameOneSquare.getFill()) {
                        counterSquare--;
                        labelCountSquare.setText(Integer.toString(counterSquare));
                    } else {
                        System.out.println("PRZEGRANA - KWADRAT!!!");
                        layout2.getChildren().clear();
                        timer_collect.stop();
                        window.setScene(scene4);
                        window.show();
                    }
                } else if (object.equals(triangle)) {
                    if (drop.get(i).getFill() == gameOneTriangle.getFill()) {
                        counterTriangle--;
                        labelCountTriangle.setText(Integer.toString(counterTriangle));
                    } else {
                        System.out.println("PRZEGRANA - TRÓJKĄT!!!");
                        layout2.getChildren().clear();
                        timer_collect.stop();
                        window.setScene(scene4);
                        window.show();
                    }
                }
                if (counterTriangle == 0 && counterSquare == 0 && counterCircle == 0) {
                    System.out.println("WYGRANA!!!");
                    drop.clear();
                } else if (counterCircle < 0 || counterTriangle < 0 || counterSquare < 0) {
                    System.out.println("PRZEGRANA!!!");
                    drop.clear();
                    timer_collect.stop();
                    window.setScene(scene4);
                    window.show();
                }

                x.getChildren().remove((drop.get(i)));
                drop.remove(i);
            }
        }

    }

    private void addLabel(Pane x){
        drop.clear();
        newX = 0;
        speed = 0;
        falling = 0;
        label = new Label("Licznik: ");
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

    private void gameCollect(Pane x){
        x.getChildren().remove(gameOneCircle);
        x.getChildren().remove(gameOneSquare);
        x.getChildren().remove(gameOneTriangle);
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

    private void TimeLine_collect(Pane x){
        drop.clear();
        //speed = 0;
        falling = 3000;
        //double falling = 3000; //określenie częstotliwości spadania (ms)
        timelineCollect = new Timeline(new KeyFrame(Duration.millis(falling), event -> {
            //speed += falling / 1000;
            int random = (int)(Math.random() * 100);
            if(random < 30)
                drop.add(shapes.circle());
            else if (random > 30 && random < 60)
                drop.add(shapes.square());
            else
                drop.add(shapes.triangle());
            x.getChildren().add((drop.get(drop.size() - 1)));

        }));
        timelineCollect.setCycleCount(1000);
        timelineCollect.play();
    }

    private void TimeLine_reflex(Pane x){
        drop.clear();
        speed = 1;
        System.out.println(speed);
        falling = 2000; //określenie częstotliwości spadania (ms)
        timelineReflex = new Timeline(new KeyFrame(Duration.millis(falling), event -> {
            if (speed < 2)
                speed += 0.05;
            //System.out.println(speed);
            int random = (int) (Math.random() * 100);
            if (random < 30)
                drop.add(shapes.circle());
            else if (random > 30 && random < 60)
                drop.add(shapes.square());
            else
                drop.add(shapes.triangle());
            x.getChildren().add((drop.get(drop.size() - 1)));
            System.out.println(falling);
            if (falling > 1000)
                falling -= 150;
        }));

        timelineReflex.setCycleCount(1000);
        timelineReflex.play();


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
