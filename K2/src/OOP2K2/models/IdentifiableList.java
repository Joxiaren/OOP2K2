package OOP2K2.models;

import java.util.ArrayList;
public class IdentifiableList<T extends Identifiable>{
    ArrayList<T> elements = new ArrayList<>();

    public IdentifiableList(){
        super();
    }
    private T find(long ID){
        for(T t : elements){
            if(t.getID() == ID) return t;
        }
        return null;
    }

    public void add(T t){
        elements.add(t);
    }
    public T read(long ID){
        return this.find(ID);
    }
    public ArrayList<T> readAll(){
        return this.elements;
    }
    public void delete(long ID){
        this.elements.remove(this.find(ID));
    }

}
