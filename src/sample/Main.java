package sample;

import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Path;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.util.Pair;

import java.sql.*;
import java.util.ArrayList;

public class Main extends Application
{
    private Stage window;
    private Rectangle r, squareCollect;
    private Circle circleCollect;
    private Path triangleCollect;

    private Scene scene1, scene2, scene3, scene4, scene5, scene6;
    private double newX = 0;
    private Shapes shapes = new Shapes();
    private ArrayList<Shape> drop = new ArrayList<>();
    private Label labelCountCircle, labelCountSquare, labelCountTriangle, labelCount;
    private int counterCircle = 5, counterSquare = 5, counterTriangle = 5, counterSpeed = 0;
    private Pane layout2, layout3;
    private Label labelCountText;

    private double speed = 1; //szybkość spadania
    private double falling;
    private TextField name;
    private Pair<String, String> g;
    private Timeline timelineCollect, timelineReflex, timeline;
    private AnimationTimer timer_collect, timer_reflex, timerMain;
    private Label labelCollect;
    private Label name1, score1;


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

        layoutMain.getChildren().addAll(labelName, labelGame, name, buttonReflex, buttonCollect, buttonRank,shapes.rectangleMain(),  shapes.circleMain(), shapes.triangleMain(),
                shapes.circleMain1(), shapes.rectangleMain1(), shapes.triangleMain1(), shapes.circleMain2(), shapes.triangleMain2(), shapes.circleMain3(), shapes.rectangleMain2(),
                shapes.triangleMain3(), shapes.rectangleMain3(), shapes.circleMain4(), shapes.triangleMain4(), shapes.rectangleMain4());
        scene1 = new Scene(layoutMain, 600, 600);

        layout2 = new Pane();
        scene2 = new Scene(layout2, 800, 600);

        layout3 = new Pane();
        scene3 = new Scene(layout3, 800, 600);

        r = shapes.rectangle();
        layout2.getChildren().add(r);
        layout3.getChildren().add(r);

        Pane layout4 = new Pane();
        Pane layout6 = new Pane();
        Button buttonNewGame_Reflex = new Button("Nowa gra");
        Button buttonNewGame_Collect = new Button("Nowa gra");
        Button buttonMainMenu = new Button("Powrót do głównego menu");
        Button buttonMainMenuReflex = new Button("Powrót do głównego menu");
        buttonNewGame_Collect.setMinSize(80, 50);
        buttonNewGame_Collect.setTranslateX(60);
        buttonNewGame_Collect.setTranslateY(150);
        buttonNewGame_Reflex.setMinSize(80, 50);
        buttonNewGame_Reflex.setTranslateX(60);
        buttonNewGame_Reflex.setTranslateY(150);
        buttonMainMenu.setTranslateX(180);
        buttonMainMenu.setTranslateY(150);
        buttonMainMenu.setMinSize(80, 50);
        buttonMainMenuReflex.setTranslateX(180);
        buttonMainMenuReflex.setTranslateY(150);
        buttonMainMenuReflex.setMinSize(80, 50);
        labelCollect = new Label();
        Label labelCollectMessage = new Label("Wybierz jedną z poniższych opcji:");

        Label labelLostReflex = new Label("Wygląda na to, że przegrałeś... :( " );
        Label labelLost1Reflex = new Label("Wybierz jedną z poniższych opcji:");
        labelCollect.setTranslateX(30);
        labelCollect.setTranslateY(50);
        labelCollect.setFont(new Font("Verdana", 20));
        labelCollectMessage.setTranslateX(30);
        labelCollectMessage.setTranslateY(100);
        labelCollectMessage.setFont(new Font("Verdana", 20));
        labelLostReflex.setTranslateX(30);
        labelLostReflex.setTranslateY(50);
        labelLostReflex.setFont(new Font("Verdana", 20));
        labelLost1Reflex.setTranslateX(30);
        labelLost1Reflex.setTranslateY(100);
        labelLost1Reflex.setFont(new Font("Verdana", 20));
        layout4.getChildren().addAll(labelCollect, labelCollectMessage, buttonNewGame_Collect, buttonMainMenu);
        scene4 = new Scene(layout4, 400, 220);
        layout6.getChildren().addAll(labelLostReflex, labelLost1Reflex, buttonNewGame_Reflex, buttonMainMenuReflex);
        scene6 = new Scene(layout6, 400, 220);

        Pane layoutRank = new Pane();
        Label labelName1 = new Label("Imię |");
        Label labelScore = new Label("Wynik | ");
        name1 = new Label();
        name1.setTranslateX(0);
        name1.setTranslateY(40);
        name1.setFont(new Font("Verdana", 20));
        score1 = new Label();
        score1.setTranslateX(70);
        score1.setTranslateY(40);
        score1.setFont(new Font("Verdana", 20));
        labelName1.setTranslateX(0);
        labelName1.setTranslateY(0);
        labelName1.setFont(new Font("Verdana", 20));
        labelScore.setTranslateX(70);
        labelScore.setTranslateY(0);
        labelScore.setFont(new Font("Verdana", 20));

        layoutRank.getChildren().addAll(labelName1, labelScore, name1);
        scene5 = new Scene(layoutRank, 600, 600);

        buttonRank.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                window.setScene(scene5);
                window.show();
                select();
            }

        });

        buttonReflex.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                layout3 = new Pane();
                scene3 = new Scene(layout3, 800, 600);
                r = shapes.rectangle();
                layout3.getChildren().add(r);
                window.setScene(scene3);
                newX = 0;
                counterSpeed = 0;
                addLabel(layout3);
                move(scene3);
                TimeLine_reflex(layout3);
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

        buttonNewGame_Reflex.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                timelineReflex.stop();
                layout3.getChildren().clear();
                r = shapes.rectangle();
                layout3.getChildren().add(r);
                window.setScene(scene3);
                newX = 0;
                counterSpeed = 0;
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

        buttonMainMenuReflex.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                timelineReflex.stop();
                window.setScene(scene1);
                window.show();

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

        connect();
    }


    private void gameUpdate_Reflex(Pane x) {

        for (int i = 0; i < drop.size(); i++) {
            (drop.get(i)).setLayoutY((drop.get(i)).getLayoutY() + speed + (drop.get(i)).getLayoutY() / 600);
            if ((drop.get(i).getLayoutY() > (r.getY() + 20) &&
                    drop.get(i).getLayoutX() > (newX + 264 + 70)) ||
                    (drop.get(i).getLayoutY() > (r.getY() + 20) && drop.get(i).getLayoutX() < (newX + 264))) {
                System.out.println("Przegrana");
                x.getChildren().remove((drop.get(i)));
                drop.remove(i);
                layout3.getChildren().clear();
                timer_reflex.stop();
                window.setScene(scene6);
                window.show();
                insertName(name.getText(),labelCount.getText());
            }
            else if((drop.get(i).getLayoutY() > (r.getY() - 10)) && drop.get(i).getLayoutY() < x.getLayoutY() + 600
                    && drop.get(i).getLayoutX() > (newX + 264) && drop.get(i).getLayoutX() < (newX + 264 + 70))
            {
                counterSpeed++;
                labelCount.setText(String.valueOf(counterSpeed));
                x.getChildren().remove((drop.get(i)));
                drop.remove(i);


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
                    if (drop.get(i).getFill() == circleCollect.getFill()) {
                        counterCircle--;
                        labelCountCircle.setText(Integer.toString(counterCircle));
                    } else {
                        labelCollect.setText("Wygląda na to, że przegrałeś.... :(");
                        System.out.println("PRZEGRANA - KOŁO!!!");
                        layout2.getChildren().clear();
                        timer_collect.stop();
                        window.setScene(scene4);
                        window.show();
                    }
                } else if (object.equals(square)) {
                    if (drop.get(i).getFill() == squareCollect.getFill()) {
                        counterSquare--;
                        labelCountSquare.setText(Integer.toString(counterSquare));
                    } else {

                        labelCollect.setText("Wygląda na to, że przegrałeś... :(");
                        System.out.println("PRZEGRANA - KWADRAT!!!");
                        layout2.getChildren().clear();
                        timer_collect.stop();
                        window.setScene(scene4);
                        window.show();
                    }
                } else if (object.equals(triangle)) {
                    if (drop.get(i).getFill() == triangleCollect.getFill()) {
                        counterTriangle--;
                        labelCountTriangle.setText(Integer.toString(counterTriangle));
                    } else {
                        labelCollect.setText("Wygląda na to, że przegrałeś.... :(");
                        System.out.println("PRZEGRANA - TRÓJKĄT!!!");
                        layout2.getChildren().clear();
                        timer_collect.stop();
                        window.setScene(scene4);
                        window.show();
                    }
                }
                if (counterTriangle == 0 && counterSquare == 0 && counterCircle == 0) {
                    labelCollect.setText("WYGRANA!!!");
                    System.out.println("WYGRANA!!!");
                    //drop.clear();

                    layout2.getChildren().clear();
                    timer_collect.stop();
                    window.setScene(scene4);
                    window.show();
                } else if (counterCircle < 0 || counterTriangle < 0 || counterSquare < 0) {
                    labelCollect.setText("Wygląda na to, że przegrałeś... :(");
                    System.out.println("PRZEGRANA!!!");
                    //drop.clear();
                    layout2.getChildren().clear();
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
        labelCountText = new Label("Licznik: ");
        labelCountText.setFont(new javafx.scene.text.Font("Arial", 30));
        labelCountText.setTranslateX(610);
        labelCountText.setTranslateY(100);
        x.getChildren().add(labelCountText);

        labelCount = new Label("0");
        labelCount.setFont(new Font("Arial", 30));
        labelCount.setTranslateX(730);
        labelCount.setTranslateY(100);
        x.getChildren().add(labelCount);
    }

    private void gameCollect(Pane x){
        x.getChildren().remove(circleCollect);
        x.getChildren().remove(squareCollect);
        x.getChildren().remove(triangleCollect);
        Label collect = new Label("Zbierz:");
        collect.setFont(new Font("Arial", 30));
        collect.setTranslateX(610);
        collect.setTranslateY(100);
        x.getChildren().add(collect);

        circleCollect = shapes.circle();
        circleCollect.setLayoutX(630);
        circleCollect.setLayoutY(169);
        x.getChildren().add(circleCollect);

        labelCountCircle = new Label("5");
        labelCountCircle.setFont(new Font("Arial", 30));
        labelCountCircle.setTranslateX(650);
        labelCountCircle.setLayoutY(150);
        x.getChildren().add(labelCountCircle);

        squareCollect = shapes.square();
        squareCollect.setLayoutX(624);
        squareCollect.setLayoutY(212);
        x.getChildren().add(squareCollect);

        labelCountSquare = new Label("5");
        labelCountSquare.setFont(new Font("Arial", 30));
        labelCountSquare.setTranslateX(650);
        labelCountSquare.setLayoutY(200);
        x.getChildren().add(labelCountSquare);

        triangleCollect = shapes.triangle();
        triangleCollect.setLayoutX(618);
        triangleCollect.setLayoutY(258);
        x.getChildren().add(triangleCollect);

        labelCountTriangle = new Label("5");
        labelCountTriangle.setFont(new Font("Arial", 30));
        labelCountTriangle.setTranslateX(650);
        labelCountTriangle.setLayoutY(250);
        x.getChildren().add(labelCountTriangle);
    }

    private void TimeLine_collect(Pane x){
        drop.clear();
        //speed = 0;
        falling = 1800;
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
            if (speed < 2.5)
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


///baza do rankingu

    public Connection connect() {
        // SQLite connection string
        String url = "jdbc:sqlite:C://sqlite/db/gra.db";
        Connection conn = null;
        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS user (\n"
                + "	id integer PRIMARY KEY,\n"
                + "	name text NOT NULL,\n"
                + "	score text NOT NULL\n"
                + ");";

        try{
            conn = DriverManager.getConnection(url);
            Statement stmt = conn.createStatement();
            System.out.println("Connected to Database");
            // create a new table
            stmt.execute(sql);
            //stmt.execute("insert into user (name) values ('kot')");
            //stmt.execute("insert into user (name) values ('ryba')");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            //  return null;
        }
        return conn;
    }

    public void insertName(String name,String score) {
        String sql = "insert into user (name,score) values ('"+ name +"','"+ score +"')";

        try (Connection conn = this.connect();
             Statement pstmt = conn.createStatement()) {
            // pstmt.setString(1, name);
            pstmt.execute(sql);
            System.out.println("Inserted");
            ResultSet rs = pstmt.executeQuery("select * from user");
            while(rs.next()){
                System.out.println(rs.getInt("id") + " " + rs.getString("name")+ " " + rs.getString("score"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


    public void select(){

        try (Connection conn = this.connect();
             Statement pstmt = conn.createStatement()) {
            ArrayList<Pair> user = new ArrayList<>();
            String name,score;
            int id;
            ResultSet rs = pstmt.executeQuery("select * from user");      //wyswietlenie indeksu i imienia
            while(rs.next()){
                id=rs.getInt("id");
                name = rs.getString(("name"));
                score= rs.getString("score");
                // name1.setText(name);
                // score1.setText(score);
                System.out.println(rs.getInt("id") + " " + rs.getString("name") + " " + rs.getString("score"));
                //String a = rs.getString("name") + "\t   " + rs.getString("score");
                // name1.setText(a);
                g = new Pair<>(name, score);
                user.add(g);

            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public static void main(String[] args) {
        launch(args);
    }

}