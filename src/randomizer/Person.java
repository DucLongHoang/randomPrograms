package randomizer;

public class Person implements Comparable<Person>{
    private final String name, surname;
    private Family fam;
    private Team team;

    public Person(String name, String surname){
        this.name = name;
        this.surname = surname;
        this.fam = null;
        this.team = null;
    }

    public boolean areRoomies(Person p){ return this.fam.getRoomies().contains(p); }
    public boolean areTeammates(Person p){ return this.team.getTeammates().contains(p); }
    public String getFullName(){ return name + " " + surname; }
    public void setFam(Family f){ this.fam = f; }
    public void setTeam(Team t) { this.team = t; }
    public Family getFam(){ return  this.fam; }

    @Override
    public boolean equals(Object o){
        if(!(o instanceof Person)) return false;
        Person p = (Person) o;
        return (this.getFullName().equalsIgnoreCase(p.getFullName()));
    }

    @Override
    public String toString() {
        return "fID: " + this.fam.getID() + "\t\t"
                + "tID: " + this.team.getID() + "\t\t"
                + this.name + " " + this.surname;
    }

    @Override
    public int compareTo(Person o) {
        return this.getFullName().compareTo(o.getFullName());
    }
}
