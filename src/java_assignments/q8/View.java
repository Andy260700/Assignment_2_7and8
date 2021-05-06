package java_assignments.q8;

import javax.swing.*;

public class View {
    private JFrame frame;
    private JTabbedPane tabbedPane;
    View(){
        EmployeeForm form = new EmployeeForm();
        EmployeeSearch search = new EmployeeSearch();
        tabbedPane = new JTabbedPane();

        frame = new JFrame();
        tabbedPane.add("Add Employee", form);
        tabbedPane.add("Search Employee", search);
        frame.setContentPane(tabbedPane);
        frame.setSize(400,260);
        frame.setVisible(true);
    }

    public JFrame getFrame() {
        return frame;
    }

    public JTabbedPane getTabbedPane() {
        return tabbedPane;
    }
}
