## Programming 8 Queues and Stacks with Generics

### DUE: Sunday, November 15, end-of-day

<hr>

In this assignment, you will implement the ADT Queue and the ADT Stack. Both will be implementing the QueueInterface. All of these will operate on Generic objects.

The Queue should be implemented using a **Circular Array**, which uses indices to mark the "head" and "tail" of the queue that is stored in the array. You should also use a **dummy space** in this implementation, meaning an extra space that is a buffer between the end of the array and the head (it is always 1 space "before" the head). **The count is not maintained.**

> If the indices used for the head and tail of the Queue are equal, then the Queue is empty. If the tail index + 1 would be equal to the head index of the Queue, then the Queue is full.

The Stack implementation should be done with a linked list with a *sentinel/dummy node* at the head of the Stack. For the implementation, both push and pop operate at the head. There is no need to maintain a tail.


> The word "queue" is used both as a general concept and as a specific ADT. The ADTs Stack and Queue are technically both queues in that they only operate on the ends of the structure, not in the middle. There is also a Priority Queue and a Deque (not to be confused with the operation dequeue, which is synonymous with remove). Typically, when someone just says "queue," they mean an FIFO Queue, but if there is any ambiguity be sure to ask.

<hr>

### QueueInterface with Generics

Modify the QueueInterface so that it can operate on generics.

- `public void push(Object value)` : add a value to the end of the Queue.
- `public Object pop()` : remove the first element of the Queue.
- `public Object peek()` : return the first element of the Queue, but do not remove it.
- `public boolean isEmpty()` : true if Queue is empty.


### Implementation of class Queue

Create the file Queue.java. This contains the class definition that implements the QueueInterface and uses generics so that it can store any type of object.

Use the following code to define the array for your Queue:

```
private static final int size = 6;
	
@SuppressWarnings("unchecked")
private T[] queue = (T[]) new Object[size];
```

The tag to SuppressWarnings is related to the cast from Object to T. It is a message to the compiler to ignore the warning that it would typically produce regarding this cast.

>Note: use 5 as the default CAPACITY for testing purposes, which means you need an array of size 6. No count will be maintained for the Queue. Please make sure the size is only 6, so that the elements will be wrapping around the circular array.

The methods for `public class Queue implements QueueInterface` are specified by the QueueInterface. 

Additionally:
- `public String toString()` : override Object toString, which might be useful for debugging.


Your class Queue should have the following private member variables. You may include more than these.
- `private int head` : index of the first element in the Queue
- `private int tail` : index of the location to place the next added value

>Note: you might find it useful to have a helper function that returns the "next" index.


### Implementation of class Stack

Create the file Stack.java. This contains the class definition that implements the QueueInterface and uses generics so that it can store any type of object.

The methods for `public class Stack implements QueueInterface` are specified by the QueueInterface. 

Additionally,
- `public String toString()` : override Object toString, which might be useful for debugging.

Your class Stack should have the private member variable:
- `Node head` : this always points to the dummy node.

<hr>

### Testing

The Tester.java file will test your ADTs using different types. Make sure it compiles, runs, and produces the correct output.

Submit via Gitlab
