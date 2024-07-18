import java.io.*;

public class Serialization {
    public static void main(String[] args) {
        Student student = new Student(); //Creates an instance of Student class.
        student.name = "Roshen Perera";
        student.age = 19;
        student.address = "Avissawella";

        try {
            FileOutputStream fileOut = new FileOutputStream("C:\\Users\\Roshen Perera\\Documents\\byteStream.txt");//Specifies the path of the file where data is printed.
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(student);
            objectOut.close();
            fileOut.close();
            System.out.println("Object written successfully");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
