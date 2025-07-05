package OOP2K2.models.table_models;

import OOP2K2.models.IdentifiableList;
import OOP2K2.models.KvarljivaRoba;

import java.util.ArrayList;

public class KvarljivaRobaTableModel extends GenericTableModel<KvarljivaRoba>{
    public KvarljivaRobaTableModel(IdentifiableList<KvarljivaRoba> modelList, int numberOfAttributes, ArrayList<String> attributeNames, ArrayList<String> attributeTypes) {
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
        if(column == 0) return "Naziv";
        if(column == 1) return "Cena";
        if(column == 2) return "Opis";
        if(column == 3) return "Datum Proizvodnje";
        if(column == 4) return "Jedinica Mere";
        if(column == 5) return "Rok Trajanja";
        if(column == 6) return "Uputsvo za Skladistenje";
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
        KvarljivaRoba kr = this.modelList.readIndex(rowIndex);

        if(columnIndex == 0) return kr.getNaziv();
        if(columnIndex == 1) return kr.getCena();
        if(columnIndex == 2) return kr.getOpis();
        if(columnIndex == 3) return kr.getDatumProizvodnje();
        if(columnIndex == 4) return kr.getJedinicaMere();
        if(columnIndex == 5) return kr.getRokTrajanja();
        if(columnIndex == 6) return kr.getUputsvoZaSkladistenje();

        return null;
    }
}
