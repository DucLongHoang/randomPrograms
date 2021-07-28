import java.io.IOException;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class DuplicateCheck {

    public static String file = "codes.txt";

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(Paths.get(file));
        Set<String> set = new HashSet<>();
        String word;

        System.out.println();
        while(sc.hasNextLine()){
            word = sc.nextLine();
            if(set.contains(word)){
                System.out.println(word + " is a duplicate");
                break;
            }
            set.add(word);
        }
        System.out.println("Check finished!");

    }

}
