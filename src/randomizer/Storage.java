package randomizer;

import java.util.*;

public class Storage <E>{

    private final Set<E> storage;

    public Storage() {
        this.storage = new HashSet<>();
    }

    public ArrayList<E> toArray(){ return new ArrayList<>(storage); }

    public boolean contains(E out){
        for(E in : storage){
            if(out.equals(in)) return true;
        }
        return false;
    }

    public void store(E e){
        if(!(this.contains(e))) {
            this.storage.add(e);
        }
    }

    public int size(){ return this.storage.size(); }

    public void print(){
        for(E e : storage){
            System.out.println(e.toString());
        }
    }

    public E get(Object o){
        E e = (E) o;
        ArrayList<E> array = this.toArray();
        for(E element : array){
            if(e.equals(element)){
                e = element;
                break;
            }
        }

        return e;
    }

    public void empty(){ this.storage.clear(); }

}
