package OOP2K2.models.converters;

import OOP2K2.interfaces.Converter;
import OOP2K2.models.Magacin;
import OOP2K2.models.Menadzer;

public class MenadzerConverter implements Converter<Menadzer> {
    @Override
    public Menadzer convert(Object[] data) {
        Menadzer m = new Menadzer();

        m.setSifraZaposlenog((String)data[0]);
        m.setIme((String)data[1]);
        m.setPrezime((String)data[2]);
        m.setPlata((double)data[3]);
        m.setMagacin((Magacin)data[4]);

        return m;
    }

    @Override
    public Object[] convert(Menadzer menadzer) {
        Object[] data = new Object[5];

        data[0] = menadzer.getSifraZaposlenog();
        data[1] = menadzer.getIme();
        data[2] = menadzer.getPrezime();
        data[3] = menadzer.getPlata();
        data[4] = menadzer.getMagacin();

        return data;
    }
}
