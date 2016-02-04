package cn.cococode.cc150;

import java.util.ArrayDeque;
import java.util.Queue;

public class Flood {
	private int[][] mMap;
	private int boardX = 0;
	private int boardY = 0;
	
	Queue<Point2I> queue = new ArrayDeque<>();
	
    public int floodFill(int[][] map, int n, int m) {
    	mMap = map;   	
    	boardX = n;
    	boardY = m;
    	queue.add(new Point2I(0, 0, 0));
    	
    	while (!queue.isEmpty()){
    		Point2I point = queue.poll();
    		bfs(point.x-1, point.y, point.step+1);
    		bfs(point.x, point.y-1, point.step+1);
    		bfs(point.x+1, point.y, point.step+1);
    		bfs(point.x, point.y+1, point.step+1);
    	}
    	    	
    	return mMap[n-1][m-1];
    }
    
    private void bfs(int x, int y, int step){
    	if (x < 0 || y < 0 || x >= boardX || y >= boardY || mMap[x][y] >= 1 ) {
			return;
		}
    	mMap[x][y] = step;
    	queue.add(new Point2I(x, y, step));
    }
}

class Point2I{
	int x;
	int y;
	int step;
	public Point2I(int x, int y, int s) {
		this.x = x;
		this.y = y;
		this.step = s;
	}
}