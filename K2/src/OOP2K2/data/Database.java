package OOP2K2.data;

import OOP2K2.models.*;

import java.util.ArrayList;
import java.util.HashMap;

public class Database{
    public IdentifiableList<BelaTehnika> belaTehnikaList = new IdentifiableList<>();
    public IdentifiableList<KvarljivaRoba> kvarljivaRobaList = new IdentifiableList<>();
    public IdentifiableList<Roba> robaList = new IdentifiableList<>();
    public IdentifiableList<Magacin> magacinList = new IdentifiableList<>();
    public IdentifiableList<Magacioner> magacionerList = new IdentifiableList<>();
    public IdentifiableList<Menadzer> menadzerList = new IdentifiableList<>();
    private HashMap<Class, IdentifiableList<?>> listMap = new HashMap<Class, IdentifiableList<?>>();
    public HashMap<String, Class> stringToClass = new HashMap<>();
    public Database(){
        super();
        listMap.put(BelaTehnika.class, belaTehnikaList);
        listMap.put(KvarljivaRoba.class, kvarljivaRobaList);
        listMap.put(Magacin.class, magacinList);
        listMap.put(Magacioner.class, magacionerList);
        listMap.put(Menadzer.class, menadzerList);
        listMap.put(Roba.class, robaList);


        magacinList.addDeleteEvent((item) -> {
            for(Magacioner m : magacionerList.readAll()){
                if(m.getRadnoMesto() == item) m.setRadnoMesto(null);
            }
            for(Menadzer m : menadzerList.readAll()){
                if(m.getMagacin() == item) m.setMagacin(null);
            }
        });

        belaTehnikaList.addAddEvent((item) -> {
            robaList.add(item);
        });
        belaTehnikaList.addDeleteEvent((item) -> {
            robaList.delete(item.getID());
        });

        kvarljivaRobaList.addAddEvent((item) -> {
            robaList.add(item);
        });
        kvarljivaRobaList.addDeleteEvent((item) ->{
            robaList.delete(item.getID());
        });
    }
    public IdentifiableList<?> getList(Class c){
        if(c.equals(Roba.class)) return this.getRoba();
        if(c.equals(Zaposleni.class)) return this.getZaposleni();
        return listMap.get(c);
    }
    public IdentifiableList<Roba> getRoba(){
        ArrayList<Roba> robaList = new ArrayList<Roba>();

        robaList.addAll(belaTehnikaList.readAll());
        robaList.addAll(kvarljivaRobaList.readAll());

        return new IdentifiableList<Roba>(robaList);
    }
    public IdentifiableList<Zaposleni> getZaposleni(){
        ArrayList<Zaposleni> zaposleniList = new ArrayList<Zaposleni>();

        zaposleniList.addAll(magacionerList.readAll());
        zaposleniList.addAll(menadzerList.readAll());

        return new IdentifiableList<Zaposleni>(zaposleniList);
    }
    public Class stringToClass(String s){
        if(s.equals("BelaTehnika")) return BelaTehnika.class;
        if(s.equals("KvarljivaRoba")) return KvarljivaRoba.class;
        if(s.equals("Magacin")) return Magacin.class;
        if(s.equals("Magacioner")) return Magacioner.class;
        if(s.equals("Menadzer")) return Menadzer.class;

        return null;
    }
}
