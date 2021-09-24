import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

public class AlternateRows {

    public static String inputFile1 = "newRows01.txt";
    public static String inputFile2 = "newRows02.txt";
    public static String outputFile = "outputHints.txt";

    public static void main(String[] args){
        FileWriter fw = null;
        try {
            Scanner sc1 = new Scanner(Paths.get(inputFile1));
            Scanner sc2 = new Scanner(Paths.get(inputFile2));
            fw = new FileWriter(new File(outputFile));
            //String line;

            while(sc1.hasNextLine()){
                fw.write(sc1.nextLine());
                fw.write("\n");
                fw.write(sc2.nextLine());
                fw.write("\n");
            }

        }
        catch (IOException e){
            System.err.println("Problem with IO: " + e.getMessage());
        }
        finally {
            try {
                if(fw != null) fw.close();
            }
            catch (IOException e) {
                System.err.println("Problem with closing writer: " + e.getMessage());
            }
        }

    }


}
