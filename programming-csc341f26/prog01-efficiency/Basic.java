import java.util.*;
import java.util.Random;

/** A basic alpha-numeric class for testing */
public class Basic implements Comparable<Basic> {

	// Member variables
	String alpha = null;
	Integer number = null;
	
	// Default constructor - does not have much utility 
	public Basic() {}
	
	// Primary constructor
	public Basic(Integer n, String s) {	
		number = n;
		alpha = s;
	}
	
	@Override
	public String toString() {
		return number+", "+alpha;
	}

	/** Comparator for default ordering. Alpha with number as tie-breaker.
	* @param other Element to compare this to (the right operand)
	* @return difference measure between this and other
	*/
	@Override
	public int compareTo(Basic other) {
		// If alpha the same, use number as tie-breaker
		if (alpha.compareTo(other.alpha)==0) {
			return number.compareTo(other.number);
		} else {
			return alpha.compareTo(other.alpha);
		}
	}
	
	@Override
	public boolean equals(Object other) {
		// a null object cannot be "this"
		if (other==null) {
			return false;
		}
		// Is other the identical object to "this"
		if (this==other) {
			return true;
		}
		
		// If it isn't the same type, no way it can be equal 
		if (!(other instanceof Basic)) {
			return false;
		}
		// need to cast so we can access member variables
		Basic s = (Basic) other;
		
		// need to match both elements to consider it equal
		return alpha.equals(s.alpha) && number==s.number;
	}

	// setters and getters
	
	public Integer number() { return number; }
	public void number(Integer n) { number = n; }
	
	public String alpha() { return alpha; }
	public void alpha(String a) { alpha = a; }
}
