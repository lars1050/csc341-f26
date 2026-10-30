import java.util.Comparator;
import java.util.function.Function;
import java.util.ArrayList;

public class ANlist {

	class Node {
		AlphaNumeric value;
		Node left;
		Node right;
		Node parent;
		int height;
		Node(AlphaNumeric an) {
			value = an;
		}
	}
	
	private static Comparator<Alphanumeric> orderBy = new Comparator<>() {
		@Override
		public int compare(AlphaNumeric an1, AlphaNumeric an2) {
			return an1.compareTo(an2);
		}
	};
	
	/*
	@Override
	public String toString
	
	public int height
	
	public void add
	
	private void adjustHeight

	public boolean contains
	
	public AlphaNumeric min
	
	public AlphaNumeric max
	
	public AlphaNumeric[] toArray
	
	public ArrayList<AlphaNumeric> query
	
	public AlphaNumeric findLast
	*/

}