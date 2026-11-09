/** Defines the methods for any type of Queue - FIFO, LIFO, priority */
public interface QueueInterface {

    /** Tests if elements are in the queue. */
    public boolean empty();
    
    /** Add a new value to the queue */
    public void push(Object value);

    /** Remove the next value form the queue */
    public Object pop();

    /** Look at the next value on the queue */
    public Object peek();


}