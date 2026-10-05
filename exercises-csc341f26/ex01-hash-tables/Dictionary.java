import java.util.function.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public class Dictionary {
	
	/** HashMap to hold key: character; value: ascii pairs **/
	// static HashMap  	TODO: finish this defintion of a hashmap
	
	static String alphabet = "abcdefghijklmnopqrstuvwxyz";

    public static void main(String[] args) {
    	
    	hashStuff();
    	listStuff();
    	
    	// testing out lambda functions
    	tryIt((a)->{ return a*10; });
		tryIt((a)->{ return a*a*a; });
		
		// TODO: call extract, passing 2 different lambda functions
		// extract(...
		// extract(...
	}
	
	//________________________________________________________________________
	//________________________________________________________________________
	
	/** Fill the AlphaMap with alpha+ascii pairs **/
	public static void hashStuff() {
		
		// TODO: Write a for loop to add all char/ascii pairs to the HashMap
		// iterate over string alphabet (defined above) 
		// 		and convert each char to its ascii equivalent. add to hashmap
		
		
		// TEST our hashmap ...
		
		String astring = "computer";
		
		// TODO: print the ascii value of each char in astring USING the HashMap

	}
	
	//________________________________________________________________________
	//________________________________________________________________________
	
	public static void listStuff() {
	
		// TODO: define a LinkedList for holding Alpha objects
		
		// TODO: iterate over the HashMap and create a new Alpha from
		// each HashMap element. Add the new Alpha to the linked list

		// TODO: Use an Iterator to print the LinkedList items		

	} // end listStuff

	//________________________________________________________________________
	//________________________________________________________________________

	public static void tryIt(Function<Integer,Integer> func) {
		
		Integer results = func.apply(10);
		System.out.println(results);
		
		Integer[] array = { 1,2,3,4 };
		// TODO: iterate over array, print the application of func to each

	}
	
	//________________________________________________________________________
	//________________________________________________________________________

	public static void extract(Function<String,Character> func) {
		// TODO: write this function
	}

} // end Lambdas