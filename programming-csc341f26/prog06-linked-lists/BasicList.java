/**
ADT List maintaining a List of Basic objects.
Objects are added to the end of the list by default.
The first element of the list is at "index" 0. This is to match the behavior of a List implemented with an array.
*/
public class BasicList {

    /** Reference to first element of the list. */
    private Node head = null;

    /** Reference to last element of the list. */
    private Node tail = null;
    
    // ____________________________________________________
    //                  PRIVATE NODE CLASS
    // ____________________________________________________
    /*
    This is a Node class private to the BasicList class 
    because it is an implementation detail. Users of BasicList do not need access.
    Because it is part of the BasicList, the class has direct access to its members.

    There are no javadocs for this class because it is private.
    */
    private class Node {
        // Hold a List item
        Basic value;
        // Reference to the next element in the list.
        Node next;

        // Only constructor for a new Node
        Node(Basic b) {
            value = b;
        }
    } // end class Node

    // ____________________________________________________
    //              CONSTRUCTORS and toString
    // ____________________________________________________

    /** Default constructor */
    public BasicList() {
        // nothing to do here
        // all member variables initialized at declaration
    }

    @Override
    public String toString() {
        // TODO 
        return "";   
    }

    // ____________________________________________________
    //              LIST STATUS METHODS
    // ____________________________________________________

    /** Reports status of List. */
    public boolean empty() {
    	// TODO
        return true;
    }

    // ____________________________________________________
    //                   ADD METHODS
    // ____________________________________________________

    /**
    * Add specified item to the end of the List.
    * @param basic item to be added to the List.
    */
    public void add(Basic basic) {

    } // end add(basic)

    /**
    * Add specified item to the List at specified location (if index valid)
    *
    * @param index Location within the List (0-based indexing)
    * @param basic item to be added to the List
    * @throws IllegalOperationException if index is out of bounds.
    */
    public void add(Basic basic, int index) throws IllegalOperationException {
    

    } // end add(basic,index)

    // ____________________________________________________
    //                   SEARCH METHODS
    // ____________________________________________________

    /**
    * Retrieve the first element in the list (without removing).
    *
    * @return basic at the front of the list.
    * @throws IllegalOperationException if list is empty.
    */
    public Basic peekFirst() throws IllegalOperationException {
        if (empty()) {
            throw new IllegalOperationException("List is empty. No peeking.");
        }
        return head.value;
    }
    
    /**
    * Retrieve the last element in the list (without removing).
    *
    * @return basic at the end of the list.
    * @throws IllegalOperationException if list is empty.
    */
    public Basic peekLast() throws IllegalOperationException {
        if (empty()) {
            throw new IllegalOperationException("List is empty. No peeking.");
        }
        return tail.value;
    }
    
    
    /**
    * Retrieve basic at specified index (if valid), without removing it.
    *
    * @param index Location within the list (0-based indexing)
    * @return basic at index if index valid
    * @throws IllegalOperationException if index is out of bounds.
    */
    public Basic get(int index) throws IllegalOperationException {
        
        return null;
        
    } // end get(index)



    /**
    * Determine location of specified basic (0-based indexing).
    *
    * @param basic item searching for in List.
    * @return location (0-based) of item, or -1 if not in list
    */
    public int locate(Basic basic) {

        return -1;
        
    } // end locate(auggie)

    // ____________________________________________________
    //                   REMOVE METHODS
    // ____________________________________________________

    /**
    * Remove specified item from the List
    *
    * @param basic item to be removed from the List (if in the List)
    * @throws IllegalOperationException if basic is not in the list
    */
    public void remove(Basic basic) throws IllegalOperationException {

        // do NOT call the locate method here -- it is inefficient

    } // end remove(auggie)

    /**
    * Remove item at specified index (if index valid)
    *
    * @param index Location within List (0-based indexing)
    * @return basic at specified location
    * @throws IllegalOperationException if index out of bounds
    */
    public Basic remove(int index) throws IllegalOperationException {
       
       return null;
       
    } // end remove(index)

    // ____________________________________________________
    //                   CONVERT METHODS
    // ____________________________________________________
    
    /**
    * Fills a new Basic array with List items.
    *
    * @return Basic array with current List items. The size of the array is equal to the number of elements.
    * @throws IllegalOperationException if the List is empty
    */
    public Basic[] toArray() throws IllegalOperationException {
    	// Iterate through the list to determine length
    	// Create the Array
    	// Copy List elements into the array
    	
        return null;
    } // end toArray
    
    /**
    * Reverse the list relative to how it is currently organized.
    */
    public void reverse() {
    	// Constraint: iterate 1 time only through the full list to reverse it.
    	// Constraint:  You may not create new Nodes in the process.
    }
    
}
