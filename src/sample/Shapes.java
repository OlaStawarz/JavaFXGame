package sample;

import javafx.scene.paint.Color;
import javafx.scene.shape.*;

import java.util.ArrayList;

public class Shapes {


    public Circle circle() {
        Circle circle = new Circle();
        circle.setLayoutX(rand());
        circle.setFill(randColor());
        circle.setLayoutY(1);
        circle.setRadius(10);
        return circle;
    }

    public Circle circleMain(){
        Circle circleMain = new Circle();
        circleMain.setRadius(10);
        circleMain.setLayoutX(50);
        circleMain.setLayoutY(80);
        circleMain.setFill(Color.GREEN);
        return circleMain;
    }

    public Circle circleMain1(){
        Circle circleMain = new Circle();
        circleMain.setRadius(10);
        circleMain.setLayoutX(300);
        circleMain.setLayoutY(120);
        circleMain.setFill(Color.RED);
        return circleMain;
    }

    public Circle circleMain2(){
        Circle circleMain = new Circle();
        circleMain.setRadius(10);
        circleMain.setLayoutX(490);
        circleMain.setLayoutY(270);
        circleMain.setFill(Color.GREEN);
        return circleMain;
    }

    public Circle circleMain3(){
        Circle circleMain = new Circle();
        circleMain.setRadius(10);
        circleMain.setLayoutX(450);
        circleMain.setLayoutY(480);
        circleMain.setFill(Color.BLUE);
        return circleMain;
    }

    public Circle circleMain4(){
        Circle circleMain = new Circle();
        circleMain.setRadius(10);
        circleMain.setLayoutX(170);
        circleMain.setLayoutY(380);
        circleMain.setFill(Color.BLUE);
        return circleMain;
    }

    public Rectangle rectangleMain() {
        Rectangle rectangleMain = new Rectangle();
        rectangleMain.setWidth(15);
        rectangleMain.setHeight(15);
        rectangleMain.setLayoutX(520);
        rectangleMain.setLayoutY(150);
        rectangleMain.setFill(Color.BLUE);
        return rectangleMain;
    }

    public Rectangle rectangleMain1() {
        Rectangle rectangleMain = new Rectangle();
        rectangleMain.setWidth(15);
        rectangleMain.setHeight(15);
        rectangleMain.setLayoutX(180);
        rectangleMain.setLayoutY(20);
        rectangleMain.setFill(Color.BLUE);
        return rectangleMain;
    }

    public Rectangle rectangleMain2() {
        Rectangle rectangleMain = new Rectangle();
        rectangleMain.setWidth(15);
        rectangleMain.setHeight(15);
        rectangleMain.setLayoutX(540);
        rectangleMain.setLayoutY(550);
        rectangleMain.setFill(Color.GREEN);
        return rectangleMain;
    }

    public Rectangle rectangleMain3() {
        Rectangle rectangleMain = new Rectangle();
        rectangleMain.setWidth(15);
        rectangleMain.setHeight(15);
        rectangleMain.setLayoutX(60);
        rectangleMain.setLayoutY(290);
        rectangleMain.setFill(Color.RED);
        return rectangleMain;
    }

    public Rectangle rectangleMain4() {
        Rectangle rectangleMain = new Rectangle();
        rectangleMain.setWidth(15);
        rectangleMain.setHeight(15);
        rectangleMain.setLayoutX(170);
        rectangleMain.setLayoutY(540);
        rectangleMain.setFill(Color.RED);
        return rectangleMain;
    }

    public Path triangleMain() {
        Path path = new Path();
        MoveTo moveTo = new MoveTo();
        moveTo.setX(25);
        moveTo.setY(20);

        LineTo lineTo = new LineTo();
        lineTo.setX(15);
        lineTo.setY(5);

        LineTo lineTo2 = new LineTo();
        lineTo2.setX(5);
        lineTo2.setY(20);

        LineTo lineTo3 = new LineTo();
        lineTo3.setX(25);
        lineTo3.setY(20);

        path.getElements().addAll(moveTo,lineTo, lineTo2, lineTo3);
        path.setLayoutX(380);
        path.setLayoutY(30);
        path.setFill(Color.GREEN);
        return path;
    }

    public Path triangleMain1() {
        Path path = new Path();
        MoveTo moveTo = new MoveTo();
        moveTo.setX(25);
        moveTo.setY(20);

        LineTo lineTo = new LineTo();
        lineTo.setX(15);
        lineTo.setY(5);

        LineTo lineTo2 = new LineTo();
        lineTo2.setX(5);
        lineTo2.setY(20);

        LineTo lineTo3 = new LineTo();
        lineTo3.setX(25);
        lineTo3.setY(20);

        path.getElements().addAll(moveTo,lineTo, lineTo2, lineTo3);
        path.setLayoutX(110);
        path.setLayoutY(180);
        path.setFill(Color.BLUE);
        return path;
    }

    public Path triangleMain2() {
        Path path = new Path();
        MoveTo moveTo = new MoveTo();
        moveTo.setX(25);
        moveTo.setY(20);

        LineTo lineTo = new LineTo();
        lineTo.setX(15);
        lineTo.setY(5);

        LineTo lineTo2 = new LineTo();
        lineTo2.setX(5);
        lineTo2.setY(20);

        LineTo lineTo3 = new LineTo();
        lineTo3.setX(25);
        lineTo3.setY(20);

        path.getElements().addAll(moveTo,lineTo, lineTo2, lineTo3);
        path.setLayoutX(530);
        path.setLayoutY(380);
        path.setFill(Color.RED);
        return path;
    }

    public Path triangleMain3() {
        Path path = new Path();
        MoveTo moveTo = new MoveTo();
        moveTo.setX(25);
        moveTo.setY(20);

        LineTo lineTo = new LineTo();
        lineTo.setX(15);
        lineTo.setY(5);

        LineTo lineTo2 = new LineTo();
        lineTo2.setX(5);
        lineTo2.setY(20);

        LineTo lineTo3 = new LineTo();
        lineTo3.setX(25);
        lineTo3.setY(20);

        path.getElements().addAll(moveTo,lineTo, lineTo2, lineTo3);
        path.setLayoutX(330);
        path.setLayoutY(520);
        path.setFill(Color.RED);
        return path;
    }

    public Path triangleMain4() {
        Path path = new Path();
        MoveTo moveTo = new MoveTo();
        moveTo.setX(25);
        moveTo.setY(20);

        LineTo lineTo = new LineTo();
        lineTo.setX(15);
        lineTo.setY(5);

        LineTo lineTo2 = new LineTo();
        lineTo2.setX(5);
        lineTo2.setY(20);

        LineTo lineTo3 = new LineTo();
        lineTo3.setX(25);
        lineTo3.setY(20);

        path.getElements().addAll(moveTo,lineTo, lineTo2, lineTo3);
        path.setLayoutX(50);
        path.setLayoutY(430);
        path.setFill(Color.GREEN);
        return path;
    }

    public Rectangle rectangle() {
        Rectangle r = new Rectangle();
        r.setX(265);
        r.setY(560);
        r.setWidth(70);
        r.setHeight(40);
        r.setArcWidth(10);
        r.setArcHeight(10);
        return r;
    }

    public Rectangle square() {
        Rectangle s = new Rectangle();
        s.setLayoutX(rand());
        s.setLayoutY(1);
        s.setFill(randColor());
        s.setWidth(15);
        s.setHeight(15);
        return s;
    }

    public Path triangle() {
        Path path = new Path();
        MoveTo moveTo = new MoveTo();
        moveTo.setX(25);
        moveTo.setY(20);

        LineTo lineTo = new LineTo();
        lineTo.setX(15);
        lineTo.setY(5);

        LineTo lineTo2 = new LineTo();
        lineTo2.setX(5);
        lineTo2.setY(20);

        LineTo lineTo3 = new LineTo();
        lineTo3.setX(25);
        lineTo3.setY(20);

        path.getElements().addAll(moveTo,lineTo, lineTo2, lineTo3);
        path.setLayoutX(rand());
        path.setFill(randColor());
        return path;
    }

    private Color randColor(){
        ArrayList<Color> colors = new ArrayList<>();
        colors.add(Color.BLUE);
        colors.add(Color.GREEN);
        colors.add(Color.RED);
        return colors.get((int) (3.0 * Math.random()));
    }

    private int rand() {
        int min = 0;
        int max = 600;
        return (int) (Math.random() * max + min);
    }
}

