package basic;

import java.io.*;

public class MySerializable {
}
class A implements Serializable
{
    int i;
    String s;

    // A class constructor
    public A(int i,String s)
    {
        this.i = i;
        this.s = s;
    }

    @Override
    public String toString() {
        return "A{" +
                "i=" + i +
                ", s='" + s + '\'' +
                '}';
    }
}

class TestSeriizable
{
    public static void main(String[] args)
            throws IOException, ClassNotFoundException
    {
        A a = new A(20,"GeeksForGeeks");

        // Serializing 'a' ø
        FileOutputStream fos = new FileOutputStream("xyz.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(a);

        // De-serializing 'a'
        FileInputStream fis = new FileInputStream("xyz.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        A b = (A)ois.readObject();//down-casting object

        System.out.println("b: "+ b);

        // closing streams
        oos.close();
        ois.close();
    }
}