package stack;

import java.util.Scanner;
import java.util.Stack;

public class MaxValueInStack {

    static class Node {

        public int value;
        public int max;

        public Node(int value, int max) {
            this.value = value;
            this.max = max;

        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int noOfCmds = sc.nextInt();
        Stack<Node> stack = new Stack<Node>();
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < noOfCmds; i++) {

            int cmd = sc.nextInt();
            if (cmd == 1) {
                int value = sc.nextInt();
                if (value > max) {
                    max = value;
                }
                stack.push(new Node(value, max));

            } else if (cmd == 2) {
                     stack.pop();
                if (!stack.empty()) {
                     Node top = stack.peek();
                     max = top.max;
                }
                else {
                    //reset
                    max = Integer.MIN_VALUE;
                }

            } else if (cmd == 3) {
                Node top = stack.peek();
                System.out.println(top.max);

            }


        }
    }
}

