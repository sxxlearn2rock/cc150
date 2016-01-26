package cn.cococode.cc150;

import java.util.ArrayList;
import java.util.Stack;

public class TwoStacks {

	public ArrayList<Integer> twoStacksSort(int[] numbers) {
		if (numbers == null) {
			return null;
		}

		Stack<Integer> s1 = new Stack<>();
		Stack<Integer> s2 = new Stack<>();
		for (int i = numbers.length - 1; i >= 0; --i) {
			s1.push(numbers[i]);
		}

		for (int i = 0; i < numbers.length; ++i) {
			int val = s1.pop();
			int count = 0;
			if (s2.isEmpty()) {
				s2.push(val);
				continue;
			}
			while (!s2.isEmpty() && val > s2.peek()){
				s1.push(s2.pop());
				++count;
			}
			s2.push(val);
			while (count > 0){
				s2.push(s1.pop());
				--count;
			}
		}

		ArrayList<Integer> retArr = new ArrayList<>();
		while (! s2.isEmpty()){
			retArr.add(s2.pop());
		}
		return retArr;
	}
}
