import java.util.LinkedList;
import java.util.Iterator;
import java.util.function.Function;


/**
Implementation of a Dictionary / Hash Map / Hash Table.
The associated key-value pairs are a String and an Auggie. There is a default hash function to map the key to an array index (but it is not a good one). Instead, you will want to provide a hash function when calling the constructor of the HashTable.

As part of the assignment, you will analyze the performance of a couple of different hash functions relative to the efficiency of the find operator.
*/
public class HashTable {

	/** Hash Table is implemented using Chaining, which requires a LinkedList that stores type KeyValuePair. */
	private class KeyValuePair {
		String key;
		Auggie value;
		KeyValuePair(String k, Auggie v) {
			key = k;
			value = v;
		}
	}
	
	/** Hash Function used to generate index from key */
	Function<String,Integer> hashFn;

	/** Hash Table structure based on chaining. */
	private LinkedList<KeyValuePair>[ ] table;

	/** The number of items in the dictionary. */
	private int length = 0;

	public HashTable(int size, Function<String,Integer> hash) {
		// There are type issues due to generics that we need to work around.
		// You can ask claude.ai if you are interested
		@SuppressWarnings("unchecked")
		LinkedList<KeyValuePair>[] temp = (LinkedList<KeyValuePair>[]) new LinkedList[size];
		table = temp;
		
		// using this hash function to generate index from key
		hashFn = hash;

		// for testing ...
		System.out.printf("Created Hash Table size %d\n",size); 
	}

	/**
	* Pretty print the dictionary.
	*/
	@Override
	public String toString() {
		// get all the auggies in the hash table
		String toPrint = "";
		Auggie[] auggies = toArray();
		for (Auggie a : auggies) {
			toPrint += a+"\n";
		}
		return toPrint;
	}

	/**
	* Search in the table for specified key.
	* @param key (Presumably) unique element of table entry
	* @return true if in the dictionary, otherwise false
	*/
	public Boolean contains(String key) {
		Integer index = hashFn.apply(key);
		// if the linked list has not yet been created, not in table
		if (null == table[index]) {
			return false;
		}
		// if not at the hashed index, not in table
		if (null == find(key,table[index])) {
			return false;
		} else {
			return true;
		}
	}

	/* Helper Function to search through a linked list */
	private KeyValuePair find(String key,LinkedList<KeyValuePair> llist) {

		// iterate through the llist until either we find it or reach the end
		Iterator<KeyValuePair> iterator = llist.iterator();
		while (iterator.hasNext()) {
			KeyValuePair kvp = iterator.next();
			if (kvp.key.equals(key)) {
				return kvp;
			}
		}
		// got here, so did not find that key
		return null;
	}

	/**
	* Put the specified key-value pair into the dictionary.
	* @param key Unique username for locating value
	* @param auggie Auggie entry to be added to the Dictionary
	*/
	public void put(String key, Auggie auggie) {

		// Where does it go in the array?
		Integer index = hashFn.apply(key);

		// if the linked list has not yet been created, not yet in table
		// let's put it in there
		if (null == table[index]) {
			table[index] = new LinkedList<KeyValuePair>();
			table[index].add(new KeyValuePair(key,auggie));
			length++;
			return;
		}

		// does that key already exist?? if not let's put it in there
		KeyValuePair kvp = find(key,table[index]);
		if (null == kvp) {
			table[index].add(new KeyValuePair(key,auggie));
			length++;
			return;
		} else {
			// it is already there and we need to reset the value
			kvp.value = auggie;
		}
	}

	/**
	* Retrieve the specified element.
	* @param key Unique String associated with value in table
	* @return associated Auggie, if in the table
	* @throws IllegalOperationException
	*/
	public Auggie get(String key) throws IllegalOperationException {
		Integer index = hashFn.apply(key);

		// if the linked list has not yet been created, not yet in table
		if (null == table[index]) {
			throw new IllegalOperationException("Key not found.");
		}

		// Check if it is in the linked list (or not) 
		KeyValuePair kvp = find(key,table[index]);
		if (null == kvp) {
			throw new IllegalOperationException("Key not found.");
		} else {
			return kvp.value;
		}
	}


	/**
	* Convert the dictionary into an array.
	* @return array of Auggies in dictionary -- array empty if dictionary empty
	*/
	public Auggie[] toArray() {

		// Create an array exactly the length of number of items
		Auggie[] array = new Auggie[length];
		
		// Each time you find an element, add it to the array
		int index = 0;
		for (LinkedList<KeyValuePair> llist : table) {
			if (null != llist) {
				Iterator<KeyValuePair> it = llist.iterator();
				while (it.hasNext()) {
					array[index] = it.next().value;
					index++;
				}
			}
		} // end for

		return array;
	}
	
	/** For testing efficiency, determine the longest linked list in the table.
	@return length of the longest linked list
	*/
	public int getMaxLength() {
		int maxLength = 0;
		for (LinkedList<KeyValuePair> llist : table) {
			if (null != llist && llist.size() > maxLength) {
				maxLength = llist.size();
			}
		} // end for
		return maxLength;
	}
	
	// getter for length
	public int length() { return length; }
	
} // end class Dictionary
