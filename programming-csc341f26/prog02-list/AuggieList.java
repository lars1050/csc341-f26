/** A collection of Auggie objects listed in no particular order. */
public class AuggieList {

    /** Basic array structure for storing the collection of auggies */
    private Auggie[] auggies;

    /** Default for maximum number of auggies that can be stored */
    private static final int DEFAULT_CAPACITY = 200;

    /** The number of auggies stored in the array. */
    private int length = 0;

    // ____________________________________________________
    //              CONSTRUCTORS
    // ____________________________________________________

    /** 
     */
    public AuggieList(int capacity) {
        // TODO: complete this constructor (and the javadocs)
    }

    /** Default Constructor */
    public AuggieList() {
        this(DEFAULT_CAPACITY);
    }

    // ____________________________________________________

    @Override
    public String toString() {
        // Create numbered list of auggies in the collection
        String printedList = "";
        for (int i = 0; i < length; i++) {
            printedList += (i + 1) + ". " + auggies[i].toString() + "\n";
        }
        return printedList;
    } // end toString()


    // ____________________________________________________
    //              LIST STATUS METHODS
    // ____________________________________________________

    /**
     *
     */
    public boolean isFull() {
        // TODO: fix this (can be 1 line of code) 
        return false;
    }

    /**
     *
     */
    public boolean isEmpty() {
        // TODO: fix this (can be 1 line of code) 
        return false;
    }

    /** Determines if provided index can be used to access List element.
     *
     */
    private boolean isValid(int index) {
        // TODO: fix this (a few lines of code).
        // This is based on the known number of elements in the array.
        return false;
    }


    // ____________________________________________________
    //                   ADD METHODS
    // ____________________________________________________

    /**
    */
    public void add(Auggie auggie) throws IllegalOperationException {
        // Default location for adding an element is at the end of the array
        // Cannot fill array beyond its capacity
        // TODO implement this method
    } // end add(Auggie)

    /**
    */
    public void add(Auggie auggie, int index) throws Exception {
        // TODO: implement this method
    } // end add(auggie,index)

    // ____________________________________________________
    //                   SEARCH METHODS
    // ____________________________________________________

    /**
    */
    public Auggie get(int index) throws ArrayIndexException {
    	// TODO: implement this method
        // Do not remove the Auggie, just return it

        return null;
    } // end get()
    
    /**
    */
    public int find(Auggie auggie) {
		// TODO: implement this method
		return -1;
	}
	
	// ____________________________________________________
	//                   REMOVE METHODS
	// ____________________________________________________
	
	/**
    */
	public Auggie remove(int index) throws ArrayIndexException {
		// TODO: implement this method
		// if the index is valid, remove the auggie and return it
		// if not valid, throw Exception
		
		return null;
	
	}
	
	/**
    */
	public void remove(Auggie auggie) throws IllegalOperationException {
		// TODO: implement this method
		// remove and return the auggie from the list
		// as long as it is in the list.
		
		// Use your find method and your other remove method!
		//    no need to write the same code twice!
	
	}
	
	/**
    */
	public void removeAll() {
		// TODO: implement this method
		// "remove" all elements from the list
	}
	
    
    // ____________________________________________________
    //                   CONVERT METHODS
    // ____________________________________________________

    /**
    *
    */
    public Auggie[] toArray() throws IllegalOperationException {
        // TODO: implement this method
        // You must directly copy into the array using a for loop
        return null;
    } // end toArray()
    
    /**
    *
    */
    public int toArray(Auggie[] toFill) throws IllegalOperationException {
	    // TODO: implement this method
		// if all List elements fit in toFill, copy them into the array.
		// if they do not all fit, throw an Exception and return.
		// return the number of elements copied into the array
		
		return -1;
	
	}

    // ____________________________________________________
    //                   SETTERS AND GETTERS
    // ____________________________________________________

    public int length() {
    	return length;
    }

    public int capacity() {
        return auggies.length;
    }

} // end class List
