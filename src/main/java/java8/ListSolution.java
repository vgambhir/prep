package java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class ListSolution {

	public static void main(String[] args) {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT. Your
		 * class should be named Solution.
		 */
		Scanner scanner = new Scanner(System.in);
		int noOfElements = new Integer(scanner.nextLine());
		String listElem = scanner.nextLine();
		String[] arr = listElem.split(" ");
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < arr.length; i++) {
			list.add(arr[i]);
		}
		System.out.println(Arrays.toString(list.toArray()));
		String opNo = scanner.nextLine().trim();
		String op = scanner.nextLine().trim();
		String[] arg1 = scanner.nextLine().split(" ");
		list.add(Integer.parseInt(arg1[0]) - 1, arg1[1]);
		System.out.println(Arrays.toString(list.toArray()));
		Set<String> nodeSet = new HashSet<String>();
		
	}
}
