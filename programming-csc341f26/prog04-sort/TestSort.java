import java.util.*;

public class TestSort {

	public static ArrayList<Auggie> toAdd = AuggieFactory.makeAuggies(10);

	public static Comparator<Auggie> byUsername = new Comparator<Auggie>() {
		@Override
		public int compare(Auggie a1, Auggie a2) {
			return a1.username().compareTo(a2.username());
		}
	};
	
	public static Comparator<Auggie> byLast = new Comparator<Auggie>() {
		@Override
		public int compare(Auggie a1, Auggie a2) {
			if (a1.last().equals(a2.last())) {
				return a1.first().compareTo(a2.first());
			}
			return a1.last().compareTo(a2.last());
		}
	};
	
	public static Comparator<Auggie> byRole = new Comparator<Auggie>() {
		@Override
		public int compare(Auggie a1, Auggie a2) {
			if (a1.role().equals(a2.role())) {
				return a1.last().compareTo(a2.last());
			}
			return a1.role().compareTo(a2.role());
		}
	};


	public static void main(String[] args) {
	
		System.out.println("\n_______________________________________________");
		sanityCheck();
		System.out.println("\n_______________________________________________");
		testMinimumSearch();
		System.out.println("\n_______________________________________________");
		testSorting();
		System.out.println("\n_______________________________________________");
		testMinimumSorted();
		System.out.println("\n_______________________________________________");
		testFindLinear();
		System.out.println("\n_______________________________________________");
		testFindBinary();
	}

	public static void sanityCheck() {
		System.out.println("Testing add and get.");
		AuggieList alist = new AuggieList();
		
		// is it adding okay?
		for (Auggie a : toAdd) {
			alist.add(a);	
		}
		System.out.println(alist);
		
		// is it getting okay?
		System.out.println("first: " + alist.get(0));
		System.out.println("last: " + alist.get(toAdd.size()-1));
		System.out.println("middle (5): " + alist.get(5));
		System.out.println("not there: " + alist.get(toAdd.size()));
	}

	public static void testMinimumSearch() {
		System.out.println("Testing finding minimum through search.");
		AuggieList alist = new AuggieList();
		for (Auggie a : toAdd) {
			alist.add(a);	
		}
		System.out.println(alist);
		System.out.println("Find minimum: username, last name, then role.");
		System.out.println(alist.minimum(byUsername));
		System.out.println(alist.minimum(byLast));
		System.out.println(alist.minimum(byRole));
	} // end testMinimumSearch
	
	public static void testMinimumSorted() {
		System.out.println("Testing finding minimum of sorted.");
		AuggieList alist = new AuggieList();
		for (Auggie a : toAdd) {
			alist.add(a);	
		}
		alist.sort(byLast,"insertion");
		System.out.println(alist);
		
		System.out.println("Find minimum byLast. Expect lookup of [0]");
		System.out.println(alist.minimum(byLast));
		System.out.println("Find minimum byUsername. Expect to search.");
		System.out.println(alist.minimum(byUsername));
	} // end testMinimumSorted
	
	public static void testSorting() {
		System.out.println("Testing sorting.");
		AuggieList alist = new AuggieList();
		for (Auggie a : toAdd) {
			alist.add(a);	
		}
		System.out.println(alist);	
		
		alist.sort(byLast,"insertion");
		System.out.println("\nShould be by last name using Insertion Sort.");
		System.out.println(alist);
		
		alist.sort(byUsername,"selection");
		System.out.println("\nShould be back to username using Selection Sort.");
		System.out.println(alist);
	} // end testSorting
	
	
	public static void testFindLinear() {
		System.out.println("Testing finding with Linear Search.");
		AuggieList alist = new AuggieList();
		for (Auggie a : toAdd) {
			alist.add(a);	
		}
		System.out.println(alist);	
		
		// find the first, last and something in between
		Auggie a = alist.get(0);
		System.out.println("Find first (expect 0): " + alist.find(a));
		
		a = alist.get(5);
		System.out.println("Find middle (expect 5): " + alist.find(a));
		
		a = alist.get(toAdd.size()-1);
		System.out.println("Find last: " + alist.find(a));
		
	} // end testFindLinear
	
	public static void testFindBinary() {
		System.out.println("Testing finding with Binary Search.");
		AuggieList alist = new AuggieList();
		for (Auggie a : toAdd) {
			alist.add(a);	
		}
		alist.sort(byLast,"insertion");
		System.out.println(alist);	
		
		// find the first, last and something in between
		Auggie a = alist.get(0);
		System.out.println("Find first (expect 0): " + alist.find(a));
		
		a = alist.get(5);
		System.out.println("Find middle (expect 5): " + alist.find(a));
		
		a = alist.get(toAdd.size()-1);
		System.out.println("Find last: " + alist.find(a));	
	}
} // end TestSort