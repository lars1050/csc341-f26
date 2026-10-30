import java.util.ArrayList;
import java.util.Comparator;
import java.util.function.Function;
import java.util.Random;

/** BST Tester - visual inspection */
public class Main {

	// Default comparison is by alpha (with number as tie-breaker)
	// This is the opposite -- ordering by number with alpha as tie-breaker
	public static Comparator<AlphaNumeric> byNumber = new Comparator<AlphaNumeric>() {
		@Override
		public int compare(AlphaNumeric s1, AlphaNumeric s2) {
			if (s1.number().compareTo(s2.number())==0) {
				return s1.alpha().compareTo(s2.alpha());
			} else {
				return s1.number().compareTo(s2.number());
			}
		}
	};

    public static void main(String[] args) {
    
     	Random random = new Random(10);

        // Create a BST of AlphaNumeric using default "alpha" ordering
        // This is a list used for testing
        ArrayList<AlphaNumeric> elements = new ArrayList<>();
        for (int i=0; i<20; i++) {
        	AlphaNumeric an = new AlphaNumeric(String.valueOf((char)(i+'a')),20-i);
        	elements.add(an);
        }
        System.out.println("Adding the following elements");
        for (AlphaNumeric e: elements) {
        	System.out.print(e+" ");
        }
        System.out.println();
        
        // calling the add method (distributing across BST)
        ANlist alist = new ANlist();
        alist.add(elements.get(10));
        for (int i=0; i<elements.size(); i+=2) {
        	if (i!=10) {
	        	alist.add(elements.get(i));
	        }
        }
        for (int i=1; i<elements.size(); i+=2) {
        	alist.add(elements.get(i));
        }
        // lets see what we have ...
        System.out.println(alist);
        
        // calling the min and max
        System.out.println(alist.min());
        System.out.println(alist.max());
        
        // calling contains ...
        for (int i=0; i<elements.size(); i+=3) {
        	System.out.println(i+":"+alist.contains(elements.get(i)));
        }
        
        // calling query ...
        alist.add(new AlphaNumeric("b",10));
        ArrayList<AlphaNumeric> qlist;
        qlist = alist.query((x)->{return x.alpha().equals("b");});
        System.out.println(qlist);
        
        // calling FindLast ...
        alist.add(new AlphaNumeric("a",15));
        alist.add(new AlphaNumeric("z",15));
        System.out.println(alist.findLast((x)->{ return x.number()==15;}));
        
        try {
	        System.out.println("Height is "+alist.height());
	    } catch(Exception e) {
	    	e.printStackTrace();
	    }
	    
    } // end main()
} // end class Main
