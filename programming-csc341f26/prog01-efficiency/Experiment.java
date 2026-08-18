import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Iterator;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;


/**
* Command-line tool to run a timing experiment comparing ArrayList and
* LinkedList on a given operation, using data produced by DataMaker.
*
* Usage: java Experiment -op <add|search|remove> -source <file> -output <file>
*   -op      which experiment to run: add, search, or remove
*   -source  csv file of number,string pairs created by DataMaker
*   -output  file to append/record the experiment's results
*/
public class Experiment {

	// Data Structures for holding data read from file.
	// These will be compared for efficiency
	static ArrayList<Basic> arrayList;
	static LinkedList<Basic> linkedList;
	
	// Forcing compiler to not optimize loops used in experiments
	static volatile Basic holder;

	/** progression of sizes used by each experiment */
	static int[] SIZES = new int[50];

	public static void main(String[] args) {
	
		// collect a datapoint for a progression of data sizes up to 1M
		for (int i=1; i<=50; i++) {
			SIZES[i-1] = i*20000;
		}

		/** Operation on dataset being tested **/
		String op = null;
		
		/** Filename from which to read the data **/
		String source = null;
		
		/** filename in which to store data (created new) **/
		String output = null;

		// parse the command-line arguments: -op <op> -source <file> -output <file>
		for (int i = 0; i < args.length; i++) {
			if (args[i].equals("-op") && i + 1 < args.length) {
				op = args[++i];
			} else if (args[i].equals("-source") && i + 1 < args.length) {
				source = args[++i];
			} else if (args[i].equals("-output") && i + 1 < args.length) {
				output = args[++i];
			}
		}

		// user must specify all three for this to work
		if (null == op || null == source || null == output) {
			System.out.print("Usage: java Experiment -op <add|traverse|get|remove> ");
			System.out.println("-source <file> -output <file>");
			return;
		}
		
		// add the folder name so that it works with Windows, Mac, and Linux
		File sourceFile = Path.of("data/"+source).toFile();
		File outputFile = Path.of("data/"+output).toFile();

		switch (op) {
			case "add":
				runAdd(sourceFile, outputFile);
				break;
			case "traverse":
				runTraverse(sourceFile,outputFile);
				break;
			case "get":
				runGet(sourceFile,  outputFile);
				break;
			case "remove":
				runRemove(sourceFile, outputFile);
				break;
			default:
				System.out.println("-op must be one of add|travers|get|remove");
		}
	}

	/**
	* Read the csv file of number,string pairs (as created by DataMaker) into
	* a list of Basic objects.
	* @param filename source csv file
	* @return list of Basic objects read from the file
	*/
	private static void loadData(File source, List<Basic> alist, int size) {

		try (BufferedReader reader = new BufferedReader(new FileReader(source))) {
		

			String line;
			
			// read at most "size" lines
			int count = 0;
			while (count < size && null != (line = reader.readLine())) {
				String[] parts = line.split(",");
				Integer number = Integer.valueOf(parts[0]);
				String alpha = parts[1];
				
				// add new Basic object to the data structure passed to method
				alist.add(new Basic(number, alpha));
				count++;
			}

		} catch (IOException e) {
			System.out.println("Could not read file: " + source.toString());
		}
	}

	// _____________________________________________________________________
	// _________________________________ ADD __________________________

	/**
	* Experiment: time (and measure memory for) adding all elements
	* to an ArrayList vs a LinkedList.
	* @param data elements to add
	* @param output file to record results in
	*/
	private static void runAdd(File source, File output) {
	
		String headings = 
		"size,arraytime(ns),linkedtime(ns),arrayram(bytes),linkedram(bytes)";

		// start the output file fresh with a header row
		try (PrintWriter writer = new PrintWriter(output)) {
			writer.println(headings);
		} catch (FileNotFoundException e) {
			System.out.println("Could not create file: " + output.toString());
			return;
		}

		Runtime runtime = Runtime.getRuntime();
		
		// use progression of data size to see trends as "n" increases
		for (int size : SIZES) {
		
			// display progress
			System.out.print(size+" ");

			// force garbage collection for better measure of memory
			arrayList = new ArrayList<Basic>();
			System.gc();

			long arrayMemBefore = runtime.totalMemory() - runtime.freeMemory();
			
			// start the timing
			long arrayStart = System.nanoTime();

			// load the data from the source into a new data structure arrayList
			loadData(source, arrayList, size);
			
			// record runtime for add
			long arrayDuration = System.nanoTime() - arrayStart;
			
			// if not enough data for this size, we are done
			if (arrayList.size() != size) {
				break;
			}

			// record memory usage to build the ArrayList
			System.gc();
			long arrayMemAfter = runtime.totalMemory() - runtime.freeMemory();
			long arrayMemUsed = arrayMemAfter - arrayMemBefore;
			
			
			// --------- Repeat Process for Linked List
			linkedList = new LinkedList<Basic>();
			System.gc();

			long linkedMemBefore = runtime.totalMemory() - runtime.freeMemory();
			
			long linkedStart = System.nanoTime();
			loadData(source, linkedList, size);
			
			long linkedDuration = System.nanoTime() - linkedStart;
			
			System.gc();
			long linkedMemAfter = runtime.totalMemory() - runtime.freeMemory();
			long linkedMemUsed = linkedMemAfter - linkedMemBefore;

			writeResult(output, size + "," + arrayDuration + "," + linkedDuration + "," + arrayMemUsed + "," + linkedMemUsed);
		}
		System.out.println();
	}

	// _____________________________________________________________________
	// _________________________________ TRAVERSE __________________________
	
	/**
	* Experiment: time iterating over all elements in an ArrayList vs
	* a LinkedList.
	* @param data elements to iterate over
	* @param output file to record results in
	*/
	private static void runTraverse(File source, File output) {

		// start the output file fresh with a header row
		try (PrintWriter writer = new PrintWriter(output)) {
			writer.println("size,arraytime (ns),linkedtime (ns)");
		} catch (FileNotFoundException e) {
			System.out.println("Could not create file: " + output.toString());
			return;
		}

		// use progression of data size to see trends as "n" increases
		for (int size : SIZES) {

			// display progress
			System.out.print(size+" ");

			// load data structures to have something to traverse
			arrayList = new ArrayList<Basic>();
			loadData(source, arrayList, size);
			
			// if not enough data to reach "size", we are done
			if (arrayList.size() != size) {
				break;
			}

			// something to use to make the loop useful
			Basic target = arrayList.get(0);

			// garbage collection to reduce pauses in the loop
			System.gc();

			// start the tranversal
			long arrayStart = System.nanoTime();
			Iterator<Basic> arrayIt = arrayList.iterator();
			while (arrayIt.hasNext()) {
				// doing something so compiler does not get rid of the loop
				if (arrayIt.next().compareTo(target)==0) {
					holder = target;
				};
			}
			// record runtime of traverse over array
			long arrayDuration = System.nanoTime() - arrayStart;


			// repeat process for linked list
			linkedList = new LinkedList<Basic>();
			loadData(source, linkedList, size);
			
			System.gc();
			long linkedStart = System.nanoTime();
			Iterator<Basic> linkedIt = linkedList.iterator();
			while (linkedIt.hasNext()) {
				if (linkedIt.next().compareTo(target)==0) {
					holder = target;
				}
			}
			long linkedDuration = System.nanoTime() - linkedStart;

			writeResult(output, size + "," + arrayDuration + "," + linkedDuration);
		}
		System.out.println();
	}

	// _____________________________________________________________________
	// _________________________________ GET __________________________
	
	/**
	* Experiment: time iterating over all elements in an ArrayList vs
	* a LinkedList.
	* @param data elements to iterate over
	* @param output file to record results in
	*/
	private static void runGet(File source, File output) {

		// start the output file fresh with a header row
		try (PrintWriter writer = new PrintWriter(output)) {
			writer.println("size,arraytime (ns),linkedtime (ns)");
		} catch (FileNotFoundException e) {
			System.out.println("Could not create file: " + output);
			return;
		}

		// use progression of data size to see trends as "n" increases
		for (int size : SIZES) {

			// display progress
			System.out.print(size+" ");


			// load data into data structures to be compared
			arrayList = new ArrayList<Basic>();
			loadData(source, arrayList, size);
			
			// if not enough data for expected "size", we are done
			if (arrayList.size() != size) {
				break;
			}

			// garbage collection to reduce pauses in the loop
			System.gc();

			// start timing
			long arrayStart = System.nanoTime();
			for (int i=0; i<arrayList.size(); i++) {
				// something to do so compiler does not optimize
				holder = arrayList.get(i);
			}
			long arrayDuration = System.nanoTime() - arrayStart;

			// repeat for linkedList
			linkedList = new LinkedList<Basic>();
			loadData(source, linkedList, size);
			System.gc();
			
			long linkedStart = System.nanoTime();
			for (int i=0; i<linkedList.size(); i++) {
				holder = linkedList.get(i);
			}
			long linkedDuration = System.nanoTime() - linkedStart;

			writeResult(output, size + "," + arrayDuration + "," + linkedDuration);
		}
		System.out.println();
	}

	// _____________________________________________________________________
	// _________________________________ REMOVE __________________________

	/**
	* Experiment: time repeatedly removing the "middle" element from
	* an ArrayList vs a LinkedList, until each is empty.
	* @param data elements to remove
	* @param output file to record results in
	*/
	private static void runRemove(File source, File output) {

		// start the output file fresh with a header row
		try (PrintWriter writer = new PrintWriter(output)) {
			writer.println("size,arraytime (ns),linkedtime (ns)");
		} catch (FileNotFoundException e) {
			System.out.println("Could not create file: " + output);
			return;
		}

		for (int size : SIZES) {
		
			// display progress
			System.out.print(size+" ");

			// load data into data structures to be compared
			arrayList = new ArrayList<Basic>();
			loadData(source, arrayList, size);
			if (arrayList.size() != size) {
				break;
			}
			
			// garbage collection to reduce pauses in the loop
			System.gc();

			// start timing
			// repeatedly locate and remove the "middle" element from arrayList
			long arrayStart = System.nanoTime();
			while (!arrayList.isEmpty()) {
				arrayList.remove(arrayList.size() / 2);
			}
			long arrayDuration = System.nanoTime() - arrayStart;

			// repeat for linkedList
			linkedList = new LinkedList<Basic>();
			loadData(source, linkedList, size);
			
			System.gc();
			long linkedStart = System.nanoTime();
			while (!linkedList.isEmpty()) {
				linkedList.remove(linkedList.size() / 2);
			}
			long linkedDuration = System.nanoTime() - linkedStart;

			writeResult(output, size + "," + arrayDuration + "," + linkedDuration);
		}
		System.out.println();
	}

	/**
	* Append a line of experiment results to the given output file.
	* @param output file to append the result line to
	* @param line result line to record
	*/
	private static void writeResult(File output, String line) {

		try (PrintWriter writer = new PrintWriter(new FileWriter(output, true))) {
			writer.println(line);
		} catch (IOException e) {
			System.out.println("Could not write to file: " + output);
		}
	}
}
