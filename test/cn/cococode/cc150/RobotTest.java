package cn.cococode.cc150;

import static org.junit.Assert.*;

import org.junit.Test;

public class RobotTest {

	@Test
	public void test() {
		Robot robot = new Robot();
		assertEquals(35, robot.countWays(4, 5));
	}

}
