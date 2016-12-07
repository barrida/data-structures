package trains;

import java.util.List;
import java.util.Map;

import algorthims.BinaryTree;
import algorthims.BreadthFirstSearch;
import algorthims.Graph;
import algorthims.Node;
import io.Input;

/**
 * The main class that runs the application
 * 
 * @author suleyman.yildirim
 *
 */
public class Application {

	public static void main(String[] args) {
		
//		Iterator<String> it = input.getTestData().iterator();
//		while (it.hasNext()) {
//			try {
//				String graphInput = (String) it.next();
//				Graph graph = createGraph(input, graphInput);
//				Trains search = new Trains(graph);
//				int source = 2;
//				int destination = 3;
//				Application.solution1(search, source, destination);
//				Application.solution2(search, source, destination);
//				Application.solution3(search, new int[] { 2, 0, 3 });
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
		try {
			int source = 2;
			int destination = 3;
			int testDataNumber = 1;
			Input input = new Input();
			Graph graph = input.createGraph(testDataNumber);
			Trains search = new Trains(graph);
			solution1(search, source, destination);
			solution2(search, source, destination);
			solution3(search, new int[] { 2, 0, 3 });
			recursiveBreadthFirstSearch(graph);
			iterativeBreadthFirstSearch(graph);			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param graph
	 */
	public static void recursiveBreadthFirstSearch(Graph graph) {
		System.out.println("---------------recursiveBreadthFirstSearch---------------");
		System.out.println(graph.toString());
		System.out.println();
		for (int i = 0; i < graph.getNodes(); i++) {
			new BreadthFirstSearch(graph).recursive(i);
		}
	}
	
	/**
	 * @param graph
	 */
	public static void iterativeBreadthFirstSearch(Graph graph) {
		System.out.println("---------------iterativeBreadthFirstSearch---------------");
		System.out.println(graph.toString());
		System.out.println();
		for (int i = 0; i < graph.getNodes(); i++) {
			new BreadthFirstSearch(graph).iterative(i);
		}
	}
	

	/**
	 * Compute the distance along a certain route
	 * 
	 * @param trains
	 * @param route
	 */
	private static void solution3(Trains trains, int... route) {
		try {
			Map<Integer, List<Integer>> routes = trains.findRoutes(route[0], route[route.length-1]);
			Map<Integer, Integer> map = trains.computeRoutes(routes);
			trains.printDistance(map,route[0], route[route.length-1]);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * The shortest route between two towns
	 * 
	 * @param trains
	 * @param source
	 * @param destination
	 * @throws Exception
	 */
	private static void solution2(Trains trains, int source, int destination) throws Exception {
		Map<Integer, List<Integer>> routes = trains.findRoutes(source, destination);
		Map<Integer, Integer> map = trains.computeRoutes(routes);
		trains.computeShortestRoute(map, source, destination);
	}

	/**
	 * The number of different routes between two towns
	 * 
	 * @param trains
	 * @param source
	 * @param destination
	 */
	private static void solution1(Trains trains, int source, int destination) {
		trains.findRoutes(source, destination);
		trains.printAllRoutes(source, destination);
	}
}
