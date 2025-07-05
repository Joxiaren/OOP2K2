package OOP2K2.models.converters;

import OOP2K2.interfaces.Converter;
import OOP2K2.models.KvarljivaRoba;

import java.time.LocalDate;

public class KvarljivaRobaConverter implements Converter<KvarljivaRoba> {

    @Override
    public KvarljivaRoba convert(Object[] data) {
        KvarljivaRoba kr = new KvarljivaRoba();

        kr.setNaziv((String)data[0]);
        kr.setCena((double)data[1]);
        kr.setOpis((String)data[2]);
        kr.setDatumProizvodnje((LocalDate)data[3]);
        kr.setJedinicaMere((String)data[4]);
        kr.setRokTrajanja((LocalDate)data[5]);
        kr.setUputsvoZaSkladistenje((String)data[6]);

        return kr;
    }

    @Override
    public Object[] convert(KvarljivaRoba kvarljivaRoba) {
        Object[] data = new Object[7];

        data[0] = kvarljivaRoba.getNaziv();
        data[1] = kvarljivaRoba.getCena();
        data[2] = kvarljivaRoba.getOpis();
        data[3] = kvarljivaRoba.getDatumProizvodnje();
        data[4] = kvarljivaRoba.getJedinicaMere();
        data[5] = kvarljivaRoba.getRokTrajanja();
        data[6] = kvarljivaRoba.getUputsvoZaSkladistenje();

        return data;
    }
}
