package OOP2K2.controllers;

import OOP2K2.data.Database;
import OOP2K2.interfaces.Formable;
import OOP2K2.models.Identifiable;
import OOP2K2.models.IdentifiableList;
import OOP2K2.interfaces.Converter;
import OOP2K2.models.Magacin;
import OOP2K2.views.FormView;
import OOP2K2.views.PregledRobeView;
import OOP2K2.views.TableView;

import java.util.ArrayList;


public class FormController<T extends Identifiable & Formable> {
    private FormView<T> formView;
    private TableView<T> tableView;
    private PregledRobeView pregledRobeView;
    private Converter<T> converter;
    private int selectedIndex = -1;
    private T selected = null;
    private Database database;
    private IdentifiableList<T> modelList;

    public FormController(FormView<T> formView,
                          TableView<T> tableView,
                          PregledRobeView pregledRobeView,
                          Converter<T> converter,
                          T t,
                          Database database){
        this.formView = formView;
        this.tableView = tableView;
        this.converter = converter;
        this.database = database;

        this.pregledRobeView = pregledRobeView;
        this.modelList = (IdentifiableList<T>)database.getList(t.getClass());
    }
    public FormView<T> getFormView(){ return formView;}
    public void start(){
        this.formView.addPregledRobeButtonListener((e) ->{
            if(selected == null) return;

            this.pregledRobeView.setMagacin((Magacin)selected);
            this.pregledRobeView.init();
        });

        this.formView.init();

        this.setAddButton();
        this.setDeleteButton();


        this.tableView.addSelectionListener((e) -> {
            if(e.getValueIsAdjusting()) return;

            selectedIndex = tableView.getSelectedRow();
            if(selectedIndex == -1 || selectedIndex >= this.modelList.size()){
                System.out.println("Unselected");
                this.setAddButton();
                return;
            }

            this.selected = this.modelList.readIndex(selectedIndex);
            this.formView.setData(converter.convert(this.selected));
            this.setUpdateButton();
        });
    }
    public void setAddButton(){
        this.formView.setButtonText("Add");
        this.formView.removeConfirmButtonListener();
        this.formView.addConfirmButtonListener((e) ->{
            this.add(this.formView.getData());
        });
    }
    public void setUpdateButton(){
        this.formView.setButtonText("Update");
        this.formView.removeConfirmButtonListener();
        this.formView.addConfirmButtonListener((e) ->{
            this.update(this.selected.getID(), this.formView.getData());
        });
    }
    public void setDeleteButton(){
        this.formView.addDeleteButtonListener((e) ->{
            if(this.selected == null) this.formView.showMessage("Nothing is selected");

            this.delete(this.selected.getID());
            this.tableView.removeUpdate(this.selectedIndex);
        });
    }
    public boolean update(long id, Object[] data){
        T toUpdate = this.modelList.read(id);
        T fromUpdate = converter.convert(data);

        toUpdate.copy(fromUpdate);

        this.tableView.updateUpdate(selectedIndex);
        return true;
    }
    public boolean add(Object[] data){
        T t = converter.convert(data);
        this.modelList.add(t);
        this.tableView.addUpdate();
        return true;
    }
    public boolean delete(long id){
        this.tableView.removeUpdate(selectedIndex);
        this.modelList.delete(id);
        return true;
    }
    public T read(long id){
        return this.modelList.read(id);
    }
    public Object[] readFormData(long id) { return converter.convert(this.modelList.read(id));}
    public ArrayList<T> readAll(){
        return this.modelList.readAll();
    }

}
