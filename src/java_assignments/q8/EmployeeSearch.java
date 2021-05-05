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
        error = new JLabel("this is error");
        output = new JTextPane();
        StyledDocument doc = output.getStyledDocument();
        MutableAttributeSet attributeSet = new SimpleAttributeSet();
        StyleConstants.setItalic(attributeSet, true);
        try {
            doc.insertString(0, "9\n8\n9\nyfctdx", attributeSet);
        }catch (BadLocationException e){
            e.printStackTrace();
        }
        search = new JButton("Search");

        GroupLayout layout = new GroupLayout(this);
        layout.setAutoCreateContainerGaps(true);
        layout.setAutoCreateGaps(true);


        layout.setHorizontalGroup(layout.createSequentialGroup()
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
}
