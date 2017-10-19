package com.ab.algorythm.pathfind;

public class DeepFinder {

    /*

        Here we check the path to 45th element from 0 in 9*9 square

        the 0 elements is blocked , so we cant go there

     */

    public static void main(String[] args) {
        SimpleGraph graph = new SimpleGraph(91);

        graph.generateAdjacencyMatrix(
                new int[][]{
                        {1, 1, 1, 1, 1, 0, 1, 0, 0},
                        {1, 1, 1, 0, 1, 0, 1, 0, 1},
                        {0, 0, 1, 0, 1, 1, 1, 0, 1},
                        {0, 1, 1, 1, 1, 0, 1, 1, 1},
                        {0, 0, 0, 0, 1, 0, 0, 1, 0},
                        {1, 1, 0, 1, 1, 0, 1, 1, 1},
                        {1, 0, 0, 1, 0, 0, 0, 1, 0},
                        {1, 1, 0, 1, 1, 1, 1, 0, 1},
                        {1, 1, 1, 1, 1, 0, 1, 1, 1}
                });



        WeighPathFinder.findPath(0, 45 , graph).forEach(System.out::println);



    }
}
