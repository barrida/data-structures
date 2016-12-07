package algorithmsTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import algorthims.DepthFirstSearch;
import algorthims.Graph;
import io.Input;

public class DepthFirstSearchTest {
	Input input;
	Graph graph;

	@Before
	public void setUp() throws Exception {
		input = new Input();
	}

	@Test
	public void testRecursive() {
		graph = input.createGraph(3); //AB0, AC0, AE0, BD0, BF0, CG0
		DepthFirstSearch dfs = new DepthFirstSearch(graph);
		dfs.recursive(0);
		assertEquals("[0, 1, 3, 5, 2, 6, 4]", dfs.getResult().toString());

		DepthFirstSearch dfs1 = new DepthFirstSearch(graph);
		dfs1.recursive(1);
		assertEquals("[1, 0, 2, 6, 4, 3, 5]", dfs1.getResult().toString());
		
		DepthFirstSearch dfs2 = new DepthFirstSearch(graph);
		dfs2.recursive(2);
		assertEquals("[2, 6]", dfs2.getResult().toString());
	}
}
