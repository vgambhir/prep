package basic;

public class StairPrint {

	public static void main(String[] args) {
		printClimber(3);
	}

	public static void printClimber(int steps) {

		int[][] arr = new int[steps][steps];

		for (int x = 0; x < arr.length; x++) {
			String res = "";
			for (int y = 0; y < arr.length; y++) {
				if(x+y < arr.length -1 )
				    res+="-";
				else
					res+="*";
				
			}
			System.out.println(res);

		}

	}

	public static void printStair(int steps) {
		for (int x = 0; x < steps; x++) {
			String res = "";
			for (int y = 0; y <= x; y++) {
				res += "*";
			}
			System.out.println(res);
		}

	}

}
