package OOP2K2.models.converters;

import OOP2K2.interfaces.Converter;
import OOP2K2.models.Magacin;

public class MagacinConverter implements Converter<Magacin> {
    @Override
    public Magacin convert(Object[] data) {
        Magacin m = new Magacin();

        m.setNazivMagacina((String)data[0]);

        return m;
    }

    @Override
    public Object[] convert(Magacin magacin) {
        Object[] data = new Object[2];

        data[0] = magacin.getNazivMagacina();
        data[1] = null;

        return data;
    }
}
