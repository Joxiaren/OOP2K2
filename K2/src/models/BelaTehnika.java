package models;

import java.time.LocalDate;

public class BelaTehnika extends Roba{
     private double xDim;
     private double yDim;
     private double zDim;
     private double radniNapon;
     private double nominalnaSnaga;

    public BelaTehnika() {
        super();
    }

    public BelaTehnika(String naziv, double cena, String opis, LocalDate datumProizvodnje, double jedinicaMere, double xDim, double yDim, double zDim, double radniNapon, double nominalnaSnaga) {
        super(naziv, cena, opis, datumProizvodnje, jedinicaMere);
        this.xDim = xDim;
        this.yDim = yDim;
        this.zDim = zDim;
        this.radniNapon = radniNapon;
        this.nominalnaSnaga = nominalnaSnaga;
    }

    public double getxDim() {
        return xDim;
    }

    public void setxDim(double xDim) {
        this.xDim = xDim;
    }

    public double getyDim() {
        return yDim;
    }

    public void setyDim(double yDim) {
        this.yDim = yDim;
    }

    public double getzDim() {
        return zDim;
    }

    public void setzDim(double zDim) {
        this.zDim = zDim;
    }

    public double getRadniNapon() {
        return radniNapon;
    }

    public void setRadniNapon(double radniNapon) {
        this.radniNapon = radniNapon;
    }

    public double getNominalnaSnaga() {
        return nominalnaSnaga;
    }

    public void setNominalnaSnaga(double nominalnaSnaga) {
        this.nominalnaSnaga = nominalnaSnaga;
    }
}
