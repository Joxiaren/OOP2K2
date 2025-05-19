package models;

import java.time.LocalDate;

public class Roba {
    private String naziv;
    private double cena;
    private String opis;
    private LocalDate datumProizvodnje;
    private double jedinicaMere;

    public Roba() {
        super();
    }

    public Roba(String naziv, double cena, String opis, LocalDate datumProizvodnje, double jedinicaMere) {
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

    public double getJedinicaMere() {
        return jedinicaMere;
    }

    public void setJedinicaMere(double jedinicaMere) {
        this.jedinicaMere = jedinicaMere;
    }
}
