import java.io.IOException;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class RowSwapper {

    static String file = "swap.txt";

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(Paths.get(file));
        List<String> list = new LinkedList<>();
        while(sc.hasNext()){
            list.add(sc.nextLine());
        }
        while(!list.isEmpty()){
            System.out.println(list.get(list.size() - 1));
            list.remove(list.size() - 1);
        }

    }

}
