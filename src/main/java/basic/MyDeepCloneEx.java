package basic;

/**
 * primitive data types are cloned one-one field , therefore clone will have its own copy
 * while references point to the same object as no new copy is created for references or objects
 */
public class MyDeepCloneEx {}


class TestX
{
    int x, y;

    @Override
    public String toString() {
        return "TestX{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}


// Contains a reference of Test and implements
// clone with deep copy.
class TestY implements Cloneable
{
    int a, b;

    TestX c = new TestX();

    public Object clone() throws
            CloneNotSupportedException
    {
        // Assign the shallow copy to new reference variable t
        TestY t = (TestY)super.clone();

        t.c = new TestX();

        // Create a new object for the field c
        // and assign it to shallow copy obtained,
        // to make it a deep copy
        return t;
    }

    @Override
    public String toString() {
        return "TestY{" +
                "a=" + a +
                ", b=" + b +
                ", c=" + c +
                '}';
    }
}

class MainX
{
    public static void main(String args[]) throws
            CloneNotSupportedException
    {
        TestY t1 = new TestY();
        t1.a = 10;
        t1.b = 20;
        t1.c.x = 30;
        t1.c.y = 40;

        TestY t3 = (TestY)t1.clone();
        t3.a = 100;

        // Change in primitive type of t2 will not 
        // be reflected in t1 field 
        t3.c.x = 300;

        // Change in object type field of t2 will not 
        // be reflected in t1(deep copy) 
        System.out.println("t1: "+ t1);
        System.out.println("t3: "+ t3);
    }
}