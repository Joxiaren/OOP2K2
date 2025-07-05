package OOP2K2.models.table_models;

import OOP2K2.models.IdentifiableList;
import OOP2K2.models.Roba;

import java.util.ArrayList;

public class RobaTableModel extends GenericTableModel<Roba> {

    public RobaTableModel(IdentifiableList<Roba> modelList, int numberOfAttributes, ArrayList<String> attributeNames, ArrayList<String> attributeTypes) {
        super(modelList, numberOfAttributes, attributeNames, attributeTypes);
    }

    @Override
    public String getColumnName(int column){
        if(column == 0) return "Naziv";
        if(column == 1) return "Cena";
        if(column == 2) return "Opis";
        if(column == 3) return "Datum Proizvodnje0";
        if(column == 4) return "Jedinica Mere";

        return "";
    }
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Roba r = modelList.readIndex(rowIndex);

        if(columnIndex == 0) return r.getNaziv();
        if(columnIndex == 1) return r.getCena();
        if(columnIndex == 2) return r.getOpis();
        if(columnIndex == 3) return r.getDatumProizvodnje();
        if(columnIndex == 4) return r.getJedinicaMere();

        return null;
    }
}
