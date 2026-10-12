import java.util.ArrayList;
import java.util.function.Function;

public class TestHash {

	public static int TABLE_SIZE = 100;

	// hash function from claude.ai
	public static Integer hashA(String s) {
		Integer hashValue = 0;
		Integer pPow = 1;
		for (int i = 0; i < s.length(); i++) {
			hashValue = (hashValue + (s.charAt(i) * pPow)) % TABLE_SIZE;
			pPow = (pPow * 31) % 100007;
		}
		return hashValue;
	}
	
	// a not so good, made up hash Function
	public static Integer hashB(String s) {
		
		Integer hashValue = 0;
		Integer pPow = 1;
		for (int i = 0; i < s.length(); i++) {
			hashValue = hashValue + s.charAt(i);
		}
		return hashValue % TABLE_SIZE;
	}
	
	/** A very bad hash function!) */
	public static Integer hashC(String s) {
		return Integer.valueOf(s.charAt(0)) % TABLE_SIZE;
	}

	public static void main(String[] args) {
	
		efficiencyTest();
	}

	public static void testHash(HashTable auggies, ArrayList<Auggie> auggieList) {
	
		Function<Auggie,String> getKey = (x)->x.username();
				
		// Test the default super bad one
		long startTime = System.nanoTime();
	
		// fill it up
		for (Auggie a : auggieList) {
			auggies.put(getKey.apply(a),a);
		}

		// get them all
		try {
			for (Auggie a : auggieList) {
				auggies.get(getKey.apply(a));
			}
		} catch (IllegalOperationException e) {
			e.printStackTrace();
		}

		long endTime = System.nanoTime();
		long duration = endTime - startTime;

		System.out.println("Execution time: " + duration + " nanos");
		System.out.println("Execution time: " + duration / 1_000_000 + " ms");
		
		System.out.printf("Table length: %d. Longest Linked List: %d\n", auggies.length(), auggies.getMaxLength());
	}
	
	public static void efficiencyTest() {
	
		// number of elements in the table
		int[] sizes = {1000,5000,10000,25000,50000};
		for (int tsize : sizes) {
		
			// adjust the table size to be smaller than number of elements
			TABLE_SIZE = tsize;
	
			System.out.println("\n____________________________ TEST SIZE "+tsize);
			// make some Auggies to work with
			ArrayList<Auggie> auggieList = AuggieFactory.makeAuggies(tsize);

			System.out.println("------------------------- Very bad ---");
			HashTable auggiesDefault = new HashTable(TABLE_SIZE,(x)->hashC(x));
			testHash(auggiesDefault, auggieList);
		
			System.out.println("----------------- Not so good hash ---");
			HashTable auggiesB = new HashTable(TABLE_SIZE,(x)->hashB(x));
			testHash(auggiesB, auggieList);
		
			System.out.println("--------------------- The good one ---");
			HashTable auggiesA = new HashTable(TABLE_SIZE,(x)->hashA(x));
			testHash(auggiesA,auggieList);
		} // end for
			
	} // end efficiencyTest
} // end TestHash