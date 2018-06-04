package tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Binary Search Tree (BST)
 * 
 * @author vandana
 *
 */
public class BinaryTree {

	Node root;

	class Node {
		Node left;
		Node right;
		int val;

	}

	public void addNode(int val) {
		root = insertNode(root, val);

	}

	/*
	 * Compute the "maxDepth or height" of a tree -- the number of nodes along the
	 * longest path from the root node down to the farthest leaf node.
	 */
	int maxHeight(Node curr) {
		if (curr == null)
			return 0;
		else {
			/* compute the depth of each subtree */
			int lHeight = maxHeight(curr.left);
			int rHeight = maxHeight(curr.right);

			/* use the larger one */
			if (lHeight > rHeight)
				return (lHeight + 1);
			else
				return (rHeight + 1);
		}
	}

	int size() {
		return size(root);
	}

	/* computes number of nodes in tree */
	int size(Node curr) {
		if (curr != null)
			System.out.println(curr.val);
		else
			System.out.println("node is null");

		if (curr == null)
			return 0;
		else
			return (size(curr.left) + 1 + size(curr.right));
	}

	public Node insertNode(Node curr, int val) {

		if (curr == null) {
			Node newNode = new Node();
			newNode.val = val;
			return newNode;
		}

		if (val < curr.val) {
			curr.left = insertNode(curr.left, val);

		} else if (val > curr.val) {
			curr.right = insertNode(curr.right, val);

		} else {
			return curr;
		}
		return curr;
	}

	/**
	 * LMR In order w.r.t root 4 6 8
	 * 
	 * @param curr
	 */
	public void traverseInOrder(Node curr) {
		if (curr != null) {
			traverseInOrder(curr.left);
			System.out.print(" " + curr.val);
			traverseInOrder(curr.right);
		}

	}

	/**
	 * LRM In order w.r.t root 4 8 6
	 * 
	 * @param curr
	 */
	public void traversePostOrder(Node curr) {
		if (curr != null) {
			traversePostOrder(curr.left);
			traversePostOrder(curr.right);
			System.out.print(" " + curr.val);
		}

	}

	/**
	 * MLR In order w.r.t root 6 4 8
	 * 
	 * @param curr
	 */
	public void traversePreOrder(Node curr) {
		if (curr != null) {
			System.out.print(" " + curr.val);
			traversePreOrder(curr.left);
			traversePreOrder(curr.right);

		}

	}

	public void printBreathFirst(Node root) {
		Queue<Node> queue = new LinkedList<Node>();

		if (root != null) {
			queue.add(root);
			System.out.println(root);
		}

		while (!queue.isEmpty()) {
			Node curr = queue.remove();
			if (curr.left != null) {
				System.out.println(curr.left.val);
				queue.add(curr.left);

			}
			if (curr.right != null) {
				System.out.println(curr.right.val);
				queue.add(curr.right);
			}
		}

	}

	public void printLevelOrder() {
		int h = maxHeight(root);
		int i;
		for (i = 1; i <= h; i++)
			printGivenLevel(root, i);
	}

	/* Print nodes at the given level */
	private void printGivenLevel(Node curr, int level) {
		if (curr == null)
			return;
		if (level == 1)
			System.out.print(curr.val + " ");
		else if (level > 1) {
			printGivenLevel(curr.left, level - 1);
			printGivenLevel(curr.right, level - 1);
		}
	}

	public static void main(String[] args) {
		BinaryTree bTree = new BinaryTree();
		bTree.addNode(6);
		// bTree.traverseInOrder(bTree.root);
		// bTree.addNode(4);
		// bTree.addNode(8);
		// bTree.addNode(3);
		// bTree.addNode(5);

		System.out.println("\n************");
		// bTree.traverseInOrder(bTree.root);
		System.out.println("\n************");
		// bTree.traversePostOrder(bTree.root);
		System.out.println("\n************");
		// bTree.traversePreOrder(bTree.root);
		System.out.println("\n************");
		// System.out.println(bTree.size());
		System.out.println("\n************");
		System.out.println(bTree.maxHeight(bTree.root));
	}

}
