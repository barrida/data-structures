package trainsTest;

import io.Input;
import trains.Application;
import trains.Trains;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import algorthims.Graph;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;

public class TrainsTest {
	
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
	public void testTrains() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testInitAdjacencyList() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testSetAdjacencyList() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testGetRoutes() {
		assertEquals(0, trains.getNumberOfRoutes());
	}

	@Test
	public void testComputeRoutes() {
		//0=[2, 0, 1, 3] --> 18 , 1=[2, 0, 3] --> 16  , 2=[2, 1, 3] --> 13 
		Map<Integer, List<Integer>> routes = trains.findRoutes(2, 3);
		assertEquals("[2, 0, 1, 3]",routes.get(0).toString());
		assertEquals("[2, 0, 3]",routes.get(1).toString());
		assertEquals("[2, 1, 3]",routes.get(2).toString());
	}

	@Test
	public void testComputeShortestRoute() throws Exception {
		Map<Integer, List<Integer>> routes = trains.findRoutes(2, 3);
		Map<Integer, Integer> map = trains.computeRoutes(routes);
		List<Integer> route = trains.computeShortestRoute(map, 2, 3);
		assertEquals("[2, 1, 3]", route.toString());
	}

	@Test
	public void testComputeDistance() throws Exception {
		//0=[2, 0, 1, 3] --> 18 , 1=[2, 0, 3] --> 16  , 2=[2, 1, 3] --> 13 
		Map<Integer, List<Integer>> routes = trains.findRoutes(2,3);
		assertEquals(18,trains.computeDistance(0));
		assertEquals(16,trains.computeDistance(1));
		assertEquals(13,trains.computeDistance(2));
	}

	@Test
	public void testFindRoutes() {
		//0=[2, 0, 1, 3] --> 18 , 1=[2, 0, 3] --> 16  , 2=[2, 1, 3] --> 13 
		Map<Integer, List<Integer>> routes = trains.findRoutes(2,3);
		assertEquals(3, routes.size());
	}

	@Test
	public void testGetNumberOfRoutes() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testSetNumberOfRoutes() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testGetRoute() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testSetRoute() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testGetVisited() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testSetVisited() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testGetGraph() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testSetGraph() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testGetAdjacencyList() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testSetRoutes() {
		assertEquals(0, trains.getNumberOfRoutes());
	}

}
