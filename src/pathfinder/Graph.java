package pathfinder;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Graph {

	
	Queue<Integer> stackOfVertex = new ArrayDeque<>();
	List<int[]> pathes = new ArrayList<>();
	Stack<Integer> stack = new Stack<>();
	// массив для хранения вершин
	private Vertex[] vertexArray;
	// матрица смежности
	private int[][] matrix;
	// текущее количество вершин
	private int count;

	public Graph(int n) {
		char a = 'A';
		vertexArray = new Vertex[n];
		matrix = new int[n][n];
		for (int i = 0; i < n; i++) {
			insertVertex(String.valueOf(a));
			a++;
			for (int j = 0; j < n; j++)
				matrix[i][j] = 0;
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

	// получение смежной непосещенной вершины
	private int getUnvisitedVertex(int vertex) {
		for (int i = 0; i < count; i++) {
			if (matrix[vertex][i] == 1 && !vertexArray[i].isVisited()) {
				return i;
			}
		}
		return -1;
	}

	// реализация обхода в глубину
	public void deedFinder(int v) {
		System.out.print("Выполняем обход в глубину: " + vertexArray[v].getLabel() + " -> ");
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

	// реализация обхода в ширину
	public void weighFinder(int v) {
		System.out.print("Выполняем обход в ширину: " + vertexArray[v].getLabel() + " -> ");
		vertexArray[v].setVisited(true);
		int vertex;
		Queue<Integer> queue = new ArrayDeque<>(100);
		queue.add(v);
		while (!queue.isEmpty()) {
			int currentVertex = queue.poll();
			System.out.println("start from " + currentVertex);
			while ((vertex = getUnvisitedVertex(currentVertex)) != -1) {
				vertexArray[vertex].setVisited(true);
				System.out.print(vertexArray[vertex].getLabel() + " -> ");
				queue.add(vertex);
			}
		}
		for (int i = 0; i < vertexArray.length && vertexArray[i] != null; i++)
			vertexArray[i].setVisited(false);
		System.out.println();
	}

}
