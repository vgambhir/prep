package basic;

/**
 * primitive data types are cloned one-one field , therefore clone will have its own copy
 * while references point to the same object as no new copy is created for references or objects
 */
public class MyShallowCloneEx {
}

class Test
{
    int x, y;

    @Override
    public String toString() {
        return "Test{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}

// Contains a reference of Test and implements
// clone with shallow copy.
class Test2 implements Cloneable
{
    int a;
    int b;
    TestX c = new TestX();
    public Object clone() throws
            CloneNotSupportedException
    {
        return super.clone();
    }


    @Override
    public String toString() {
        return "Test2{" +
                "a=" + a +
                ", b=" + b +
                ", c=" + c +
                '}';
    }
}

// Driver class
class Main
{
    public static void main(String args[]) throws
            CloneNotSupportedException
    {
        Test2 t1 = new Test2();
        t1.a = 10;
        t1.b = 20;
        t1.c.x = 30;
        t1.c.y = 40;

        Test2 t2 = (Test2)t1.clone();
        System.out.println(t1);

        // Creating a copy of object t1 and passing
        //  it to t2
        t2.a = 100;

        // Change in primitive type of t2 will not
        // be reflected in t1 field
        t2.c.x = 300;
        // Change in object type field will be
        // reflected in both t2 and t1(shallow copy)
        System.out.println("t1: "+ t1);
        System.out.println("t2: "+ t2);



    }
}