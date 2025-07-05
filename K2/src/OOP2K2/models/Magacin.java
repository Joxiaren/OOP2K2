package OOP2K2.models;

import OOP2K2.interfaces.Formable;

import java.util.ArrayList;
import java.util.Arrays;

public class Magacin extends Identifiable implements Formable {

    private String nazivMagacina;
    private ArrayList<Roba> robaUMagacinu = new ArrayList<>();


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
    public ArrayList<Roba> getAllRoba() {
        return this.robaUMagacinu;
    }
    public void removeRoba(int index){
        this.robaUMagacinu.remove(index);
    }
    public void removeRoba(Roba r){
        this.robaUMagacinu.remove(r);
    }

    @Override
    public String toString(){
        return this.getNazivMagacina();
    }
    @Override
    public void copy(Object from){
        Magacin m = (Magacin)from;
        this.nazivMagacina = m.nazivMagacina;
        this.robaUMagacinu = m.robaUMagacinu;
    }
    @Override
    public int numberOfAttributes() {
        return 2;
    }

    @Override
    public ArrayList<String> attributeNames() {
        return new ArrayList(Arrays.asList("Naziv magacina", "Roba u Magacinu"));
    }

    @Override
    public ArrayList<String>  attributeTypes() {
        return new ArrayList(Arrays.asList("String", "List:Roba"));
    }
}
