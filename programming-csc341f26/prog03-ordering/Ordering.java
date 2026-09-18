import java.util.*;

public class Ordering {

	// Define a comparator (uses compare) byLast that establishes an ordering
	// for Auggies based on the last name with the first name as tie-breaker.
	// Be sure to declare byLast as public static!
	// TODO


	// Define a comparator byCredits that establishes an ordering
	// for Auggies based on total credits earned with the last name as a tie-breaker.
	// Be sure to declare byCredits as public static!
	// TODO



	public static void main(String[] args) {

		// Creating an array to sort
		// Note this is for testing the comparators, not the AuggieList
		ArrayList<Auggie> auggies = new ArrayList<>();

		Auggie a0 = new Auggie(10000,"First00","Last00",0);
		Auggie a1 = new Auggie(10001,"First01","Last01",1);
		Auggie a2 = new Auggie(10002,"First02","Last02",2);
		Auggie a3 = new Auggie(10003,"First03","Last03",3);
		Auggie a4 = new Auggie(10004,"First04","Last04",4);

		// creating a tie to be broken for byLast (same last name, different first name)
		a0.last("Xavier"); a2.last("Xavier");

		// creating a tie to be broken for byCredits (same credits, different last name)
		a1.credits(5); a3.credits(5);

		// Test all your orderings.
		// First we will put in the array.
		auggies.add(a2);
		auggies.add(a4);
		auggies.add(a0);
		auggies.add(a3);
		auggies.add(a1);

		System.out.println("\nHere they are in added order");
		for (Auggie a: auggies) {
			System.out.println(a);
		}

		// Sort using the Collections.sort method for an ArrayList
		// this will use the Auggie.compareTo method for ordering
		// TODO

		System.out.println("\nNow they should be in id order");
		for (Auggie a: auggies) {
			System.out.println(a);
		}

		// Sort using the .sort() for ArrayList with byLast as the argument.
		// TODO

		System.out.println("\nNow they should be in last name, first name order");
		for (Auggie a: auggies) {
			System.out.println(a);
		}

		// Sort using the .sort() for ArrayList with byCredits as the argument.
		// TODO

		System.out.println("\nNow they should be in credits, last name order");
		for (Auggie a: auggies) {
			System.out.println(a);
		}

	}
}
