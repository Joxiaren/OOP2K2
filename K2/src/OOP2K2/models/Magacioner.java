package OOP2K2.models;

public class Magacioner extends Zaposleni{
    private int odmori;
    private Magacin radnoMesto;
    public Magacioner() {
        super();
    }
    public Magacioner(String sifraZaposlenog, String ime, String prezime, double plata, int odmori, Magacin radnoMesto) {
        super(sifraZaposlenog, ime, prezime, plata);
        this.odmori = odmori;
        this.radnoMesto = radnoMesto;
    }

    public int getOdmori() {
        return odmori;
    }

    public void setOdmori(int odmori) {
        this.odmori = odmori;
    }

    public Magacin getRadnoMesto() {
        return radnoMesto;
    }

    public void setRadnoMesto(Magacin radnoMesto) {
        this.radnoMesto = radnoMesto;
    }
}
