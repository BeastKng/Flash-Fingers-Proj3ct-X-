
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Random;
import java.util.Scanner;

public class GameLogic_Single {
    private Scanner in;
    private int mistakes;
    private double time;
    private String display;
    private StringBuilder User_input;

    public GameLogic_Single() {
        in = new Scanner(System.in);
        this.mistakes = 0;
        this.time = 0.0;
        this.display = "";
        this.User_input = new StringBuilder();
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    public void setUserInput(String input) {
        this.User_input.append(input); // Append user input to the StringBuilder.
    }

    public int getMistakes() {
        return this.mistakes;
    }

    public String getDisplay() {
        return this.display;
    }

    public String getUserInput() {
        return this.User_input.toString(); // Convert the StringBuilder to a String.
    }

    public static int Checker(String output, String user1) {
        int len_output = output.length();
        int len_user1 = user1.length();
        int mistakes = 0;

        for (int i = 0; i < Math.min(len_output, len_user1); i++) {
            if (output.charAt(i) != user1.charAt(i)) {
                mistakes++;
            }
        }

        mistakes += Math.abs(len_output - len_user1);
        return mistakes;
    }

    public void SinglePlayer() {
        FileReader file;
        System.out.println("You have chosen single-player mode. Which field would you like to choose (Anime, Computer, Random):  ");
        String field = in.nextLine();

            if (field.equalsIgnoreCase("Anime")) {
                file = new FileReader("Anime.txt");
            } else if (field.equalsIgnoreCase("Computer")) {
                file = new FileReader("Computer.txt");
            } else if (field.equalsIgnoreCase("Random")) {
                file = new FileReader("agatha_complete.txt");
            } else { 
                System.out.println("Bad input given");
                return; // Exit the method on bad input.
            }

            String randomSentence = file.randomSen();
            System.out.println(randomSentence);
            LocalTime p1Start = LocalTime.now();
            System.out.println("Enter the displayed line : ");
            String input = in.nextLine();
            LocalTime p1End = LocalTime.now();
            setUserInput(input);

            int mistakesMade = Checker(randomSentence, getUserInput());
            System.out.println("Mistakes made: " + mistakesMade);
            if (mistakesMade == 0){
                System.out.println("You have no mistakes, Well Done!");
            }
            Duration duration = Duration.between(p1Start, p1End);
            System.out.println("Type duration: " + duration.get(ChronoUnit.SECONDS) + " seconds");
        }
    }

    /*public static void main(String[] args) {
        GameLogic_Single game = new GameLogic_Single();
        game.SinglePlayer();
    }*/



