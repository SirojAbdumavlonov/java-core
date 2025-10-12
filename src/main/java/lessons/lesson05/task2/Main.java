package lessons.lesson05.task2;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Quiz quiz = new Quiz("Quiz");

        quiz.addQuestion(new TextQuestion("What is the latest iPhone version?", "17", 2));
        quiz.addQuestion(new OptionQuestion("What the color is sky?",
            Arrays.asList("Black", "White", "Blue", "Red"), 3, 2));

        Team a = new Team("A");
        Team b = new Team("B");

        quiz.addTeam(a);
        quiz.addTeam(b);

        quiz.startGame();
    }
}