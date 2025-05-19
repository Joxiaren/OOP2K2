package models;

import java.time.LocalDate;

public class KvarljivaRoba extends Roba{
    private LocalDate rokTrajanja;
    private String uputsvoZaSkladistenje;

    public KvarljivaRoba() {
        super();
    }

    public KvarljivaRoba(String naziv, double cena, String opis, LocalDate datumProizvodnje, double jedinicaMere, LocalDate rokTrajanja, String uputsvoZaSkladistenje) {
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
}
