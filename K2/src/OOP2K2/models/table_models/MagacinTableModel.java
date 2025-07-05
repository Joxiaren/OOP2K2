package OOP2K2.models.table_models;

import OOP2K2.models.IdentifiableList;
import OOP2K2.models.Magacin;

import java.util.ArrayList;

public class MagacinTableModel extends GenericTableModel<Magacin>{
    public MagacinTableModel(IdentifiableList<Magacin> modelList, int numberOfAttributes, ArrayList<String> attributeNames, ArrayList<String> attributeTypes) {
        super(modelList, numberOfAttributes, attributeNames, attributeTypes);
    }

    @Override
    public int getColumnCount() { return 1; }
    @Override
    public String getColumnName(int column){
        if(column == 0) return "Naziv Magacina";
        return "";
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Magacin m = this.modelList.readIndex(rowIndex);

        if(columnIndex == 0) return m.getNazivMagacina();

        return null;
    }
}
