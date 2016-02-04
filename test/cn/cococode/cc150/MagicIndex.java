package cn.cococode.cc150;

public class MagicIndex {
    public boolean findMagicIndex(int[] A, int n) {
    	if (A == null || n < 0) {
			return false;
		}
    	
    	int left = 0;
    	int right = n - 1;
    	int mid = 0;
    	while (left <= right){
    		mid = (left + right) / 2;
    		if (mid == A[mid]) {
				return true;
			}else if (mid > A[mid]){
				left = mid + 1;
			}else {
				right = mid - 1;
			}
    		
    	}
    	return false;
    }
    
    public boolean findMagicIndexRecc(int[] A, int n, int left, int right){
    	if (left > right) {
			return false;
		}
    	int mid = (left + right) / 2;
    	if (A[mid] == mid) {
			return true;
		}else if (mid > A[mid]){
			if (findMagicIndexRecc(A, n, mid + 1, right)) {
			return true;	
			}
		}else {
			if (findMagicIndexRecc(A, n, left, mid-1)) {
				return true;
			}
			
		}
    	return false;
    }
}
