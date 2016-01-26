package cn.cococode.cc150;

import org.junit.Test;

public class TwoStacksTest {

	@Test
	public void test() {
		TwoStacks stack = new TwoStacks();
		
		int[] arr = { 1, 5, 9 , 15, 24, 12, 34, 8, 17, 2, 1, 5, 6, 19};
		
		System.out.println(stack.twoStacksSort(arr));
	}

}
