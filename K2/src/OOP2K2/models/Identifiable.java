package OOP2K2.models;

import OOP2K2.interfaces.Copyable;

import java.util.UUID;

public abstract class Identifiable implements Copyable {
    private long ID;
    public Identifiable(){
        this.ID = UUID.randomUUID().getMostSignificantBits();
    }
    public long getID(){
        return ID;
    }
}
