package cn.cococode.cc150;

import static org.junit.Assert.*;

import org.junit.Test;

public class QueensTest {

	@Test
	public void test() {
		assertEquals(92, new Queens().nQueens(8));
	}

}
