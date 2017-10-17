package pathfinder;

import java.util.Arrays;

public class DeepFinder {

    /*

        Here we check the path to 15 element from 0 in 25*25 square

        the 0 elements is blocked , so we cant go there

     */

    public static void main(String[] args) {
        Graph graph = new Graph(25);

        graph.generateAdjacency(
                new int[][]{
                        {1, 1, 1, 1, 1},
                        {1, 1, 0, 0, 1},
                        {0, 0, 0, 1, 1},
                        {1, 1, 0, 0, 1},
                        {0, 1, 1, 1, 1}
                });


       // run weigh search
        FinderIMPL.weighFinder(0, 15, graph);
    }
}
