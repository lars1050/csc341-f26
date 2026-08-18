import java.util.Random;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.nio.file.Path;

/**
* Command-line tool to generate a csv file of random number/string pairs,
* each pair representing the data for a Basic object.
*
* Usage: java DataMaker -s <size> -o <filename>
*   -s  number of lines (Basic objects) to generate
*   -o  name of the csv file to create
*/
public class DataMaker {

	/** shortest possible length of the random string */
	public static final int MIN_STRING_LENGTH = 5;

	/** longest possible length of the random string */
	public static final int MAX_STRING_LENGTH = 30;

	/** upper bound (exclusive) on the random number generated */
	public static final int MAX_NUMBER = 10_000_000;

	/** characters used to build the random string */
	private static final String LETTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

	private static Random rand = new Random();

	public static void main(String[] args) {

		Integer size = null;
		String filename = null;

		// parse the command-line arguments: -s <size> -o <filename>
		for (int i = 0; i < args.length; i++) {
			if (args[i].equals("-s") && i + 1 < args.length) {
				size = Integer.valueOf(args[++i]);
			} else if (args[i].equals("-o") && i + 1 < args.length) {
				filename = args[++i];
			}
		}

		if (null == size || null == filename) {
			System.out.println("Usage: java DataMaker -s <size> -o <filename>");
			return;
		}

		writeData(size, filename);
	}

	/**
	* Generate the specified number of random number/string pairs
	* and write them, one pair per line, to the given csv file.
	* @param size number of lines (Basic objects) to generate
	* @param filename name of the csv file to create
	*/
	public static void writeData(int size, String filename) {
	        
        Path pathWithFile = Path.of("data/"+filename);

		try (PrintWriter writer = new PrintWriter(pathWithFile.toFile())) {
			for (int i = 0; i < size; i++) {
				writer.println(randomNumber() + "," + randomString());
			}
			System.out.printf("Wrote %d lines to %s\n", size, filename);
		} catch (FileNotFoundException e) {
			System.out.println("Could not create file: " + filename);
		}
	}

	/** @return random number to pair with the random string */
	private static int randomNumber() {
		return rand.nextInt(MAX_NUMBER);
	}

	/** @return random string with length between MIN_STRING_LENGTH and MAX_STRING_LENGTH, inclusive */
	private static String randomString() {
		int length = MIN_STRING_LENGTH + rand.nextInt(MAX_STRING_LENGTH - MIN_STRING_LENGTH + 1);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < length; i++) {
			sb.append(LETTERS.charAt(rand.nextInt(LETTERS.length())));
		}
		return sb.toString();
	}
}
