package cn.cococode.cc150;

import java.util.InputMismatchException;

public class MinimalBST {
    public int buildMinimalBST(int[] vals) {
    	if (vals == null) {
			return -1;
		}
    	
    	final int count = vals.length;
    	
    	int ret = log2(count + 1);
    	
    	if (power(2, ret) < count + 1) {
			++ret;
		}
    	
    	return ret;
    }
    
    public int log2(int val){
    	if (val <= 0) {
			throw new InputMismatchException();
		}
    	
    	int ret = -1;
    	
    	while (val > 0) {
			val = val >> 1;
			++ret;
		}
    	return ret;
    }

    public int power(int base, int pow){
    	if (pow < 0) {
			throw new InputMismatchException();
		}
    	
    	if (pow == 0) {
			return 1;
		}
    	if (pow == 1) {
			return base;
		}
    	if ((pow & 1) == 0) {
			return power(base, pow >> 1) * power(base, pow >> 1);
		}else {
			return power(base, pow >> 1) * power(base, pow >> 1) * base;
		}
    }
}
