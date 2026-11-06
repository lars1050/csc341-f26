/** A set of 3 integers. Stored in sorted order. */
public class Trio {
    int first;
    int second;
    int third;

    // Not allowing default constructor because must contain 3 elements.

    /** Constructor assigning all 3 elements
     * @param f first in the tuple
     * @param s second in the tuple
     * @param t third in the tuple
     */
    public Trio(int f, int s, int t) {
        first = f;
        second = s;
        third = t;
        
        // values are always stored in sorted order
        order();
    }

    /** Copy constructor creating new tuple based on input parameter
     * @param toCopy Trio of values to copy into a new Trio object
     */
    public Trio(Trio toCopy) {
    	// these objects should already be in ascending order
        first = toCopy.first;
        second = toCopy.second;
        third = toCopy.third;
    }

    @Override
    public String toString() {
        return "["+first+", "+second+", "+third+"]";
    }

    // Place the 3 elements in increasing order from first to third.
    private void order() {
    
    	// establish the order of the first and second element
        int temp = second;
        if (second<first) {
        	// swap if necessary
            second = first;
            first = temp;
        } // else first and second already ordered (no need for change)
        
        // establish the order of the third element
        temp = third;
        if (third<first) {
            // third is minimum (shift first and second "right")
            third = second;
            second = first;
            first = temp;
        } else if (third<second) {
        	// third is middle (shift second "right")
            third = second;
            second = temp;
        }
        // else third is last and all are ordered
    }

    //_______________________ SETTERS and GETTERS
    public int first() {
        return first;
    }
    public int second() {
        return second;
    }
    public int third() {
        return third;
    }
    public void first(int f) {
        first = f;
        order();
    }
    public void second(int s) {
        second = s;
        order();
    }
    public void third(int t) {
        third = t;
        order();
    }
}