package algorthims;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class DepthFirstSearch {
	private Graph graph;
	private List<Integer> result; // list holds the search dfs result
	private Map<Integer, LinkedList<Integer>> adjacencyList; // adjacency list of the graph
	private boolean visitedNodes[]; // array holds visited nodes

	public DepthFirstSearch(Graph graph) {
		this.setGraph(graph);
		this.adjacencyList = graph.getAdjacencyList();
		this.visitedNodes = new boolean[graph.getNodes()];
		this.setResult(new LinkedList<Integer>());
	}
	
	public void recursive(int source){
		visitedNodes[source] = true;
		System.out.println(source + " ");
		result.add(source);
		Iterator<Integer> it = adjacencyList.get(source).iterator();
		while(it.hasNext()){
			int currentNode = it.next();	
			if (visitedNodes[currentNode]==false) {
				recursive(currentNode);
			}
		}
	}

	public List<Integer> getResult() {
		return result;
	}

	public void setResult(List<Integer> result) {
		this.result = result;
	}

	public Graph getGraph() {
		return graph;
	}

	public void setGraph(Graph graph) {
		this.graph = graph;
	}
}
