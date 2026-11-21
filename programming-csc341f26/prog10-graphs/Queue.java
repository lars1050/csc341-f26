public class Queue<T> implements QueueInterface<T> {

	private static final int SIZE = 20;
	
	private int head = 0;
	private int tail = 0;
    
	@SuppressWarnings("unchecked")
	private T[] queue = (T[]) new Object[SIZE];

    /** Tests if elements are in the queue. 
	* @returns boolean based on if queue is empty or not
	*/
    public boolean empty() {
		return head == tail;
	}
	
	public boolean full() {
		return head == next(tail);
	}
	
	private int next(int index) {
		return (index+1) % SIZE;
	}
    
    /** Add a new value to the queue 
	* @param value to add to queue
	*/
    public void push(T value) {
    	if (full()) {
    		return;
    	}
		queue[tail] = value;
		tail = next(tail);
	}

    /** Remove the next value from the queue 
	* @returns the next value in the queue
	*/
    public T pop() {
    	if (empty()) {
			return null;
		}
		T value = queue[head];
		head = next(head);
		return value;
	}

    /** Look at the next value on the queue 
	* @returns the next value in the queue
	*/
    public T peek() {
		return queue[head];
	}

}