package cn.cococode.cc150;

import java.util.ArrayList;
import java.util.Stack;

public class BitOperation {
	public int binInsert(int n, int m, int j, int i) {
		m <<= j;
		return n | m;
	}

	public String printBin(double num) {
		StringBuilder sb = new StringBuilder(".");
		while (num > 0) {
			if (sb.length() > 32) {
				return "Error";
			}
			num *= 2;
			if (num >= 1) {
				sb.append("1");
				num -= 1;
			} else {
				sb.append("0");
			}

		}

		return sb.toString();
	}

	public int[] getCloseNumber(int x) {
        int[] ret = new int[2];
        
        ArrayList<Integer> arrayList = new ArrayList<>();
       Stack<Integer> stack = new Stack<>();
        
       int xx = x;
        while (xx > 0) {
        	stack.push(xx & 1);
        	xx >>= 1;
        }
        
        while (!stack .isEmpty()){
        	arrayList.add(stack.pop());
        }
        final int SIZE = arrayList.size() - 1;
        boolean findLess = false;
        boolean findMore = false;
        
        if (arrayList.get(arrayList.size() -1 ) == 1) {
            for (int i = arrayList.size() - 2; i >=0 ; --i){
            	if (arrayList.get(i) == 0 && (!findMore)) {
            		findMore = true;
					int more = (x & ~(1 << (SIZE - i - 1)));
					more |= (1 << (SIZE-i));
					ret[1] = more;
				}
            	
            	if (arrayList.get(i) == 1 && findMore) {
					int less = (x & ~(1 << (SIZE - i)));
					less |= (1 << (SIZE - i -1));
					ret[0] = less;
					break;
				}
            	
            }
		}else {
            for (int i = arrayList.size() - 2; i >=0 ; --i){         	
            	if (arrayList.get(i) == 1 && (!findLess)) {
            		findLess = true;
					int less = (x | 1 << (SIZE - i -1));
					less &= ~(1 << (SIZE - i));
					ret[0] = less;					
				}
            	
            	if (arrayList.get(i) == 0 && findLess) {
            		findLess = true;
					int more = (x | (1 << (SIZE - i)));
					more &= ~(1 << (SIZE-i-1));
					ret[1] = more;
					break;
				}
            }
		}
     
        return ret;
    }

    public int calcCost(int A, int B) {
    	int ret = 0;
    	
    	while (A != 0 || B !=0){
    		if ((A & 1) != (B & 1)) {
				++ret;
			} 		
    		
    		 A >>= 1;
    		 B >>= 1;
    	}
    	
    	return ret;
    }


    public int exchangeOddEven(int x) {
    	int ret = x;
    	int temp = x;
    	int count = 0;
    	
    	while (temp != 0){
    		if ((temp & 1) !=  ((temp & 2) >> 1)) {
				if ((temp & 1) == 0) {
					ret |= (1 << count);
					ret &= ~(1 << (count+1));
				}else {
					ret &= ~(1 << count);
					ret |= (1 << (count+1));
				}
			}    		
    		temp >>= 2;
			++count;
			++count;
    	} 	
    	return ret;
    }

    public int findMissing(int[][] numbers, int n) {
    	for ( int i =0; i < n - 1; ++i){
    		if (numbers[i][0] == numbers[i+1][0]) {
				return i + 1;
			}
    	}
    	return n;
    }

    public int[] renderPixel(int[] screen, int x, int y) {
    	int xi = x / 8;
    	int xj = x % 8;
    	int yi = y / 8;
    	int yj = y % 8;
    	
    	if (xi == yi) {
        	for (int k = xj; k <= yj; ++k){
        		screen[xi] |= (1 <<k);
        	}
		}else {
	    	for (int k = 7; k >= xj; --k){
	    		screen[xi] |= (1 <<k);
	    	}
	    	
	    	for (int k = 0; k <= yj; ++k){
	    		screen[yi] |= (1 << k);
	    	}
	    	
	    	for (int k = xi+1; k < yi; ++k){
	    		screen[k] = 1;
	    	}
		}    	    	
       return screen;
    }
}
