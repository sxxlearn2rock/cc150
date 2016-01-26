package cn.cococode.cc150;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class LinkedListTest {
	LinkedList ll;
	@Before
	public void setUp(){
		ll = new LinkedList();
	}

	@Test()
	public void test() {
		ListNode head = LinkedList.createRandomList(10);
		LinkedList.printList(head);
		System.out.println();
		
//		assertEquals(0, ll.FindKthToTail(head, 10).val);
//		
//		ListNode three = head.next.next;
//		System.out.println(three.val);
		
//		assertTrue(ll.removeNode(three));
//		ll.printList(head);
		
		ll.printList(ll.partition(head, 50));
	}

}
