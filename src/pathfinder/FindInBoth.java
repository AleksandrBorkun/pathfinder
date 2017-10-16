package pathfinder;

import java.util.Deque;
import java.util.LinkedList;

public class FindInBoth {

	Deque<Integer> turn = new LinkedList<>();
	int [] used = new int [10];
	int [][]mas = {
					{0,0,0,0,0,0,0,0,0,0},
					{0,0,0,0,0,0,0,0,0,0},
					{0,0,0,0,0,0,0,0,0,0},
					{0,0,0,0,0,0,0,0,0,0},
					{0,0,0,0,0,0,0,0,0,0},
					{0,0,0,0,0,0,0,0,0,0},
					{0,0,0,0,0,0,0,0,0,0},
					{0,0,0,0,0,0,0,2,0,0},
					{0,0,0,0,0,0,0,0,0,0},
					{0,0,0,0,0,0,0,0,0,0}
				};
	
	int width = 10;
	int height = 10;

	public void getPath(int x,int y){
	    while (mas[x][y] == 0){
	        System.out.println(x + " " + y);
	        if (x < width - 1 && mas[x + 1][y] == mas[x][y] - 1) {
	            x++;
	            continue;
	        }
	        if (x > 0 && mas[x - 1][y] == mas[x][y] - 1) {
	            x--; 
	            continue;
	        }
	        if (y < height - 1 && mas[x][y+1] == mas[x][y] - 1) {
	            y++;
	            continue;
	        }
	        if (y > 0 && mas[x][y-1] == mas[x][y] - 1) {
	            y--;
	            continue;
	        }
	    }
	    System.out.println(x + " " + y); 
	}
		

}
