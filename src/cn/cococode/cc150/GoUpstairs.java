package cn.cococode.cc150;

import java.util.ArrayList;

public class GoUpstairs {
	private ArrayList<Integer> mList = new ArrayList<>();
	
    public int countWays(int n) {
    	if (n <= 0) {
			return -99999999;
		}
    	mList.add(0);
    	mList.add(1);
    	mList.add(2);
    	mList.add(4);
    	if (n <= 3) {
			return mList.get(n).intValue();
		}
    	
    	int count = 4;
    	while ( count <= n){
    		mList.add((mList.get(count-1)% 1000000007 + 
    				mList.get(count-2)% 1000000007 + 
    				mList.get(count-3)% 1000000007)% 1000000007);
    		count++;
    	}
    	return (mList.get(n) % 1000000007);
    	}
}
