import java.lang.reflect.*;
import java.util.Scanner;
import java.io.*;
    
public class TestList extends Assert {

	static Auggie a0 = new Auggie(10000,"First00","Last00",0);
	static Auggie a1 = new Auggie(10001,"First01","Last01",1);
	static Auggie a2 = new Auggie(10002,"First02","Last02",2);
	static Auggie a3 = new Auggie(10003,"First03","Last03",3);
	static Auggie a4 = new Auggie(10004,"First04","Last04",4);
	
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
		}}

	public static void main(String[] args) {

		// Initial add() and get() test
		/* It is a bit of a chicken-and-egg problem.
		* To test add(), get() needs to be correct to confirm auggie was added.
		* To test get(), add() needs to be correct to confirm location of auggie.
		*/

		System.out.println("\n\nSanity check test of add, length, get.");
		System.out.println("If these initial tests do not pass, the rest of the tests are irrelevant!\n");
		
		try {
			AuggieList auggies = new AuggieList(5);
			auggies.add(a1);
			assertEquals(1,auggies.length(),"First Add (length)");
			assertEquals(a1,auggies.get(0),"First Add (a1)");
		} catch (Exception e) {
			System.out.println("Sanity Check FAILED ... DO NOT PROCEED.");
			e.printStackTrace();
		}
		System.out.println("\nSanity Check complete!");

		/* Once the above are confirmed to be working, the testing can proceed.
		*/
		
		try {
			testConstructorGetters();
		} catch(Exception e) {
			System.out.println("\n\n*** STOP HERE -- something wrong with constructor!!\n\n");
		}
		try {
			testAdds();
		} catch(Exception e) {
			System.out.println("\n\nADDS THROWING EXCEPTION.");
			e.printStackTrace();
			System.out.println("\n\n");
		}
		
		try {
			testSearches();
		} catch(Exception e) {
			System.out.println("\n\nSEARCHES THROWING EXCEPTION.");
			e.printStackTrace();
			System.out.println("\n\n");
		}
		
		try {
			testConvert();
		} catch(Exception e) {
			System.out.println("\n\nCONVERT THROWING EXCEPTION.");
			e.printStackTrace();
			System.out.println("\n\n");
		}

		try {
			testRemoves();
		} catch(Exception e) {
			System.out.println("\n\nREMOVES THROWING EXCEPTION.");
			e.printStackTrace();
			System.out.println("\n\n");
		}

	} // end main

	/* __________________________________________________________________ */
	public static void testConstructorGetters() throws Exception {
		System.out.println("\n\n_________________________________________");
		System.out.println("Testing AuggieList constructor ...");

		AuggieList auggies;

		// Test default constructor and getters
		auggies = new AuggieList();
		assertEquals(200, auggies.capacity(), "AuggieList() capacity");
		assertEquals(0, auggies.length(), "AuggieList() length");
		assertEquals(true, auggies.isEmpty(), "AuggieList() isEmpty");

		// Test constructor with length parameter
		auggies = new AuggieList(5);
		assertEquals(0, auggies.length(), "AuggieList(5) length");
		assertEquals(5, auggies.capacity(), "AuggieList(5) capacity");
		assertEquals(true, auggies.isEmpty(), "AuggieList(5) isEmpty");

		// Test length getter (testing greater than 0)
		try {
			auggies.add(a1);
			assertEquals(1,auggies.length(),"length()");
			auggies.add(a2);
			assertEquals(2,auggies.length(),"length()");
		} catch(Exception e) {
			// passing exception along to caller
			throw e;
		}

		// Test isEmpty and null.
		try {
		auggies = new AuggieList(3);
		assertEquals(false, auggies.isFull(), "test isFull when isEmpty");
		assertEquals(true, auggies.isEmpty(), "test isEmpty when isEmpty");

		auggies.add(a1);
		assertEquals(false, auggies.isFull(), "test isFull - 1 of 3");
		assertEquals(false, auggies.isEmpty(), "test isEmpty - 1 of 3");

		auggies.add(a1);
		auggies.add(a1);
		assertEquals(true, auggies.isFull(), "test isFull - 3 of 3");
		assertEquals(false, auggies.isEmpty(), "test isEmpty - 3 of 3");

		// test length getter when isFull
		assertEquals(3,auggies.length(),"length()");
		} catch(Exception e) {
			// passing exception along to caller
			throw e;
		}

	} // end testConstructorGetters
	
	/* __________________________________________________________________ */
	public static void testAdds() throws Exception {
		System.out.println("\n\n_________________________________________");
		System.out.println("Testing AuggieList add methods ...");

		AuggieList auggies;

		System.out.println("--------------add(Auggie)");
		auggies = new AuggieList(3);

		// 0 of 3 added
		assertEquals(0,auggies.length(),"pre-add (length)");
		
		// adding 1 of 3
		try {
			auggies.add(a0);
			assertEquals(1,auggies.length(),"add first (length)");
			assertEquals(a0,auggies.get(0),"add first (value)");
		} catch(Exception e) {
			throw e;
		}
		
		// adding 2 of 3
		try {
			auggies.add(a1);
			assertEquals(2,auggies.length(),"add 2nd (length)");
			assertEquals(a1,auggies.get(1),"add 2nd (value)");
		} catch(Exception e) {
			throw e;
		}
		
		// adding 3 of 3
		try {
			auggies.add(a2);
			assertEquals(3,auggies.length(),"add to capacity (length)");
			assertEquals(a2,auggies.get(2),"add to capacity (value)");
		} catch(Exception e) {
			throw e;
		}
		
		// attempt add 4 of 3
		try {
			auggies.add(a3);
			System.out.println("Add over capacity. Expect Exception. None thrown.");
		} catch (IllegalOperationException e) {
			// This is the expected behavior. List should not change.
			assertEquals(3,auggies.length(),"add attempt over capacity (length)");
			assertEquals(a2,auggies.get(2),"add attempt over capacity (value)");
		}

		System.out.println("--------------add(auggie,index)");
		auggies = new AuggieList(6);

		// attempt to add at 0 in isEmpty array. it should fail to add.
		try {
			auggies.add(a1,0);
			System.out.println("Add past length 0. Expect Exception. None thrown.");
		} catch(ArrayIndexException e) {
			// This is the expected behavior. List should not change.
			assertEquals(0,auggies.length(),"attempt add to isEmpty - invalid index (length)");
		}
		
		// setup to add at index. adding 1 element.
		try {
			auggies.add(a0);	// a0 should now be in list
		} catch(Exception e) {
			throw e;
		}
		
		// again fail to add past length of 1
		try {
			auggies.add(a1,1);
			System.out.println("Add past length 1. Expect Exception. None thrown.");
		} catch(ArrayIndexException e) {
			// Expected behavior. List should not change. 
			// Contains only a0 at index 0.
			assertEquals(1,auggies.length(),"attempt add at 1 (length)");
			assertEquals(a0,auggies.get(0),"attempt add at 1 (value)");
		}
		
		// add at index 0. Will contain {a1,a0}
		try {
			auggies.add(a1,0); 
			assertEquals(2,auggies.length(),"add at 0 (length)");
			assertEquals(a1,auggies.get(0),"add at 0 (value)");
			assertEquals(a0,auggies.get(1),"add at 0 (2nd auggie)");
		} catch(Exception e) {
			throw e;
		}

		// test other invalid indices
		try {
			auggies.add(a4,-1);
			System.out.println("Add at index -1. Expect Exception. None thrown.");
		} catch(ArrayIndexException e) {
			// Expected behavior. List should not change
			assertEquals(2,auggies.length(),"add at index -1 (length)");
		}
		// test other invalid indices
		try {
			auggies.add(a4,5);
			System.out.println("Add at index 5. Expect Exception. None thrown.");
		} catch(ArrayIndexException e) {
			// Expected behavior. List should not change
			assertEquals(2,auggies.length(),"add at index 5 (length)");
		}
	}
	
	/* __________________________________________________________________ */
	public static void testSearches() throws Exception {
		System.out.println("\n\n_________________________________________");
		System.out.println("Testing AuggieList search methods ...");

		AuggieList auggies;

		auggies = new AuggieList(5);
		
		try {
			auggies.add(a0);
			auggies.add(a1);
			auggies.add(a2);
		} catch(Exception e) {
			throw e;
		}

		System.out.println("------------testing get()");
		try { // all valid gets
			assertEquals(a0,auggies.get(0),"get at index 0");
			assertEquals(a1,auggies.get(1),"get at index 1");
			assertEquals(a2,auggies.get(2),"get at index 2");
		} catch(Exception e) {
			throw e;
		}
		
		// get one past the end
		try {
			auggies.get(3);
			System.out.println("Get at length. Expect Exception. None thrown.");
		} catch(ArrayIndexException e) {
			// Expected behavior. All good.
		}

		// get at capacity
		try {
			auggies.get(5);
			System.out.println("Get at capacity. Expect Exception. None thrown.");
		} catch(ArrayIndexException e) {
			// Expected behavior. All good.
		}
		
		// get at -1
		try {
			auggies.get(-1);
			System.out.println("Get at -1. Expect Exception. None thrown.");
		} catch(ArrayIndexException e) {
			// Expected behavior. All good.
		}

		System.out.println("------------Testing find()");
		assertEquals(0, auggies.find(a0), "find first");
		assertEquals(1, auggies.find(a1), "find middle");
		assertEquals(2, auggies.find(a2), "find last");
		assertEquals(-1, auggies.find(a3), "find but not in AuggieList");

	} // end testSearches
	
	/* __________________________________________________________________ */
	public static void testConvert() throws Exception {
		System.out.println("\n\n_________________________________________");
		System.out.println("Testing AuggieList convert methods ...");

		AuggieList auggies;
		Auggie[] array;

		System.out.println("--------------Testing toArray()");
		auggies = new AuggieList(4);
		
		// toArray with isEmpty list - not allowed
		try {
			auggies.toArray();
			System.out.println("toArray for isEmpty list. Expect Exception. None thrown.");
		} catch(IllegalOperationException e) {
			// expected behavior. all good.
		}

		// toarray with 1 element
		try {
			auggies.add(a0);
			array = auggies.toArray();
			if (null==array) {
				System.out.println("ERROR: toArray 1 element. Returns null.");
			} else {
				assertEquals(1,array.length,"toArray 1 element (length)");
				assertEquals(array[0], a0, "toArray 1 element (value)");
			}
		} catch(Exception e) {
			throw e;
		}

		// toarray with more elements
		try {
			auggies.add(a1);
			array = auggies.toArray();
			if (null==array) {
				System.out.println("ERROR: toArray 2 elements. Returns null.");
			} else {
				assertEquals(2,array.length,"toArray 2 elements (length)");
				assertEquals(array[0], a0, "toArray 2 elements (auggie 0)");
				assertEquals(array[1], a1, "toArray 2 elements (auggie 1)");
			}
		} catch(Exception e) {
			throw e;
		}

		System.out.println("--------------Testing toArray(Auggie[])");

		auggies = new AuggieList(4);

		auggies.add(a0);
		auggies.add(a1);
		auggies.add(a2);

		// Fill array larger than count of list
		array = new Auggie[10];
		int copied = 0;

		copied = auggies.toArray(array);
		assertEquals(3,copied,"copy into larger array");
		assertEquals(a0,array[0],"copy into larger (a0)");
		assertEquals(a1,array[1],"copy into larger (a1)");
		assertEquals(a2,array[2],"copy into larger (a2)");

		// Fill array same size as count
		array = new Auggie[3];
		copied = auggies.toArray(array);
		assertEquals(3,copied,"copy into same size array");
		assertEquals(a0,array[0],"copy into same size (a0)");
		assertEquals(a1,array[1],"copy into same size (a1)");
		assertEquals(a2,array[2],"copy into same size (a2)");

		// copy into smaller - not allowed
		int count = auggies.length();
		array = new Auggie[2];
		try {
			copied = auggies.toArray(array);
			System.out.println("toArray into too-small array. Expect Exception. None thrown.");
		} catch(IllegalOperationException e) {
			// expected behavior. all good.
			assertEquals(count,auggies.length(),"size changed but array too small.");
		}
	} // end testConvert

	/* __________________________________________________________________ */
	public static void testRemoves() throws Exception {
		System.out.println("\n\n_________________________________________");
		System.out.println("Testing AuggieList remove methods ...");

		// This assumes add, length is working.

		AuggieList auggies;

		System.out.println("--------------remove(index)");
		auggies = new AuggieList(6);
		auggies.add(a0);
		auggies.add(a1);
		auggies.add(a2);
		auggies.add(a3);

		Auggie removed;

		int count = 0;

		// attempt remove invalid at 4
		try {
			count = auggies.length();
			auggies.remove(4);
		} catch(ArrayIndexException e) {
			// expected behavior
			assertEquals(count,auggies.length(),"size changed but invalid index 4.");
		}

		// attempt remove invalid at -1
		try {
			count = auggies.length();
			auggies.remove(-1);
		} catch(ArrayIndexException e) {
			// expected behavior
			assertEquals(count,auggies.length(),"size changed but invalid index -1.");
		}

		auggies = new AuggieList(6);
		auggies.add(a0);
		auggies.add(a1);
		auggies.add(a2);
		auggies.add(a3);

		// remove middle a1 from {a0,a1,a2,a3} == {a0,a2,a3}
		removed = auggies.remove(1);
		assertEquals(3,auggies.length(),"remove middle (length)");
		assertEquals(a1,removed,"remove middle (value)");

		// remove last a3 from {a0,a2,a3} == {a0,a2}
		removed = auggies.remove(2);
		assertEquals(2,auggies.length(),"remove last (length)");
		assertEquals(a3,removed,"remove last (value)");

		// remove first (a0) from {a0,a2} == {a2}
		removed = auggies.remove(0);
		assertEquals(1,auggies.length(),"remove first (length)");
		assertEquals(a0,removed,"remove first (value)");

		// remove only (a2)
		removed = auggies.remove(0);
		assertEquals(0,auggies.length(),"remove only (length)");
		assertEquals(a2,removed,"remove only (value)");

		// _________________________________________________________
		System.out.println("--------------remove(Auggie)");
		auggies = new AuggieList(6);

		// attempt remove not in list
		try {
			count = auggies.length();
			auggies.remove(a0);
			System.out.println("remove from empty list. Expect Exception. None thrown.");
		} catch(IllegalOperationException e) {
			// expected behavior. all good.
			assertEquals(count,auggies.length(),"size changed but invalid auggie");
		}

		auggies.add(a0);
		auggies.add(a1);
		auggies.add(a2);
		auggies.add(a3);

		// remove middle a1 from {a0,a1,a2,a3} == {a0,a2,a3}
		auggies.remove(a1);
		assertEquals(3,auggies.length(),"remove middle (a1)");

		// remove last a3 from {a0,a2,a3} == {a0,a2}
		auggies.remove(a3);
		assertEquals(2,auggies.length(),"remove last (a3)");

		// remove first (a0) from {a0,a2} == {a2}
		auggies.remove(a0);
		assertEquals(1,auggies.length(),"remove first (a0)");

		// remove only (a2)
		auggies.remove(a2);
		assertEquals(0,auggies.length(),"remove only auggie (length)");

		// _________________________________________________________
		System.out.println("--------------removeAll()");
		auggies = new AuggieList(6);
		auggies.add(a0);
		auggies.add(a1);
		auggies.add(a2);
		auggies.add(a3);
		auggies.add(a4);

		auggies.removeAll();
		assertEquals(0,auggies.length(),"removeAll clears the list (length)");
		assertEquals(true,auggies.isEmpty(),"removeAll clears the list (isEmpty)");

	} // end testRemoves
} // end class Main