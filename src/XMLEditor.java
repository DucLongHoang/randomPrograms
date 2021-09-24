import java.io.*;
import java.nio.file.Paths;
import java.util.Scanner;

public class XMLEditor {

    private static final File input = new File("edit.txt");
    private static final File output = new File("newEdit.txt");

    public XMLEditor(){ }

    public void findReplace(String find, String replace){
        BufferedWriter writer = null;
        Scanner sc;

        try{
            writer = new BufferedWriter(new FileWriter(output));
            sc = new Scanner(Paths.get("edit.txt"));
            String line;

            while(sc.hasNextLine()){
                line = sc.nextLine();
                if(line.contains(find)){
                    line = "\t\t" + "<name>" + replace + "</name>";
                }
                writer.write(line + "\n");
                writer.flush();
            }

            System.out.println("\nSuccessfully found and replaced!!!");
        }
        catch (IOException e){
            System.err.println("Problem with IO operation: " + e.getMessage());
        }
        finally {
            try{
                if(writer != null) writer.close();
            }
            catch (IOException e){
                System.err.println("Problem closing buffers: " + e.getMessage());
            }
        }
    }

    public static void main(String[] args){
        XMLEditor editor = new XMLEditor();
        editor.findReplace("<name>", "2");


    }





}
