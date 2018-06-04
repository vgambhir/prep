package dp;

/**
 * restricts the creation of only one instance for a class
 * 
 * @author vandana
 *
 */
public class Singleton4 {

	private static final Singleton4 sPattern = new Singleton4();

	private Singleton4() {
	}

	public static Singleton4 getInstance() {
		return sPattern;

	}

}
