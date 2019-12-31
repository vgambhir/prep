package java8;

@FunctionalInterface
public interface MyFunctionalInterface {

    int squareRoot(int x);
}


class TestMyFunctionalInterface {


    public static void main(String[] args) {

//        MyFunctionalInterface f = x -> {
//            return x * x;
//        };

        MyFunctionalInterface f1 = x -> x * x;
        System.out.println(f1.squareRoot(2));


    }


}