package poet;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ConcreteGraph<L> implements graph.Graph<L> {

    private final Map<L, Map<L, Integer>> outgoingEdges;

    /**
     * Creates a new instance of ConcreteGraph.
     * This constructor initializes the outgoingEdges field with an empty HashMap.
     */
    public ConcreteGraph() {
        this.outgoingEdges = new HashMap<>();
    }

    /**
     * Creates an empty graph.
     *
     * @return an empty graph of type ConcreteGraph
     */
    public static <L> ConcreteGraph<L> empty() {
        return new ConcreteGraph<>();
    }

    /**
     * Adds a vertex to the graph.
     *
     * @param vertex the vertex to be added
     * @return true if the vertex is added successfully, false otherwise
     */
    @Override
    public boolean add(L vertex) {
        if (!outgoingEdges.containsKey(vertex)) {
            outgoingEdges.put(vertex, new HashMap<>());
            return true;
        }
        return false;
    }

    @Override
    public int set(L source, L target, int weight) {
        return 0;
    }

    /**
     * Adds an edge between two vertices in the graph.
     *
     * @param source the source vertex of the edge
     * @param target the target vertex of the edge
     * @return the weight of the edge after it is added
     */ // New method to add an edge
    public int addEdge(L source, L target) {
        add(source);
        add(target);

        Map<L, Integer> edges = outgoingEdges.get(source);
        int weight = edges.getOrDefault(target, 0) + 1;
        edges.put(target, weight);

        return weight;
    }

    /**
     * Retrieves the successors of a given vertex in the graph.
     *
     * @param vertex the vertex for which the successors are to be retrieved
     * @return a set containing the successors of the given vertex
     */ // New method to get successors
    public Set<L> getSuccessors(L vertex) {
        return outgoingEdges.getOrDefault(vertex, new HashMap<>()).keySet();
    }

    /**
     * Retrieves the weight of the edge between source and target vertices in the graph.
     *
     * @param source the source vertex of the edge
     * @param target the target vertex of the edge
     * @return the weight of the edge between source and target vertices, or 0 if the edge does not exist
     */ // New method to get weight
    public int getWeight(String source, String target) {
        return outgoingEdges.getOrDefault(source, new HashMap<>()).getOrDefault(target, 0);
    }

  
}
