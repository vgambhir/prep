package jstreams;

import java.math.BigDecimal;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

public class MyDoubleStream {
    // Driver code
    public static void main(String[] args)
    {
        // Creating a DoubleStream
        DoubleStream stream = DoubleStream.of(3.0, 4.0, 6.0, 8.0);

        // Using DoubleStream mapToObj(DoubleFunction mapper)
        // and displaying an object-valued Stream
        // consisting of the results of
        // applying the given function
//        stream.mapToObj(num ->{return num * num * num ;})
//                .forEach(System.out::println);

        stream.mapToObj(num -> num * num * num)
                .forEach(System.out::println);



        // Creating a DoubleStream
        DoubleStream streamA = DoubleStream.of(3.4, 4.5,
                6.7, 8.9);

        // Creating a Stream
        // Using DoubleStream mapToObj(DoubleFunction mapper)
        Stream<BigDecimal> stream1 = streamA
                .mapToObj(BigDecimal::valueOf);

        // Displaying an object-valued Stream
        // consisting of the results of
        // applying the given function.
        stream1.forEach(num -> System.out.println
                (num.add(BigDecimal.TEN)));


    }
}


