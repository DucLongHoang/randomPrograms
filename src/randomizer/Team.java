package randomizer;

import java.util.HashSet;
import java.util.Set;

public class Team {
    private final int ID;
    private final Set<Person> teammates;

    public Team(int ID){
        teammates = new HashSet<>();
        this.ID = ID;
    }

    public Set<Person> getTeammates(){
        return Set.copyOf(this.teammates);
    }
    public int getID() { return ID; }
    public int size(){
        return teammates.size();
    }

    public boolean add(Person p){
        for(Person member : teammates){
            if(p.areRoomies(member)) return false;
        }
        p.setTeam(this);
        teammates.add(p);
        return true;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder("Team " + this.getID() + " : ");
        for(Person p : teammates){
            sb.append(p.getFullName()).append(", ");
        }
        sb.deleteCharAt(sb.length() - 1).deleteCharAt(sb.length() - 1);
        return (sb.toString());
    }
}
