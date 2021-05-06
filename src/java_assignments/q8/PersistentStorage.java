package java_assignments.q8;

import java.io.Serializable;
import java.util.HashMap;

public class PersistentStorage implements Serializable {
    private static final long serialVersionUID = 5L;
    private HashMap<String, Employee> employeeContainer;
    private int count;
    PersistentStorage() {
        employeeContainer = new HashMap<>();
        count = 0;
    }

    public String addEmployee(Employee employee) {
        if (employee != null) {
            employeeContainer.put(employee.getEmployeeId(), employee);
            return employee.getEmployeeId();
        }
        return null;
    }

    public Employee findEmployee(String empId) throws InvalidCodeException {
        if (!employeeContainer.containsKey(empId))
            throw new InvalidCodeException("The employee id " + empId + " is Invalid");
        return employeeContainer.get(empId);
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }
}
