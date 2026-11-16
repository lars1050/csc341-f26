
// NAMES HERE: 
// TODO: write comments within the function for 2 of the add() versions


// Binary Search Tree class with add and toString implemented
// 4 versions of add (all do the same thing)
class BST {

	class Node {
		int value;
		Node left;
		Node right;
		Node parent;
		Node(int val) { value = val; }
	} // end class Node
	
	// Entry point into the BST
	Node root;
	
	public String toString() {
		// in order tree print (from min to max)
		return toString("", root);
	}
	
	public String toString(String toReturn, Node n) {
		// stopping condition (bottom of the tree)
		if (n==null) { return toReturn; }
		
		// Print all of the left subtree
		toReturn = toString(toReturn, n.left);
		
		// print the root of this subtree
		toReturn += n.value + " ";
		
		// print all of the right subtree
		return toString(toReturn, n.right);
		
	} // end toString
	
	public void add(int num) {
		// if it's the first add (root), just do this
		if (null==root) { 
			root = new Node(num);
			return;
		}
		
		// otherwise, choose any one of these versions
		add_v1(num);
		//add_v2(num);
		//add_v3(num);
		//add_v4(num,root);
	} // end add
	
	public void add_v1(int num) {
		Node node = new Node(num);
		Node it = root;
		while (it != null) {
			if (num <= it.value) {
				if (it.left == null) {
					it.left = node;
					node.parent = it;
					it = null;
				} else {
					it = it.left;
				}
			} else {
				if (it.right == null) {
					it.right = node;
					node.parent = it;
					it = null;
				} else {
					it = it.right;
				}
			} // end if (num <= ...)
		} // end while
	} // end add_v1
	
	public void add_v2(int num) {
		Node node = new Node(num);
		Node it = root;
		boolean foundParent = false;
		while (!foundParent) {
			if (num <= it.value) {
				if (null==it.left) {
					foundParent = true;
				} else {
					it = it.left;
				}
			} else {
				if (null==it.right) {
					foundParent = true;
				} else {
					it = it.right;
				}
			} // end if (num <= ...)
		} // end while 
		if (num <= it.value) {
			it.left = node;
		} else {
			it.right = node;
		}
		node.parent = it;
	} // end add_v2
	
	public void add_v3(int num) {
		Node node = new Node(num);
		Node prev = null;
		Node it = root;
		while (it != null) {
			prev = it;
			if (num <= it.value) {
				it = it.left;
			} else {
				it = it.right;
			}
		} // end while
		
		if (num < prev.value) {
			prev.left = node;
		} else {
			prev.right = node;
		}
		node.parent = prev;
	} // end add_v3
	
	public void add_v4(int num, Node it) {
		if (num <= it.value && null==it.left) {
			it.left = new Node(num);
			it.left.parent = it;
			return;
		}
		if (num > it.value && null==it.right) {
			it.right = new Node(num);
			it.right.parent = it;
			return;
		}
		if (num <= it.value) {
			add_v4(num, it.left);
		} else {
			add_v4(num, it.right);
		}
	} // end add_v4
	
} // end class BST
