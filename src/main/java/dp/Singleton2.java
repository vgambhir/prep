package dp;

/**
 * restricts the creation of only one instance for a class
 * 
 * @author vandana
 *
 */
public class Singleton2 {

	private static Singleton2 sPattern = null;

	private Singleton2() {
	}

	public static Singleton2 getInstance() {

		if (null == sPattern) {

			synchronized (Singleton2.class) {
				if (null == sPattern) {
					sPattern = new Singleton2();
				}
			}
		}
		return sPattern;
	}

}
