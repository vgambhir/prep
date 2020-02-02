package hhsc;

public class TestHashCode {
}


class TestHCode
{
    public static void main(String[] args) {
        TestHashCode testHashCode = new TestHashCode();
        // converting the internal
        //     * address of the object into an integer Object.hashcode
        System.out.println(testHashCode.hashCode());
        System.out.println(System.identityHashCode(testHashCode));
    }


}