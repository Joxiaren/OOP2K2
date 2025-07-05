package OOP2K2.controllers;

import OOP2K2.interfaces.Formable;
import OOP2K2.models.Identifiable;
import OOP2K2.views.TabView;

public class TabController<T extends Identifiable & Formable> {
    private TabView<T> tabView;
    private FormController<T> formController;

    public TabController(TabView<T> tabView,
                         FormController<T> formController){
        this.tabView = tabView;
        this.formController = formController;
    }
    public TabView<T> getTabView(){
        return tabView;
    };
    public void start(){
        formController.start();
        tabView.init();
    }

}
