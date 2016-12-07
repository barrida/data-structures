package trains;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import algorthims.Graph;

/**
 * Class that have functionalities to solve the Problem One: Trains 
 * @author suleyman.yildirim
 * 
 */
public class Trains {
	public int numberOfRoutes;	
	public List<Integer> route;
	public Map<Integer, List<Integer>> routes;	// routes
	public Map<Integer, LinkedList<Integer>> adjacencyList;
	public boolean[] visited;
	Graph graph;
	
	/**
	 * @param graph
	 * @see Graph
	 */
	public Trains(Graph graph) {
		this.numberOfRoutes = 0;
		this.graph = graph;
		this.route = new ArrayList<Integer>();
		this.routes = new HashMap<Integer, List<Integer>>();
		this.visited = graph.getVisitedNodes();
		this.adjacencyList = graph.getAdjacencyList();
	}
	
	/**
	 * Computes all routes from source to destination node. You should call
	 * {@link #findRoutes(int, int)} to use this function
	 * 
	 * @param routes
	 *            the number of different routes between two towns
	 * 
	 * @return map (distance,route)
	 * @see {@link #computeShortestRoute(Map, int, int)}
	 * @throws Exception
	 */
	public Map<Integer, Integer> computeRoutes(Map<Integer, List<Integer>> routes) throws Exception  {
		if (routes.size() == 0){
			throw new Exception("You should first call findRoutes(int, int) to computer shortest route");
		}
		Map<Integer, Integer> map = new HashMap<>();
		for (int route = 0; route < routes.size(); route++) {
			map.put(computeDistance(route), route);
		}
		return map;
	}
	
	/**
	 * Display shortest route from source to destination
	 * @param map
	 * @param source
	 * @param destination
	 * @return 
	 */
	public List<Integer> computeShortestRoute(Map<Integer, Integer> map, int source, int destination ){
		Integer minDistance = Collections.min(map.keySet());
		Integer route = map.get(minDistance);
		System.out.println("The shortest route from " + source + " to " + destination + ": " + routes.get(route).toString());
		System.out.println("------------------------------------------------");
		return routes.get(route);
	}
	
	/**
	 * Display routes with their total weight
	 * @param map
	 * @param source
	 * @param destination
	 */
	public void printDistance(Map<Integer, Integer> map, int source, int destination ){
		System.out.println("The distance of the all routes between " + source + " to " + destination + ": " );
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
		    Integer distance = entry.getKey();
		    Integer currentRoute = entry.getValue();
			System.out.println(routes.get(currentRoute) + "\t--> " + distance + " " );
		}
		System.out.println("------------------------------------------------");
	}
	
	/**
	 * Iterate through the nodes along a route and compute the distance 
	 * @param route index of route. Example: route 0 -> [2, 1, 3])
	 * @return distance
	 */
	public int computeDistance(int route) {
		int distance = 0;
		int i = 0;	
		Iterator<Integer> it = routes.get(route).iterator();
		Integer current;
		Integer next = null;
		while (it.hasNext()) {
			if (i == 0) {
				current = (Integer) it.next();
				next = (Integer) it.next();
			} else {
				current = next;
				next = (Integer) it.next();
			}
			distance += findWeight(current, next);
			i++;
		}
		return distance;
	}

	/**
	 * Finds the cost of travel from current to next node
	 * @param currentNode
	 * @param nextNode
	 * @return weight
	 */
	private int findWeight(int currentNode, int nextNode) {
		int w = 0;
		Graph.Edge edges[] = graph.getEdgePairs();
		for (int i = 0; i < edges.length; i++) {
			if (edges[i].u == currentNode && edges[i].v == nextNode) {
				w = edges[i].w;
				break;
			}
		}
		return w;
	}

	/**
	 * Finds the number of different routes between two towns
	 * @param source source node
	 * @param destination destination node
	 * @return routes (route number, list)
	 */
	public Map<Integer, List<Integer>> findRoutes(int source, int destination){		
		addNodeToRoute(source);
		searchAdjacentNodes(source, destination);
		removeNodeFromRoute(source);
		return routes;
	}

	/**
	 * Marks the current node as not visited and removes from the route
	 * @param source
	 */
	private void removeNodeFromRoute(int source) {
		visited[source] = false;
		route.remove(route.indexOf(source));
	}

	/**
	 * Marks the current node as visited and adds to the route 
	 * @param source
	 */
	private void addNodeToRoute(int source) {
		visited[source] = true;
		route.add(source);
	}
	
	/**
	 * Recursively searches all routes from source to destination. Adjacent nodes of unvisited nodes is searched
	 * from adjacentNode to destination until the destination found. When destination is reached, route is
	 * added to the {@link #routes}
	 * 
	 * @param source
	 * @param destination
	 */
	private void searchAdjacentNodes(int source, int destination) {
		if (source != destination) {
			for (Integer adjacentNode : adjacencyList.get(source)) {
				if (isNotVisited(adjacentNode)) {
					findRoutes(adjacentNode, destination);
				}
			}
		} else {
			routes.put(numberOfRoutes, new ArrayList<Integer>(route));
			numberOfRoutes++;
		}
	}

	/**
	 * Checks if the current node is not visited yet
	 * @param adjacentNode adjacent node among other adjacent nodes
	 * @return visited array of visited nodes
	 */
	private boolean isNotVisited(Integer adjacentNode) {
		return visited[adjacentNode] == false;
	}
	
	/**
	 * Print the contents of the all routes from source to destination
	 */
	public void printAllRoutes(int source, int destination) {
		System.out.println("The number of different routes from " + source +  " to " + destination + ": ");
		for (int route = 0; route < this.numberOfRoutes; route++) {
			for (int node = 0; node < routes.get(route).size(); node++) {
				System.out.print(routes.get(route).get(node) + " ");
			}
			System.out.println();
		}
		System.out.println("------------------------------------------------");
	}


	
	/**
     * Displays array and the sum of the distance
     * @param dist the distance to the respective nodes from the source node
     * @param V total number of nodes
     */
    public void printShortestRoutes(int dist[], int V)
    {
    	int min = Integer.MIN_VALUE;
        System.out.println("Node"+"\t\t"+"Distance from Source");
        for (int i = 0; i < V; ++i){
        	if (i == 0) {
				min = dist[i];
			} else if (dist[i] <= min) {
				min = dist[i];
			}
        	System.out.println(i+"\t\t"+dist[i]);
        }
    }
	
	public int getNumberOfRoutes() {
		return numberOfRoutes;
	}

	public void setNumberOfRoutes(int numberOfRoutes) {
		this.numberOfRoutes = numberOfRoutes;
	}

	public List<Integer> getRoute() {
		return route;
	}

	public void setRoute(List<Integer> route) {
		this.route = route;
	}

	public boolean[] getVisited() {
		return visited;
	}

	public void setVisited(boolean[] visited) {
		this.visited = visited;
	}

	public Graph getGraph() {
		return graph;
	}

	public void setGraph(Graph graph) {
		this.graph = graph;
	}

	public Map<Integer, LinkedList<Integer>> getAdjacencyList() {
		return adjacencyList;
	}

	public void setRoutes(Map<Integer, List<Integer>> routes) {
		this.routes = routes;
	}
	
	public Map<Integer, List<Integer>> getRoutes() {
		return routes;
	}
}
