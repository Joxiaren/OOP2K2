package OOP2K2;

import OOP2K2.controllers.MainController;
import OOP2K2.data.Database;
import OOP2K2.models.BelaTehnika;
import OOP2K2.views.MainView;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatMTMoonlightIJTheme;

import javax.xml.crypto.Data;

public class App {
    private static Database database = new Database();
    public static void main(String[] args) {
        databaseSeed();

        FlatMTMoonlightIJTheme.setup();

        MainView mv = new MainView();
        MainController mc = new MainController(mv);

        mc.start();
    }

    private static void databaseSeed(){
        database.belaTehnikaList.add(new BelaTehnika());
    }
}
