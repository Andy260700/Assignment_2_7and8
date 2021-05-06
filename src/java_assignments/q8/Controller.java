package java_assignments.q8;

import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.HashMap;

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
                MutableAttributeSet attributeSet1 = new SimpleAttributeSet();
                StyleConstants.setItalic(attributeSet1, true);
                StyleConstants.setForeground(attributeSet1, Color.DARK_GRAY);
                MutableAttributeSet attributeSet2 = new SimpleAttributeSet();
                StyleConstants.setBold(attributeSet2, true);
                StyleConstants.setForeground(attributeSet2, Color.BLUE);
                StyleConstants.setFontFamily(attributeSet2, "Monospaced");
                try {
                    HashMap<String, String > stringMatching = new HashMap<>();
                    stringMatching.put("\nEmployee Id : ",employee.getEmployeeId());
                    stringMatching.put("\nName : ", employee.getEmployeeName());
                    stringMatching.put("\nDepartment : ", employee.getDepartment().toString());
                    stringMatching.put("\nGrade : ", employee.getGrade().toString());
                    stringMatching.put("\nBasic Salary : ", String.format("%6.2f",employee.getBasicSalary()));
                    doc.remove(0, doc.getLength());
                    for(var ds : stringMatching.entrySet()){
                        doc.insertString(doc.getLength(), ds.getKey() , attributeSet1);
                        doc.insertString(doc.getLength(), ds.getValue() , attributeSet2);
                    }
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
