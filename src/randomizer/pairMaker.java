package randomizer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class pairMaker {

    public static void main(String[] args){

        String[] day = {"15.06", "16.06", "17.06", "18.06", "19.06", "20.06", "21.06", "22.06", "23.06"};
        for(int j = 0; j < day.length; j++) {
            System.out.println(day[j]);

            List<String> names = new ArrayList<>();
            names.add("Long");
            names.add("Jakub");
            names.add("Nancy");
            names.add("Helo");
            names.add("Mateo");
            names.add("Tony");
            names.add("Simona");
            names.add("Antonin");
            names.add("Agath");
            names.add("Camille");

            Random r = new Random();
            int number;
            StringBuilder sb;
            while (!names.isEmpty()) {
                sb = new StringBuilder();
                for (int i = 0; i < 2; i++) {
                    number = r.nextInt(names.size());
                    number = number % names.size();
                    sb.append(names.get(number)).append(" ");
                    names.remove(number);
                }
                System.out.println(sb.toString());
            }
            System.out.println();
        }


    }


}
