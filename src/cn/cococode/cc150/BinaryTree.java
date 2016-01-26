package cn.cococode.cc150;

import java.util.ArrayDeque;
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
	
}

class FixedSizeQueue{
	private int size = 2;
	private ArrayDeque<Integer> data = new ArrayDeque<>();
	
	public void push(Integer i){
		if (data.size() == size) {
			data.poll();
		}
		data.add(i);
	}
	
	public Integer poll(){
		return data.poll();
	}
	
	public Integer peek(){
		return data.getFirst();
	}
	
	public Integer getLast(){
		return data.getLast();
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

