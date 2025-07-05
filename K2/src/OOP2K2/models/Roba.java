package OOP2K2.models;

import OOP2K2.interfaces.Formable;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

public abstract class Roba extends Identifiable implements Formable {
    private String naziv;
    private double cena;
    private String opis;
    private LocalDate datumProizvodnje;
    private String jedinicaMere;

    public Roba() {
        super();
    }

    public Roba(String naziv, double cena, String opis, LocalDate datumProizvodnje, String jedinicaMere) {
        super();
        this.naziv = naziv;
        this.cena = cena;
        this.opis = opis;
        this.datumProizvodnje = datumProizvodnje;
        this.jedinicaMere = jedinicaMere;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public LocalDate getDatumProizvodnje() {
        return datumProizvodnje;
    }

    public void setDatumProizvodnje(LocalDate datumProizvodnje) {
        this.datumProizvodnje = datumProizvodnje;
    }

    public String getJedinicaMere() {
        return jedinicaMere;
    }

    public void setJedinicaMere(String jedinicaMere) {
        this.jedinicaMere = jedinicaMere;
    }

    @Override
    public void copy(Object o){
        Roba r = (Roba)o;
        this.naziv = r.naziv;
        this.cena = r.cena;
        this.opis = r.opis;
        this.datumProizvodnje = r.datumProizvodnje;
        this.jedinicaMere = r.jedinicaMere;
    }
    @Override
    public int numberOfAttributes() {
        return 5;
    }

    @Override
    public ArrayList<String> attributeNames() {
        return new ArrayList(Arrays.asList("Naziv", "Cena", "Opis", "Datum proizvodnje", "Jedinica mere"));
    }

    @Override
    public ArrayList<String> attributeTypes() {
        return new ArrayList(Arrays.asList("String", "Double", "String", "LocalDate", "String"));
    }

    @Override
    public String toString() {
        return getNaziv();
    }
}
