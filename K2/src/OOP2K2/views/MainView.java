package OOP2K2.views;

import OOP2K2.controllers.FormController;
import OOP2K2.models.*;

import javax.swing.*;
import java.awt.*;
import java.io.Serial;

public class MainView extends JFrame {
    @Serial
    private static final long serialVersionUID = 2551920927317172030L;

    private final JTabbedPane tabbedPane = new JTabbedPane();

    public MainView(){
        super();
    }
    public void init(){
        this.getContentPane().add(tabbedPane);
        this.applySettings();
    }
    public void addTab(String title, Component c){
        this.tabbedPane.add(title, c);
    }

    public void applySettings(){
        this.setSize(800  ,600);
        this.setTitle("OOP2K2 - Jovan Stoiljkovic");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void start(){
        this.setVisible(true);
    }
}
