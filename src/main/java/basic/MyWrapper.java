package basic;

public class MyWrapper {

    public static void main(String[] args)
    {
        Integer i = new Integer(12);
        System.out.println(i);
        modify(i);
        System.out.println(i);
        System.out.println(modify1(i));

        // radix (0-9)A-
        System.out.println("binary to int "+Integer.parseInt("100", 2)); //read it as binary base-2


        System.out.println("decimal to int"+Integer.parseInt("100", 10)); //decimal
        System.out.println("octal to int"+Integer.parseInt("47", 8)); //octal
        System.out.println("int to octal"+Integer.toOctalString(39)); //octal
        System.out.println("hex to int "+Integer.parseInt("A", 16)); //hex
        System.out.println("hex to int: "+Integer.toHexString(10)); //octal


        System.out.println(""+Integer.toBinaryString(4)); //binary
        System.out.println(""+ (char)65); //char representation
        System.out.println(""+ (char)0); //char representation
        System.out.println("int to octal"+Integer.toOctalString(100)); //octal
        System.out.println("int to hex"+Integer.toHexString(100)); //octal
        System.out.println("int to hex"+Integer.toHexString(90)); //octal  5a






    }

    private static void modify(Integer i)
    {
        i = i + 1;
    }
    private static Integer modify1(Integer i)
    {
        i = i + 1;
        System.out.println(i);
        return i;
    }

}
