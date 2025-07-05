package OOP2K2.models;

import OOP2K2.interfaces.Formable;

import java.util.ArrayList;
import java.util.Arrays;

public abstract class Zaposleni extends Identifiable implements Formable {
    private String sifraZaposlenog;
    private String ime;
    private String prezime;
    private double plata;

    public Zaposleni() {
        super();
    }

    public Zaposleni(String sifraZaposlenog, String ime, String prezime, double plata) {
        super();
        this.sifraZaposlenog = sifraZaposlenog;
        this.ime = ime;
        this.prezime = prezime;
        this.plata = plata;
    }

    public String getSifraZaposlenog() {
        return sifraZaposlenog;
    }

    public void setSifraZaposlenog(String sifraZaposlenog) {
        this.sifraZaposlenog = sifraZaposlenog;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public double getPlata() {
        return plata;
    }

    public void setPlata(double plata) {
        this.plata = plata;
    }

    @Override
    public void copy(Object o){
        Zaposleni z = (Zaposleni)o;
        this.sifraZaposlenog = z.sifraZaposlenog;
        this.ime = z.ime;
        this.prezime = z.prezime;
        this.plata = z.plata;
    }

    @Override
    public int numberOfAttributes() {
        return 4;
    }

    @Override
    public ArrayList<String> attributeNames() {
        return new ArrayList(Arrays.asList("Sifra zaposlenog", "Ime", "Prezime", "Plata"));
    }

    @Override
    public ArrayList<String> attributeTypes() {
        return new ArrayList(Arrays.asList("String", "String", "String", "Double"));
    }
}
