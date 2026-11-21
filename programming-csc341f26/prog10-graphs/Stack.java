public class Stack<T> implements QueueInterface<T> {
	
	class Node {
		T value;
		Node next;
		Node(T value) {
			this.value = value;
		}
	}
	
	/** Entry point of the stack. This is a sentinal. */
	private Node head = new Node(null);

    /** Tests if elements are in the queue. 
	* @returns boolean based on if queue is empty or not
	*/
    public boolean empty() {
		return head.next == null;
	}
    
    /** Add a new value to the stack 
	* @param value to add to stack
	*/
    public void push(T value) {
		Node n = new Node(value);
		n.next = head.next;
		head.next = n;
	}

    /** Remove the next value from the stack 
	* @returns the next value in the stack
	*/
    public T pop() {
		if (empty()) {
			return null;
		}
		T value = head.next.value;
		head.next = head.next.next;
		return value;
	}

    /** Look at the next value on the stack 
	* @returns the next value in the stack
	*/
    public T peek() {
		return head.next.value;
	}
}