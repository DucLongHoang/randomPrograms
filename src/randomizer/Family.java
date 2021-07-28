package randomizer;

import java.util.HashSet;
import java.util.Set;

public class Family {
    private final int ID;
    private final Set<Person> roommates;

    public Family(int ID){
        this.ID = ID;
        this.roommates = new HashSet();
    }

    public void add(Person out){
        for(Person in : roommates){
            if(in.equals(out)) return;
        }
        roommates.add(out);
        out.setFam(this);
    }

    public int getID() { return ID; }
    public Set<Person> getRoomies(){ return Set.copyOf(roommates); }

    @Override
    public boolean equals(Object o){
        if(!(o instanceof Family)) return false;
        Family f = (Family) o;
        return f.getID() == this.getID();
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder("Family " + this.getID() + " : ");
        for(Person p : roommates){
            sb.append(p.getFullName()).append(", ");
        }
        sb.deleteCharAt(sb.length() - 1).deleteCharAt(sb.length() - 1);
        return (sb.toString());
    }
}
