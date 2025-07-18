package OOP2K2.models;

import OOP2K2.interfaces.Formable;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

public class BelaTehnika extends Roba implements Formable {
     private double xDim;
     private double yDim;
     private double zDim;
     private double radniNapon;
     private double nominalnaSnaga;

    public BelaTehnika() {
        super();
    }

    public BelaTehnika(String naziv, double cena, String opis, LocalDate datumProizvodnje, String jedinicaMere, double xDim, double yDim, double zDim, double radniNapon, double nominalnaSnaga) {
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

    @Override
    public void copy(Object from){
        super.copy(from);

        BelaTehnika bt = (BelaTehnika)from;

        this.nominalnaSnaga = bt.nominalnaSnaga;
        this.radniNapon = bt.radniNapon;
        this.xDim = bt.xDim;
        this.yDim = bt.yDim;
        this.zDim = bt.zDim;
    }
    @Override
    public int numberOfAttributes() {
        return super.numberOfAttributes() + 5;
    }

    @Override
    public ArrayList<String> attributeNames() {
        ArrayList<String> ret = super.attributeNames();
        ret.addAll(Arrays.asList("XDim", "YDim", "ZDim", "Radni Napon", "Nominalna Snaga"));
        return ret;
    }

    @Override
    public ArrayList<String> attributeTypes() {
        ArrayList<String> ret = super.attributeTypes();
        ret.addAll(Arrays.asList("Double", "Double", "Double", "Double", "Double"));
        return ret;
    }
}
