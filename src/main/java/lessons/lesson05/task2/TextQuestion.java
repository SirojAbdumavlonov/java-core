package lessons.lesson05.task2;

import java.util.Scanner;

public class TextQuestion extends Question {

    private String correctAnswer;

    public TextQuestion(String text, String correctAnswer, int point) {
        super(text, point);
        this.correctAnswer = correctAnswer;
    }

    @Override
    public boolean insertAnswer(Scanner scanner) {
        System.out.println("Please enter your answer to insert:");
        String answer = scanner.nextLine();

        if (answer.trim().equalsIgnoreCase(correctAnswer)) {
            System.out.println("Correct answer");
            return true;
        }

        System.out.println("Wrong answer");
        return false;
    }
}
