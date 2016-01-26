package cn.cococode.cc150;

import org.junit.Before;
import org.junit.Test;

public class SetOfStacksTest {

	private SetOfStacks stack;
	@Before
	public void setUp(){
		stack = new SetOfStacks();
	}
	
	@Test
	public void test() {
		for (int i = 0; i < 52; ++i){
			stack.push(i);
		}
		
		stack.printStack();
		
		for (int i = 0; i < 30; ++i){
			stack.pop();
		}
		
		System.out.println();
		
		stack.printStack();
	}

}
