package OOP2K2.models;

import OOP2K2.interfaces.Lambda;

import java.util.ArrayList;
public class IdentifiableList<T extends Identifiable>{
    ArrayList<T> elements = new ArrayList<>();
    ArrayList<Lambda<T>> addEvents = new ArrayList<>();
    ArrayList<Lambda<T>> deleteEvents = new ArrayList<>();
    ArrayList<Lambda<T>> updateEvents = new ArrayList<>();

    public IdentifiableList(){
        super();
    }
    public IdentifiableList(ArrayList<T> elements){
        super();
        this.elements = elements;
    }
    private T find(long ID){
        for(T t : elements){
            if(t.getID() == ID) return t;
        }
        return null;
    }

    public void add(T t){
        elements.add(t);
        for(Lambda<T> l : this.addEvents) l.start(t);
    }
    public T read(long ID){
        return this.find(ID);
    }
    public T readIndex(int index){
        return this.elements.get(index);
    }
    public ArrayList<T> readAll(){
        return new ArrayList<T>(this.elements);
    }
    public void update(T from, T to){
        to.copy(from);
        for(Lambda<T> l : this.updateEvents) l.start(to);
    }
    public void delete(long ID){
        T t = this.find(ID);
        for(Lambda<T> l : this.deleteEvents) l.start(t);
        this.elements.remove(t);
    }
    public void deleteIndex(int index){
        T t = this.elements.get(index);
        for(Lambda<T> l : this.deleteEvents) l.start(t);
        this.elements.remove(index);
    }
    public int size(){
        return this.elements.size();
    }

    public void addAddEvent(Lambda<T> l){
        this.addEvents.add(l);
    }
    public void addDeleteEvent(Lambda<T> l){
        this.deleteEvents.add(l);
    }
    public void addUpdateEvent(Lambda<T> l){
        this.updateEvents.add(l);
    }

}
