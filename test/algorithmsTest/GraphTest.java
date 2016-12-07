package algorithmsTest;

import io.Input;
import trains.Application;
import trains.Trains;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import algorthims.Graph;

public class GraphTest{
	
	Input input;
	Trains trains;
	String graphInput;
	Graph graph;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	   
	}

	@Before
	public void setUp() throws Exception {
		input =  new Input();
		graph = input.createGraph(1);
		trains = new Trains(graph);
	}

	@Test
	public void testGraph() {
		
		fail("Not yet implemented");
	}

	@Test
	public void testGraphIntInt() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddEdgeIntIntIntInt() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddEdgeIntIntInt() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetNodes() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetNodes() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetEdges() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetEdges() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetEdgePairs() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetEdgePairs() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetVisitedNodes() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetAdjacencyList() {
		fail("Not yet implemented");
	}

}
