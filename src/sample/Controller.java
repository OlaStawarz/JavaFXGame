package sample;

import javafx.beans.property.SimpleStringProperty;


public class Controller {

    private SimpleStringProperty name;
    private SimpleStringProperty score;

    public Controller () {
    }

    public Controller (String s1, String s2) {

        name = new SimpleStringProperty(s1);
        score = new SimpleStringProperty(s2);
    }

    public String getName() {

        return name.get();
    }
    public void setName(String s) {

        name.set(s);
    }

    public String getScore() {

        return score.get();
    }
    public void setScore(String s) {
        score.set(s);
    }

}
