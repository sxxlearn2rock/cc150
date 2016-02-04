package cn.cococode.cc150;

import org.junit.Test;

public class SubSetTest {

	@Test
	public void test() {
		SubSet subSet = new SubSet();
		int[] arr = {3,5,1};
		System.out.println(subSet.getSubsets(arr, arr.length));
		
//		System.out.println();
	}
}


