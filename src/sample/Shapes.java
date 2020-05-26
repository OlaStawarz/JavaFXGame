package sample;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

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
        r.setArcWidth(20);
        r.setArcHeight(20);
        return r;
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

