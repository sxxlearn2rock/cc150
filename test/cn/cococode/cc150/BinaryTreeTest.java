package cn.cococode.cc150;

import static org.junit.Assert.*;

import org.junit.Test;

public class BinaryTreeTest {

	@Test
	public void test() {
		BinaryTree tree = new BinaryTree();
		
		assertEquals(4,tree.getLCA(17, 19));
		assertEquals(2,tree.getLCA(10, 19));
		assertEquals(1,tree.getLCA(17, 27));
	}

}
