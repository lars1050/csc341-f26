import java.util.ArrayList;
import java.util.function.Function;

public class TestHash {

	public static final int TABLE_SIZE = HashTable.DEFAULT_SIZE;

	// hash function from claude.ai
	public static Integer hashA(String s) {
		Integer hashValue = 0;
		Integer pPow = 1;
		for (int i = 0; i < s.length(); i++) {
			hashValue = (hashValue + (s.charAt(i) * pPow)) % TABLE_SIZE;
			pPow = (pPow * 31) % 1000000007;
		}
		return hashValue;
	}

	// a not so good, made up hash Function
	public static Integer hashB(String s) {
		// TODO ... write this to add all chars in username (mod)
		return 0;
	}

	public static void main(String[] args) {

		basicTest();
		//efficiencyTest();
	}

	public static void basicTest() {

		// TODO ... write this method

		// AuggieFactory.makeAuggies(10) -- create objects to place in table.

		// to test hashB, include hashB as part of a lambda fn in constructor.
		// new HashTable((x)->hashB(x))
		
		// testing put with username 
		// fill new hash table with array of Auggies: table.put(a.username(),a)
		
		// testing toString and toArray
		
		// testing get
		
		// testing contains

	} // end basicTest

} // end TestHash
