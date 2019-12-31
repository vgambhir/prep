package basic;
/**
 * Draw Cross given square of given length
 * @author vandana
 *
 */
public class DrawCross {

	public static void main(String[] args) {
		int n = 10;
		
		for (int i = 0; i < n; i++) {
			String res = "";
			for (int j = 0; j < n; j++) {

				if ((i == j) || (i+j) == (n-1))
					res += "*";
				else
					res += "-";

			}

			System.out.println(res);

		}

	}
}
