import java.util.LinkedList;
import java.util.Iterator;
import java.util.function.Function;


/**
Implementation of a Dictionary / Hash Map / Hash Table.
The associated key-value pairs are a String and an Auggie. There is a default hash function to map the key to an array index (but it is not a good one).
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

	/** The size of the array that stores elements. */
	public static final int DEFAULT_SIZE = 100;

	/** Hash Table structure based on chaining. */
	private LinkedList<KeyValuePair>[ ] table;

	/** Default Hash Function (it is a bad hash function!) */
	Function<String,Integer> hashFn = (x) -> Integer.valueOf(x.charAt(0)) % DEFAULT_SIZE;

	/** The number of items in the dictionary. */
	private int length = 0;

	/** Default Constructor*/
	public HashTable() {
		// There are type issues due to generics that we need to work around.
		// You can ask claude.ai if you are interested in learning more
		@SuppressWarnings("unchecked")
		LinkedList<KeyValuePair>[] temp = (LinkedList<KeyValuePair>[]) new LinkedList[DEFAULT_SIZE];
		table = temp;
	}

	/** Constructor to set hash function.
	@param hash Function applied to the key to get an index into the table.
	*/
	public HashTable(Function<String,Integer> hash) {
		this();
		hashFn = hash;
	}

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

		// >>> TODO: finish this ...
		// Use the find helper function defined below !!

		// if the linked list has not yet been created, not in table

		// if not at the hashed index, not in table

		return false;
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
	* Put specified key-value pair into HashTable OR replace value if key exists.
	* @param key Unique string for locating value
	* @param auggie Auggie entry to be added to the table
	*/
	public void put(String key, Auggie auggie) {
		// >>> TODO .. complete this.
		// Remember to increase length as appropriate

		// if the linked list has not yet been created, then not yet in table
		// let's make the list and put auggie in there
		//if (null == table[index]) {
			// TODO .. finish this

		// does that key already exist?? if not let's put it in there
		//KeyValuePair kvp = find(key,table[index]);
		// TODO .. finish this

		// otherwise replace the value for that key
	}

	/**
	* Retrieve the specified element.
	* @param key Unique String associated with value in table
	* @return associated Auggie, if in the table
	* @throws IllegalOperationException
	*/
	public Auggie get(String key) throws IllegalOperationException {

		Integer index = hashFn.apply(key);

		// if the linked list has not yet been created, then not yet in table
		if (null == table[index]) {
			throw new IllegalOperationException("Key not found.");
		}

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

		Auggie[] array = new Auggie[length];
		// TODO ... finish this
		// look at find() above to iterate through table

		return array;
	}

} // end class Dictionary
