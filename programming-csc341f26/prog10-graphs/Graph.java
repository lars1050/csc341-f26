import java.util.LinkedList;
import java.util.ArrayList;

/**
 * A directed graph.
 *
 * The graph is a list of vertices. Each vertex keeps a list of adjacent.
 */
public class Graph<T> {

    /** every vertex in the graph */
    private ArrayList<Vertex<T>> vertices = new ArrayList<>();

    /** Add a vertex that has already been built (adjacency list filled in). */
    public void addVertex(Vertex<T> vertex) {
        vertices.add(vertex);
    }

    /** Clear visited flags and parents so a new traversal starts fresh. */
    public void reset() {
    	for (Vertex<T> v : vertices) {
            v.visited = false;
            v.parent = null;
        }
    }
    
    /** Search the entire tree using BFS, starting with Vertex start.
    * @param start begin search from this vertex in the graph
    */
    public void BFS(Vertex<T> start) {
    	// generalize algorithm for search.
    	// Queue makes it a BFS
    	traverse(new Queue<Vertex<T>>(), start);
    }

	/** Search the entire tree using DFS, starting with Vertex start.
	* @param start begin search from this vertex in the graph
	*/
	public void DFS(Vertex<T> start) {
    	// generalize algorithm for search.
    	// Stack makes it a DFS
		traverse(new Stack<Vertex<T>>(), start);
	}
	
    /**
     * Search the graph from start until goal is found.
     *
     * As each new vertex is discovered we record its parent (the vertex we
     * reached it from). Afterward, path() follows those parents backward.
     *
     * @param list empty Queue or Stack that holds vertices waiting to be explored
     * @param start value to start at
     */
    private void traverse(QueueInterface<Vertex<T>> queue, Vertex<T> start) {
    
    	// reset parent and visited for all vertices
        reset();

		// TODO: Complete the code to traverse the graph starting at start vertex
		
    }// end travers()

    /**
     * Build the path from the start to goal after traverse() has run.
     *
     * Following parent links gives the path BACKWARD (goal ... start).
     * Pushing each vertex onto a Stack and then popping them all
     * reverses it into the right order (start ... goal).
     */
    public ArrayList<Vertex<T>> path(Vertex<T> goal) {
    
    	// TODO: Complete the code to create the path from start to goal
    	
        // walk backward from goal to start; start's parent is null
        
        // return ArrayList ordered from start to goal
        return null;
    }

    /** one line per vertex */
    @Override
    public String toString() {
        String result = "";
        for (Vertex<T> v : vertices) {
            result += v + "\n";
        }
        return result;
    }
}
