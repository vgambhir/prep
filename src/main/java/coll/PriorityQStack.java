package coll;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Implement a stack using priority Q Stack LIFO methods that need to be
 * supported are push(element), pop() return element, peek(see top elemement),
 * isStackEmpty, searchElement(how far from top)
 * 
 * push == addFirstQ pop = removeFirstQ peel == peekFirst
 * 
 * @author vandana
 *
 */
public class PriorityQStack {

	int count = 0;
	private PriorityQueue<Node> pq = new PriorityQueue<Node>(new NodeComparator());

	public String push(String val) {

		Node n = new Node();
		n.count = count++;
		n.val = val;
		pq.add(n);
		return val;

	}

	public String pop() {
		Node n = pq.poll();
		return n.val;

	}
	
	public static void main(String[] args) {
		PriorityQStack pqStack = new PriorityQStack();
		pqStack.push("A");
		pqStack.push("B");
		pqStack.push("C");
		System.out.println(pqStack.pop());
		
	}
	
	

}

class Node {
	String val;
	int count;

}

class NodeComparator implements Comparator<Node> {

	@Override
	public int compare(Node o1, Node o2) {

		if (o1.count < o2.count)
			return 1;
		else
			return -1;
	}

}
