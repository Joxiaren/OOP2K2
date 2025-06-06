package OOP2K2.models;

public abstract class Zaposleni  extends Identifiable{
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
}
