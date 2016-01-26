package cn.cococode.cc150;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Stack;

public class CatDogAsylum {
    public ArrayList<Integer> asylum(int[][] ope) {
    	ArrayList<Integer> retArr = new ArrayList<>();
    	Stack<Integer> stack = new Stack<>();
    	ArrayDeque<Integer> queue = new ArrayDeque<>();
    	
    	for (int[] oper : ope) {
			if (oper[0] == 1) {
				queue.add(oper[1]);
			}
			else if(oper[0] == 2){
				if (queue.isEmpty()) {
					continue;
				}
				if (oper[1] == 0) {
					retArr.add(queue.poll());
				}else if(oper[1] < 0){
					
					while (!queue.isEmpty() && queue.peek() > 0){
						stack.push(queue.poll());
					}
					
					if (! queue.isEmpty()) {
						retArr.add(queue.poll());
					}
					while (!stack.isEmpty()){
						queue.addFirst(stack.pop());
					}
					
				}else if(oper[1] > 0){
					
					while (!queue.isEmpty() &&queue.peek() < 0){
						stack.push(queue.poll());
					}
					
					if (! queue.isEmpty()) {
						retArr.add(queue.poll());
					}
					while (!stack.isEmpty()){
						queue.addFirst(stack.pop());
					}					
				}
			}
		}
      	return retArr;
    }
}
