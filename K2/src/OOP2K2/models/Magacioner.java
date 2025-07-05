package OOP2K2.models;

import OOP2K2.interfaces.Formable;

import java.util.ArrayList;
import java.util.Arrays;

public class Magacioner extends Zaposleni implements Formable {
    private Integer odmori;
    private Magacin radnoMesto;
    public Magacioner() {
        super();
    }
    public Magacioner(String sifraZaposlenog, String ime, String prezime, double plata, Integer odmori, Magacin radnoMesto) {
        super(sifraZaposlenog, ime, prezime, plata);
        this.odmori = odmori;
        this.radnoMesto = radnoMesto;
    }

    public int getOdmori() {
        return odmori;
    }

    public void setOdmori(Integer odmori) {
        this.odmori = odmori;
    }

    public Magacin getRadnoMesto() {
        return radnoMesto;
    }

    public void setRadnoMesto(Magacin radnoMesto) {
        this.radnoMesto = radnoMesto;
    }

    @Override
    public void copy(Object from){
        super.copy(from);

        Magacioner m = (Magacioner)from;

        this.odmori = m.odmori;
        this.radnoMesto = m.radnoMesto;
    }

    @Override
    public int numberOfAttributes() {
        return super.numberOfAttributes() + 2;
    }

    @Override
    public ArrayList<String> attributeNames() {
        ArrayList<String> ret = super.attributeNames();
        ret.addAll(Arrays.asList("Odmori", "Radno mesto"));
        return ret;
    }

    @Override
    public ArrayList<String> attributeTypes() {
        ArrayList<String> ret = super.attributeTypes();
        ret.addAll(Arrays.asList("Integer", "Magacin"));
        return ret;
    }
}
