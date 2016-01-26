package cn.cococode.cc150;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ArrayAndStringTest {

	ArrayAndString as;
	
	@Before
	public void setUp(){
		as = new ArrayAndString();
	}
	
	@Test
	public void test() {
		String strA1 = "Hello world";
		String strB1 = "worldhello ";
		assertFalse(as.checkReverseEqual(strA1, strB1));
		
		String strA2 = "waterbottle";
		String strB2 = "erbottlewat";
		assertTrue(as.checkReverseEqual(strA2, strB2));
	}

}
