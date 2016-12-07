package algorthims;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Class that represents a graph
 * @author suleyman.yildirim
 *
 */
public class Graph {
	
	private int nodes; // total number of vertex in a graph
	private int edges;	 // total number of edges in a graph
	private Edge edgePairs[];	 // array of edges
	private boolean visitedNodes[]; // array holds visited nodes
	private Map<Integer, LinkedList<Integer>> adjacencyList;

	/**
	 * Default constructor
	 */
	public Graph() {
		
	}

	/**
	 * Initializes graph and edges
	 * @param nodes total number of nodes
	 * @param edges total number of edges
	 */
	public Graph(int nodes, int edges) {
		this.nodes = nodes;
		this.edges = edges;	
		this.visitedNodes = new boolean[nodes]; //sets the visited nodes to false
		this.setEdgePairs(edges);
		initAdjacencyList();
	}

	/**
	 * Initialize an adjacency list
	 */
	public void initAdjacencyList() {
		adjacencyList = new HashMap<Integer, LinkedList<Integer>>();
		for (int i = 0; i < this.getNodes(); i++) {
			adjacencyList.put(i, new LinkedList<Integer>());
		}
	}
	
	/**
	 * Creates an adjacency list representation of the graph
	 * @param adjacencyList
	 */
	public void setAdjacencyList() {
		Graph.Edge edgeArr[] = this.getEdgePairs();
		for (int i = 0; i < edgeArr.length; i++) {			
			int sourceNode = edgeArr[i].u;
			int adjacentNode = edgeArr[i].v;
			this.adjacencyList.get(sourceNode).add(adjacentNode);
		}
	}
	
	/**
	 * Represent an edge (u,v) with weight and state
	 */
	public class Edge{
		public int u; // start node
		public int v; // end node
		public int w; // weight of the directed edge from node u to v. Default value is 0 for an unweighted graph
		State state; //
	}
	
	/**
	 * State of the node
	 */
	public enum State {
		NODE_UNVISITED, NODE_VISITED;
	}
	
	/**
	 * Add edge to the weighted graph
	 * @param i index of an edge
	 * @param u source node
	 * @param v destination node
	 * @param w cost of the edge(u,v)
	 */
	public void addEdge(int i, int u, int v, int w) {
		this.edgePairs[i].u = u;
        this.edgePairs[i].v = v;
        this.edgePairs[i].w = w;
	}

	/**
	 * Add edge to the unweighted graph
	 * @param i index of an edge
	 * @param u source node
	 * @param v destination node
	 */
	public void addEdge(int i, int u, int v) {
		this.edgePairs[i].u = u;
        this.edgePairs[i].v = v;
	}
	/**
	 * Gets the total number of nodes in a graph
	 * @return nodes
	 */
	public int getNodes() {
		return nodes;
	}

	/**
	 * Sets the total number of vertexes in a graph
	 * @param nodes the total number of nodes in a graph 
	 */
	public void setNodes(int nodes) {
		this.nodes = nodes;
	}

	/**
	 * Gets the total number of edges in a graph
	 * @return totalEdge the total number of edges in a graph
	 */
	public int getEdges() {
		return edges;
	}

	/**
	 * Sets the total number of edges in a graph
	 * @param edge the total number of edges
	 */
	public void setEdges(int edge) {
		this.edges = edge;
	} 
	
	/**
	 * Gets the (u,v) pairs of edges in a graph
	 * @return (u,v) pairs of edges
	 */
	public Edge[] getEdgePairs() {
		return edgePairs;
	}

	
	/**
	 * Initialize edge pairs (u,v) in a graph
	 * @param edge 
	 */
	public void setEdgePairs(int edge) {
		edgePairs = new Edge[edge];
		for (int i = 0; i < edge; ++i){
			edgePairs[i] = new Edge();
			edgePairs[i].w = Integer.MIN_VALUE;
			edgePairs[i].state = State.NODE_UNVISITED;
		}
	}

	/**
	 * @return the visited
	 */
	public boolean[] getVisitedNodes() {
		return visitedNodes;
	}
	
	
	/** Gets an adjacency list of a given graph
	 * @return adjacencyList
	 */
	public Map<Integer, LinkedList<Integer>> getAdjacencyList() {
		return adjacencyList;
	}

	@Override
	public String toString() {
		return String.format("Graph [adjacencyList=%s]", adjacencyList);
	}

	


	
}
