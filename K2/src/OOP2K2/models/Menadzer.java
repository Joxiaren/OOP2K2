package OOP2K2.models;

public class Menadzer extends Zaposleni {
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
}
