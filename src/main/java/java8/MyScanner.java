package java8;

import java.util.Scanner;

public class MyScanner {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		//start read line and split
		String[] nd = scan.nextLine().split(" ");
		int n = Integer.parseInt(nd[0].trim());
		int d = Integer.parseInt(nd[1].trim());
		//end read line and split
		
		// start read 2 inputs on the same line - one string followed by int
		String myString = scan.next();
		int myInt = scan.nextInt();
		// end read 2 inputs on the same line - one string followed by int
		
		// Notes always better to read input as scan.nextLine() and then either split
		// if required or else parse it to it int or double value
		
		//or force use nextLine() to move cursor to next Line
		int n1= scan.nextInt();
		scan.nextLine();
		
		
		
	}

}
