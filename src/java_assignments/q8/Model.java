package java_assignments.q8;
import java.io.*;

public class Model {
    private PersistentStorage employeeCollection;
    private boolean isSaved = true;
    Model(){
        try (FileInputStream fileIn = new FileInputStream("./files/q6.ser")) {
            try (ObjectInputStream objIn = new ObjectInputStream(fileIn)) {
                employeeCollection = (PersistentStorage) objIn.readObject();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            employeeCollection = new PersistentStorage();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean getSaved(){
        return isSaved;
    }

    public void setSaved(boolean saved) {
        isSaved = saved;
    }

}
