package OOP2K2.controllers;

import OOP2K2.models.*;
import OOP2K2.views.FormView;
import OOP2K2.views.MainView;
import OOP2K2.views.TabView;

public class MainController {
    private MainView mainView;
    private final TabController<BelaTehnika> btTabController;
    private final TabController<KvarljivaRoba> krTabController;
    private final TabController<Magacin> magacinTabController;
    private final TabController<Magacioner> magacionerTabController;
    private final TabController<Menadzer> menadzerTabController;
    public MainController(MainView mainView,
                          TabController<BelaTehnika> btTabController,
                          TabController<KvarljivaRoba> krTabController,
                          TabController<Magacin> magacinTabController,
                          TabController<Magacioner> magacionerTabController,
                          TabController<Menadzer> meandzerTabController){
        this.mainView = mainView;

        this.btTabController = btTabController;
        this.krTabController = krTabController;
        this.magacinTabController = magacinTabController;
        this.magacionerTabController = magacionerTabController;
        this.menadzerTabController = meandzerTabController;

        this.btTabController.start();
        this.krTabController.start();
        this.magacinTabController.start();
        this.magacionerTabController.start();
        this.menadzerTabController.start();

        this.mainView.addTab("Bela Tehnika", this.btTabController.getTabView());
        this.mainView.addTab("Kvarljiva Roba", this.krTabController.getTabView());
        this.mainView.addTab("Magacini", this.magacinTabController.getTabView());
        this.mainView.addTab("Magacioneri", this.magacionerTabController.getTabView());
        this.mainView.addTab("Menadzeri", this.menadzerTabController.getTabView());

        this.mainView.init();
    }
    public void start(){
        this.mainView.start();
    }
}
