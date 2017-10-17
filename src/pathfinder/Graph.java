package pathfinder;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Graph {


    Queue<Integer> stackOfVertex = new ArrayDeque<>();
    Stack<Integer> stack = new Stack<>();

    // массив для хранения вершин
    private Vertex[] vertexArray;
    // матрица смежности
    private int[][] matrix;

    // массив результатов
    private int[] resultMatrix;

    // текущее количество вершин
    private int count;

    public Graph(int n) {
        char a = 'A';
        vertexArray = new Vertex[n];
        matrix = new int[n][n];
        resultMatrix = new int[n];
        for (int i = 0; i < n; i++) {
            resultMatrix[i] = 1000;
            insertVertex(String.valueOf(a));
            a++;
            for (int j = 0; j < n; j++)
                matrix[i][j] = 1000;
        }
    }

    public void insertVertex(String key) {
        Vertex v = new Vertex(key);
        vertexArray[count++] = v;
    }

    public void insertEdge(int begin, int end) {
        matrix[begin][end] = 1;
        matrix[end][begin] = 1;
    }

    public int[] getNeighbours(int[] arr) {
        int c = 0;
        int[] temp = new int[arr.length];
        for (int i = 0; i < temp.length; i++) {
            if (arr[i] != 1000) {
                temp[c++] = i;
            }
        }
        return temp;
    }


    public Vertex[] getVertexArray() {
        return vertexArray;
    }

    public int[][] getMatrix() {
        return matrix;
    }

    public int getCount() {
        return count;
    }


    public int[] getResultMatrix() {
        return resultMatrix;
    }


    public void generateAdjacency(int[][] visualMap) {
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

//        for (int i = 0; i < matrix.length; i++) {
//            System.out.println(Arrays.toString(matrix[i]));
//        }
    }


}