import java.io.*;
import java.nio.file.Paths;
import java.util.Scanner;

public class IGUnfollowers {

    static String following = "following.txt";
    static String followers = "followers.txt";
    static String test = "test.txt";

    public static void modifyFile(String filePath, String toDelete){
        File toModify = new File(filePath);
        String oldContent = "";
        BufferedReader br = null;
        FileWriter fw = null;

        try {
            br = new BufferedReader(new FileReader(toModify));
            String line = br.readLine();
            String[] parse;
            int parseLength;

            while (line != null){
                if(line.contains(toDelete)){
                    line = br.readLine();
                } else if(line.charAt(0) == ('·')){
                    line = br.readLine();
                } else {
                    oldContent = oldContent + line + System.lineSeparator();
                    line = br.readLine();
                }
            }
            fw = new FileWriter(toModify);
            fw.write(oldContent);
            fw.flush();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
                fw.close();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        modifyFile(followers, "Verified");
        modifyFile(following, "Verified");
        System.out.println("Done");



    }


}
