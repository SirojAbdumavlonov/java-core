package lessons.lesson05.task2;

import java.util.List;
import java.util.Scanner;

public class Quiz {
    private String title;
    private List<Team> teams;
    private List<Question> questions;

    public Quiz(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public void addQuestion(Question question) {
        questions.add(question);
    }

    public void addTeam(Team team) {
        teams.add(team);
    }

    public void startGame(){
        if (teams.isEmpty()){
            System.out.println("No teams found");
            return;
        }
        if (questions.isEmpty()){
            System.out.println("No questions found");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Quiz has started");

        for (Question question : questions){
            System.out.println("Question: " + question.getText());
            for (Team team : teams){
                System.out.println("Team " + team.getTitle() + " is answer, enter your answer");
                boolean isCorrect = question.insertAnswer(scanner);
                if (isCorrect){
                    System.out.println("Correct!");
                    team.addPoints(question.getPoint());
                }
                System.out.println();
            }
        }

    }
    public void gameResults(){
        System.out.println("Teams and their points:");
        for (Team team : teams){
            System.out.println("Team: " + team.getTitle() + ", points: " + team.getPoints());
        }

        Team winnerTeam = getWinnerTeam();
        System.out.println("Winner: " + winnerTeam.getTitle() + " earned points: " + winnerTeam.getPoints());
    }

    public Team getWinnerTeam(){
        if (teams.isEmpty()){
            System.out.println("No teams found");
            return null;
        }

        Team winnerTeam = teams.getFirst();
        int points = winnerTeam.getPoints();

        for (Team team : teams){
            if (team.getPoints() > points){
                winnerTeam = team;
                points = team.getPoints();
            }
        }
        return winnerTeam;
    }
}