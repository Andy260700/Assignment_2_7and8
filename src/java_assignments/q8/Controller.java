package java_assignments.q8;

import javax.swing.*;
import javax.swing.text.*;
import java.awt.event.ActionEvent;

public class Controller {
    private Model model;
    private View view;
    private EmployeeSearch employeeSearchPanel;
    private EmployeeForm employeeFormPanel;
    private Grade selectedGrade = null;
    Controller(Model model, View view){
        this.model = model;
        this.view = view;
        JTabbedPane jTabbedPane = view.getTabbedPane();
        employeeFormPanel = (EmployeeForm) jTabbedPane.getComponentAt(0);
        employeeSearchPanel = (EmployeeSearch) jTabbedPane.getComponentAt(1);
        employeeFormPanel.getSubmit().addActionListener(this::saveButton);
        employeeSearchPanel.getSearch().addActionListener(this::searchButton);
        employeeFormPanel.getjRadioButtonA().addActionListener(this::gradefromButton);
        employeeFormPanel.getjRadioButtonB().addActionListener(this::gradefromButton);
        employeeFormPanel.getjRadioButtonC().addActionListener(this::gradefromButton);
    }
//    private void initView(){
//
//    }
    private void gradefromButton(ActionEvent event){
        JRadioButton button = (JRadioButton) event.getSource();
        if(button == employeeFormPanel.getjRadioButtonA())
            selectedGrade = Grade.A;
        else if(button == employeeFormPanel.getjRadioButtonB())
            selectedGrade = Grade.B;
        else
            selectedGrade = Grade.C;
    }
    private void saveButton(ActionEvent event){
        String name = employeeFormPanel.getname().getText();
        Department dept = (Department) employeeFormPanel.getDepartmentList().getSelectedItem();
        if(!name.equals("") && !name.equals("enter name") && selectedGrade!=null) {
            Employee employee = new Employee(name, dept, selectedGrade);
            model.getEmployeeCollection().addEmployee(employee);
            JOptionPane.showMessageDialog(null, employee.toString(), "Employee Details", JOptionPane.INFORMATION_MESSAGE);
            model.saveToFile();
        }
        else {
            employeeFormPanel.getError().setText("fields cannot be empty!");
        }
    }
    private void searchButton(ActionEvent event){
        String empId = employeeSearchPanel.getEmployeeId().getText();
        if(!empId.equals("") && !empId.equals("enter id"))
        {
            try {
                Employee employee = model.getEmployeeCollection().findEmployee(empId);
                StyledDocument doc  = employeeSearchPanel.getOutput().getStyledDocument();
                MutableAttributeSet attributeSet = new SimpleAttributeSet();
                StyleConstants.setItalic(attributeSet, true);
                try {
                    doc.remove(0, doc.getLength());
                    doc.insertString(0, employee.toString(), attributeSet);
                }catch (BadLocationException e){
                    e.printStackTrace();
                }
            }
            catch (InvalidCodeException e){
                employeeSearchPanel.getError().setText(e.getMessage());
            }
        }
        else{
            employeeSearchPanel.getError().setText("employee id cannot be empty");
        }
    }
}
