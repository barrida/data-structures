package algorithmsTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import algorthims.BreadthFirstSearch;
import algorthims.Graph;
import io.Input;

public class BreadthFirstSearchTest {
	Input input;
	Graph graph;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

	}

	@Before
	public void setUp() throws Exception {

	}

	@Test
	public void testBFS() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testRecursive() {
		testCase1(0);
		testCase2(1);
	}
	

	public void testCase2(int graphId) {
		input = new Input();
		graph = input.createGraph(graphId);

		BreadthFirstSearch bfs = new BreadthFirstSearch(graph);
		bfs.recursive(0);
		assertEquals("[0, 1, 2, 3]", bfs.getResult().toString());

		BreadthFirstSearch bfs2 = new BreadthFirstSearch(graph);
		bfs2.recursive(1);
		assertEquals("[1, 3]", bfs2.getResult().toString());

		BreadthFirstSearch bfs3 = new BreadthFirstSearch(graph);
		bfs3.recursive(2);
		assertEquals("[2, 0, 1, 3]", bfs3.getResult().toString());

		BreadthFirstSearch bfs4 = new BreadthFirstSearch(graph);
		bfs4.recursive(3);
		assertEquals("[3]", bfs4.getResult().toString());
	}

	/**
	 * @param graphId
	 *            graph input from test data
	 * @throws NumberFormatException
	 */
	public void testCase1(int graphId) throws NumberFormatException {
		input = new Input();
		graph = input.createGraph(graphId);

		BreadthFirstSearch bfs = new BreadthFirstSearch(graph);
		bfs.recursive(0);
		assertEquals("[0, 1, 3, 4, 2]", bfs.getResult().toString());

		BreadthFirstSearch bfs2 = new BreadthFirstSearch(graph);
		bfs2.recursive(1);
		assertEquals("[1, 2, 3, 4]", bfs2.getResult().toString());

		BreadthFirstSearch bfs3 = new BreadthFirstSearch(graph);
		bfs3.recursive(2);
		assertEquals("[2, 3, 4, 1]", bfs3.getResult().toString());

		BreadthFirstSearch bfs4 = new BreadthFirstSearch(graph);
		bfs4.recursive(3);
		assertEquals("[3, 2, 4, 1]", bfs4.getResult().toString());
	}

	@Test
	public void testIterative() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testSearchAdjacentNodes() {
		fail("Not yet implemented"); // TODO
	}

}
