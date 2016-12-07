package algorthims;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.stream.Collectors;

/**
 * Class that implements Breadth-first search (BFS) algorithm. If you are asked
 * to implement BFS, the key thing to remember is the use of the queue.
 * 
 * @author suleyman.yildirim
 * 
 */
public class BreadthFirstSearch {
	private Graph graph;
	private Queue<Integer> queue;
	private Queue<Integer> result;
	private Map<Integer, LinkedList<Integer>> adjacencyList;
	private boolean visitedNodes[]; // array holds visited nodes

	public BreadthFirstSearch(Graph graph) {
		this.setGraph(graph);
		this.adjacencyList = graph.getAdjacencyList();
		this.visitedNodes = new boolean[graph.getNodes()];
		this.queue = new LinkedList<Integer>();
		this.result = new LinkedList<Integer>();
	}

	public void recursive(int source) {
		try {
			System.out.println("BFS recursive from source " + source);
			visitedNodes[source] = true;
			queue.add(source);
			result.add(source);
			searchAdjacentNodes(queue.peek());
			System.out.println(result.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void iterative(int source) {
		try {
			System.out.println("BFS iterative from source " + source);
			visitedNodes[source] = true;
			queue.add(source);
			while (queue.size() != 0) {
				int s = queue.remove();
				System.out.print(s + " ");
				result.add(s);
				for (Integer adjacentNode : adjacencyList.get(s)) {
					if (isUnvisited(adjacentNode)) {
						visitedNodes[adjacentNode] = true;
						queue.add(adjacentNode);
						result.add(adjacentNode);
					}
				}
			}
			System.out.println("searchNodesIterative " + queue.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Visit the adjacent unvisited vertex. Mark it as visited. Display it. Push
	 * it in a stack.
	 * 
	 * If no adjacent vertex is found, pop up a vertex from the stack.
	 * 
	 * @param source
	 */
	public void searchAdjacentNodes(int source) {
		if (isAllVisited())
			return;
		
		for (Integer adjacentNode : adjacencyList.get(source)) {
			if (isUnvisited(adjacentNode)) {
				visitedNodes[adjacentNode] = true;
				queue.add(adjacentNode);
				result.add(adjacentNode);
			}
		}
		queue.remove();
		if (queue.peek() != null) {
			searchAdjacentNodes(queue.peek());
		}
	}

	@SuppressWarnings("unused")
	private boolean isAllVisited() {
		for (int i = 0; i < visitedNodes.length; i++) {
			if (visitedNodes[i] == false) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Checks if the current node is not visited
	 * 
	 * @param adjacentNode
	 *            adjacent node among other adjacent nodes
	 * @return visited array of visited nodes
	 */
	private boolean isUnvisited(Integer adjacentNode) {
		return visitedNodes[adjacentNode] == false;
	}

	public Queue<Integer> getQueue() {
		return queue;
	}

	public Queue<Integer> getResult() {
		return result;
	}

	public Graph getGraph() {
		return graph;
	}

	public void setGraph(Graph graph) {
		this.graph = graph;
	}
}
