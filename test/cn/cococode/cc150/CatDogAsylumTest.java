package cn.cococode.cc150;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class CatDogAsylumTest {

	@Test
	public void test() {
		CatDogAsylum asylum = new CatDogAsylum();
		int[][] arr = {{1,1}, {1,-1}, {2,0}, {2,-1}};
		ArrayList<Integer> arrayList = asylum.asylum(arr);
		System.out.println(arrayList);
	}

}
