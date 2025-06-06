package OOP2K2.models;

import java.util.UUID;

public abstract class Identifiable {
    private long ID;
    public Identifiable(){
        this.ID = UUID.randomUUID().getMostSignificantBits();
    }

    public long getID(){
        return ID;
    }
}
