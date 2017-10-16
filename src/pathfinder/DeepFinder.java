package pathfinder;

public class DeepFinder {

	public static void main(String[] args) {
		Graph graph = new Graph(9);

		graph.insertEdge(0, 1);
        graph.insertEdge(0, 3);
		graph.insertEdge(1, 2);
		graph.insertEdge(2, 5);
		graph.insertEdge(3, 6);
        graph.insertEdge(6, 7);
        graph.insertEdge(7, 8);
		graph.insertEdge(5, 8);


		graph.weighFinder(0, 7);
	}
}
