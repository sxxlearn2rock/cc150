package cn.cococode.cc150;

import static org.junit.Assert.*;

import org.junit.Test;

public class CoinsTest {

	@Test
	public void test() {
		Coins coins = new Coins();
		assertEquals(217265490, coins.countWays(11746));
	}

}
