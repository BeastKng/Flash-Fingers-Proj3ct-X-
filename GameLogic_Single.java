import java.io.File;
import java.time.Duration;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class GameLogic_Single {
    private Scanner in;
    //private FileReader file;
    private int mistakes;
    private double time;
    private String display;
    private String User_input;
 
/*     public GameLogic_Single() {
        Scanner in = new Scanner(System.in);
        //file = new FileReader();
        this.mistakes = 0;
        this.display = " ";
        this.User_input = " ";
    }
*/
    public GameLogic_Single(){
        in = new Scanner(System.in);
        this.mistake = 0;
        this.time = 0.0;
        this.display = "";
        this.User_input = "";
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    public void setUserInput(String input) {
        this.User_input = input;
    }

    public int getmistakes() {
        return this.mistakes;
    }

    public String getDisplay(){
        return this.Display;
    }

    public String getUser_input(){
        return this.User_input;

    }public void mistakeByLen(String display , String user_input) { // increases the mistakes based on Length
        int len_display = display.length();
        int len_user_input = user_input.length();
        this.mistake += Math.abs(len_display - len_user_input);
        
    } public void mistakeByChar(String display, String user_input) { // increases the mistakes based on characters
        int len_display = display.length();
        int len_user_input = user_input.length();
        
        for (int i = 0; i < Math.min(len_display, len_user_input); i++) {
            if (display.charAt(i) != user_input.charAt(i)) {
                this.mistakes += 1;
            } 
        }

    } public void SinglePlayer() {
        FileReader file;
        System.out.print("You have chosen single player mode. Which field would you like to choose (Anime, Computer, Random):  ");
        String field = in.nextLine();
        if (field.equalsIgnoreCase("Anime")) {
            file = new FileReader("Anime.txt");
        } 
        else if (field.equalsIgnoreCase("Computer")) {
            file = new FileReader("Computer.txt");
        }
        else if (field.equalsIgnoreCase("Random")) {
            file = new FileReader("agatha_complete.txt");
        }
        else {
            System.out.println("Bad input given");
        }

        System.out.println(file.randomSen());
        System.out.print("Enter the displayed line above: ");
        String input = in.nextLine();
        this.User_input += input;

        System.out.println("Mistakes made: " + this.mistakes);



        

		//String output = indexnum("agatha_complete.txt"); // have to change the file 
		LocalTime p1Start = LocalTime.now();
		String user1 = User_input();
		LocalTime p1End = LocalTime.now();
		
		Duration duration = Duration.between(p1Start, p1End);
		return ("Type duration: " + duration.get(ChronoUnit.SECONDS) + " seconds /nNumber of mistake(s: " + Checker(display, user_Input));
			
    }
}
