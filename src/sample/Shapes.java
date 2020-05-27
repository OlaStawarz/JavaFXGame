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

