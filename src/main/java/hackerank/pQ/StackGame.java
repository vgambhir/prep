package hackerank.pQ;

import java.util.Stack;

import static hackerank.pQ.StackSizeCompare.populateStack;

public class StackGame {


    public static void main(String[] args) {

        System.out.println(twoStacks(55, new int[]{11, 6, 1, 13, 14, 7, 8, 10, 3, 17, 7, 18, 6, 4, 5, 13, 17, 4, 16, 9, 17, 16, 12, 6, 7}, new int[]{10, 15, 13, 17, 10, 7, 0, 16, 8, 13, 11, 8, 14, 13}));


    }

    public static void populateStack(int[] arr, Stack<Integer> st) {
        for (int i = arr.length - 1; i >= 0; i--) {

            st.push(arr[i]);

        }


    }

    public static Stack<Integer> findStackWithNumber(Stack<Integer> st1, Stack<Integer> st2) {

        if (!st1.empty() && !st2.empty()) {
            return st1.peek() < st2.peek() ? st1 : st2;
        } else if (st1.empty())
            return st2;
        else if (st2.empty())
            return st1;
        else
            return st1;

    }


    static int twoStacks(int x, int[] a, int[] b) {
        Stack<Integer> st1 = new Stack<>();
        Stack<Integer> st2 = new Stack<>();

        populateStack(a, st1);
        populateStack(b, st2);

        int currSum = 0;
        int count = 0;
        //chose number to pop

        while (currSum < x) {

            int min = 0;
            Stack<Integer> tempStack = findStackWithNumber(st1, st2);

            if ((tempStack.peek() + currSum) > x) {
                return count;

            } else {
                int popNumber = tempStack.pop();
                count++;
                currSum += popNumber;

            }
        }
        return count;

    }

}
