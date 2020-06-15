package sample;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;


public class Controller {

    private SimpleStringProperty name;
    private SimpleIntegerProperty score;

    public Controller () {
    }

    public Controller (String s1, int s2) {

        name = new SimpleStringProperty(s1);
        score = new SimpleIntegerProperty(s2);
    }

    public String getName() {

        return name.get();
    }
    public void setName(String s) {

        name.set(s);
    }

    public int getScore() {

        return score.get();
    }
    public void setScore(int s) {
        score.set(s);
    }

}
