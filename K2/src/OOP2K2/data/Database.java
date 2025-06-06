package OOP2K2.data;

import OOP2K2.models.*;

public class Database{
    public IdentifiableList<BelaTehnika> belaTehnikaList = new IdentifiableList<>();
    public IdentifiableList<KvarljivaRoba> kvarljivaRobaList = new IdentifiableList<>();
    public IdentifiableList<Magacin> magacinList = new IdentifiableList<>();
    public IdentifiableList<Magacioner> magacionerList = new IdentifiableList<>();
    public IdentifiableList<Menadzer> menadzerList = new IdentifiableList<>();

    public Database(){
        super();
    }

}
