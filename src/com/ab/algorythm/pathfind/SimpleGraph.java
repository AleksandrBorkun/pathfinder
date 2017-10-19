package com.ab.algorythm.pathfind;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SimpleGraph {

    private int [][] matrix;

    public SimpleGraph(int size){
        matrix = new int [size][size];
        for(int arr []:matrix){
            Arrays.fill(arr, Integer.MAX_VALUE);
        }
    }

    public List<Integer> getNeighbors(int id){
    List<Integer> neighborList = new ArrayList<>();
    int count = 0;
        for (int i : matrix [id]){
            if (i != Integer.MAX_VALUE){
                neighborList.add(count);
            }
            count++;
        }
        return neighborList;
    }

    // this method generate adjacency matrix of your graph from double array (from tetris structure to graph(tree))
    // look here for e.p.
    // (RUS) : https://habrahabr.ru/post/65367/
    // (ENG) : http://www.geeksforgeeks.org/graph-and-its-representations/
    public void generateAdjacencyMatrix(int[][] visualMap) {
        int len = visualMap.length;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (i != 0 && visualMap[i - 1][j] != 0 && visualMap[i][j] != 0) {
                    insertEdge(len * (i - 1) + j, len * i + j);
                }
                if(j == len-1)
                    continue;
                if (visualMap[i][j] != 0 && visualMap[i][j + 1] != 0) {
                    insertEdge(len * i + j, len * i + j + 1);
                }
            }
        }
    }

    private void insertEdge(int begin, int end){
        matrix[begin][end] = 1;
        matrix[end][begin] = 1;
    }

}
