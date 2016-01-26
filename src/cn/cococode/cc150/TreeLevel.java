package cn.cococode.cc150;

public class TreeLevel {
	private int steps = 0;
	private ListNode listNode = new ListNode(-99);
	
    public ListNode getTreeLevel(TreeNode root, int dep) {
    	if (root == null || dep < 1) {
			return null;
		}
    	ListNode listHead = listNode;

    	if (dep == 1) {
			listHead.val = root.val;
			return listHead;
		}
    	
    	steps = dep;
    	
    	printTreeLevel(root, 1);

    	listHead = listHead.next;
    	
    	return listHead;
    }
    
    public void printTreeLevel(TreeNode node, int curDep){
    	if (node == null) {
			return;
		}
    	
    	if (steps - 1 == curDep) {
			if (node.left != null) {
				//System.out.print(node.left.val + " ");
				listNode.next = new ListNode(node.left.val);
				listNode = listNode.next;
			}
			if (node.right != null) {
				//System.out.print(node.right.val + " ");
				listNode.next = new ListNode(node.right.val);
				listNode = listNode.next;
			}
			return;
		}
    	
    	printTreeLevel(node.left, curDep+1);
    	printTreeLevel(node.right, curDep+1);   	
    }
}

