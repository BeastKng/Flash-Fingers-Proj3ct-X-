import java.io.File;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class GameLogic_Multiple {
    private Scanner in;
    private int mistakes;
    private double time;
    private String display;
    private String User_1;
    private String User_2;

    public GameLogic_Multiple() {
        in = new Scanner(System.in);
        this.mistakes = 0;
        this.time = 0.0;
        this.display = "";
        this.User_1 = "";
        this.User_2 = "";
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    public void setUser_1(String User_1) {
        this.User_1 = User_1;
    }

    public void setUser_2(String User_2) {
        this.User_2 = User_2;
    }

    public int getMistakes() {
        return this.mistakes;
    }

    public String getDisplay() {
        return this.display;
    }

    public String getUser_1() {
        return this.User_1;
    }

    public String getUser_2() {
        return this.User_2;
    }
    public static int Checker1(String output, String User_1) {
        int len_output = output.length();
        int len_user1 = User_1.length();
        int mistakes1 = 0;
        int min_length1;
        min_length1 = Math.min(len_output, len_user1);
        
        for (int i = 0; i < min_length1; i++) {
            if (output.charAt(i) != User_1.charAt(i)) {
                mistakes1++;
                mistakes1 += Math.abs(len_output - len_user1);
            }
        }
    
        
        return mistakes1;  // Return the  mistakes for players 

	}public static int Checker2(String output, String User_2) {
        int len_output = output.length();
        int len_user2 = User_2.length();
        int mistakes2 = 0;
        int min_length2;
        min_length2 = Math.min(len_output, len_user2);

        for (int i = 0; i < min_length2; i++) {
            if (output.charAt(i) != User_2.charAt(i)) {
                mistakes2++;
                mistakes2 += Math.abs(len_output - len_user2);
            }
        }
    
        
        return mistakes2;
        
    }public static String User_input() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public static String indexnum(String filename) {
        File file = new File(filename);
        StringBuilder stringBuilder = new StringBuilder();

        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                stringBuilder.append(scanner.nextLine()).append("\n");
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return stringBuilder.toString();
    }

    public static void MultiPlayer() {
        FileReader file = null;
        Scanner in = new Scanner(System.in);
        System.out.println("You have chosen Muiltiple-player mode. Which field would you like to choose (Anime, Computer, Random):  ");
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

        String output = file.randomSen();
        System.out.println(output);
        System.out.println("\nIt's your turn player 1: ");
        LocalTime p1Start = LocalTime.now();
        String User_1 = User_input();
        LocalTime p1End = LocalTime.now();

        Duration player1 = Duration.between(p1Start, p1End);
        long player1Time = player1.get(ChronoUnit.SECONDS);

        System.out.println("\nIt's your turn player 2: ");
        LocalTime p2Start = LocalTime.now();
        String User_2 = User_input();
        LocalTime p2End = LocalTime.now();

        Duration player2 = Duration.between(p2Start, p2End);
        long player2Time = player2.get(ChronoUnit.SECONDS);

        System.out.print("\nPlayer 1 Results: ");
        int p1 = Checker1(output, User_1);
        System.out.println(p1 + " mistake" + "(s)" + "\nPlayer 1 duration: " + player1Time + " seconds");

        System.out.print("\nPlayer 2 Results: ");
        int p2 = Checker2(output, User_2);
        System.out.println(p2 + " mistake" + "(s)" + "\nPlayer 2 duration: " + player2Time + " seconds");

        if(p1 == p2){
            if(player1Time < player2Time){
                System.out.println("\nPlayer 1 Wins!!!!!! ");
            }else if(player1Time > player2Time){
                System.out.println("\nPlayer 2 Wins!!!!!! ");
            }else if(player1Time == player2Time){
                System.out.println("\nIt's a Tie !!!!!!");
                
            }
        }else{
            if (p1 < p2) {
                System.out.println("\nPlayer 1 Wins!!!!!!");
            }else if (p1 > p2) {
                System.out.println("\nPlayer 2 Wins!!!!!!!!!");
            }
        }
         
       
    }

    /*public static void main(String[] args) {
        GameLogic_Multiple game = new GameLogic_Multiple();
        game.MultiPlayer();
    }*/
}
