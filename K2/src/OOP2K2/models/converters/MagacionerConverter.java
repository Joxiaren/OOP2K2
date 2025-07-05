package OOP2K2.models.converters;

import OOP2K2.interfaces.Converter;
import OOP2K2.models.Magacin;
import OOP2K2.models.Magacioner;

public class MagacionerConverter implements Converter<Magacioner> {
    @Override
    public Magacioner convert(Object[] data) {
        Magacioner m = new Magacioner();

        m.setSifraZaposlenog((String)data[0]);
        m.setIme((String)data[1]);
        m.setPrezime((String)data[2]);
        m.setPlata((double)data[3]);
        m.setOdmori((int)data[4]);
        m.setRadnoMesto((Magacin)data[5]);

        return m;
    }

    @Override
    public Object[] convert(Magacioner magacioner) {
        Object[] data = new Object[6];

        data[0] = magacioner.getSifraZaposlenog();
        data[1] = magacioner.getIme();
        data[2] = magacioner.getPrezime();
        data[3] = magacioner.getPlata();
        data[4] = magacioner.getOdmori();
        data[5] = magacioner.getRadnoMesto();

        return data;
    }
}
