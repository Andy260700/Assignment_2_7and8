package java_assignments.q8;

import javax.swing.*;
import javax.swing.text.*;

public class EmployeeSearch extends JPanel {
    private JLabel employeeIdLabel, error;
    private JTextField employeeId;
    private JTextPane output;
    private JButton search;

    EmployeeSearch(){
        employeeIdLabel = new JLabel("Employee id : ");
        employeeIdLabel.setLabelFor(employeeId);
        employeeId = new JTextField("enter id");
        error = new JLabel("");
        output = new JTextPane();
        search = new JButton("Search");

        GroupLayout layout = new GroupLayout(this);
        layout.setAutoCreateContainerGaps(true);
        layout.setAutoCreateGaps(true);


        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addGroup(layout
                                        .createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(employeeIdLabel)
                                        .addComponent(search)
//                        .addComponent(grade)
                        )
                        .addGroup(layout
                                .createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(employeeId)
                                .addComponent(error)

                        ))

                .addGroup(layout.createSequentialGroup()
                        .addComponent(output)
                )
        );

        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(employeeIdLabel)
                        .addComponent(employeeId)
                )
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(search)
                        .addComponent(error)
                )
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(output)
                )
        );

        this.setLayout(layout);
    }
    public JButton getSearch() {
        return search;
    }

    public JLabel getError() {
        return error;
    }

    public JTextField getEmployeeId() {
        return employeeId;
    }

    public JLabel getEmployeeIdLabel() {
        return employeeIdLabel;
    }

    public JTextPane getOutput() {
        return output;
    }

}
