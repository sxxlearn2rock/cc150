package cn.cococode.cc150;

import java.util.InputMismatchException;

public class MathBasic {
	public double antsCollision(int n) {
		if (n <= 1) {
			return 0.0;
		}

		return 1 - (power(0.5, n - 1));

	}

	public boolean checkCrossLine(double s1, double s2, double y1, double y2) {
		if (doubleEquals(s1, s2) && doubleEquals(y1, y2)) {
			return true;
		}
		if (!doubleEquals(s1, s2)) {
			return true;
		}

		return false;
	}

	private boolean doubleEquals(double d1, double d2) {
		double res = d1 - d2;
		return (res > -0.0000001 && res < 0.0000001);
	}

    public int calc(int a, int b, int type) {
    	int ret = 0;
    	
    	switch (type) {
		case 1:
			for (int i = 0; i < b; ++i){
				ret += a;
			}
			break;
			
		case 0:
			if (b == 0) {
				break;
			}
			int flag = 0;
			if (a < 0) {
				++flag;
				a = getNegetive(a);
				}
			
			if (b < 0) {
				++flag;
				b = getNegetive(b);
				}
			int res = a - b;
			while (res >= 0){
				res -= b;
				++ret;
			}
			
			if (flag == 1) {
				ret = getNegetive(ret);
			}
			break;
			
		case -1:			
			ret = a + getNegetive(b);
			break;

		default:
			break;
		}
    	
    	return ret;
    }

    public double[] getBipartition(Point[] A, Point[] B) {
        double[] ret = new double[2];
        
        double x1 = getCenter(A)[0];
        double y1 = getCenter(A)[1];       
        double x2 = getCenter(B)[0];
        double y2 = getCenter(B)[1];
        
        ret[0] = (y2 - y1) / (x2 - x1);        
        ret[1] = y1 - x1 * ret[0];

        return ret;
    }
    
    private double[] getCenter(Point[] p){
    	if (p.length != 4) {
			return null;
		}
    	double[] ret = new double[2];
    	double x = 0;
    	double y = 0;
    	for (int i = 0; i < 4; ++i){
    		x += p[i].x;
    		y += p[i].y;
    	}
    	
    	ret[0] = x / 4;
    	ret[1] = y / 4;
    	return ret;
    }

    
    public int findKth(int k) {
    	int ret = 1;
    	if (k <= 0) {
			return -99999999;
		}
    	--k;
    	
    	int a = k / 3;
    	int b = k % 3;
    	
    	ret  = (int) power(3* 5 * 7, a);
    	
		if (b == 1) {
			ret *= 3;
		}else if(b == 2) {
			ret *= 15;
		}
    	
       return ret;
    }
    
    private int getNegetive(int a){
    	if (a == 0) {
			return 0;
		}
    	if (a > 0) {
			return ~(a - 1);
		}
    	return (~a) + 1;
    }
    
	private boolean doubleEquals(double d1, double d2, double tolaretion) {
		double res = d1 - d2;
		if (tolaretion < 0) {
			tolaretion = -tolaretion;
		}
		return (res > -tolaretion && res < tolaretion);
	}

	private double power(double base, int pow) {
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
		} else {
			return power(base, pow >> 1) * power(base, pow >> 1) * base;
		}
	}

}


class Point {
    int x;
    int y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public Point() {
        this.x = 0;
        this.y = 0;
    }
}