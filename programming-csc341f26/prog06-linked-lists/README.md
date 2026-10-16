## Programming Assignment 06 : Linked List of Auggies

Due: Thursday, March 26 end-of-day

In this lab, you will again be creating the ADT List, except this time you will be implementing it using a linked list.


### GENERAL REQUIREMENTS

**You are responsible for testing your code.** It does not have to be a formal test and you will not be graded on your tests. You will be graded on the completeness, correctness, and quality of your code.

High quality code is expected:
- clean and organized
- self-documenting, which means using good naming conventions for your variables
- commented, and those comments should describe the purpose of the code (the why), not what it is doing (unless you are using some hard-to-follow logic that would be useful to explain).
- style-compliant. 

The Javadocs has been completed for you.

**Special Constraint**: You may not maintain a count of elements in the list.

**Special Constraint**: You may not break out of any for loop. If you do not know how many interations there will be, then you should be using a while loop. Since you may not maintain a count of items, it is not likely that you would even know how many iterations.

> Note that for any method that specifies an index, you will not know if an index is valid until after iterating through the List.


<hr>

#### LIST IMPLEMENTATION

Any method of a List should have the same behavior, regardless if implemented using an array or a linked list.

**Helper Functions**

- `public boolean empty()` determines whether or not there are any items in the List.

- `@Override public String toString()` overrides Object method for printing.

**Constructors**

- `public List()` default constructor.


**Add Methods**

- `public void add(Auggie auggie)` adds that item to the end of the list.

- `public void add(Auggie auggie, int index)` adds that Auggie at the stated index or throws an IllegalOperationException if the index is not valid.


**Find Methods**

- `public Auggie get(int index)` returns List element at that index or throws IllegalOperationException if the index is not valid.

- `public int locate(Auggie auggie)` returns index (location) of the auggie or -1 if it is not in the list.


**Remove Methods**

- `public void remove(Auggie auggie)` Removes that item from the list or throws IllegalOperationException if it is not in the list.

- `public Auggie remove(int index)` Removes the auggie at that index and returns that value. Throws an IllegalOperationException if the index is not valid.


**Conversion Method**

- `Auggie[] toArray()` returns an array that contains the List elements. If the list is empty, throws an IllegalOperationException.

- `void reverse()` reorganizes the List so that it is in the reverse order of how it is currently organized. You may iterate over the list only one time to complete this method. You may not create new Nodes in the process.



