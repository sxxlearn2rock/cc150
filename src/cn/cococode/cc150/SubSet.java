package cn.cococode.cc150;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class SubSet {
	ArrayList<ArrayList<Integer>> mRet = new ArrayList<ArrayList<Integer>>();
    public ArrayList<ArrayList<Integer>> getSubsets(int[] A, int n) {
    	

    	Arrays.sort(A);
    	for ( int i = 0; i < n/2; ++i){
    		int j = n-1-i;
    		int temp = A[i];
    		A[i] = A[j];
    		A[j] = temp;
    	}
    	
    	
    	for ( int i = 0; i < n; ++i){
    		getSubset(A, i);
    	}
    	
    	Collections.sort(mRet, new CompareList());
    	
    	return mRet;
    }
    
    private void getSubset(int[] arr, int count){
    	final int size = mRet.size();
    	ArrayList<Integer> soloCount = new ArrayList<>();
    	soloCount.add(arr[count]);
    	mRet.add(soloCount);
    	for (int i = 0; i < size; ++i){
    		ArrayList<Integer> newArr = new ArrayList<>();
    		newArr.addAll(mRet.get(i));
    		newArr.add(arr[count]);
    		mRet.add(newArr);
    	}
    }
   
}

class CompareList implements Comparator<ArrayList<Integer>>{

	@Override
	public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
		int size1= o1.size();
		int size2 = o2.size();
		int minSize = (size1 >= size2 ? size2 : size1);
		for (int i = 0; i < minSize; ++i){
			if (o1.get(i) > o2.get(i)) {
				return -1;
			}else if (o1.get(i) < o2.get(i)){
				return 1;
			}
		}		
		return size2 - size1;
	}
}
