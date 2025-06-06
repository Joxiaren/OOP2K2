package OOP2K2.controllers;

import OOP2K2.views.MainView;

public class MainController {
    private MainView mainView;

    public MainController(MainView mainView){
        this.mainView = mainView;

        this.mainView.init();
    }
    public void start(){
        this.mainView.start();
    }
}
