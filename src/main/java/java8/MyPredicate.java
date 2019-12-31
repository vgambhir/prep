package java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

class MyPredicate {


    public static void main(String[] args) {

      Predicate<Integer> p = x -> x > 5;

        List<Integer> number = Arrays.asList(10,1,5,6,8,9);
        List<Integer> nList = number.stream().filter(p).collect(Collectors.toList());
        System.out.println(nList);


    }


}