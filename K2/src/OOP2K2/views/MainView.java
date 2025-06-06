package OOP2K2.views;

import javax.swing.*;
import java.io.Serial;

public class MainView extends JFrame {
    @Serial
    private static final long serialVersionUID = 2551920927317172030L;

    private final JTabbedPane tabbedPane = new JTabbedPane();
    private final JMenuBar menubar = new JMenuBar();
    public void init(){
        menubar.add(new JMenu("File"));
        menubar.add(new JMenu("Settings"));

        tabbedPane.addTab("Bela Tehnika", new JPanel());
        tabbedPane.addTab("Kvarljiva Roba", new JPanel());
        tabbedPane.addTab("Magacini", new JPanel());
        tabbedPane.addTab("Magacioneri", new JPanel());
        tabbedPane.addTab("Menadzeri", new JPanel());

        this.getContentPane().add(tabbedPane);

        this.setJMenuBar(this.menubar);
        this.applySettings();
    }
    public void applySettings(){
        this.setSize(800,600);
        this.setTitle("OOP2K2 - Jovan Stoiljkovic");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void start(){
        this.setVisible(true);
    }
}
