package OOP2K2.models.table_models;

import OOP2K2.models.BelaTehnika;
import OOP2K2.models.IdentifiableList;

import java.util.ArrayList;

public class BelaTehnikaTableModel extends GenericTableModel<BelaTehnika>{
    public BelaTehnikaTableModel(IdentifiableList<BelaTehnika> modelList, int numberOfAttributes, ArrayList<String> attributeNames, ArrayList<String> attributeTypes) {
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
    public String getColumnName(int column) {
        column -= 1;
        if(column == -1) return "";
        if(column == 0) return "Naziv";
        if(column == 1) return "Cena";
        if(column == 2) return "Opis";
        if(column == 3) return "Datum Proizvodnje0";
        if(column == 4) return "Jedinica Mere";
        if(column == 5) return "X";
        if(column == 6) return "Y";
        if(column == 7) return "Z";
        if(column == 8) return "Radni Napon";
        if(column == 9) return "Nominalna Snaga";

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
        BelaTehnika bt = this.modelList.readIndex(rowIndex);

        if(columnIndex == -1) return "";
        if(columnIndex == 0) return bt.getNaziv();
        if(columnIndex == 1) return bt.getCena();
        if(columnIndex == 2) return bt.getOpis();
        if(columnIndex == 3) return bt.getDatumProizvodnje();
        if(columnIndex == 4) return bt.getJedinicaMere();
        if(columnIndex == 5) return bt.getxDim();
        if(columnIndex == 6) return bt.getyDim();
        if(columnIndex == 7) return bt.getzDim();
        if(columnIndex == 8) return bt.getRadniNapon();
        if(columnIndex == 9) return bt.getNominalnaSnaga();

        return null;
    }
}
