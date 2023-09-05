import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Random;

public class ProtoprojX{
    
    // public static String reader(String filename){
        
    //     Scanner Usertxt = new Scanner(System.in);
    //     System.out.println("Enter txt copy");
    //     String data = " ";
    //     int count = 0;
    //     try {
    //         File dict = new File(filename);
    //         Scanner myReader =  new Scanner(dict);
    //         while(myReader.hasNextLine()){
    //             //String data = myReader.hasNextLine();
    //             data = data + myReader.nextLine() + "\n";
    //             System.out.println(data);
    //             count = count + 1;
    //     }
    //     myReader.close();
        
    // }catch(FileNotFoundException ex) {
    //         System.out.println("An error occurred. ");
    //         ex.printStackTrace();

    //     } 
    //     count = count -1;
    //     return data; 
        
    //     }
        public static int indexnum(String filename){
            int countlines = 1;
            Random rand = new Random();
            int randd = rand.nextInt(countlines);
            try{
            File dict = new File(filename);
            Scanner myReader =  new Scanner(dict);
            String data = "";
            while(myReader.hasNextLine()){
                data = data + myReader.nextLine() + "\n";
                countlines = countlines + 1;
            }
            myReader.close();
            //String[] data_new = data.split("\n");

            
            String[] data_new = data.split("\n");
        
        
            int countline_forand = countlines;
            for (; countlines>0;countlines--){
            randd = rand.nextInt(countline_forand);
        }System.out.print("Line number: " + randd + " ");
        String output = data_new[randd];
        System.out.print(output);

        }catch(FileNotFoundException ex){
            System.out.print("An error has occured. ");
            ex.printStackTrace();
        }

        
        return randd;
        //System.out.print("COUNTLINES: " + countlines);
        
       }
       
        
       
public static void main(String[] args){
    //reader("agatha_complete.txt");
    indexnum("agatha_complete.txt");
    //indexedLine("agatha_complete.txt");

}
}
