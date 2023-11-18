/* Copyright (c) 2015-2016 MIT 6.005 course staff, all rights reserved.
 * Redistribution of original or derived work requires permission of course staff.
 */
package graph;


import static org.junit.Assert.*;

import org.junit.Test;
import java.util.Map;
import java.util.Set;

/**
 * Tests for ConcreteEdgesGraph.
 * 
 * This class runs the GraphInstanceTest tests against ConcreteEdgesGraph, as
 * well as tests for that particular implementation.
 * 
 * Tests against the Graph spec should be in GraphInstanceTest.
 */
public class ConcreteEdgesGraphTest extends GraphInstanceTest {

    /**
     * Provides an instance of ConcreteEdgesGraph for tests in GraphInstanceTest.
     *
     * @return an empty instance of ConcreteEdgesGraph
     */
    @Override
    public Graph<String> emptyInstance() {
        return new ConcreteEdgesGraph();
    }

    /**
     * Tests the addition of a vertex to the graph.
     */
    @Test
    public void testAddVertex() {
        Graph<String> graph = emptyInstance();
        assertTrue(graph.add("A"));
        assertTrue(graph.vertices().contains("A"));
    }

    /**
     * Tests adding a duplicate vertex to the graph.
     */
    @Test
    public void testAddDuplicateVertex() {
        Graph<String> graph = emptyInstance();
        assertTrue(graph.add("A"));
        assertFalse(graph.add("A"));
        assertEquals(1, graph.vertices().size());
    }

    /**
     * Tests adding an edge between two vertices in the graph.
     */
    @Test
    public void testAddEdge() {
        Graph<String> graph = emptyInstance();
        assertTrue(graph.add("A"));
        assertTrue(graph.add("B"));
        assertEquals(0, graph.set("A", "B", 2));
        assertTrue(graph.targets("A").containsKey("B"));
    }

    /**
     * Tests setting the weight of an edge between two vertices in the graph.
     */
    @Test
    public void testSetEdgeWeight() {
        Graph<String> graph = emptyInstance();
        assertTrue(graph.add("A"));
        assertTrue(graph.add("B"));
        graph.set("A", "B", 2);
        assertEquals(2, graph.set("A", "B", 5));
        assertEquals(5, graph.targets("A").get("B").intValue());
    }

    /**
     * Tests removing a vertex from the graph.
     */
    @Test
    public void testRemoveVertex() {
        Graph<String> graph = emptyInstance();
        assertTrue(graph.add("A"));
        assertTrue(graph.add("B"));
        assertTrue(graph.remove("A"));
        assertFalse(graph.vertices().contains("A"));
        assertFalse(graph.targets("B").containsKey("A"));
    }

    /**
     * Tests retrieving the set of vertices in the graph.
     */
    @Test
    public void testVertices() {
        Graph<String> graph = emptyInstance();
        assertTrue(graph.add("A"));
        assertTrue(graph.add("B"));
        Set<String> vertices = graph.vertices();
        assertEquals(2, vertices.size());
        assertTrue(vertices.contains("A"));
        assertTrue(vertices.contains("B"));
    }

    /**
     * Tests retrieving the sources of edges with a target vertex in the graph.
     */
    @Test
    public void testSources() {
        Graph<String> graph = emptyInstance();
        assertTrue(graph.add("A"));
        assertTrue(graph.add("B"));
        assertTrue(graph.add("C"));
        graph.set("A", "B", 2);
        graph.set("C", "B", 3);
        Map<String, Integer> sources = graph.sources("B");
        assertEquals(2, sources.size());
        assertTrue(sources.containsKey("A"));
        assertTrue(sources.containsKey("C"));
    }

    /**
     * Tests retrieving the targets of edges with a source vertex in the graph.
     */
    @Test
    public void testTargets() {
        Graph<String> graph = emptyInstance();
        assertTrue(graph.add("A"));
        assertTrue(graph.add("B"));
        assertTrue(graph.add("C"));
        graph.set("A", "B", 2);
        graph.set("A", "C", 3);
        Map<String, Integer> targets = graph.targets("A");
        assertEquals(2, targets.size());
        assertTrue(targets.containsKey("B"));
        assertTrue(targets.containsKey("C"));
    }

    /*
     * Testing Edge...
     */

    /**
     * Tests the construction of an Edge instance.
     */
    @Test
    public void testEdgeConstruction() {
        Edge edge = new Edge("A", "B", 3);
        assertEquals("A", edge.getSource());
        assertEquals("B", edge.getTarget());
        assertEquals(3, edge.getWeight());
    }

    /**
     * Tests equality between two Edge instances.
     */
    @Test
    public void testEdgeEquality() {
        Edge edge1 = new Edge("A", "B", 3);
        Edge edge2 = new Edge("A", "B", 3);
        assertEquals(edge1, edge2);
    }

    /**
     * Tests inequality between two Edge instances.
     */
    @Test
    public void testEdgeInequality() {
        Edge edge1 = new Edge("A", "B", 3);
        Edge edge2 = new Edge("B", "A", 3);
        assertNotEquals(edge1, edge2);
    }

    /**
     * Tests the string representation of an Edge instance.
     */
    @Test
    public void testEdgeToString() {
        Edge edge = new Edge("A", "B", 3);
        assertEquals("(A -> B, weight: 3)", edge.toString());
    }
}
