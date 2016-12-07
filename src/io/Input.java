package io;

import constants.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import algorthims.Graph;

/**
 * Utility class to retrieve data from test data 
 * @author suleyman.yildirim
 * @see Constants
 */
public class Input {
	
	/**
	 * Gets the list of test input via text file testData.txt file. Each line corresponds to a single graph.
	 * 
	 * @return testData
	 */
	public List<String> getTestData() {
		BufferedReader br = null;
		List<String> graphInputs = new ArrayList<String>();
		try {
			String currentGraph;
			br = new BufferedReader(new FileReader(Constants.TEST_DATA));
			while ((currentGraph = br.readLine()) != null) {
				currentGraph = currentGraph.replaceAll("\\s+", ""); // matches one or many whitespaces
				graphInputs.add(currentGraph);
			}
		} catch (IOException e) {
			e.getMessage();
			e.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
			} catch (IOException ex) {
				ex.getMessage();
				ex.printStackTrace();
			}
		}
		return graphInputs;
	}

	/**
	 * Given the test input, gets the total number of edges
	 * 
	 * @param graphInput
	 *            test input
	 * @return total number of edges
	 */

	public int getEdges(String graphInput) {
		return graphInput.split("\\,").length;
	}
	

	/**
	 * Given the test input, gets the total number of nodes
	 * 
	 * @param graphInput
	 *            test input
	 * @return total number of nodes
	 */
	public int getNodes(String graphInput) {
		String[] strArr = graphInput.split("\\,");
		Set<Character> nodes = new HashSet<Character>();
		for (int i = 0; i < strArr.length; i++) {
			nodes.add(strArr[i].charAt(0));
			nodes.add(strArr[i].charAt(1));
		}
		return nodes.size();
	}

	/**
	 * Constructs edges of a graph from test data.
	 * 
	 * @param id
	 * 
	 * @return
	 * @throws NumberFormatException
	 */
	public Graph createGraph(int id) throws NumberFormatException {
		String graphInput = this.getTestData().get(id);
		int V = this.getNodes(graphInput);
		int E = this.getEdges(graphInput);
		Graph graph = new Graph(V, E);
		String[] strArr = graphInput.split("\\,");
		for (int i = 0; i < E; i++) {
			int source = Constants.ALPHABET.indexOf(strArr[i].substring(0, 1)); // u
			int destination = Constants.ALPHABET.indexOf(strArr[i].substring(1, 2)); // v
			int weight = Integer.parseInt(strArr[i].substring(2, 3)); // w
			graph.addEdge(i, source, destination, weight);
		}
		graph.setAdjacencyList();
		return graph;
	}
}
