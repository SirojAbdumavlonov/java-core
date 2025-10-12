package lessons.lesson05.task2;

import java.util.List;
import java.util.Scanner;

public class OptionQuestion extends Question {
    private List<String> answers;
    private int correctOption; //index

    public OptionQuestion(String text, List<String> answers, int correctOption, int point) {
        super(text, point);
        this.answers = answers;
        this.correctOption = correctOption;
    }

    @Override
    public boolean insertAnswer(Scanner scanner) {
        System.out.println("Please insert correct answer number: ");
        int answerNumber = scanner.nextInt();
        System.out.println("Options:");
        for (String answer: answers) {
            System.out.println(answer);
        }
        if (correctOption == answerNumber) {
            System.out.println("Correct answer");
            return true;
        }

        System.out.println("Wrong answer");
        return false;
    }
}
