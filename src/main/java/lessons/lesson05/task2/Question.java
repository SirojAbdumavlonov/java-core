package lessons.lesson05.task2;

import java.util.Scanner;

public abstract class Question {
    private String text;
    private int point;

    public Question(String text, int point) {
        this.text = text;
        this.point = point;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public abstract boolean insertAnswer(Scanner scanner);
}
