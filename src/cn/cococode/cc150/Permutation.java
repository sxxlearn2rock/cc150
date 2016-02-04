package cn.cococode.cc150;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Permutation {
	private int mTotalSteps;
	private ArrayList<String> mRet = new ArrayList<>();
	private StringBuilder curStr = new StringBuilder();
	private String sortedStr = "";
	boolean[] availableMap;
	
    public ArrayList<String> getPermutation(String A) {
    	mTotalSteps = A.length();  
    	//��ԭString���ս�������
    	sortedStr = A;

    	availableMap = new boolean[A.length()];
    	//��ʼ���������ַ�����
		for (int i = 0; i < mTotalSteps; ++i){
			availableMap[i] = true;
		}
		
    	dfs(0);
    	
    	Collections.sort(mRet, new CompareCharBackwords());
    	return mRet;
    }

    private void dfs(int step) {
		if (step == mTotalSteps) {
			mRet.add(curStr.toString());
			return;
		}
		
		for (int i = 0; i < mTotalSteps; ++i){
			if (availableMap[i] == true) {
				curStr.append(sortedStr.charAt(i));
				availableMap[i] = false;
				dfs(step+1);
				curStr.deleteCharAt(curStr.length()-1);
				availableMap[i] = true;
			}
		}
	}
}

class CompareCharBackwords implements Comparator<String>{
	@Override
	public int compare(String o1, String o2) {
		return (o2.compareTo(o1));
	}	
}