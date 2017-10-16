package pathfinder;

public class DeepFinder {

	public static void main(String[] args) {
		Graph graph = new Graph(9);

		graph.insertEdge(0, 1);
		graph.insertEdge(1, 2);
		graph.insertEdge(2, 5);
		graph.insertEdge(3, 0);
		graph.insertEdge(3, 6);
		graph.insertEdge(5, 2);
		graph.insertEdge(5, 8);
		graph.insertEdge(7, 6);
		graph.insertEdge(8, 7);


		graph.deedFinder(0);

	}
}
