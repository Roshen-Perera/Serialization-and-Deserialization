import java.io.*;

public class Deserialization {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Student student = null;
        try {
            FileInputStream fileInput = new FileInputStream("C:\\Users\\Roshen Perera\\Documents\\byteStream.txt");
            ObjectInputStream objectInput = new ObjectInputStream(fileInput);
            student = (Student) objectInput.readObject();
            fileInput.close();
            objectInput.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            System.out.println("Deserializing Students...");
            System.out.println("Student Name: " + student.name);
            System.out.println("Student Age: " + student.age);
            System.out.println("Student Address: " + student.address);
        }
    }
}
