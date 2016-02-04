package cn.cococode.cc150;

import java.util.Stack;

public class Queens {
	private boolean[][] board;
	private int width = 0;
	private int mCount = 0;
	
    public int nQueens(int n) {
    	width = n;
        board = new boolean[n][n];
        
        for (int i = 0; i < n; ++i){
        	for (int j = 0; j < n; ++j){
        		board[i][j] = true;
        	}
        }
        
        dfs(0);
        
        return mCount;
    }
    
    void dfs(int x){
    	if (x == width) {
			mCount++;
			return;
		}
    	for(int i = 0; i < width; ++i){
    		if (board[x][i]) {
    			 Stack<Point2> s = setBoard(x, i);
				dfs(x+1);
				while (!s.isEmpty()){
					Point2 p = s.pop();
					board[p.x][p.y] = true;
				}
			}
    	}
    }
    
    Stack<Point2> setBoard(int x, int y){
    	Stack<Point2> stack = new Stack<>();
    	for (int i = 1; x +i < width; ++i){
    		if (board[x + i][y]) {
    			board[x + i][y] = false;
    			stack.push(new Point2(x+i, y));
			}   		
    		
    		if (y + i < width && board[x +i][y +i]) {
				board[x +i][y +i] = false;
				stack.push(new Point2(x+i, y+i));
			}
    		if (y - i >= 0 && board[x +i][y - i]) {
				board[x +i][y - i] = false;
				stack.push(new Point2(x+i, y-i));
			}
    	}
    	return stack;
    }
}

class Point2{
	int x;
	int y;
	public Point2(int x, int y) {
		this.x = x;
		this.y = y;		
	}
}
