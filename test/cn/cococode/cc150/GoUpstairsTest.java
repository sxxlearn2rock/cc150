package cn.cococode.cc150;

import static org.junit.Assert.*;

import org.junit.Test;

public class GoUpstairsTest {

	@Test
	public void test() {
		GoUpstairs upstairs = new GoUpstairs();
		
//		System.out.println(upstairs.countWays(38));
		
		assertEquals(346087099, upstairs.countWays(36196));
	}

}
