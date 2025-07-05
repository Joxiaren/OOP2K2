package OOP2K2.views;

import OOP2K2.data.Database;
import OOP2K2.interfaces.Formable;
import OOP2K2.models.Identifiable;
import OOP2K2.models.Magacin;
import OOP2K2.models.Roba;
import OOP2K2.models.table_models.GenericTableModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;

public class FormView<T extends Identifiable & Formable> extends JPanel{
    private Database database;
    private ArrayList<JLabel> labels = new ArrayList<>();
    private ArrayList<JComponent> inputs = new ArrayList<>();
    private ActionListener pregledRobeActionListener;
    private JPanel buttonContainer;
    private JButton confirmButton;
    private JButton deleteButton;


    private final int numberOfAttributes;
    private final ArrayList<String> attributeNames;
    private final ArrayList<String> attributeTypes;
    public FormView(T t,
                    Database database){
        this.numberOfAttributes = t.numberOfAttributes();
        this.attributeNames = t.attributeNames();
        this.attributeTypes = t.attributeTypes();

        this.database = database;
    }
    public void init(){
        SpringLayout springLayout = new SpringLayout();
        JLabel newLabel;
        JComponent newInput;

        for(int j = 0; j < this.numberOfAttributes; j++){
            newLabel = new JLabel(this.attributeNames.get(j) + ":");

            labels.add(newLabel);
            this.add(newLabel);

            newInput = switch (this.attributeTypes.get(j)) {
                case "String" -> new JTextField();
                case "Double" -> new JSpinner(new SpinnerNumberModel(0.0, 0.0, Double.MAX_VALUE, 0.01));
                case "Integer" -> new JSpinner(new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1));
                case "LocalDate" -> new JSpinner(new SpinnerDateModel());
                case "List:Roba" -> {
                    JButton button = new JButton("Pregled Robe");
                    button.addActionListener(pregledRobeActionListener);
                    yield button;
                }
                case "Magacin" -> {
                    JComboBox<Magacin> combo = new JComboBox<>();
                    database.magacinList.addAddEvent((item) ->{
                        combo.addItem(item);
                    });
                    database.magacinList.addDeleteEvent((item) -> {
                        combo.removeItem(item);
                    });

                    for(Magacin m : database.magacinList.readAll()) combo.addItem(m);
                    yield combo;

                }
                default -> null;
            };
            inputs.add(newInput);
            this.add(newInput);
        }

        springLayout.putConstraint(SpringLayout.NORTH, this.labels.getFirst(), 10, SpringLayout.NORTH, this);
        springLayout.putConstraint(SpringLayout.EAST, this.labels.getFirst(), -100, SpringLayout.HORIZONTAL_CENTER, this);

        springLayout.putConstraint(SpringLayout.WEST, this.inputs.getFirst(), 40, SpringLayout.EAST, this.labels.getFirst());
        springLayout.putConstraint(SpringLayout.EAST, this.inputs.getFirst(), -40, SpringLayout.EAST, this);
        springLayout.putConstraint(SpringLayout.NORTH, this.inputs.getFirst(), 0, SpringLayout.NORTH, this.labels.getFirst());

        for(int j = 1; j < this.numberOfAttributes; j++){
            springLayout.putConstraint(SpringLayout.NORTH, this.labels.get(j), 10, SpringLayout.SOUTH, this.labels.get(j - 1));
            springLayout.putConstraint(SpringLayout.EAST, this.labels.get(j), -100, SpringLayout.HORIZONTAL_CENTER, this);

            springLayout.putConstraint(SpringLayout.WEST, this.inputs.get(j), 40, SpringLayout.EAST, this.labels.get(j));
            springLayout.putConstraint(SpringLayout.EAST, this.inputs.get(j), -40, SpringLayout.EAST, this);
            springLayout.putConstraint(SpringLayout.NORTH, this.inputs.get(j), 0, SpringLayout.NORTH, this.labels.get(j));
        }


        this.buttonContainer = new JPanel();
        this.buttonContainer.setLayout(new FlowLayout());

        this.confirmButton = new JButton("Confirm");
        this.deleteButton = new JButton("Delete");
        this.buttonContainer.add( this.confirmButton);
        this.buttonContainer.add( this.deleteButton);

        this.add(this.buttonContainer);

        springLayout.putConstraint(SpringLayout.NORTH, this.buttonContainer, 15, SpringLayout.SOUTH, this.labels.getLast());
        springLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, this.buttonContainer, 0, SpringLayout.HORIZONTAL_CENTER, this);

        this.setMinimumSize(new Dimension(800, 300));
        this.setLayout(springLayout);
    }
    public void setButtonText(String text){
        this.confirmButton.setText(text);
    }
    public void addPregledRobeButtonListener(ActionListener al) {
        this.pregledRobeActionListener = al;
    }
    public void addDeleteButtonListener(ActionListener al) {
        this.deleteButton.addActionListener(al);
    }
    public void addConfirmButtonListener(ActionListener al){
        this.confirmButton.addActionListener(al);
    }
    public void removeConfirmButtonListener() {
        for(ActionListener al : this.confirmButton.getActionListeners()) this.confirmButton.removeActionListener(al);
    }
    public void showMessage(String s){
        JOptionPane.showMessageDialog(this, s);
    }
    public Object[] getData() {
        Object[] data = new Object[this.numberOfAttributes];

        JComponent currentInput;
        for(int j = 0; j < this.numberOfAttributes; j++){
            currentInput = this.inputs.get(j);

            data[j] = switch(this.attributeTypes.get(j)){
                case "String" -> ((JTextField)currentInput).getText();
                case "Double" -> (Double)((JSpinner)currentInput).getValue();
                case "Integer" -> ((JSpinner)currentInput).getValue();
                case "LocalDate" -> ((Date)((JSpinner)currentInput).getValue()).toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                case "Magacin" -> (Magacin)((JComboBox<Magacin>)currentInput).getSelectedItem();
                default -> null;
            };
        }

        return data;
    }
    public void setData(Object[] data){
        JComponent currentInput;
        for(int j = 0; j < this.numberOfAttributes; j++){
            currentInput = this.inputs.get(j);
            switch(this.attributeTypes.get(j)){
                case "String":
                    ((JTextField)currentInput).setText((String)data[j]);
                    break;
                case "Double":
                    ((JSpinner)currentInput).setValue((Double)data[j]);
                    break;
                case "Integer":
                    ((JSpinner)currentInput).setValue((Integer)data[j]);
                    break;
                case "LocalDate":
                    ((JSpinner)currentInput).setValue(Date.from(((LocalDate)data[j]).atStartOfDay(ZoneId.systemDefault()).toInstant()));
                    break;
                case "Magacin":
                    ((JComboBox<Magacin>)currentInput).setSelectedItem((Magacin)data[j]);
                    break;
            }
        }
    }

}
