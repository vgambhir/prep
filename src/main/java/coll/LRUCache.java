package coll;

import java.util.HashMap;
import java.util.Map;
/**
 * Least recently used cache implementation, eviction of least recently used item from cache
 * @author vandana
 *
 */
public class LRUCache {

	private Map<String, Node> map; //key
	private Node head;
	private Node tail;
	private int cacheSize = -1;
	private int counter = 0 ;

	class Node {
		@Override
		public String toString() {
			return "Node [key=" + key + ", val=" + val + "]";
		}

		String key; // acts as key in map
		String val;
		Node prev;
		Node next;

	}

	public LRUCache(int size) {
		this.cacheSize = size;
		map = new HashMap<String, Node>();
	}

	public void put(String key, String val) {

		// update remove node from list
		if (map.containsKey(key)) {
			Node curr = map.get(key);
			curr.val = val;
			Node prev = curr.prev;
			Node next = curr.next;
			// end of list
			if(next == null)
				tail = prev;
			
			prev.next = next;
			if(next != null)
			{
			next.prev = prev;
			}
			addNodeToHead(curr);
			return;

		}
        // if new node and cache is not full
		if (counter < cacheSize) {
			Node n = new Node();
			n.key = key;
			n.val = val;
			map.put(key, n);
			addNodeToHead(n);
			counter++;
		} 
		
		// if cache is full delete tail from map and reference from tail and add new node to head and map
		else {
			// delete tail node
			Node n = new Node();
			n.key = key;
			n.val = val;
			// delete tail node and remove from map
			String nKey = tail.key;
			map.remove(nKey);
			Node prev = tail.prev;
			prev.next = null;
			tail = prev;
			map.put(key, n);
			addNodeToHead(n);

		}

	}

	public void addNodeToHead(Node n) {

		if (head == null) {
			head = n;
			tail = n;
		} else {

			Node temp = head;
			temp.prev = n;
			n.next = temp;
			head = n;

		}

	}

	public void printResults() {
		System.out.println("**********************************");
		System.out.println(map);
		System.out.println("______________");

		Node curr = head;
		while (curr != null) {
			System.out.print(curr + "--");
			curr = curr.next;
		}

		System.out.println("\n Tail =" + tail.key + "," + tail.val);
		System.out.println("**********************************");

	}

	public static void main(String[] args) {

		LRUCache cache = new LRUCache(3);
		cache.put("A", "Alpha");
		cache.printResults();
		cache.put("B", "Beta");
		cache.printResults();
		cache.put("C", "Charlie");
		cache.printResults();
		cache.put("D", "Delta");
		cache.printResults();
		cache.put("B", "Bravo");
		cache.printResults();
	}

}
