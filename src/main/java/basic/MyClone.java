package basic;

public class MyClone {

    public void testMe(){
        try {
            //if you want to invoke a method directly on super class reference, then that method has to be public
            super.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println("Calling super class clone failed from testMe()");
            e.printStackTrace();
        }
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

}


class MyClone1 implements Cloneable {

    @Override
    public String toString() {
        return "MyClone1{" +
                "y=" + y +
                '}';
    }

    int y = 10;

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }


}


class CloneTest{

    public static void main(String[] args) {
        MyClone m = new MyClone();
        m.testMe();
        //m.clone() not available even if this method belongs to parent object class.
        // now added clone() method but not implemented clonebale interface
        try {
            m.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println("Calling super class clone failed on unimplementable interface object");
            e.printStackTrace();
        }


        MyClone1 m1 = new MyClone1();

        try {
            MyClone1 c1 = (MyClone1)m1.clone(); //your proteced methods are available
            System.out.println("Value of c1:"+ c1);
        } catch (CloneNotSupportedException e) {
            System.out.println("Calling super class clone failed from main()");
            e.printStackTrace();
        }
    }




}