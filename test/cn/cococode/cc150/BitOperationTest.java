package cn.cococode.cc150;

import static org.junit.Assert.*;

import org.junit.Test;

public class BitOperationTest {

	@Test
	public void test() {
		BitOperation bitOperation = new BitOperation();
		
		assertEquals(1100, bitOperation.binInsert(1024, 19, 2, 6));
		
//		assertEquals(".101", bitOperation.printBin(0.625));
//		assertEquals("Error", bitOperation.printBin(0.6251111111111111111111111111111111111111111111111111111111111111));
//		
//		assertEquals(50, bitOperation.getCloseNumber(49)[1]);
//		assertEquals(41, bitOperation.getCloseNumber(49)[0]);
//		
//		assertEquals(76383, bitOperation.getCloseNumber(76351)[1]);
//		assertEquals(76284, bitOperation.getCloseNumber(76351)[0]);
		
//		assertEquals(4, bitOperation.calcCost(10, 5));
//		assertEquals(5, bitOperation.exchangeOddEven(10));
		assertEquals(43, bitOperation.exchangeOddEven(23));
	}

}
