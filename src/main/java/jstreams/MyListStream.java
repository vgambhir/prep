package jstreams;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MyListStream {
    public static <T> List<T> createList(T N)
    {

        // Currently only one value is taken
        int size = 9;


        return Stream

                // Generate the Stream
                .generate(String::new)

                // Size of the List to be created
                .limit(size)

                // Passing the value to be mapped
                .map(s -> N)

                // Convert the generated stream into List
                .collect(Collectors.toList());
    }

    // Driver code
    public static void main(String[] args)
    {

        int N = 10;
        System.out.println("List with element "
                + N + ": "
                + createList(N));

        String str = "GeeksForGeeks";
        System.out.println("List with element "
                + str + ": "
                + createList(str));
    }
}
