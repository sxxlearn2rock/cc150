package cn.cococode.cc150;

import java.util.ArrayList;

public class Checker {
	
	private ArrayList<Double> mArray = new ArrayList<>();
	
    public boolean checkBST(TreeNode root) {
    	
    	recordArray(root, 0, false);
    	
    	if (mArray.isEmpty()){
    		return false;
    	}
    	
    	if (mArray.size() == 1) {
			return true;
		}
    	
    	for (int i = 1; i < mArray.size(); ++i){
    		if (mArray.get(i) <= mArray.get(i - 1)) {
				return false;
			}
    	}
    	
    	return true;
    }
    
    private void recordArray(TreeNode node, Integer fatherVal, boolean isLeft){
    	if (node == null) {
			return;
		}
    	
      	recordArray(node.left, node.val, true);	
      	
    	if ( isLeft && node.val == fatherVal.intValue()) {
			mArray.add(node.val - 0.1);
		}else {
	    	mArray.add(node.val + 0.0);
		}
    	
  
    	recordArray(node.right, node.val, false);
    }
}
