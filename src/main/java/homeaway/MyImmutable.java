package homeaway;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Making class immutable
 * 
 * @author vandana
 *
 *         1. mark class as final 2. make all fields as final 3. remove all
 *         setters
 */
// mark class as final
public final class MyImmutable {

	// mark all fields as final
	private final Date date;

	private final String name;

	private final Map<String, Date> map;

	/**
	 * Constructor
	 * 
	 * @param date
	 * @param n
	 * @param hm
	 */

	
	public MyImmutable(Date date, String n, Map<String, Date> hm) {
		this.date = new Date();
		this.name = n;
		this.map = new HashMap<String, Date>();
	}
	
	

	public Date getDate() {
		return date;
	}

	public String getName() {
		return name;
	}

	public Map<String, Date> getMap() {
		return map;
	}
}
