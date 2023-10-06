import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Random;

public class FileReader {
    private String fileName;

    public FileReader(String fileName) {
        this.fileName = fileName;
    } // constrcutor

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return this.fileName;
    }

    public int numLines() { // returns number of Lines in the File
        int num = 0;
        try {
            File myObj = new File(this.fileName);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                num += 1;
                myReader.nextLine();
            }
            myReader.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("An error occurred");
            e.printStackTrace();
        }

        return num;

    } // numLines

    public String[] toArray() { // returns the data in the file to a useful array
        String lines = "";
        try {
            File myObj = new File(this.fileName);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                lines += data + "\n";
            }
            myReader.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        String[] arr = lines.split("\n");

        return arr;

    } // toArray

    public String randomSen() { // return a random sentence from a line in the array
        Random random = new Random();
        int num = random.nextInt(numLines());

        return toArray()[num];
    } // randomSen

} // class FileReader