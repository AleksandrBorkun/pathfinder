package com.ab.algorythm.trash;

public class FinderIMPL {
/* WORK NEEDED
    private static Graph graph;
    private static int[] resultMatrix;
    private static Vertex[] vertexArray;
    private static int[][] matrix;
    private static int  count;

   // weigh search
    public static void weighFinder(int v, int end, Graph someGraph) {
        insertValues(someGraph);
        System.out.print("start the weigh search: " + vertexArray[v].getLabel() + " -> ");
        vertexArray[v].setVisited(true);
        int vertex = 0;
        resultMatrix[v] = 0;
        Queue<Integer> queue = new ArrayDeque<>(100);
        queue.add(v);
        while (!queue.isEmpty()) {
            if (vertex == end) {
                break;
            }
            int currentVertex = queue.poll();

            while (true) {
                if ((vertex = getUnvisitedVertex(currentVertex)) != -1) {
                    resultMatrix[vertex] = getBiggestNeighbour(vertex) + 1;
                    if (vertex == end) {
                        break;
                    }
                    vertexArray[vertex].setVisited(true);
                    System.out.print(vertexArray[vertex].getLabel() + " -> ");
                    queue.add(vertex);
                } else {
                    break;
                }
            }
        }

        for (int i = 0; i < vertexArray.length && vertexArray[i] != null; i++)
            vertexArray[i].setVisited(false);

        System.out.println("\nresult matrix: ");
        System.out.println(Arrays.toString(resultMatrix));
        System.out.println("restore path from end to start: ");
        getPath(v, end);
    }

    private static void insertValues(Graph some) {
        graph = some;
        vertexArray = graph.getVertexArray();
        matrix = graph.getMatrix();
        count = graph.getCount();
        resultMatrix = graph.getResultMatrix();
    }

    // получение смежной непосещенной вершины
    private static int getUnvisitedVertex(int vertex) {
        for (int i = 0; i < count; i++) {
            if (matrix[vertex][i] == 1 && !vertexArray[i].isVisited()) {
                return i;
            }
        }
        return -1;
    }

    //restore path from result array
    private static void getPath(int start, int end) {
        System.out.print(end + " <- ");
        while (end != start) {
            end = getLowerNeighbour(end);
            System.out.print(end + " <- ");
        }
    }


    private static int getLowerNeighbour(int val) {
        int[] neighbor = graph.getNeighbours(matrix[val]);
        int lowest = resultMatrix[neighbor[0]];
        int index = neighbor[0];
        for (int i = 0; i < neighbor.length - 1; i++) {
            if (neighbor[i + 1] != 0)
                if (resultMatrix[neighbor[i + 1]] < lowest) {
                    lowest = resultMatrix[neighbor[i + 1]];
                    index = neighbor[i + 1];
                }
        }
        return index;
    }

    private static int getBiggestNeighbour(int val) {
        int[] neighbor = graph.getNeighbours(matrix[val]);
        int biggest = resultMatrix[neighbor[0]] == 1000 ? 0 : resultMatrix[neighbor[0]];
        for (int i = 0; i < neighbor.length - 1; i++) {
            if (resultMatrix[neighbor[i + 1]] > biggest && resultMatrix[neighbor[i + 1]] != 1000) {
                biggest = resultMatrix[neighbor[i + 1]];
            }
        }
        return biggest;
    }

        /* deep search *** need improve ***
    public static void deedFinder(int v, Graph someGraph) {
        insertValues(someGraph);
        Stack<Integer> stack = new Stack<>();
        System.out.print("start the deep search: " + vertexArray[v].getLabel() + " -> ");
        vertexArray[v].setVisited(true);
        stack.push(v);
        while (!stack.isEmpty()) {
            int adjVertex = getUnvisitedVertex((int) stack.peek());
            if (adjVertex == -1) {
                stack.pop();
                System.out.println();
            } else {
                vertexArray[adjVertex].setVisited(true);
                System.out.print(vertexArray[adjVertex].getLabel() + " -> ");
                stack.push(adjVertex);
            }
        }

        for (int i = 0; i < vertexArray.length && vertexArray[i] != null; i++)
            vertexArray[i].setVisited(false);
        System.out.println();
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
    }
    */



}


