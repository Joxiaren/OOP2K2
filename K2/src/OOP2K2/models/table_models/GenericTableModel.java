package OOP2K2.models.table_models;

import OOP2K2.interfaces.Formable;
import OOP2K2.models.Identifiable;
import OOP2K2.models.IdentifiableList;

import javax.swing.table.AbstractTableModel;
import java.io.Serial;
import java.util.ArrayList;

public abstract class GenericTableModel<T extends Identifiable & Formable> extends AbstractTableModel {
    @Serial
    private static final long serialVersionUID = 7476022180529920289L;
    protected IdentifiableList<T> modelList;
    protected final int numberOfAttributes;
    protected final ArrayList<String> attributeNames;
    protected final ArrayList<String> attributeTypes;

    public GenericTableModel(IdentifiableList<T> modelList,
                             int numberOfAttributes,
                             ArrayList<String> attributeNames,
                             ArrayList<String> attributeTypes){
        super();
        this.modelList = modelList;
        this.numberOfAttributes = numberOfAttributes;
        this.attributeNames = attributeNames;
        this.attributeTypes = attributeTypes;

    }
    public void updateModelList(ArrayList<T> list){
        this.modelList = new IdentifiableList<>(list);
        fireTableDataChanged();
        fireTableStructureChanged();
    }
    public void addModel(T model){
        modelList.add(model);
        fireTableRowsInserted(this.modelList.size() - 1, this.modelList.size() - 1);
    }
    public T getModel(int index){
        return this.modelList.readIndex(index);
    }
    public void updateModel(int index){
        fireTableRowsUpdated(index, index);
        this.recalculate();
    }
    public void removeModel(int index){
        modelList.deleteIndex(index);
        fireTableRowsDeleted(index, index);
        this.recalculate();
    }
    public void addUpdate(){
        fireTableRowsInserted(this.modelList.size() - 1, this.modelList.size() - 1);
        this.recalculate();
    }
    public void removeUpdate(int index){
        fireTableRowsDeleted(index, index);
        this.recalculate();
    }

    public void recalculate(){
        fireTableRowsUpdated(modelList.size(), modelList.size() + 3);
    }
    public double sumColumn(int column){
        double sum = 0.0;

        for(int j = 0; j < this.modelList.size(); j++){
            sum += (Double)this.getValueAt(j, column);
        }

        return sum;
    }
    public double meanColumn(int column){
        return sumColumn(column) / (this.modelList.size());
    }
    public double minColumn(int column){
        double minValue = (Double)this.getValueAt(0, column);

        for(int j = 1; j < this.modelList.size(); j++) minValue = Math.min(minValue, (Double) this.getValueAt(j, column));

        return minValue;
    }
    public double maxColumn(int column){
        double maxValue = (Double)this.getValueAt(0, column);

        for(int j = 1; j < this.modelList.size(); j++) maxValue = Math.max(maxValue, (Double) this.getValueAt(j, column));

        return maxValue;
    }
    public int sumColumnInt(int column){
        int sum = 0;

        for(int j = 0; j < this.modelList.size(); j++){
            sum += (int)this.getValueAt(j, column);
        }

        return sum;
    }
    public double meanColumnInt(int column){
        return (double)sumColumnInt(column) / (this.modelList.size());
    }
    public int minColumnInt(int column){
        int minValue = (int)this.getValueAt(0, column);

        for(int j = 1; j < this.modelList.size(); j++) minValue = Math.min(minValue, (int) this.getValueAt(j, column));

        return minValue;
    }
    public int maxColumnInt(int column){
        int maxValue = (int)this.getValueAt(0, column);

        for(int j = 1; j < this.modelList.size(); j++) maxValue = Math.max(maxValue, (int) this.getValueAt(j, column));

        return maxValue;
    }
    @Override
    public int getRowCount() {
        return modelList.size();
    }

    @Override
    public int getColumnCount() {
        return this.numberOfAttributes;
    }
}
