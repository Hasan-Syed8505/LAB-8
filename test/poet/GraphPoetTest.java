/* Copyright (c) 2015-2016 MIT 6.005 course staff, all rights reserved.
 * Redistribution of original or derived work requires permission of course staff.
 */
package poet;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Tests for GraphPoet.
 */
public class GraphPoetTest {
    
    // Testing strategy
    //   TODO
    
    @Test(expected=AssertionError.class)
    public void testAssertionsEnabled() {
        assert false; // make sure assertions are enabled with VM argument: -ea
    }
    
    // TODO tests
    @Test
    public void testGraphPoetConstructor() throws IOException {
        // Test the GraphPoet(File) constructor with a sample corpus file
        GraphPoet samplePoet = new GraphPoet(new File("test/poet/sample-corpus.txt"));

        // Add assertions to check the state of the GraphPoet object after
        // construction
        // For example, check that the graph is not empty
        //assertTrue(!samplePoet.graph.toString().isEmpty());
    }

    @Test
    public void testPoemGeneration1() throws IOException {
        GraphPoet samplePoet = new GraphPoet(new File("test/poet/sample-corpus.txt"));
        // Test the poem(String) method with different input strings

        String input1 = "Test of the mugar system.";
        String expectedOutput1 = "Test of of the the mugar mugar omni system.";
        assertEquals(expectedOutput1, samplePoet.poem(input1));
    }
    
}
