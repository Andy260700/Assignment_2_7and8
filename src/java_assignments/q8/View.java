package java_assignments.q8;

import javax.swing.*;

public class View {
    JFrame frame;
    View(){
        EmployeeForm form = new EmployeeForm();
        EmployeeSearch search = new EmployeeSearch();
        JTabbedPane jTabbedPane = new JTabbedPane();

        frame = new JFrame();
        jTabbedPane.add("Add Employee", form);
        jTabbedPane.add("Search Employee", search);
        frame.setContentPane(jTabbedPane);
        frame.setSize(400,200);
        frame.setVisible(true);


    }
}
