import java.io.*;

public class Deserialization {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Student student = null;
        try {
            FileInputStream fileInput = new FileInputStream("C:\\Users\\Roshen Perera\\Documents\\byteStream.txt");// Reads the data from the file which has the byte stream.
            ObjectInputStream objectInput = new ObjectInputStream(fileInput);// Converts the byte stream into object.
            student = (Student) objectInput.readObject(); // Reads the byte stream.
            fileInput.close();
            objectInput.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            //prints the converted the objects
            System.out.println("Data Deserialized Successfully");
            System.out.println("Student Name: " + student.name);
            System.out.println("Student Age: " + student.age);
            System.out.println("Student Address: " + student.address);
        }
    }
}
