/***************************************************************************
* Author: Ziting Shen
* Date: 10/04/2015
*
* This program implements a generic binary search tree.
*
*/
class BinarySearchTree<T extends Comparable<T>>{
	Node<T> root;
	int size;

	// constructors
	BinarySearchTree(){
    	root = null;
    	size = 0;
	}

	BinarySearchTree(T initial) {
		root = new Node<T>(initial);
		size = 1;
	}

	BinarySearchTree(T[] initials) {
		for(T i: initials) {
			add(i);
			size++;
		}
	}

	// add an item to the tree
	public void add(T newitem){
		root = add(newitem, root);
	}

	private Node<T> add(T newitem, Node<T> n){
		if(n == null) {
			n = new Node<T>(newitem);
			size++;
			return n;
		}
		if(n.compareTo(newitem) > 0) {
			n.left = add(newitem, n.left);
			return n;
		}
		n.right = add(newitem, n.right);
		return n;
	}

	// print out the in-order traverse of the tree
	public void inOrderTraverse(){
		inOrderTraverse(root);
	}

	private void inOrderTraverse(Node<T> n) {
		if(n != null){
			inOrderTraverse(n.left);
			System.out.println(n);
			inOrderTraverse(n.right);
		}
	}

	// a nested class of the nodes in the tree
	private class Node<T extends Comparable<T>>{
	    T content;
		Node<T> left;
		Node<T> right;

		// constructors
		Node(){
			content = null;
			left = null;
			right = null;
		}

		Node(T content){
			this.content = content;
			left = null;
			right = null;
		}

		Node(T content, Node<T> left, Node<T> right) {
			this.content = content;
			this.left = left;
			this.right = right;
		}

		// compare the node to another T object
		public int compareTo(T other) {
			return content.compareTo(other);
		}

		// convert the node to a string
		public String toString() {
			return content.toString();
		}
	}

	// an optional tester
	public static void main(String[] args) {
		System.out.println("tester!");
		String[] arr = {"why", "who are you", "SB", "just test", "ohmy"};
		BinarySearchTree<String> b = new BinarySearchTree<String>(arr);

		b.inOrderTraverse();
	}
}