import java.util.*;

/**
Implementation of a List focusing on methods related to ordering (sorting).
*/
public class AuggieList {

	/** The size of the array that stores elements. */
	private static final int DEFAULT_SIZE = 20;

	/** List data structure for holding elements. */
	private Auggie[] auggies;

	/** The number of items in the list. */
	private int length = 0;
	
	/** Current Comparator by which the list is ordered */
	private Comparator<Auggie> currentOrder = null;
	
	/** Is the list currently sorted by currentOrder Comparator ?? */
	private boolean isOrdered = false;

	/** Default */
	public AuggieList() {
		auggies = new Auggie[DEFAULT_SIZE];
	}

	/**
	* Pretty print the list.
	*/
	@Override
	public String toString() {
		// get all the auggies in the list
		String toPrint = "";
		for (int i=0; i<length; i++) {
			toPrint += auggies[i]+"\n";
		}
		return toPrint;
	}
	
	/**
	* Determine if any room left in the List
	* @return True if at capacity, otherwise false
	*/
	public Boolean isFull() {
		return length == auggies.length;
	}
	
	/* ______________________   ADD (APPEND) _________________________ */

	/**
	* Append element to the list (if there is capacity)
	* @param value Value to be added
	*/
	public void add(Auggie value) {
		if (!isFull()) {
			auggies[length++] = value;
			// we broke any ordering that exists
			isOrdered = false;
			currentOrder = null;
		}
		// in bad form, ignoring if there is no capacity
	}

	/* ______________________   FIND METHODS _________________________ */
	
	/** 
	* Getter for a value at a specific index.
	* @param index Location of a value in the list
	* @return Auggie located at that index or null if index not valid.
	*/
	public Auggie get(int index) {
		// is there an Auggie at that index?>
		if (index < 0 || index >= length) {
			return null;
		}
		return auggies[index];
	} // end get

	
	/**
	* Find the specified value in the 
	* @return array of Auggies in dictionary -- array empty if dictionary empty
	*/
	public int find(Auggie value) {
		if (isOrdered) {
			// use the very efficient Binary Search
			System.out.println("Applying Binary Search.");
			return findRecursive(value,0,length-1);
		} else {
			System.out.println("Applying Linear Search.");
			return findLinear(value);
		}
	}
	
	/**
	* Find the location of the minimum value in the List
	* @return index (location) of the minimum value in the list
	*/
	public Auggie minimum(Comparator<Auggie> order) {
	
		// if it is ordered, the minimum is the first element
		if (isOrdered && order.equals(currentOrder)) {
			System.out.println("Using the ordered list for minimum.");
			return auggies[0];
		}
		
		// Have to find it by searching through list
		System.out.println("Searching for minimum.");
		return auggies[locationMinimum(order,0,length-1)];
	}
	
	/** Private helper function
	* Find the specified value in the list via Linear Search
	* @param value To find in the list
	* @return index (location) of the element. -1 if not in the list.
	*/
	private int findLinear(Auggie value) {
		// start at beginning and compare elements until you find it
		int i=0;
		while (i<length && !value.equals(auggies[i])) {
			i++;
		}
		if (i==length) {
			return -1;
		}
		return i;
	}
	
	/** Private helper recursive function for binary search.
	* Convert the dictionary into an array.
	* @return array of Auggies in dictionary -- array empty if dictionary empty
	*/
	private int findRecursive(Auggie value, int start, int end) {
	
		// check for stopping condition of recursion
		// TODO: fill in for stopping condition
	
		// did we find it?
		// TODO: fill in to determine if it was found (in the middle)
		
		// no. should we look left of middle or right of middle?
		// TODO: fill in to determine next call to findRecursive
		
		return -1;
	} // end findRecursive

	/* ______________________   SORT METHODS _________________________ */

	/* Private helper function.
	* Determine the location of the minimum value in sublist[start:end] (end is inclusive)
	* @param order Comparator to use to establish ordering
	* @param start Starting index of the subarray to search
	* @param end Ending index (inclusive) of the subarray to search
	* @return Index (location) of minimum value in the subarray.
	*/
	private int locationMinimum(Comparator<Auggie> order, int start, int end) {
	
		// search entire array for the minimum value
		// TODO: complete this method
		return 0;
	}

	/** Private helper function
	* Reorder the list using the specified ordering with the Insertion Sort algorithm.
	* @param orderBy Comparator that establishes ordering
	*/
	private void sortInsertion(Comparator<Auggie> orderBy) {
		System.out.println("Sorting with Insertion Sort.");
		// TODO: complete this method of sorting auggies using Insertion Sort
	}

	/** Private helper function.
	* Reorder the list using the specified ordering with the Selection Sort algorithm.
	* @param orderBy Comparator that establishes ordering
	*/
	private void sortSelection(Comparator<Auggie> orderBy) {
		System.out.println("Sorting with Selection Sort.");
		// TODO: complete this method of sorting auggies using Selection Sort
		// You must call the locationMinimum helper function.
	}

	/**
	* Sort auggies list based on specified order and specified algorithm.
	* @param orderBy Comparator that established ordering of auggies
	* @param algo Algorithm to use for sorting -- insertion or selection
	*/
	public void sort(Comparator<Auggie> orderBy, String algo) {
		// maybe it is already ordered based on this ordering ??
		if (isOrdered && orderBy.equals(currentOrder)) {
			return;
		}
		
		// if not insertion than going with selection.
		// should really check specifically for selection, but oh well ...
		if (algo.equals("insertion")) {
			sortInsertion(orderBy);
		} else {
			sortSelection(orderBy);
		}
		// we have restored order
		currentOrder = orderBy;
		isOrdered = true;
	}
} // end class AuggieList

