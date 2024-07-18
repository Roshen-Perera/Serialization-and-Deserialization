import java.io.Serializable;

public class Student implements Serializable { //We implement Serializable interface because we need to convert this object in to byte stream.
    public String name;
    public int age;
    public String address;
}
