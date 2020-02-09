package hackerank.pQ;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class StackSizeCompare {

    /*
     * Complete the equalStacks function below.
     */
    static int equalStacks(int[] h1, int[] h2, int[] h3) {
        /*
         * Write your code here.
         */
        Stack<Integer> st1 = new Stack<>();
        Stack<Integer> st2 = new Stack<>();
        Stack<Integer> st3 = new Stack<>();
        populateStack(h1, st1);
        populateStack(h2, st2);
        populateStack(h3, st3);

        while (st1.peek() != st2.peek() &&
                st1.peek() != st3.peek() &&
                st2.peek() != st3.peek()
        ) {
            // find smallest with peek

        }


        return -1;

    }

    static int equalStacks1(int[] h1, int[] h2, int[] h3) {
        /*
         * Write your code here.
         */
        int[] arr1 = populateArray(h1);
        int[] arr2 = populateArray(h2);
        int[] arr3 = populateArray(h3);

        for (int i = arr1.length - 1; i >= 0; i--)
        {
          int temp = arr1[i];
          if (containsNumber(temp,arr2) && containsNumber(temp,arr3))
          {
           return temp;
          }
        }


        return -1;

    }


    public static boolean containsNumber(int number, int[]arr)
    {
        for (int i = arr.length - 1; i >= 0; i--) {
           if(arr[i] == number)
               return true;

        }
        return false;


    }

    public static int[] populateArray(int[] arr) {
        int[] newArr = new int[arr.length];
        int temp = 0;
        for (int i = arr.length - 1, x = 0; i >= 0; i--, x++) {
            temp = temp + arr[i];
            newArr[x] = temp;

        }
        return newArr;

    }


    public static void populateStack(int[] arr, Stack<Integer> st) {
        int temp = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            temp = temp + arr[i];
            st.push(temp);

        }


    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] n1N2N3 = scanner.nextLine().split(" ");

        int n1 = Integer.parseInt(n1N2N3[0].trim());

        int n2 = Integer.parseInt(n1N2N3[1].trim());

        int n3 = Integer.parseInt(n1N2N3[2].trim());

        int[] h1 = new int[n1];

        String[] h1Items = scanner.nextLine().split(" ");

        for (int h1Itr = 0; h1Itr < n1; h1Itr++) {
            int h1Item = Integer.parseInt(h1Items[h1Itr].trim());
            h1[h1Itr] = h1Item;
        }

        int[] h2 = new int[n2];

        String[] h2Items = scanner.nextLine().split(" ");

        for (int h2Itr = 0; h2Itr < n2; h2Itr++) {
            int h2Item = Integer.parseInt(h2Items[h2Itr].trim());
            h2[h2Itr] = h2Item;
        }

        int[] h3 = new int[n3];

        String[] h3Items = scanner.nextLine().split(" ");

        for (int h3Itr = 0; h3Itr < n3; h3Itr++) {
            int h3Item = Integer.parseInt(h3Items[h3Itr].trim());
            h3[h3Itr] = h3Item;
        }

        int result = equalStacks(h1, h2, h3);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();
    }
}
