package OOP2K2.models.table_models;

import OOP2K2.models.IdentifiableList;
import OOP2K2.models.Magacioner;

import java.util.ArrayList;

public class MagacionerTableModel extends GenericTableModel<Magacioner>{
    public MagacionerTableModel(IdentifiableList<Magacioner> modelList, int numberOfAttributes, ArrayList<String> attributeNames, ArrayList<String> attributeTypes) {
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
        if(column == 4) return "Broj odmora";
        if(column == 5) return "Radno Mesto";

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
            if(this.attributeTypes.get(columnIndex).equals("Integer")){
                if(rowIndex == 0) return this.sumColumnInt(columnIndex+1);
                if(rowIndex == 1) return this.meanColumnInt(columnIndex+1);
                if(rowIndex == 2) return this.minColumnInt(columnIndex+1);
                if(rowIndex == 3) return this.maxColumnInt(columnIndex+1);
            }
            if(this.attributeTypes.get(columnIndex).equals("Double")){
                if(rowIndex == 0) return this.sumColumn(columnIndex+1);
                if(rowIndex == 1) return this.meanColumn(columnIndex+1);
                if(rowIndex == 2) return this.minColumn(columnIndex+1);
                if(rowIndex == 3) return this.maxColumn(columnIndex+1);
            }


            return "";
        }
        Magacioner m = this.modelList.readIndex(rowIndex);

        if(columnIndex == 0) return m.getSifraZaposlenog();
        if(columnIndex == 1) return m.getIme();
        if(columnIndex == 2) return m.getPrezime();
        if(columnIndex == 3) return m.getPlata();
        if(columnIndex == 4) return m.getOdmori();
        if(columnIndex == 5) {
            if(m.getRadnoMesto() == null) return null;
            return m.getRadnoMesto().getNazivMagacina();
        }

        return null;
    }
}
