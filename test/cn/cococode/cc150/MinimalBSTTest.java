package cn.cococode.cc150;

import static org.junit.Assert.*;

import org.junit.Test;

public class MinimalBSTTest {

	@Test
	public void test() {
		MinimalBST mBst = new MinimalBST();
		
		assertEquals(3, mBst.log2(15));
		
		assertEquals(1024, mBst.power(2, 10));
	}

}
