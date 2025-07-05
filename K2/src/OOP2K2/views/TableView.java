package OOP2K2.views;

import OOP2K2.interfaces.Formable;
import OOP2K2.models.Identifiable;
import OOP2K2.models.table_models.GenericTableModel;

import javax.swing.*;
import javax.swing.event.ListSelectionListener;
import java.awt.*;

public class TableView<T extends Identifiable & Formable> extends JTable {
    private final GenericTableModel<T> tableModel;

    public TableView(GenericTableModel<T> tableModel) {
        super(tableModel);
        this.tableModel = tableModel;
        this.setMinimumSize(new Dimension(1200, 600));
    }
    public void addUpdate(){
        tableModel.addUpdate();
    }
    public void removeUpdate(int index){
        tableModel.removeUpdate(index);
    }
    public void updateUpdate(int index){
        tableModel.updateModel(index);
    }
    public void addSelectionListener(ListSelectionListener al){
        this.getSelectionModel().addListSelectionListener(al);
    }
    public void init(){

    }
}
