package cn.cococode.cc150;

import java.util.ArrayList;
import java.util.Random;

public class LinkedList {
	public static ListNode createList(int n) {
		if (n < 1) {
			return null;
		}
		ListNode head = new ListNode(0);
		ListNode cur = head;
		for (int i = 1; i < n; ++i) {
			ListNode next = new ListNode(i);
			cur.next = next;
			cur = next;
		}

		return head;
	}
	
	public static ListNode createRandomList(int n){
		if (n < 1) {
			return null;
		}
		
		Random random = new Random(47);
		
		ListNode head = new ListNode(0);
		ListNode cur = head;
		for (int i = 1; i < n; ++i) {
			ListNode next = new ListNode(random.nextInt(100));
			cur.next = next;
			cur = next;
		}
		return head;
	}

	public static void printList(ListNode head) {
		ListNode cur = head;
		while (cur != null) {
			System.out.print(cur.val + " ");
			cur = cur.next;
		}
	}

	public ListNode FindKthToTail(ListNode head, int k) {
		if (k < 1)
			return null;
		ListNode left = head;
		ListNode right = head;
		for (int i = 0; i < k; ++i) {
			if (right == null) {
				return null;
			}
			right = right.next;
		}

		while (right != null) {
			left = left.next;
			right = right.next;
		}

		return left;
	}

	public boolean removeNode(ListNode pNode) {
		if (pNode == null || pNode.next == null)
			return false;

		pNode.val = pNode.next.val;
		pNode.next = pNode.next.next;

		return true;
	}

	public ListNode partition(ListNode pHead, int x) {
		if (pHead == null)
			return null;
		
		ListNode small = null;
		ListNode big = null;
		ListNode smallHead = null;
		ListNode bigHead = null;
		
		while (pHead != null) {
			if (pHead.val < x) {
				ListNode r = new ListNode(pHead.val);	
				if (small == null) {
					smallHead = r;
					small = r;
				}
				small.next = r;
				small = small.next;
			}else{
				ListNode l = new ListNode(pHead.val);
				if (big == null) {
					bigHead = l;
					big = l;
				}
				big.next = l;
				big = big.next;
			}
			pHead = pHead.next;
		}
		
		if (smallHead == null ) {
			return bigHead;
		}
		
		if (bigHead == null ) {
			return smallHead;
		}
		
		small.next = bigHead;
		
		return smallHead;
	}

    public ListNode plusAB(ListNode a, ListNode b) {
    	if (a == null) return b;
    	if (b == null) return a;
			
    	ListNode aa = a;
    	ListNode bb = b;
    	ListNode head = null;
    	ListNode cur = null;
		int andone = 0;
		while (aa != null || bb != null) {
			
			int aval = 0;
			int bval = 0;
			
			if (aa != null) {
				aval = aa.val;
				aa = aa.next;
			}
			
			if (bb != null) {
				bval = bb.val;
				bb = bb.next;
			}
			
			int res = aval + bval + andone;
			if (res > 9) {
				res -= 10;
				andone = 1;
			}else {
				andone = 0;
			}
			
			ListNode node = new ListNode(res);
			
			if (head == null) {
				head = node;
				cur = node;
			}else {
				cur.next = node;
				cur = cur.next;
			}
		} 
		
		if (andone == 1) {
			ListNode node = new ListNode(1);
			cur.next = node;
		}
		
    	return head;
    }

    public boolean isPalindrome(ListNode pHead) {
    	if (pHead == null) {
			return false;
		}
    	
    	ListNode curNode = pHead;
    	ArrayList<Integer> array = new ArrayList<>();
    	
    	while (curNode != null) {
			array.add(curNode.val);
			curNode = curNode.next;
		}
    	
    	for ( int i = 0, j = array.size()-1; i < j; ++i, --j ) {
    		if (array.get(i) != array.get(j)) {
				return false;
			}
    	}
    	
    	return true;
    }
}

class ListNode {
	int val;
	ListNode next = null;

	public ListNode(int v) {
		this.val = v;
	}
}