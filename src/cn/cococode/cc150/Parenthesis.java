package cn.cococode.cc150;

import java.util.Stack;

public class Parenthesis {
    public boolean chkParenthesis(String A, int n) {
    	Stack<Integer> stack = new Stack<>();
    	for (Character ch : A.toCharArray()) {
			if (ch == '(') {
				stack.push(1);
			}else if (ch == ')'){
				if (stack.isEmpty()) {
					return false;
				}
				stack.pop();
			}else if (stack.isEmpty()){
				return false;
			}
		}
    	if (!stack.isEmpty()) {
			return false;
		}
    	return true;
    }
}
