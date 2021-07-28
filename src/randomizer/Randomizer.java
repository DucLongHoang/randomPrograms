package randomizer;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.*;

public class Randomizer {

    public static String people = "person.txt";
    public static String roomies = "roomies.txt";

    public static Storage<Person> everybody;
    public static Storage<Person> players;
    public static Storage<Family> families;
    public static Storage<Team> teams;

    public Randomizer(){
        everybody = new Storage<>();
        players = new Storage<>();
        families = new Storage<>();
        teams = new Storage<>();
    }

    // if multiple names, make reasonable names and surnames
    public static String[] split(String[] div){
        String[] result = new String[2];
        int count = div.length;
        switch (count) {
            case 2 -> result = div;
            case 3 -> {
                result[0] = div[0] + " " + div[1];
                result[1] = div[2];
            }
            case 4 -> {
                result[0] = div[0] + " " + div[1];
                result[1] = div[2] + " " + div[3];
            }
            default -> {
                if(div.length == 1){
                    result[0] = div[0]; result[1] = "no surname";
                }
                else{
                    result[0] = div[0];
                    StringBuilder sb = new StringBuilder();
                    for(int i = 1; i < div.length; i++){
                        sb.append(div[i]).append(" ");
                    }
                    sb.deleteCharAt(sb.length() - 1);
                    result[1] = sb.toString();
                }
            }
        }
        return result;
    }

    // Puts all people into families according to the 2 files
    public void makeFamilies() throws IOException {
        Scanner scP = new Scanner(Paths.get(people));
        Scanner scR = new Scanner(Paths.get(roomies));

        Family f; Person p; int ID = 0;
        String pLine, rLine;
        String[] split, nameSplit;

        while(scP.hasNextLine()){
            pLine = scP.nextLine();
            split = split(pLine.split("\t"));
            p = new Person(split[0], split[1]);

            if(everybody.contains(p)){      // if already went through
                if(!players.contains(p)) {  // add already existing object
                    players.store(everybody.get(p));
                }
                scR.nextLine();     // skip roommates line
                continue;
            }

            f = new Family(ID);     // make new family
            f.add(p);
            everybody.store(p);
            players.store(p);
            families.store(f);

            rLine = scR.nextLine();
            if(rLine.equals("null")){       // someone without roommates
                ID++;
                continue;
            }

            split = rLine.split(", ");      // split roommates line

            // add roommates
            for (String s : split) {
                nameSplit = split(s.split(" "));
                p = new Person(nameSplit[0], nameSplit[1]);
                f.add(p);
                everybody.store(p);
            }
            ID++;
        }
    }

    // Puts people randomly into Teams of 4 if possible
    public void makeTeams(int teamSize){
        List<Person> list = players.toArray();        // manipulating Array and not Set
        //List<Person> list = everybody.toArray();
        boolean[] checked = new boolean[list.size()];   // array to see who already is in a Team
        Team t;

        Random random = new Random();
        int ID = 8;
        int index;

        while(true){
            t = new Team(ID);

            for(int i = 0; i < list.size(); i++){
                if(nobodyLeft(checked)) {
                    teams.store(t);
                    return;
                }
                if(t.size() == teamSize) break;

                index = random.nextInt(list.size());
                while(checked[index]) {
                    //index = (index + 1) % list.size();      // take the next possible person
                    index = random.nextInt(everybody.size() * 3) % list.size();
                    // little bit more random
                }
                if(t.add(list.get(index))){
                    checked[index] = true;      // check if Person is already in another Team
                }
            }
            teams.store(t);
            ID++;
        }
    }

    // prints players, families and teams
    public void printAll(){
        System.out.println();
        //everybody.print();
        players.print();
        System.out.println();
        families.print();
        System.out.println();
        teams.print();
    }

    // check if everything in array is true
    public static boolean nobodyLeft(boolean[] all){
        for(boolean someone : all){
            if(!someone) return false;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        System.out.println("\n");
        Randomizer r = new Randomizer();

        while(true){
            r.makeFamilies();
            r.makeTeams(4);
            r.printAll();
            if(extraConditionsOK()) break;
            everybody.empty();
            players.empty();
            families.empty();
            teams.empty();
        }
    }

    // extra conditions for special cases
    public static boolean extraConditionsOK(){
        if(theseTwoAreNotInTeam("Adrien Hidden", "Alan Ferizović")) return false;
        if(theseTwoAreNotInTeam("Léo Du Portal", "Alan Ferizović")) return false;

        return true;
    }

    // self explanatory
    public static boolean theseTwoAreNotInTeam(String first, String second){
        String[] split = first.split(" ");
        String[] nameSplit = split(split);
        Person one = players.get(new Person(nameSplit[0], nameSplit[1]));
        //Person one = everybody.get(new Person(nameSplit[0], nameSplit[1]));

        split = second.split(" ");
        nameSplit = split(split);
        Person two = players.get(new Person(nameSplit[0], nameSplit[1]));
        //Person two = everybody.get(new Person(nameSplit[0], nameSplit[1]));

        return !one.areTeammates(two);
    }
    // opposite of the above
    public static boolean theseTwoAreInTeam(String first, String second){
        return !theseTwoAreNotInTeam(first, second);
    }

}
