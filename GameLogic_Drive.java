import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Random;

public class GameLogic_Drive {
    private static class FileReader {
        private String fileName;

        public FileReader(String fileName) {
            this.fileName = fileName;
        }

        public void setFileName(String fileName) {
            this.fileName = fileName;
        }

        public String getFileName() {
            return this.fileName;
        }

        public int numLines() { // returns the number of lines in the file
            int num = 0;
            try {
                File myObj = new File(this.fileName);
                Scanner myReader = new Scanner(myObj);
                while (myReader.hasNextLine()) {
                    num += 1;
                    myReader.nextLine();
                }
                myReader.close();
            } catch (FileNotFoundException e) {
                System.out.println("An error occurred");
                e.printStackTrace();
            }
            return num;
        }

        public String[] toArray() { // returns the data in the file to a useful array
            StringBuilder lines = new StringBuilder();
            try {
                File myObj = new File(this.fileName);
                Scanner myReader = new Scanner(myObj);
                while (myReader.hasNextLine()) {
                    String data = myReader.nextLine();
                    lines.append(data).append("\n");
                }
                myReader.close();
            } catch (FileNotFoundException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }

            String[] arr = lines.toString().split("\n");

            return arr;
        }

        public String randomSen() { // return a random sentence from a line in the array
            Random random = new Random();
            int num = random.nextInt(numLines());

            return toArray()[num];
        }
    }

    public static void Theme() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Which field would you like to choose: Anime, Computer Science or Random:");
        String field = scanner.nextLine();
        String sen = "";

        if (field.equalsIgnoreCase("Anime")) {
            FileReader file = new FileReader("Anime.txt");
            sen += file.randomSen();
        } else if (field.equalsIgnoreCase("Computer Science")) { // Corrected the field name
            FileReader file = new FileReader("Computer.txt"); // Corrected the file name
            sen += file.randomSen();
        } else if (field.equalsIgnoreCase("Random")) {
            FileReader file = new FileReader("agatha_complete.txt");
            sen += file.randomSen();
        } else {
            System.out.println("Bad Input given");
        }

        System.out.println("Random Sentence: " + sen);

        //GameLogic_Single game = new GameLogic_Single();
        //game.SinglePlayer();

        GameLogic_Multiple game = new GameLogic_Multiple();
        game.MultiPlayer();
    
    }
    public static void main(String[]args){

        

        while (true) {
            System.out.println("Press (1) for single player /\\Press (2) for Multple player");
            Scanner in = new Scanner(System.in);        
            String cmd = in.nextLine();
            if (cmd.equalsIgnoreCase("1")){
                GameLogic_Single game = new GameLogic_Single();
                game.SinglePlayer();

            }else if (cmd.equalsIgnoreCase("2")){
                GameLogic_Multiple game = new GameLogic_Multiple();
                game.MultiPlayer();
            }else{
                System.out.println("Wrong input please press (1) for single player or (2) for multiple player");
            }
        }
    }
}
        

         


