package pathfinder;

public class DeepFinder {

    /*

        Here we check the path to 8 element fom 1 in 3*3 square

        the 5th element is blocked , so we cant go there

        11111 22222 33333
        11111 22222 33333
        11111 22222 33333

        44444 00000 66666
        44444 00000 66666
        44444 00000 66666

        77777 88888 99999
        77777 88888 99999
        77777 88888 99999

     */

    public static void main(String[] args) {
        Graph graph = new Graph(9);


        // create the matrix of adjacency
        graph.insertEdge(0, 1);
        graph.insertEdge(0, 3);
        graph.insertEdge(1, 2);
        graph.insertEdge(2, 5);
        graph.insertEdge(3, 6);
        graph.insertEdge(6, 7);
        graph.insertEdge(7, 8);
        graph.insertEdge(5, 8);

        //run weith Finder
        FinderIMPL.weighFinder(0, 7, graph);
    }
}
