import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Random;

public class ProtoX{
    
    
        public static String indexnum(String filename){
            int countlines = 1;
            Random rand = new Random();
            int randd = rand.nextInt(countlines);
            String output = "";
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
        }System.out.println("Line number: " + randd + " ");
        output = data_new[randd];
        System.out.println(output);

        }catch(FileNotFoundException ex){
            System.out.print("An error has occured. ");
            ex.printStackTrace();
        }

        
        return output;
        //System.out.print("COUNTLINES: " + countlines);
        
       } public static String User_input (){
        Scanner in = new Scanner(System.in);
        System.out.print("Enter The Displayed Line Above: ");
        String user1 = in.nextLine();
        return user1;
       }

       public static int Checker(String output, String user1){
        int len_output = output.length();
        int len_user1 = user1.length();
        int count_pts = 0;
        int mistakes = 0;
        int difference;
        int min_lenght;
        min_lenght = Math.min(len_output, len_user1);


        if (len_output != len_user1){
            
            //min_lenght = Math.min(len_output, len_user1);
            for (int i= 0 ; i < min_lenght ; i++){
                if (output.charAt(i) != user1.charAt(i)){ // should we have a semi colon
                    mistakes++;
                }
            }mistakes = Math.abs(len_output - len_user1);
        }  
            
        else{
             for (int i= 0 ; i < min_lenght ; i++){
                if (output.charAt(i) != user1.charAt(i)){ 
                    mistakes++;
                }
                else{
                count_pts++;
                }
            }mistakes = mistakes - 1; // to be fixed in the future. due to it printing mistake = 1 when there is no mistake
            }   
            
    System.out.println("output length " + len_output);
    System.out.println(len_user1);
    System.out.print("mistakes " + mistakes);
    return mistakes;

    
}
 

       
public static void main(String[] args){
    String output = indexnum("agatha_complete.txt");

    String user1 = User_input();

    //indexedLine("agatha_complete.txt");
    //reader("agatha_complete.txt");
    //User_input();
    Checker(output, user1);
   

    
    



}
}
