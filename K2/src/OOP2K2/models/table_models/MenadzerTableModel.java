package OOP2K2.models.table_models;

import OOP2K2.models.IdentifiableList;
import OOP2K2.models.Menadzer;

import java.util.ArrayList;

public class MenadzerTableModel extends GenericTableModel<Menadzer>{
    public MenadzerTableModel(IdentifiableList<Menadzer> modelList, int numberOfAttributes, ArrayList<String> attributeNames, ArrayList<String> attributeTypes) {
        super(modelList, numberOfAttributes, attributeNames, attributeTypes);
    }

    @Override
    public int getColumnCount(){
        return super.getColumnCount() + 1;
    }
    @Override
    public int getRowCount(){
        return super.getRowCount() + 4;
    }
    @Override
    public String getColumnName(int column){
        column -= 1;
        if(column == -1) return "";
        if(column == 0) return "Sifra Zaposlenog";
        if(column == 1) return "Ime";
        if(column == 2) return "Prezime";
        if(column == 3) return "Plata";
        if(column == 4) return "Magacin";

        return "";
    }
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        columnIndex -= 1;
        if(rowIndex > this.modelList.size() - 1){
            rowIndex -= (this.modelList.size());
            if(columnIndex == -1){
                if(rowIndex == 0) return "Suma:";
                if(rowIndex == 1) return "Srednja Vrednost:";
                if(rowIndex == 2) return "Min:";
                if(rowIndex == 3) return "Max:";

                return "";
            }
            if(!this.attributeTypes.get(columnIndex).equals("Integer") && !this.attributeTypes.get(columnIndex).equals("Double")) return "";

            if(rowIndex == 0) return this.sumColumn(columnIndex+1);
            if(rowIndex == 1) return this.meanColumn(columnIndex+1);
            if(rowIndex == 2) return this.minColumn(columnIndex+1);
            if(rowIndex == 3) return this.maxColumn(columnIndex+1);

            return "";
        }
        Menadzer m = this.modelList.readIndex(rowIndex);

        if(columnIndex == 0) return m.getSifraZaposlenog();
        if(columnIndex == 1) return m.getIme();
        if(columnIndex == 2) return m.getPrezime();
        if(columnIndex == 3) return m.getPlata();
        if(columnIndex == 4) {
            if(m.getMagacin() == null) return null;
            return m.getMagacin().getNazivMagacina();
        }

        return null;
    }
}
