package OOP2K2;

import OOP2K2.controllers.*;
import OOP2K2.data.*;
import OOP2K2.models.*;
import OOP2K2.models.converters.*;
import OOP2K2.models.table_models.*;
import OOP2K2.views.*;

import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatMTMoonlightIJTheme;

import javax.swing.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

public class App {
    private final static Database database = new Database();
    public static void main(String[] args) {
        FlatMTMoonlightIJTheme.setup();

        JComboBox<Roba> robaJComboBox = new JComboBox<>();
        database.robaList.addAddEvent((item) ->{
            robaJComboBox.addItem(item);
        });
        database.robaList.addDeleteEvent((item) -> {
            robaJComboBox.removeItem(item);
        });
        
        databaseSeed();

        BelaTehnika bt = new BelaTehnika();
        KvarljivaRoba kr = new KvarljivaRoba();
        Magacin magacin = new Magacin();
        Magacioner magacioner = new Magacioner();
        Menadzer menadzer = new Menadzer();

        PregledRobeView pregledRobeView = new PregledRobeView(robaJComboBox);

        FormView<BelaTehnika> belaTehnikaView = new FormView<>(bt, database);
        FormView<KvarljivaRoba> kvarljivaRobaView = new FormView<>(kr, database);
        FormView<Magacin> magacinView = new FormView<>(magacin, database);
        FormView<Magacioner> magacionerView = new FormView<>(magacioner, database);
        FormView<Menadzer> menadzerView = new FormView<>(menadzer, database);

        TableView<BelaTehnika> belaTehnikaTableView = new TableView<>(
                new BelaTehnikaTableModel(
                        database.belaTehnikaList,
                        bt.numberOfAttributes(),
                        bt.attributeNames(),
                        bt.attributeTypes()));

        TableView<KvarljivaRoba> kvarljivaRobaTableView = new TableView<>(
                new KvarljivaRobaTableModel(
                        database.kvarljivaRobaList,
                        kr.numberOfAttributes(),
                        kr.attributeNames(),
                        kr.attributeTypes()));

        TableView<Magacin> magacinTableView = new TableView<>(
                new MagacinTableModel(
                        database.magacinList,
                        magacin.numberOfAttributes(),
                        magacin.attributeNames(),
                        magacin.attributeTypes()));

        TableView<Magacioner> magacionerTableView = new TableView<>(
                new MagacionerTableModel(
                        database.magacionerList,
                        magacioner.numberOfAttributes(),
                        magacioner.attributeNames(),
                        magacioner.attributeTypes()));

        TableView<Menadzer> menadzerTableView = new TableView<>(
                new MenadzerTableModel(
                        database.menadzerList,
                        menadzer.numberOfAttributes(),
                        menadzer.attributeNames(),
                        menadzer.attributeTypes()));


        TabView<BelaTehnika> belaTehnikaTabView = new TabView<>(belaTehnikaView, belaTehnikaTableView);
        TabView<KvarljivaRoba> kvarljivaRobaTabView = new TabView<>(kvarljivaRobaView, kvarljivaRobaTableView);
        TabView<Magacin> magacinTabView = new TabView<>(magacinView, magacinTableView);
        TabView<Magacioner> magacionerTabView = new TabView<>(magacionerView, magacionerTableView);
        TabView<Menadzer> menadzerTabView = new TabView<>(menadzerView, menadzerTableView);


        MainView mv = new MainView();

        FormController<BelaTehnika> btController = new FormController<>(belaTehnikaView, belaTehnikaTableView, pregledRobeView, new BelaTehnikaConverter(), bt, database);
        FormController<KvarljivaRoba> krController = new FormController<>(kvarljivaRobaView, kvarljivaRobaTableView, pregledRobeView, new KvarljivaRobaConverter(), kr, database);
        FormController<Magacin> magacinController = new FormController<>(magacinView, magacinTableView, pregledRobeView, new MagacinConverter(), magacin, database);
        FormController<Magacioner> magacionerController = new FormController<>(magacionerView, magacionerTableView, pregledRobeView, new MagacionerConverter(), magacioner, database);
        FormController<Menadzer> menadzerController = new FormController<>(menadzerView, menadzerTableView, pregledRobeView, new MenadzerConverter(), menadzer, database);

        TabController<BelaTehnika> btTabController = new TabController<>(belaTehnikaTabView, btController);
        TabController<KvarljivaRoba> krTabController = new TabController<>(kvarljivaRobaTabView, krController);
        TabController<Magacin> magacinTabController = new TabController<>(magacinTabView, magacinController);
        TabController<Magacioner> magacionerTabController = new TabController<>(magacionerTabView, magacionerController);
        TabController<Menadzer> menadzerTabController = new TabController<>(menadzerTabView, menadzerController);

        MainController mc = new MainController(
                    mv,
                    btTabController,
                    krTabController,
                    magacinTabController,
                    magacionerTabController,
                    menadzerTabController
                );

        mc.start();
    }

    private static void databaseSeed(){

        database.belaTehnikaList.add(new BelaTehnika(
                "Frizider51",
                5000.0,
                "Hladan frizider",
                LocalDate.of(2024,10,20),
                "kwh",
                100.0,
                200.0,
                100.0,
                20.0,
                40.0));
        database.belaTehnikaList.add(new BelaTehnika(
                "Sporet",
                5200.0,
                "Vreo sporet",
                LocalDate.of(2024,10,22),
                "kwh",
                100.0,
                200.0,
                100.0,
                120.0,
                340.0));
        database.belaTehnikaList.add(new BelaTehnika(
                "Ves masina",
                5000.0,
                "Prljav ves cini manje prljavim",
                LocalDate.of(2025,10,20),
                "N",
                140.0,
                200.0,
                120.0,
                22.0,
                411.0));

        database.kvarljivaRobaList.add(new KvarljivaRoba(
                "Paradajz",
                50.0,
                "Svez paradajz idealan za salatu",
                LocalDate.of(2002, 5, 10),
                "g",
                LocalDate.of(2026, 1, 1),
                "Cuvati na hladnom i tamnom mestu"));
        database.kvarljivaRobaList.add(new KvarljivaRoba(
                "Mleko",
                250.0,
                "Kravlje mleko",
                LocalDate.of(2025, 7, 2),
                "ml",
                LocalDate.of(2025, 8, 2),
                "Cuvati na hladnom i tamnom mestu"));
        database.kvarljivaRobaList.add(new KvarljivaRoba(
                "Zamrznute nudle",
                10.0,
                "Budzet dorucak/rucak/vecera",
                LocalDate.of(2023, 9, 20),
                "g",
                LocalDate.of(2032, 11, 11),
                "Cuvati u zamrzivacu"));

        Magacin m1 = new Magacin("Magacin kvarljive robe");
        m1.addRoba(database.kvarljivaRobaList.readIndex(0));
        m1.addRoba(database.kvarljivaRobaList.readIndex(1));
        m1.addRoba(database.kvarljivaRobaList.readIndex(2));

        Magacin m2 = new Magacin("Magacin bele tehnike");
        m2.addRoba(database.belaTehnikaList.readIndex(0));
        m2.addRoba(database.belaTehnikaList.readIndex(1));
        m2.addRoba(database.belaTehnikaList.readIndex(2));

        database.magacinList.add(m1);
        database.magacinList.add(m2);

        database.magacionerList.add(new Magacioner(
                "1798",
                "Petar",
                "Petrovic",
                1000,
                5,
                m1));
        database.magacionerList.add(new Magacioner(
                "8112",
                "Dalibor",
                "Daliborovic",
                1200,
                21,
                m1));
        database.magacionerList.add(new Magacioner(
                "9834",
                "Mirko",
                "Grcic",
                3000,
                10,
                m2));

        database.menadzerList.add(new Menadzer(
                "2137",
                "Goran",
                "Mitic",
                10000,
                m1));
        database.menadzerList.add(new Menadzer(
                "7801",
                "Darko",
                "Milisavljevic",
                11000,
                m2));

    }
}
