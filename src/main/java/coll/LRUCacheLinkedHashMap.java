package coll;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Use 
 * LinkedHashMap get(k), put (k,v) tim implement LRU
 * 
 * @author vandana

 *
 */
public class LRUCacheLinkedHashMap<K, V> extends LinkedHashMap<K, V> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int cacheSize = 0;

	public LRUCacheLinkedHashMap(int cacheSize) {
		super(16, 1, true);
		this.cacheSize = cacheSize;
	}

	protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
		return this.size() > cacheSize;
	}

	public static void main(String[] args) {

		LRUCacheLinkedHashMap<String, String> m = new LRUCacheLinkedHashMap<String, String>(3);
		m.put("A", "Alpha");
		System.out.println(m);

		m.put("B", "Beta");
		System.out.println(m);
		m.put("C", "Carla");
		System.out.println(m);
		m.get("A");
		m.put("D", "Darlene");
		System.out.println(m);
	}
}
