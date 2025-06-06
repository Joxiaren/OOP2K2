package OOP2K2.models;

import java.util.ArrayList;

public class Magacin {

    private String nazivMagacina;
    private ArrayList<Roba> robaUMagacinu = new ArrayList<Roba>();


    public Magacin() {
        super();
    }

    public Magacin(String nazivMagacina) {
        super();
        this.nazivMagacina = nazivMagacina;
    }

    public Magacin(String nazivMagacina, ArrayList<Roba> robaUMagacinu) {
        super();
        this.nazivMagacina = nazivMagacina;
        this.robaUMagacinu = robaUMagacinu;
    }

    public String getNazivMagacina() {
        return nazivMagacina;
    }

    public void setNazivMagacina(String nazivMagacina) {
        this.nazivMagacina = nazivMagacina;
    }

    public void addRoba(Roba r){
        this.robaUMagacinu.add(r);
    }
    public Roba getRoba(int index){
        return this.robaUMagacinu.get(index);
    }
    public void removeRoba(int index){
        this.robaUMagacinu.remove(index);
    }
    public void removeRoba(Roba r){
        this.robaUMagacinu.remove(r);
    }
}
