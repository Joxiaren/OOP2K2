package OOP2K2.models.converters;

import OOP2K2.interfaces.Converter;
import OOP2K2.models.BelaTehnika;

import java.time.LocalDate;

public class BelaTehnikaConverter implements Converter<BelaTehnika> {
    @Override
    public BelaTehnika convert(Object[] data) {
        BelaTehnika belaTehnika = new BelaTehnika();

        belaTehnika.setNaziv((String)data[0]);
        belaTehnika.setCena((double)data[1]);
        belaTehnika.setOpis((String)data[2]);
        belaTehnika.setDatumProizvodnje((LocalDate)data[3]);
        belaTehnika.setJedinicaMere((String)data[4]);
        belaTehnika.setxDim((double)data[5]);
        belaTehnika.setyDim((double)data[6]);
        belaTehnika.setzDim((double)data[7]);
        belaTehnika.setRadniNapon((double)data[8]);
        belaTehnika.setNominalnaSnaga((double)data[9]);

        return belaTehnika;
    }

    @Override
    public Object[] convert(BelaTehnika belaTehnika) {
        Object[] data = new Object[10];

        data[0] = belaTehnika.getNaziv();
        data[1] = belaTehnika.getCena();
        data[2] = belaTehnika.getOpis();
        data[3] = belaTehnika.getDatumProizvodnje();
        data[4] = belaTehnika.getJedinicaMere();
        data[5] = belaTehnika.getxDim();
        data[6] = belaTehnika.getyDim();
        data[7] = belaTehnika.getzDim();
        data[8] = belaTehnika.getRadniNapon();
        data[9] = belaTehnika.getNominalnaSnaga();

        return data;
    }
}
