package list;

public class SinglyLinkedList {

	Node head;

	class Node {
		String val;
		Node next;

	}

	public void addNodeToHead(String value) {

		Node n = new Node();
		n.val = value;

		// list is empty
		if (head == null) {
			head = n;

		} else {
			n.next = head;
			head = n;
		}

	}

	// remove first node with val when iterating from head
	public void findValExist(String val) {
		Node curr = head;

		while (curr != null) {
			if (curr.val == val) {
				System.out.println("Value found:" + val);
				return;

			}
			curr = curr.next;

		}

		System.out.println("No Value found:" + val);

	}

	public void remove(String val) {
		Node curr = head;
		Node prev = null;

		if (curr == null) {
			System.out.println("List is empty");
		}

		while (curr != null) {
			if (curr.val.equalsIgnoreCase(val)) {
				System.out.println("Value found:" + val);
				if (prev == null) {// means value to be removed is first or head
					head = curr.next;
				} else
					prev.next = curr.next;
				return;

			}
			prev = curr;
			curr = curr.next;

		}

		System.out.println("No Value found:" + val);

	}

	public void addNodeToTail(String value) {

		Node n = new Node();
		n.val = value;

		// list is empty
		if (head == null) {
			head = n;

		} else {
			Node curr = head;
			while (curr.next != null) {
				curr = curr.next;

			}

			curr.next = n;

		}

	}

	public void printList() {

		if (head == null) {
			System.out.println("List is empty");
			return;
		}

		Node curr = head;
		do {
			System.out.print(curr.val + ",");
			curr = curr.next;
		} while (curr != null);
		System.out.println("\n ========================");
	}

	public Node reverseList(Node node) {
		Node prev = null;
		Node curr = node;
		Node next = null;
		while (curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		node = prev;
		return node;

	}

	/**
	 * Get Nth node from Tail
	 * 
	 * @param head
	 * @param n
	 *            will be always smaller than list size
	 * @return
	 */
	public String getNthNodeFromTail(Node head, int n) {

		Node pt2 = head;
		int ctr = 0;
		while (ctr < n && pt2 != null) {
			ctr++;
			pt2 = pt2.next;
		}

		if (pt2 == null)
			return null;

		Node pt1 = head;
		while (pt2.next != null) {
			pt2 = pt2.next;
			pt1 = pt1.next;
		}

		return pt1.val;

	}

	/**
	 * Get Nth node from head
	 * 
	 * @param head
	 * @param n
	 *            will be always smaller than list size
	 * @return
	 */
	public String getNthNodeFromHead(Node head, int n) {
		Node curr = head;
		int i = 0;
		String res = null;

		while (i <= n && curr != null) {

			res = curr.val;
			curr = curr.next;
			i++;

		}

		return res;

	}

	public void printReverse(Node curr) {

		if (curr != null) {
			printReverse(curr.next);
			System.out.println(curr.val);
		}

	}

	public static void main(String[] args) {
		SinglyLinkedList sList = new SinglyLinkedList();
		// sList.addNodeToHead("A");
		// sList.printList();
		// sList.addNodeToHead("B");
		// sList.printList();

		sList.addNodeToTail("A");
		sList.addNodeToTail("B");
		sList.addNodeToTail("C");
		sList.printList();
		// sList.addNodeToTail("B");
		// sList.printList();
		// sList.addNodeToTail("C");
		// sList.printList();
		// sList.findValExist("A");
		// sList.findValExist("C");
		// sList.remove("A");
		// sList.printList();
		// sList.printReverse(sList.head);
		// System.out.println(sList.getNthNodeFromHead(sList.head, 3));
		System.out.println(sList.getNthNodeFromTail(sList.head, 0));

	}

}
