package OOP2K2.models;

import OOP2K2.interfaces.Formable;

import java.util.ArrayList;
import java.util.Arrays;

public class Menadzer extends Zaposleni implements Formable {
    private Magacin magacin;
    public Menadzer() {
        super();
    }
    public Menadzer(String sifraZaposlenog, String ime, String prezime, double plata, Magacin magacin) {
        super(sifraZaposlenog, ime, prezime, plata);
        this.magacin = magacin;
    }

    public Magacin getMagacin() {
        return magacin;
    }

    public void setMagacin(Magacin magacin) {
        this.magacin = magacin;
    }

    @Override
    public void copy(Object from){
        super.copy(from);

        Menadzer m = (Menadzer) from;

        this.magacin = m.magacin;
    }
    @Override
    public int numberOfAttributes() {
        return super.numberOfAttributes() + 1;
    }

    @Override
    public ArrayList<String> attributeNames() {
        ArrayList<String> ret = super.attributeNames();
        ret.addAll(Arrays.asList("Magacin"));
        return ret;
    }

    @Override
    public ArrayList<String> attributeTypes() {
        ArrayList<String> ret = super.attributeTypes();
        ret.addAll(Arrays.asList("Magacin"));
        return ret;
    }

}
