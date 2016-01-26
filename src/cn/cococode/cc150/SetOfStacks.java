package cn.cococode.cc150;

import java.util.ArrayList;

public class SetOfStacks {
	private ArrayList<ArrayList<Integer>> mData;
	private int sizeOfStack = 10;
	private int numOfData = 0;

	public SetOfStacks() {
		mData = new ArrayList<ArrayList<Integer>>();
	}

	public void push(Integer val){
		if (numOfData % sizeOfStack == 0) {
			mData.add(new ArrayList<Integer>());
		}
		mData.get(mData.size()-1).add(val);
		++numOfData;
	}
	
	public Integer pop() {
		if (numOfData <= 0) {
			return null;
		}
		
		Integer ret = null;
		
		ArrayList<Integer> arrayList = mData.get(mData.size()-1);
		if (numOfData % sizeOfStack == 1) {
			ret = arrayList.get(0);
			mData.remove(mData.size()-1);
			--numOfData;
			return ret;
		}
		
		ret = arrayList.get(arrayList.size()-1);
		arrayList.remove(arrayList.size()-1);
		--numOfData;
		
		return ret;
	}
	
	public void printStack(){
		for (ArrayList<Integer> arrayList : mData) {
			for (Integer integer : arrayList) {
				System.out.print(integer + "\t");
			}
			System.out.println();
		}
	}	
	
	public ArrayList<ArrayList<Integer>> operate(int[][] ope, int size) {
		sizeOfStack = size;
		
		for (int[] operation : ope) {
			if (operation[0] == 1) {
				push(operation[1]);
			}else if (operation[0] == 2) {
				pop();
			}
		}
		
		return mData;
	}
}
