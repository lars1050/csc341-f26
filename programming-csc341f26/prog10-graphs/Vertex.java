import java.util.LinkedList;

/**
 * One vertex (node) of a graph.
 *
 * T is the type of data stored. For the puzzle, T is Integer:
 * the state number 0-15.
 */
public class Vertex<T> {

    /** the data in this vertex, e.g. 10 (binary 1010) */
    T value;

    /** Describes value or a label for the Vertex */
    String description;

    /** values of the vertices this one has an edge TO */
    LinkedList<Vertex<T>> adjacent = new LinkedList<>();

    /** the vertex we came from during a traversal (used to rebuild the path) */
    Vertex<T> parent;

    /** true once the traversal has reached this vertex */
    boolean visited;

	/** Constructor
	@param value Object stored in the vertex
	@param description Pretty print version of the value.
	*/
    public Vertex(T value, String description) {
        this.value = value;
        this.description = description;
    }

    /** prints as   value: description -> [neighbor, neighbor, ...] */
    @Override
    public String toString() {
        String toReturn = value + ": " + description + " -> {";
        for (Vertex<T> v : adjacent) {
        	toReturn += v.value + " ";
        }
        toReturn += "}";
        return toReturn;
    }
}
