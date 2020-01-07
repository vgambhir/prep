package basic;

import java.util.Arrays;

public enum MyEnum {


    RED,GREEN,BLUE;

    //public static final MyEnum RED = new MyEnum(); //equivalent
    public static void main(String[] args)
    {
        MyEnum c1 = MyEnum.RED;
        System.out.println(c1);
    }

}


enum MyEnum1 {


    RED,GREEN,BLUE;

    //public static final MyEnum RED = new MyEnum(); //equivalent

   //constructor must be private
    private MyEnum1(){

        System.out.println("this is being instantiated: "+ this.toString());

    }
    public static void main(String[] args)
    {
        MyEnum c1 = MyEnum.RED;
        System.out.println(c1);
    }

}



enum MyEnum2 {


    RED("stop"),GREEN("move"),YELLOW("wait");

    //declare value
    String action;

    //public static final MyEnum RED = new MyEnum(); //equivalent

    //constructor must be private can not be public or protected
    private MyEnum2(String action){
        this.action = action;
        System.out.println("this is being instantiated: "+ this.toString());

    }

    public String getAction()
    {
        return this.action;
    }
    public static void main(String[] args)
    {
        MyEnum2[] signals = MyEnum2.values();

        for (MyEnum2 signal : signals)
        {
            // use getter method to get the value
            System.out.println("name : " + signal.name() +
                    " action: " + signal.getAction() );
        }

        Arrays.stream(MyEnum2.values()).forEach(e -> System.out.println("name : " + e.name() +
                        " action: " + e.getAction() )

        );


    }

}