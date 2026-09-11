import java.util.Random;
import java.util.*;


public class Auggie {

	/** student id */
    private Integer id;
    
    /** First Name */
    private String first;
    
    /** Last Name */
    private String last;
    
    /** Credits earned */
	private Integer credits = 0;

	/** Default Constructor.
	*/
	public Auggie() {
		id = -1;
		first = "Anony";
		last = "Mous";
		credits = 0;
	}
	
	/** Constructor 
	* @param id unique 5 digit integer
	* @param first name
	* @param last name
	* @param credits total credits earned
	*/
    public Auggie(Integer id, String first, String last, Integer credits) {
    	this.id = id;
    	this.first = first;
    	this.last = last;
    	this.credits = credits;
    }

	@Override
    public String toString() {
        return id+" "+first+" "+last+","+credits + " earned credits.";
    }
    
    @Override
    public boolean equals(Object other) {
    	if (null==other) {
    		return false;
    	}
    	if (!(other instanceof Auggie)) {
    		return false;
    	}
    	Auggie aug = (Auggie) other;
    	// usernames are unique, so this should be sufficient to test equivalency
    	return id.equals(aug.id);
    }
    
    // Setters and Getters 
    public Integer id() { return id; }
    public void id(Integer id) { this.id = id; }

    public String first() { return first; }
    public void first(String f) { first = f; }

    public String last() { return last; }
    public void last(String l) { last = l; }

    public Integer credits() { return credits;}
    public void credits(Integer c) { credits = c;}
}
