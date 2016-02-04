package cn.cococode.cc150;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Queue;

public class BinaryTree {

	public boolean isBalance(TreeNode root) {
		if (cheakBalance(root)) {
			return true;
		}
		return false;

	}

	private boolean cheakBalance(TreeNode root) {
		if (root == null)
			return true;
		if (Math.abs(calculateHeight(root.left) - calculateHeight(root.right)) > 1) {
			return false;
		}

		if (!cheakBalance(root.left) || !cheakBalance(root.right)) {
			return false;
		}
		return true;
	}

	private int calculateHeight(TreeNode node) {
		if (node == null) {
			return -1; // 注意，空节点的高度为-1
		}
		int lh, rh = 0;

		lh = calculateHeight(node.left);
		rh = calculateHeight(node.right);

		return lh > rh ? lh + 1 : rh + 1;
	}

	private FixedSizeQueue queue = new FixedSizeQueue();

	public int findSucc(TreeNode root, int p) {
		if (root == null) {
			return -1;
		}

		int ret = findSucc(root.left, p);

		if (ret != -1) {
			return ret;
		}

		queue.push(root.val);
		if (queue.peek() == p) {
			return queue.getLast();
		}

		ret = findSucc(root.right, p);

		if (ret != -1) {
			return ret;
		}
		return -1;
	}

	public int getLCA(int a, int b) {
		if (a <= 0 || b <= 0) {
			return 0;
		}
		
		if (a < b) {
			int t = a;
			a = b;
			b = t;
		}
		
		a  >>= (log2(a) - log2(b));


		while (a != b ) {
			a >>= 1;
			b >>= 1;
		}

		return a;
	}
	
    private int log2(int val){
    	if (val <= 0) {
			throw new InputMismatchException();
		}
    	
    	int ret = -1;
    	
    	while (val > 0) {
			val = val >> 1;
			++ret;
		}
    	return ret;
    }
}

class FixedSizeQueue {
	private int size = 2;
	private ArrayDeque<Integer> data = new ArrayDeque<>();

	public void push(Integer i) {
		if (data.size() == size) {
			data.poll();
		}
		data.add(i);
	}

	public Integer poll() {
		return data.poll();
	}

	public Integer peek() {
		return data.getFirst();
	}

	public Integer getLast() {
		return data.getLast();
	}

	private ArrayList<ArrayList<Integer>> array2d = new ArrayList<ArrayList<Integer>>();
	private ArrayList<Integer> array = new ArrayList<>();
	
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
    	findPathRec(root, target, 0);
    	
    	return array2d;
    }
	
    private void findPathRec(TreeNode node, int target, int sum){
    	
    	if (node == null || sum + node.val > target) {
			return ;
		}   	  	
    	array.add(node.val);
    	
    	if (node.left == null && node.right == null ) {
    		if (sum + node.val == target) {
    			ArrayList<Integer> newArr = new ArrayList<>();
    			for (Integer integer : array) {
					newArr.add(integer);
				}
    			array2d.add(newArr);
    			
			}
				array.remove(array.size()-1);
    		
    		return;
		}
    	
    	findPathRec(node.left, target, sum+node.val);
    	findPathRec(node.right, target, sum+node.val);
    	
    	array.remove(array.size()-1);
    	
    	return ;
    }
}

class TreeNode {
	int val = 0;
	TreeNode left = null;
	TreeNode right = null;

	public TreeNode(int val) {
		this.val = val;
	}
}
