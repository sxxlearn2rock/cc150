package cn.cococode.cc150;

public class Joseph {
    public int getResult1(int n, int m) {
    	if (n < 0 || m < 2) {
			return 0;
		}
    	if (n == 1) {
			return 1;
		}
        ListNode head = new ListNode(0);
        ListNode node = head;
        
        for (int i = 1; i <=n; ++i){
        	node.next = new ListNode(i);
        	node = node.next;
        }
        node.next = head.next;
        node = head.next;
        
        while (node.next != node){
        	for (int i = 1; i < m-1; ++i){
        		node = node.next;
        	}
        	node.next = node.next.next;
        	node = node.next;
        }   	
    	return node.val;
    }

    public int getResult(int n) {
    	if (n <= 1) {
			return 1;
		}
        ListNode head = new ListNode(0);
        ListNode node = head;
        
        for (int i = 1; i <=n; ++i){
        	node.next = new ListNode(i);
        	node = node.next;
        }
        node.next = head.next;
        node = head.next;        
        
        return 1;
    }
}


