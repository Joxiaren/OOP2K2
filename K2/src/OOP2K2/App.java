package OOP2K2;

import OOP2K2.controllers.MainController;
import OOP2K2.views.MainView;

public class App {
    public static void main(String[] args) {

        MainView mv = new MainView();
        MainController mc = new MainController(mv);

        mc.start();
    }
}
