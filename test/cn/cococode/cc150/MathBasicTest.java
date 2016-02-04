package cn.cococode.cc150;

import static org.junit.Assert.*;

import org.junit.Test;

public class MathBasicTest {

	@Test
	public void test() {
		MathBasic mb = new MathBasic();
		assertEquals(0.75, mb.antsCollision(3), 0.00001);
		
		assertEquals(18, mb.calc(3, 6, 1));
//		assertEquals(4, mb.calc(9, 2, 0));
		assertEquals(-4, mb.calc(-8, 2, 0));
		assertEquals(18, mb.calc(24, 6, -1));
		
//		System.out.println(Integer.toBinaryString(-18));
	}

}
