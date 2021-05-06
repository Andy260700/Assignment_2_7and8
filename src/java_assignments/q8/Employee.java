package java_assignments.q8;

import java.io.Serializable;
import java.util.Objects;

enum Grade{
    A,B,C
};
enum Department{
    HR
    , MARKETING{
        @Override
        public String toString() {
            return "Marketing";
        }
    }, SALES{
        @Override
        public String toString() {
            return "Sales";
        }
    }, IT

};
public class Employee implements Serializable{
    private static final long serialVersionUID = 4L;
    private String employeeId;
    private static int idGenerator = 0;
    private String employeeName;
    private Department department;
    private double basicSalary;
    private Grade grade;
    Employee(String name, Department dept, Grade grade){
        this.employeeId = String.format("%06d",++idGenerator);
        this.employeeName = name;
        this.department = dept;
        this.grade = grade;
        switch (grade){
            case A: {
                this.basicSalary = 88000.00;
                break;
            }
            case B: {
                this.basicSalary = 70000.00;
                break;
            }
            case C: {
                this.basicSalary = 50000.00;
                break;
            }
        }
    }
    public static void setIdGenerator(int a){
        idGenerator = a;
    }
    public static int getIdGenerator(){
        return idGenerator;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("|| Employee ||").append("\n\n");
        sb.append(" Employee Id = ").append(employeeId).append('\n');
        sb.append(" Employee Name = ").append(employeeName).append('\n');
        sb.append(" Department = ").append(department).append('\n');
        sb.append(" Basic Salary = ").append(basicSalary).append('\n');
        sb.append(" Grade = ").append(grade).append('\n');
        return sb.toString();
    }

    public Department getDepartment() {
        return department;
    }

    public double getBasicSalary() {
        return basicSalary;
    }

    public Grade getGrade() {
        return grade;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return employeeId.equals(employee.employeeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeId);
    }
}
