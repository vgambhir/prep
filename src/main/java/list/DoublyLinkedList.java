package list;

public class DoublyLinkedList {

	Node head;

	public void addNodeToHead(String val) {
		Node n = new Node();
		n.val = val;
		// list is empty
		if (head == null) {
			head = n;
		} else {
			Node temp = head;
			temp.prev = n;
			n.next = temp;
			head = n;

		}

	}

	public void addNodeToTail(String val) {
		Node n = new Node();
		n.val = val;
		// list is empty
		if (head == null) {
			head = n;
		} else {
			Node curr = head;
			while (curr.next != null) {
				curr = curr.next;

			}
			curr.next = n;
			n.prev = curr;

		}

	}

	public void removeNode(String val) {
		if (head == null) {
			// list is empty
			System.out.println("List is empty");
			return;
		}
		// val is in head node
		Node curr = head;
		if (curr.val.equals(val)) {
			// remove head;
			head = curr.next;

		} else {
			curr = curr.next;
			while (curr != null) {
				if (curr.val.equals(val)) {
					Node prev = curr.prev;
					Node next = curr.next;
					prev.next = next;
					if (next != null)
						next.prev = prev;
					System.out.println("Found element:" + val);
					return;
				}
				curr = curr.next;

			}

		}
		System.out.println("Element not in List");

	}

	public void printList() {
		Node curr = head;
		while (curr != null) {
			System.out.print(curr.val + ",");
			curr = curr.next;
		}
		System.out.println("\n========================");
	}

	class Node {

		Node prev;
		String val;
		Node next;

	}

	public static void main(String[] args) {
		DoublyLinkedList dLinkList = new DoublyLinkedList();
		// dLinkList.addNodeToHead("A");
		// dLinkList.printList();
		// dLinkList.addNodeToHead("B");
		// dLinkList.printList();

		dLinkList.addNodeToTail("A");
		dLinkList.printList();
		dLinkList.addNodeToTail("B");
		dLinkList.printList();
		dLinkList.addNodeToTail("C");
		dLinkList.printList();
		dLinkList.removeNode("C");
		dLinkList.printList();
	}

}
