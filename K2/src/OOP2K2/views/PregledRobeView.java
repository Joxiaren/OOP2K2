package OOP2K2.views;

import OOP2K2.models.Magacin;
import OOP2K2.models.Roba;
import OOP2K2.models.table_models.RobaTableModel;

import javax.swing.*;
import java.awt.*;
import java.io.Serial;
import java.util.ArrayList;
import java.util.Arrays;

public class PregledRobeView extends JFrame {
    @Serial
    private static final long serialVersionUID = 2077997248427583950L;
    private Magacin magacin;
    private RobaTableModel robaTableModel;
    private JTable robaTable;
    private JButton deleteButton;
    private JComboBox<Roba> robaComboBox;
    private JButton addButton;
    private int selectedIndex = -1;
    private Roba selected = null;
    public PregledRobeView(JComboBox<Roba> robaComboBox){
        this.robaComboBox = robaComboBox;
        this.robaTableModel = new RobaTableModel(
                null,
                5,
                new ArrayList(Arrays.asList("Naziv", "Cena", "Opis", "Datum proizvodnje", "Jedinica mere")),
                new ArrayList(Arrays.asList("String", "Double", "String", "LocalDate", "String"))
        );


        this.deleteButton = new JButton("Delete");
        this.addButton = new JButton("Add");

        this.deleteButton.addActionListener((e) -> {
            if(selected == null){
                JOptionPane.showMessageDialog(this, "Izaberite stavku");
                return;
            }
            this.robaTableModel.removeModel(selectedIndex);
        });

        this.addButton.addActionListener((e) -> {
            Roba r = (Roba)this.robaComboBox.getSelectedItem();
            this.robaTableModel.addModel(r);
        });


        this.setSize(800,600);
        this.setDefaultCloseOperation(HIDE_ON_CLOSE);
        this.setLayout(new BorderLayout());

        this.robaTable = new JTable(this.robaTableModel);
        this.robaTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        this.robaTable.getSelectionModel().addListSelectionListener((e) ->{
            if(e.getValueIsAdjusting()) return;

            selectedIndex = this.robaTable.getSelectedRow();
            if(selectedIndex == -1){
                this.selected = null;
                return;
            }

            this.selected = this.magacin.getRoba(selectedIndex);
        });

        JScrollPane scrollPane = new JScrollPane(this.robaTable);

        this.getContentPane().add(scrollPane, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout());

        bottomPanel.add(this.robaComboBox);
        bottomPanel.add(this.addButton);
        bottomPanel.add(this.deleteButton);

        this.getContentPane().add(bottomPanel, BorderLayout.SOUTH);
    }
    public void setMagacin(Magacin magacin){
        this.magacin = magacin;
        this.robaTableModel.updateModelList(this.magacin.getAllRoba());
    }
    public void init(){
        this.setVisible(true);
    }
}
