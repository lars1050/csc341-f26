## Programming Assignment 9 Priority Queues and Heaps

### Implementation due Thu Nov 19 end-of-day
Submit via Gitlab


<hr>

Create a GENERIC class __PriorityQ__ that implements a Max-Heap. The type being stored must implement Comparable\<T\>. When determining the order within the tree, use the \<T\>.compareTo() method. The compareTo method dictates the __key__ (or basis of ordering by priority).

You can create a priority queue with a default size of 20. When you create a new array for the priority queue, you must use the following code:

```
private T[] heap;

public PriorityQ() {
	@SuppressWarnings("unchecked")
	T[] temp = (T[]) new Comparable[20];
	heap = temp;
	...
}
```

Implement the following methods that are part of the user interface:

- `public PriorityQ()` : the default constructor.

- `public PriorityQ(T[] array)` : copy the array elements into the (new) heap array, then call heapify() to arrange into a priority queue. Note that you are copying elements into heap[], which will have the default size of 20. You can assume the array to copy will fit in heap[20] -- but of course you would never make such an assumption in the real world!

- `public T pop()` : Remove and return the object with the maximum priority in the heap. Do not worry about throwing an exception - return null if the heap is empty.

- `public void push(T object)`: add the object to the heap in the appropriate order. Do not worry about throwing an exception -- just ignore the request. Again, not something you would do in the real world.
  
-  `public vod keyChanged(T object)`: inform the Q that the key has changed for the given object. Find the object in the Q, and move it as appropriate.

- `public T peek()` : Return, but do not remove, the value with the maximum key in the heap. Return null if the heap is empty.

- `public boolean isEmpty()`: you know what this does :-)

- `public T[] getHeap()`: this is a getter for the array that holds the heap (or you can return a new array that is the exact size of the number of elements in the heap). It does not really make sense to provide this functionality to the user, because the array is in "heap" order, not sorted order. However, you probably will appreciate having this as you are debugging your code.

Implement the following **private** helper methods (**name them whatever makes sense to you - but still name them something that represents what they do**):

- private int left(int index): return the index of the left child of "node" at index

- private int right(int index): return the index of the right child of "node" at index

- private int parent(int index): return the index of the parent of "node" at index

- private void sink(int i): sink the value at index i "down" into the "tree"

- private void float(int i): float the value at index i "up" into the "tree"

- private void heapify(): convert the current array heap[] to a maximum priority queue. The algorithm is to iterate from the element at [size/2] down to index [0], and at each iteration, sink the element at that index.

<hr>

### Documentation
- Comment the code. Not too much, not too little.
- Style compliant.
- The Javadocs is not required for this assignment.

<hr>

### Testing

It is up to you to test your code and make sure it is meeting the requirements. I will not assess your tests.

Since the priority queue uses generics, you can test your code with Integers, which is by far the easiest. Just to be sure, you might want to also create one that holds a different type of object and add a few items.

As you are testing, feel free to change access modifiers to public or print things out in the class implementation. HOWEVER, this should all be cleaned up before you submit.


