package java_assignments.q8;

import javax.swing.*;

public class EmployeeForm extends JPanel {
    private JLabel nameLabel, department, grade, error;
    private JTextField name;
    private JComboBox<Department> departmentList;
    private JRadioButton jRadioButtonA;
    private JRadioButton jRadioButtonB;
    private JRadioButton jRadioButtonC;
    private ButtonGroup buttonGroup;
    private JButton submit;

    EmployeeForm() {
        nameLabel = new JLabel("Name :");
        nameLabel.setLabelFor(name);
        department = new JLabel("Department : ");
        department.setLabelFor(departmentList);
        grade = new JLabel("Grade : ");
        grade.setLabelFor(jRadioButtonA);
        grade.setLabelFor(jRadioButtonB);
        grade.setLabelFor(jRadioButtonC);
        name = new JTextField("enter name");
        error = new JLabel("All fields are mandatory");
        jRadioButtonA = new JRadioButton("A");
        jRadioButtonB = new JRadioButton("B");
        jRadioButtonC = new JRadioButton("C");
        buttonGroup = new ButtonGroup();
        buttonGroup.add(jRadioButtonA);
        buttonGroup.add(jRadioButtonB);
        buttonGroup.add(jRadioButtonC);
        departmentList = new JComboBox<Department>(Department.values());
        submit = new JButton("Submit");
        GroupLayout layout = new GroupLayout(this);
        layout.setAutoCreateContainerGaps(true);
        layout.setAutoCreateGaps(true);


        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addGroup(layout
                        .createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(nameLabel)
                        .addComponent(department)
                        .addComponent(grade)
                        .addComponent(submit)
                )
                .addGroup(layout
                        .createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(name)
                        .addComponent(departmentList)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jRadioButtonA)
                                .addComponent(jRadioButtonB)
                                .addComponent(jRadioButtonC)
                        )
                        .addComponent(error)
                )
        );

        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(name)
                        .addComponent(nameLabel)
                )
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(department)
                        .addComponent(departmentList)
                )
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(grade)
                        .addComponent(jRadioButtonA)
                        .addComponent(jRadioButtonB)
                        .addComponent(jRadioButtonC)

                )
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(submit)
                        .addComponent(error)
                )
        );

        this.setLayout(layout);
    }

}
