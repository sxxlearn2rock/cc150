package cn.cococode.cc150;

public class Robot {
	public int countWays(int x, int y) {
		if (x <= 0 || y <= 0) {
			return 0;
		}

		int[][] arr = new int[x][y];
		arr[0][0] = 0;
		for (int i = 1; i < y; ++i) {
			arr[0][i] = 1;
		}

		for (int i = 1; i < x; ++i) {
			arr[i][0] = 1;
		}

		for (int i = 1; i < x; ++i) {
			for (int j = 1; j < y; ++j) {
				arr[i][j] = arr[i - 1][j] + arr[i][j - 1];
			}
		}

		return arr[x - 1][y - 1];
	}

	public int countWays(int[][] map, int x, int y) {
		if (x <= 0 || y <= 0 || map[0][0] != 1) {
			return 0;
		}

		int[][] arr = new int[x][y];
		for (int i = 0; i < x; ++i) {
			for (int j = 0; j < y; ++j) {
				arr[i][j] = 0;
			}
		}

		for (int i = 1; i < y; ++i) {
			if (map[0][i] == 1){
				arr[0][i] = 1;
			}else {
				break;
			}
				
		}

		for (int i = 1; i < x; ++i) {
			if (map[i][0] == 1) {
				arr[i][0] = 1;
			}
			else {
				break;
			}
			
		}

		for (int i = 1; i < x; ++i) {
			for (int j = 1; j < y; ++j) {
				if (map[i][j] == 1) {
					arr[i][j] = (arr[i - 1][j] + arr[i][j - 1]) % 1000000007;
				}else {
					arr[i][j] = 0;
				}
			}
		}

		return arr[x - 1][y - 1];
	}
}
