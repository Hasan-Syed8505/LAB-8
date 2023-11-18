/* Copyright (c) 2015-2016 MIT 6.005 course staff, all rights reserved.
 * Redistribution of original or derived work requires permission of course staff.
 */
package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * An implementation of Graph.
 * 
 * <p>
 * PS2 instructions: you MUST use the provided rep.
 */

// ConcreteEdgesGraph class

//ConcreteEdgesGraph class
public class ConcreteEdgesGraph implements Graph<String> {

 private final Set<String> vertices = new HashSet<>();
 private final List<Edge> edges = new ArrayList<>();

 // Abstraction function:
 // Represents a weighted directed graph with labeled vertices and edges.
 // Representation invariant:
 // Edges in the 'edges' list must connect vertices in 'vertices'.
 // Safety from rep exposure:
 // All fields are private. Defensive copies are used where needed.

 // Constructor
 public ConcreteEdgesGraph() {
     // Initialize the graph if needed
 }

 // Representation invariant check
 private void checkRep() {
     for (Edge edge : edges) {
         assert vertices.contains(edge.getSource()) : "Source vertex not in vertices set";
         assert vertices.contains(edge.getTarget()) : "Target vertex not in vertices set";
     }
 }

 @Override
 public boolean add(String vertex) {
     if (vertices.add(vertex)) {
         checkRep();
         return true;
     }
     return false;
 }

 @Override
 public int set(String source, String target, int weight) {
     Iterator<Edge> iterator = edges.iterator();
     while (iterator.hasNext()) {
         Edge edge = iterator.next();
         if (edge.getSource().equals(source) && edge.getTarget().equals(target)) {
             int previousWeight = edge.getWeight();
             iterator.remove(); // Use iterator to safely remove the element
             edges.add(new Edge(source, target, weight));
             vertices.add(source);
             vertices.add(target);
             checkRep(); // Call checkRep after modification
             return previousWeight;
         }
     }
     edges.add(new Edge(source, target, weight));
     vertices.add(source);
     vertices.add(target);
     checkRep(); // Call checkRep after modification
     return 0;
 }

 @Override
 public boolean remove(String vertex) {
     if (vertices.remove(vertex)) {
         edges.removeIf(edge -> edge.getSource().equals(vertex) || edge.getTarget().equals(vertex));
         checkRep(); // Call checkRep after modification
         return true;
     }
     return false;
 }

 @Override
 public Set<String> vertices() {
     return new HashSet<>(vertices);
 }

 @Override
 public Map<String, Integer> sources(String target) {
     Map<String, Integer> sourceMap = new HashMap<>();
     for (Edge edge : edges) {
         if (edge.getTarget().equals(target)) {
             sourceMap.put(edge.getSource(), edge.getWeight());
         }
     }
     return sourceMap;
 }

 @Override
 public Map<String, Integer> targets(String source) {
     Map<String, Integer> targetMap = new HashMap<>();
     for (Edge edge : edges) {
         if (edge.getSource().equals(source)) {
             targetMap.put(edge.getTarget(), edge.getWeight());
         }
     }
     return targetMap;
 }

 // toString()
 @Override
 public String toString() {
     StringBuilder result = new StringBuilder();
     for (Edge edge : edges) {
         result.append(edge.toString()).append("\n");
     }
     return result.toString();
 }
}


/**
 * TODO specification
 * Immutable.
 * This class is internal to the rep of ConcreteEdgesGraph.
 * 
 * <p>PS2 instructions: the specification and implementation of this class is
 * up to you.
 */
class Edge {
    
    // TODO fields
    
    // Abstraction function:
    //   TODO
    // Representation invariant:
    //   TODO
    // Safety from rep exposure:
    //   TODO
    
    // TODO constructor
    
    // TODO checkRep
    
    // TODO methods
    
    // TODO toString()
    
}
