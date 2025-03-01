# Serialization-and-Deserialization

## Introduction
The process of transforming an object's state into a byte stream is known as serialization. After that, this byte stream can be transferred across a network, saved to a file, or kept in a database. 
The opposite of serialization is called deserialization. It is the process of transforming an object back into a byte stream. The byte stream is parsed and a new object is created using the relevant tools.
We need serialization to stop from creating objects again and again in order call the data of that class if need again.
## Benefits
* **Communication**: Objects can be designed, shared, and executed simultaneously by various systems thanks to the conversion of objects into byte streams, which facilitates transfer via networks.
* **Persistence**: Any object's current state can be readily saved in a database and retrieved whenever needed.
* **Cloning**: It simplifies the cloning process by enabling the creation of an exact duplicate of an object by serialization into a bit stream and subsequent conversion back to the original form.
* **Time Saving**: Compared to building a real object from a class, converting a byte stream to an object takes a lot less time.

## Mechanism
### Student Class
We implement Serializable interface because we need to convert this object in to byte stream.
```java
import java.io.Serializable;

public class Student implements Serializable { 
    public String name;
    public int age;
    public String address;
}
```

### Serialization Class
```java
import java.io.*;

public class Serialization {
    public static void main(String[] args) {
        Student student = new Student(); //Creates an instance of Student class.
        student.name = "Roshen Perera";
        student.age = 19;
        student.address = "Avissawella";

        try {
            FileOutputStream fileOut = new FileOutputStream("C:\\Users\\Roshen Perera\\Documents\\byteStream.txt");//Specifies the path of the file where data is printed.
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);// Converts the object into byte stream.
            objectOut.writeObject(student);// Writes the object as a byte stream
            objectOut.close();
            fileOut.close();
            System.out.println("Data Serialized Successfully");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
```

### Deserialization Class
```java
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
```

GitHub Repository link : https://github.com/Roshen-Perera/Serialization-and-Deserialization.git