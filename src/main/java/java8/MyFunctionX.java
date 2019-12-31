package java8;

import java.util.function.Function;

public class MyFunctionX {

    public static void main(String[] args) {
        Function<String,String> myFunction = s -> s + "AA";
        myFunction = myFunction.andThen(s -> s +"BB");

        System.out.println(myFunction.apply("V"));

    }
}



