package java_assignments.q8;
import java.io.*;

public class Model {
    private PersistentStorage employeeCollection;

    Model(){
        try (FileInputStream fileIn = new FileInputStream("./files/q8.ser")) {
            try (ObjectInputStream objIn = new ObjectInputStream(fileIn)) {
                employeeCollection = (PersistentStorage) objIn.readObject();
                Employee.setIdGenerator(employeeCollection.getCount());
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            employeeCollection = new PersistentStorage();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void saveToFile(){
        try (FileOutputStream fileOut = new FileOutputStream("./files/q8.ser")) {
            ObjectOutputStream objOut = new ObjectOutputStream(fileOut);
                employeeCollection.setCount(Employee.getIdGenerator());
                objOut.writeObject(employeeCollection);
                objOut.close();
        } catch (FileNotFoundException e) {
            employeeCollection = new PersistentStorage();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public PersistentStorage getEmployeeCollection() {
        return employeeCollection;
    }
}
