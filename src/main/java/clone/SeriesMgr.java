package clone;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Immutable objects are objects that don't change. You make them, then you can't change them.
 * Instead, if you want to change an immutable object, you must clone it and change the clone while you are creating it.
 * Primitives are immutable, so you don't have to do anything special.
 * A clone is an exact copy of the original. In java, it essentially means the ability to create an object with similar state as the original object.
 * The java clone() method provides this functionality.
 */
public final class SeriesMgr implements Cloneable{

    private final int[] arr;
    public SeriesMgr(int[] arr)
    {
        this.arr = arr;
    }

    public int[] getArr() {
        int x[] = arr.clone();
        return x;
    }
}


final class SeriesMgrCollection implements Cloneable{

    private final List<Integer> intList;
    public SeriesMgrCollection(int[] arr)
    {
        this.intList = Collections.unmodifiableList(Arrays.stream(arr).boxed().collect(Collectors.toList()));
    }

    public int[] getArr() {

        // to arrays creates a new array
        return  intList.stream().mapToInt(Integer::intValue).toArray();
    }
}


class TestSeriesMgr{

    public static void main(String[] args) {
        SeriesMgr mgr = new SeriesMgr(new int[]{1,2,4});
        System.out.println(mgr.getArr());



    }




}