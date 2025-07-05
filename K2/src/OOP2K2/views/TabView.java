package OOP2K2.views;

import OOP2K2.interfaces.Formable;
import OOP2K2.models.Identifiable;

import javax.swing.*;
import java.awt.*;

public class TabView<T extends Identifiable & Formable> extends JPanel {
    private FormView<T> formView;
    private TableView<T> tableView;

    private JSplitPane splitPane;
    private JScrollPane tableScrollPane;
    public TabView(FormView<T> formView,
                   TableView<T> tableView){
        super();
        this.formView = formView;
        this.tableView = tableView;
    }
    public void init(){
        this.tableView.init();
        this.tableView.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        this.setLayout(new BorderLayout());
        this.splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
        this.splitPane.add(this.formView);

        this.tableScrollPane = new JScrollPane(this.tableView);
        this.splitPane.add(this.tableScrollPane);

        this.add(this.splitPane, BorderLayout.CENTER);
    }
}
