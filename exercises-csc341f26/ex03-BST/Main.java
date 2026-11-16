class Main {
	public static void main(String[] args) {
	
		BST bst = new BST();
		
		int[] toAdd = {20,15,25,10,17,5,22,28,26};
		
		for (int n: toAdd) {
			bst.add(n);
		}
		
		System.out.println(bst);
	}
}