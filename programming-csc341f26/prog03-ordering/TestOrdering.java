import java.util.*;

public class TestOrdering extends Assert {

	// Auggies for testing default order (Auggie.compareTo, by id)
	// and the byLast / byCredits comparators (with ties to break).
	static Auggie t0 = new Auggie(20000,"Ann","Zephyr",10);
	static Auggie t1 = new Auggie(20001,"Bob","Adams",50);
	static Auggie t2 = new Auggie(20002,"Cid","Zephyr",30);
	static Auggie t3 = new Auggie(20003,"Dee","Mason",50);
	static Auggie t4 = new Auggie(20004,"Eve","Mason",70);
	static Auggie tNotFound = new Auggie(29999,"Not","There",99);

	// Auggies for testing sublist() -- only id matters, using default ordering.
	static Auggie n2  = new Auggie(2,"n2","Last",0);
	static Auggie n5  = new Auggie(5,"n5","Last",0);
	static Auggie n8  = new Auggie(8,"n8","Last",0);
	static Auggie n12 = new Auggie(12,"n12","Last",0);
	static Auggie n17 = new Auggie(17,"n17","Last",0);

	public static void assertEquals(Auggie expect, Auggie result, String msg) {
		boolean match = true;
		// First test for nulls to avoid Exceptions
		if ((null==expect) && (null!=result)) {
			match = false;
		} else if ((null==expect) && (null==result)) {
			match = true;
		} else {
			match = (expect.equals(result));
		}
		if (!match) {
			System.out.println(msg+".\n   Expect "+expect+".\n   Result "+result);
		}
	}

	public static void assertEquals(Auggie[] expect, Auggie[] result, String msg) {
		if (expect.length != result.length) {
			System.out.println(msg+" (length).\n   Expect "+expect.length+".\n   Result "+result.length);
			return;
		}
		for (int i = 0; i < expect.length; i++) {
			assertEquals(expect[i], result[i], msg+" (index "+i+")");
		}
	}

	public static void main(String[] args) {

		try {
			testConstructors();
		} catch(Exception e) {
			System.out.println("\n\n*** STOP HERE -- something wrong with constructors!!\n\n");
			e.printStackTrace();
			return;
		}

		try {
			testAddFindDefaultOrder();
		} catch(Exception e) {
			System.out.println("\n\nDEFAULT ORDER ADD/FIND THROWING EXCEPTION.");
			e.printStackTrace();
		}

		try {
			testAddFindByLast();
		} catch(Exception e) {
			System.out.println("\n\nBYLAST ADD/FIND THROWING EXCEPTION.");
			e.printStackTrace();
		}

		try {
			testAddFindByCredits();
		} catch(Exception e) {
			System.out.println("\n\nBYCREDITS ADD/FIND THROWING EXCEPTION.");
			e.printStackTrace();
		}

		try {
			testSublist();
		} catch(Exception e) {
			System.out.println("\n\nSUBLIST THROWING EXCEPTION.");
			e.printStackTrace();
		}

	} // end main

	/* __________________________________________________________________ */
	public static void testConstructors() throws Exception {
		System.out.println("\n\n_________________________________________");
		System.out.println("Testing AuggieList ordering constructors ...");

		AuggieList auggies;

		// Default constructor: default capacity, default (compareTo) ordering.
		auggies = new AuggieList();
		assertEquals(200, auggies.capacity(), "AuggieList() capacity");
		assertEquals(true, auggies.isEmpty(), "AuggieList() isEmpty");

		// Constructor with capacity only.
		auggies = new AuggieList(10);
		assertEquals(10, auggies.capacity(), "AuggieList(10) capacity");
		assertEquals(true, auggies.isEmpty(), "AuggieList(10) isEmpty");

		// Constructor with a Comparator, default capacity.
		auggies = new AuggieList(Ordering.byLast);
		assertEquals(200, auggies.capacity(), "AuggieList(byLast) capacity");
		assertEquals(true, auggies.isEmpty(), "AuggieList(byLast) isEmpty");

		// Constructor with a Comparator and capacity.
		auggies = new AuggieList(Ordering.byCredits, 10);
		assertEquals(10, auggies.capacity(), "AuggieList(byCredits,10) capacity");
		assertEquals(true, auggies.isEmpty(), "AuggieList(byCredits,10) isEmpty");

	} // end testConstructors

	/* __________________________________________________________________ */
	public static void testAddFindDefaultOrder() throws Exception {
		System.out.println("\n\n_________________________________________");
		System.out.println("Testing add()/find() with default ordering (Auggie.compareTo by id) ...");

		AuggieList auggies = new AuggieList(5);

		// Add out of order; add() must place each Auggie to keep the list ordered.
		auggies.add(t2);
		auggies.add(t4);
		auggies.add(t0);
		auggies.add(t3);
		auggies.add(t1);

		assertEquals(5, auggies.length(), "add 5 (length)");
		assertEquals(t0, auggies.get(0), "default order position 0 (t0, id 20000)");
		assertEquals(t1, auggies.get(1), "default order position 1 (t1, id 20001)");
		assertEquals(t2, auggies.get(2), "default order position 2 (t2, id 20002)");
		assertEquals(t3, auggies.get(3), "default order position 3 (t3, id 20003)");
		assertEquals(t4, auggies.get(4), "default order position 4 (t4, id 20004)");

		System.out.println("------------testing find() with default ordering");
		assertEquals(0, auggies.find(t0), "find t0 (default order)");
		assertEquals(1, auggies.find(t1), "find t1 (default order)");
		assertEquals(2, auggies.find(t2), "find t2 (default order)");
		assertEquals(3, auggies.find(t3), "find t3 (default order)");
		assertEquals(4, auggies.find(t4), "find t4 (default order)");
		assertEquals(-1, auggies.find(tNotFound), "find not in list (default order)");

	} // end testAddFindDefaultOrder

	/* __________________________________________________________________ */
	public static void testAddFindByLast() throws Exception {
		System.out.println("\n\n_________________________________________");
		System.out.println("Testing add()/find() with byLast ordering (last name, first name tie-breaker) ...");

		AuggieList auggies = new AuggieList(Ordering.byLast, 5);

		// Add out of order.
		auggies.add(t2);
		auggies.add(t4);
		auggies.add(t0);
		auggies.add(t3);
		auggies.add(t1);

		assertEquals(5, auggies.length(), "add 5 (length)");
		// Expected order: t1 (Adams), t3 (Mason,Dee), t4 (Mason,Eve), t0 (Zephyr,Ann), t2 (Zephyr,Cid)
		assertEquals(t1, auggies.get(0), "byLast position 0 (t1, Adams)");
		assertEquals(t3, auggies.get(1), "byLast position 1 (t3, Mason/Dee)");
		assertEquals(t4, auggies.get(2), "byLast position 2 (t4, Mason/Eve)");
		assertEquals(t0, auggies.get(3), "byLast position 3 (t0, Zephyr/Ann)");
		assertEquals(t2, auggies.get(4), "byLast position 4 (t2, Zephyr/Cid)");

		System.out.println("------------testing find() with byLast ordering");
		assertEquals(0, auggies.find(t1), "find t1 (byLast order)");
		assertEquals(1, auggies.find(t3), "find t3 (byLast order)");
		assertEquals(2, auggies.find(t4), "find t4 (byLast order)");
		assertEquals(3, auggies.find(t0), "find t0 (byLast order)");
		assertEquals(4, auggies.find(t2), "find t2 (byLast order)");
		assertEquals(-1, auggies.find(tNotFound), "find not in list (byLast order)");

	} // end testAddFindByLast

	/* __________________________________________________________________ */
	public static void testAddFindByCredits() throws Exception {
		System.out.println("\n\n_________________________________________");
		System.out.println("Testing add()/find() with byCredits ordering (credits, last name tie-breaker) ...");

		AuggieList auggies = new AuggieList(Ordering.byCredits, 5);

		// Add out of order.
		auggies.add(t2);
		auggies.add(t4);
		auggies.add(t0);
		auggies.add(t3);
		auggies.add(t1);

		assertEquals(5, auggies.length(), "add 5 (length)");
		// Expected order: t0 (10), t2 (30), t1 (50,Adams), t3 (50,Mason), t4 (70)
		assertEquals(t0, auggies.get(0), "byCredits position 0 (t0, 10)");
		assertEquals(t2, auggies.get(1), "byCredits position 1 (t2, 30)");
		assertEquals(t1, auggies.get(2), "byCredits position 2 (t1, 50/Adams)");
		assertEquals(t3, auggies.get(3), "byCredits position 3 (t3, 50/Mason)");
		assertEquals(t4, auggies.get(4), "byCredits position 4 (t4, 70)");

		System.out.println("------------testing find() with byCredits ordering");
		assertEquals(0, auggies.find(t0), "find t0 (byCredits order)");
		assertEquals(1, auggies.find(t2), "find t2 (byCredits order)");
		assertEquals(2, auggies.find(t1), "find t1 (byCredits order)");
		assertEquals(3, auggies.find(t3), "find t3 (byCredits order)");
		assertEquals(4, auggies.find(t4), "find t4 (byCredits order)");
		assertEquals(-1, auggies.find(tNotFound), "find not in list (byCredits order)");

	} // end testAddFindByCredits

	/* __________________________________________________________________ */
	public static void testSublist() throws Exception {
		System.out.println("\n\n_________________________________________");
		System.out.println("Testing sublist() with default ordering ...");

		// List holds {2,5,8,12,17}, ordered by id via Auggie.compareTo.
		AuggieList auggies = new AuggieList(5);
		auggies.add(n8);
		auggies.add(n17);
		auggies.add(n2);
		auggies.add(n12);
		auggies.add(n5);

		Auggie[] result;

		// Both endpoints in the list -- excludes both endpoints.
		result = auggies.sublist(n2, n17);
		assertEquals(new Auggie[]{n5,n8,n12}, result, "sublist(2,17) endpoints in list");

		// Neither endpoint in the list.
		result = auggies.sublist(new Auggie(7,"x","x",0), new Auggie(15,"x","x",0));
		assertEquals(new Auggie[]{n8,n12}, result, "sublist(7,15) endpoints not in list");

		// Start before the list, end in the list.
		result = auggies.sublist(new Auggie(0,"x","x",0), n12);
		assertEquals(new Auggie[]{n2,n5,n8}, result, "sublist(0,12) start not in list");

		// Start in the list, end after the list.
		result = auggies.sublist(n8, new Auggie(20,"x","x",0));
		assertEquals(new Auggie[]{n12,n17}, result, "sublist(8,20) end not in list");

		// Range covers the whole list, neither endpoint in the list.
		result = auggies.sublist(new Auggie(0,"x","x",0), new Auggie(20,"x","x",0));
		assertEquals(new Auggie[]{n2,n5,n8,n12,n17}, result, "sublist(0,20) covers whole list");

		// Range entirely before the list -- nothing in range.
		result = auggies.sublist(new Auggie(-5,"x","x",0), new Auggie(0,"x","x",0));
		assertEquals(new Auggie[0], result, "sublist(-5,0) before list, empty result");

		// Range entirely after the list -- nothing in range.
		result = auggies.sublist(new Auggie(20,"x","x",0), new Auggie(30,"x","x",0));
		assertEquals(new Auggie[0], result, "sublist(20,30) after list, empty result");

		// Adjacent endpoints already in the list, nothing strictly between them.
		result = auggies.sublist(n5, n8);
		assertEquals(new Auggie[0], result, "sublist(5,8) nothing strictly between, empty result");

	} // end testSublist

} // end class TestOrdering
