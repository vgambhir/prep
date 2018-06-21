package homeaway;

import java.util.Stack;

/**
 * The following are the only functions that should be used to write this program: push | pop | peek | isEmpty 
 * @author vandana
 *
 */



public class SortStack {
	public static Stack<Integer> sortStack(Stack<Integer> input) {

		Stack<Integer> resultStack = new Stack<Integer>();
		System.out.println("=============== debug logs ================");
		while (!input.isEmpty()) {
			int curr = input.pop();
			System.out.println("Element taken out: " + curr);
			while (!resultStack.isEmpty() && resultStack.peek() > curr) {
				input.push(resultStack.pop());
			}
			resultStack.push(curr);
			System.out.println("input: " + input);
			System.out.println("resultStack: " + resultStack);
		}
		System.out.println("=============== debug logs ended ================");
		return resultStack;
	}

	public static Stack<Integer> sort1(Stack<Integer> s) {

		// result in descending order..resultStack will have smallest at bottom
		Stack<Integer> resultStack = new Stack<Integer>();

		while (!s.isEmpty()) {

			int curr = s.pop();

			while (!resultStack.isEmpty() && curr < resultStack.peek()) {

				// change places push back to input stack
				s.push(resultStack.pop());

			}

			resultStack.push(curr);

		}

		return resultStack;

	}

	public static void main(String[] args) {
		
		  Stack<Integer> input = new Stack<Integer>();
		  input.push(5);
		  input.push(2);
		  input.push(9);
		  Stack<Integer> result = SortStack.sort1(input);
		  System.out.println(result.toString());
		  
		

	}

}
