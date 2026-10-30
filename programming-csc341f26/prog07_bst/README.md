## Programming Assigment 7 - Binary Search Trees

### Due Thursday, November 5 end-of-day. Submit via Gitlab.

In this programming assignment, you will create the Abstract Data Type List, except this time you will use a Binary Search Tree for implementation. The List will be storing elements of type AlphaNumeric.

Learning Outcomes:
- Understand the structure of a binary tree.
- Understand the structure of a binary search tree.
- Know how to implement a binary search tree.
- Know how to implement a class that uses the Comparator interface.
- Use iteration to traverse a binary search tree.
- Use recursion to traverse a binary search tree.

<hr>

Things to keep in mind:

If you are searching for an element based on the ordering of the tree, then you can use binary search. However, if you need to access every element in the tree or perform a "linear" search, you must use recursion. This is the ONLY way to traverse the tree (unless you maintain your own stack, which we will not do until a few weeks from now).

Please make sure your code is **style compliant**. 

Use the method empty() when you need to check that -- not repeatedly check if root is null. REASON: if you ever change how you checked if a list was empty, you have to change it in only 1 place!

Please add **Javadocs** and appropriately **comment** your code.

It is your responsibility to ensure your code is functioning as required. Please ask if you have any questions or need clarification on the requirements.

<hr>

### Implementation Requirements

Implement the following. **Look at Main.java to get the full signature of the method.**

If the List is empty and min or max are called, throw an `IllegalOperationException`.

- `String toString()` : Create a string of values in order
- `int height()`	: returns the height of the tree
- `void add()`
- `private void adjustHeight(Node n)`
- `private boolean empty()`
- `boolean contains()`
- `AlphaNumeric min()` : based on order of tree (you know where this is in the tree)
- `AlphaNumeric max()` : based on order of tree (you know where this is in the tree)
- `ArrayList<AlphaNumeric> query()` : find all elements that match the lambda function
- `AlphaNumeric findLast()` : find the last occurrence of the element that matches the lambda function, based on the ordering of the tree.
- `AlphaNumeric[] toArray()` : place elements in the tree into the array IN SORTED ORDER. You may not use any Java functions to do this for you. You must declare the array, and individually place each element into the array. This is a challenging method to write.

A note about `private void adjustHeight(Node n)`. When you add to the tree (at the bottom), you might need to adjust the height of nodes along the path from the one you just added back to the root. Follow the path back through the parent pointers. If at any node, the height does not change, return from the method. Note that the height of a node can be determined by the height of the left and right nodes.

There is a little bit of code in Main to add some elements to the tree. It calls all the methods to ensure you are matching the signature requirements.

<hr>

All students will need to make an appointment to check in with me on this assignment. I will ask you to explain parts of the code, ask how the code needs to change to change the behavior, and potentially ask you to write code on paper related to binary search trees. If you cannot answer questions about your code that you "wrote", one can only assume you did not write it.










