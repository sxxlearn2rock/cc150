package cn.cococode.cc150;

public class Box {
	public int getHeight(int[] w, int[] l, int[] h, int n) {
		int[] res = new int[n];
		for (int i = 0; i < n; ++i) {
			res[i] = h[i];
			for (int j = 0; j < i; ++j) {
				if (w[i] == w[j] || l[i] == l[j]) {
					if (h[i] >= h[j])
					{
						res[j] = 0;
					}
					else {
						res[i] = 0;
						break;
					}
				}
			}
			
		}
		int ret = 0;
		for (int i = 0; i < n; ++i) {
			ret += res[i];
		}
		return ret;
	}
}
