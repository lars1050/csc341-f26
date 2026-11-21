import java.util.ArrayList;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
    	
    	// user needs to specify algorithm and graph (start and goal are optional for sample)
    	if (args.length < 4) {
    		System.out.print("Specify search and graph. ");
    		System.out.println("Ex: java Main bfs puzzle 0 15");
    		return;
    	}
    
    	// determine graph and algorithm for search
    	String search = args[0];
    	String problem = args[1];
    	
    	// T is chosen here, where each branch knows its concrete type,
    	// then the same generic code does the rest.
    	if (problem.equals("puzzle")) {
    		// start = 0000 (everyone at old home), goal = 1111 (everyone at new home)
    		// ignoring user request and putting in 0 to 15
    		solve(search, make_puzzle_vertices(), 0, 15);
    		
    	} else {	// sample graph
    		solve(search, make_sample_vertices(), args[2], args[3]);
    	}
    }
    
    /**
     * Build a graph from the vertices, search from start, and print the path to goal.
     * Works for any type T because it only uses Graph<T> and Vertex<T>.
     * @param vertices   maps each value to its vertex, e.g. "C" ==> vertex C
     * @param startValue value stored in the start vertex, e.g. "C" or 0
     * @param goalValue  value stored in the goal vertex, e.g. "F" or 15
     */
    public static <T> void solve(String search, HashMap<T, Vertex<T>> vertices,
                                 T startValue, T goalValue) {
                                 
    	Graph<T> graph = new Graph<>();
    	
    	// populate graph with vertices
    	for (Vertex<T> v : vertices.values()) {
    		graph.addVertex(v);
    	}
    	
    	// look up the vertices that hold the start and goal values
    	Vertex<T> start = vertices.get(startValue);
    	Vertex<T> goal = vertices.get(goalValue);
    	if (start == null || goal == null) {
    		System.out.println("No vertex for start or goal.");
    		return;
    	}
    	
    	// run the search
    	if (search.equalsIgnoreCase("bfs")) {
    		graph.BFS(start);
    	} else {
    		graph.DFS(start);
    	}
    	
    	// the search never reached the goal, so there is no path
    	if (!goal.visited) {
    		System.out.println("No path from " + startValue + " to " + goalValue);
    		return;
    	}
    	
    	// get the path to the goal
    	ArrayList<Vertex<T>> path = graph.path(goal);
    	for (Vertex<T> v : path) {
    		System.out.println(v.value + ": " + v.description);
    	}
    }
    
    // __________________________________________________________________________
    // _______________     EXAMPLE GRAPH IMPLEMENTATION _________________________
    
    public static HashMap<String, Vertex<String>> make_sample_vertices() {
    	/*
    	Each row is one vertex and its edges:  the FIRST entry is the vertex,
    	the REST are the vertices it has an edge TO.
    		{ "A", "C", "D" }   means   A ==> { C, D }
    	A vertex with no edges out is just { "G" }.
    	*/
    	String[][] EDGES = {
    		{ "A", "C", "D" },
    		{ "B", "A", "E" },
    		{ "C", "B", "D", "E" },
    		{ "D", "F" },
    		{ "E", "F", "G" },
    		{ "F", "G" },
    		{ "G" },
    	};

    	// Create a vertex for each row (first entry of each row).
    	// The map lets us find a vertex from its value: "C" ==> vertex C
    	HashMap<String, Vertex<String>> vertices = new HashMap<>();
    	for (String[] row : EDGES) {
    		// add to hashmap, keyed on character, eg. "A", hashmap value is Vertex
    		// Vertex value and Vertex description are the same, e.g. "A" and "A"
    		vertices.put(row[0], new Vertex<>(row[0], row[0]));
    	}
    	
    	// Now that all vertices exist, fill in adjacency lists
    	for (String[] row : EDGES) {
    		Vertex<String> v = vertices.get(row[0]);
    		for (int i = 1; i < row.length; i++) {
    			// for each adjacent vertex, get vertex from hashmap and add to adjacency
    			v.adjacent.add(vertices.get(row[i]));
    		}
    	}
    	
    	return vertices;
    } // end make_sample_vertices()
    
    
	// __________________________________________________________________________
    // _______________     PUZZLE GRAPH IMPLEMENTATION __________________________
    
    
    public static HashMap<Integer, Vertex<Integer>> make_puzzle_vertices() {
		/* 
		The puzzle: 
		A human, snake, cat, and fish must move from the old home to the new home. 
		The human can carry at most ONE animal per trip. If the human is not there:
			- the snake eats the cat
			- the cat eats the fish
		(the snake and fish are safe together)
		
		How it is modeled as a graph:
		- A vertex is a STATE, stored as a number 0-15. Each of its 4 bits
		  tells where one mover is: 0 = old home, 1 = new home.
			 bit:    8      4      2     1
				   human  snake   cat  fish
	 
			0  = 0000  everyone in the old home (start)
			10 = 1010  human and cat in the new home
			15 = 1111  everyone in the new home (goal)
			
		- An edge is ONE TRIP: the human crosses alone or with one animal.
			If an animal gets eaten in a state, that state has no edges out.
	
		MOVES[i] lists the states you can reach in one trip from state i		
		Dead states have no moves: {}.
		*/
		
		int[][] MOVES = {
			/*0= 0000 */ { 0b1000, 0b1100, 0b1010, 0b1001 },
			/*1= 0001 */ { 0b1001, 0b1101, 0b1011 },
			/*2= 0010 */ { 0b1010, 0b1110, 0b1011 },
			/*3= 0011 */ { },  	// dead end state (because an animal was eaten)                          
			/*4= 0100 */ { 0b1100, 0b1110, 0b1101 },
			/*5= 0101 */ { 0b1101, 0b1111 },
			/*6= 0110 */ { },
			/*7= 0111 */ { },  
			/*8= 1000 */ { },              
			/*9= 1001 */ { },                         
			/*10=1010 */ { 0b0010, 0b0000 },           
			/*11=1011 */ { 0b0011, 0b0001, 0b0010 },        
			/*12=1100 */ { },                              
			/*13=1101 */ { 0b0101, 0b0001, 0b0100 },      
			/*14=1110 */ { 0b0110, 0b0010, 0b0100 },          
			/*15=1111 */ { 0b0111, 0b0011, 0b0101, 0b0110 },
		};

        // Step 1: create a vertex for each of the 16 states.
        // key = state number, so vertices.get(0) is 0000 (everyone in the old home)
        HashMap<Integer, Vertex<Integer>> vertices = new HashMap<>();
        for (int i = 0; i < 16; i++) {
            vertices.put(i, new Vertex<>(i, describeState(i)));
        }

        // Step 2: now that all vertices exist, fill in adjacency lists
        for (Vertex<Integer> v : vertices.values()) {
        	// get the list of states that this vertex can legally move to
            for (int adj : MOVES[v.value]) {
            	// get vertex that corresponds to this adjacent state 
                v.adjacent.add(vertices.get(adj));
            }
        } // end for 
        
		return vertices;
		
	} // end make_puzzle_vertices()
	
	/** builds e.g. "old = {snake, fish}; new = {human, cat}" */
    public static String describeState(int state) {
		// Create lists of who is where
		String oldHome = "OLD = {";
		String newHome = "NEW = {";
		
		// BITS human | snake | cat | fish
		// so 1100 woud result in new = { human snake }; old = { cat fish }
		
		// if the left-most bit is 1 (i.e. !=0), human is in new home
		if (0!=(state & (1<<3))) { newHome += " human "; }
		else { oldHome += " human "; }
		
		if (0!=(state & (1<<2))) { newHome += " snake "; }
		else { oldHome += " snake "; }
		
		if (0!=(state & (1<<1))) { newHome += " cat "; }
		else { oldHome += " cat "; }
		
		if (0!=(state & (1<<0))) { newHome += " fish "; }
		else { oldHome += " fish "; }
		
		String describe = oldHome + "}; " + newHome + "}"; 
		//System.out.println(state + ": " + describe);
		return describe;
		
	} // end describeState()
	
} // end class Main
