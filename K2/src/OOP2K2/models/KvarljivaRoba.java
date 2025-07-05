package OOP2K2.models;

import OOP2K2.interfaces.Formable;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

public class KvarljivaRoba extends Roba implements Formable {
    private LocalDate rokTrajanja;
    private String uputsvoZaSkladistenje;

    public KvarljivaRoba() {
        super();
    }

    public KvarljivaRoba(String naziv, double cena, String opis, LocalDate datumProizvodnje, String jedinicaMere, LocalDate rokTrajanja, String uputsvoZaSkladistenje) {
        super(naziv, cena, opis, datumProizvodnje, jedinicaMere);
        this.rokTrajanja = rokTrajanja;
        this.uputsvoZaSkladistenje = uputsvoZaSkladistenje;
    }

    public LocalDate getRokTrajanja() {
        return rokTrajanja;
    }

    public void setRokTrajanja(LocalDate rokTrajanja) {
        this.rokTrajanja = rokTrajanja;
    }

    public String getUputsvoZaSkladistenje() {
        return uputsvoZaSkladistenje;
    }

    public void setUputsvoZaSkladistenje(String uputsvoZaSkladistenje) {
        this.uputsvoZaSkladistenje = uputsvoZaSkladistenje;
    }

    @Override
    public void copy(Object o){
        super.copy(o);

        KvarljivaRoba kr = (KvarljivaRoba)o;

        this.rokTrajanja = kr.rokTrajanja;
        this.uputsvoZaSkladistenje = kr.uputsvoZaSkladistenje;
    }
    @Override
    public int numberOfAttributes() {
        return super.numberOfAttributes() + 2;
    }

    @Override
    public ArrayList<String> attributeNames() {
        ArrayList<String> ret = super.attributeNames();
        ret.addAll(Arrays.asList("Rok trajanja", "Uputsvo za skladistenje"));
        return ret;
    }

    @Override
    public ArrayList<String> attributeTypes() {
        ArrayList<String> ret = super.attributeTypes();
        ret.addAll(Arrays.asList("LocalDate", "String"));
        return ret;
    }
}
