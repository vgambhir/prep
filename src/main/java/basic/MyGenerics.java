package basic;

public class MyGenerics {

    public static void main(String a[])
    {

        // Creating object of sub class C and
        // passing it to Bound as a type parameter.
        Bound<C> bec = new Bound<C>(new C());
        bec.doRunTest();



        // similarly passing super class A
        Bound<A1> bea = new Bound<A1>(new A1());
        bea.doRunTest();

    }
}

class A1
{
    public void displayClass()
    {
        System.out.println("Inside super class A");
    }
}
class Bound<T extends A1>
{

    private T objRef;

    public Bound(T obj){
        this.objRef = obj;
    }

    public void doRunTest(){
        this.objRef.displayClass();
    }
}

class C extends A1
{
    public void displayClass()
    {
        System.out.println("Inside sub class C");
    }
}