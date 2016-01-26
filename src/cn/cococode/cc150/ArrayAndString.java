package cn.cococode.cc150;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class ArrayAndString {
	// No.1
	public static boolean isUniqueChar(String str) {
		if (str == null) {
			System.out.println("The input string is null!");
			System.exit(0);
		}

		Set<Character> charSet = new HashSet<Character>();
		for (char ch : str.toCharArray()) {
			if (charSet.contains(ch)) {
				return false;
			}
			charSet.add(ch);
		}

		return true;
	}

	// No.1<--->s2
	public static boolean isUniqueChar2(String iniString) {
		long flag1 = 0;
		long flag2 = 0;
		int pos = 0;

		for (char ch : iniString.toCharArray()) {
			if (ch <= 63) {
				pos = 1 << ch;
				if ((flag1 & pos) > 0) {
					return false;
				}
				flag1 |= pos;
			} else {
				pos = 1 << (ch - 63);

				if ((flag2 & pos) > 0) {
					return false;
				}
				flag2 |= pos;
			}

		}
		return true;
	}

	// No.2
	public static String reverseString(String iniString) {
		StringBuilder strBuilder = new StringBuilder();
		int leftPtr = 0;
		int rightPtr = iniString.length() - 1;

		// for (int i = iniString.length()-1; i >=0; --i){
		// strBuilder.append(iniString.charAt(i));
		// }

		while (rightPtr - leftPtr >= 0) {
			strBuilder.insert(leftPtr, iniString.charAt(rightPtr));
			if (rightPtr != leftPtr) {
				strBuilder.insert(leftPtr + 1, iniString.charAt(leftPtr));
			}
			leftPtr++;
			rightPtr--;
		}
		return strBuilder.toString();
	}

	// No.3
	public static boolean permutation(String strA, String strB) {
		if (strA == null || strB == null || strA.length() != strB.length()) {
			return false;
		}

		Map<Character, Integer> mapA = new HashMap<Character, Integer>();
		Map<Character, Integer> mapB = new HashMap<Character, Integer>();
		for (int i = 0; i < strA.length(); ++i) {
			Integer countA = mapA.get(strA.charAt(i));
			mapA.put(strA.charAt(i), countA == null ? 1 : countA + 1);
			Integer countB = mapB.get(strB.charAt(i));
			mapB.put(strB.charAt(i), countB == null ? 1 : countB + 1);
		}

		if (mapA.size() != mapB.size())
			return false;

		Set<Entry<Character, Integer>> entries = mapA.entrySet();

		for (Entry<Character, Integer> entry : entries) {
			Character key = entry.getKey();
			if (!(entry.getValue().equals(mapB.get(key)))) {
				return false;
			}
		}

		return true;
	}

	// No.4
	public static boolean replaceSpace(char[] charArr) {

		return false;
	}

	// No.5
	public String zipString(String iniString) {
		if (iniString.length() <= 1) {
			return iniString;
		}

		StringBuilder sb = new StringBuilder();

		boolean isZipped = false;
		int curPointer = 0;
		int nextPoint = 1;

		while (curPointer < iniString.length()) {
			while (nextPoint < iniString.length() && iniString.charAt(nextPoint) == iniString.charAt(curPointer)) {
				isZipped = true;
				nextPoint++;
			}
			sb.append(iniString.charAt(curPointer)).append(nextPoint - curPointer);
			curPointer = nextPoint++;
		}

		if (!isZipped) {
			return iniString;
		}
		return sb.toString();
	}

	// No.6
	public int[][] transformImage(int[][] mat, int n) {
		int[][] retMat = new int[n][n];
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				retMat[i][j] = mat[n - 1 - j][i];
			}
		}
		return retMat;
	}

	// No.7
	public int[][] clearZero(int[][] mat, int n) {
		int[][] retMat = new int[n][n];

		Set<Integer> iSet = new HashSet<Integer>();
		Set<Integer> jSet = new HashSet<Integer>();
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				if (mat[i][j] == 0) {
					iSet.add(i);
					jSet.add(j);
				}
			}
		}

		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				if (!(iSet.contains(i) || jSet.contains(j))) {
					retMat[i][j] = mat[i][j];
				} else {
					retMat[i][j] = 0;
				}
			}
		}

		return retMat;
	}

	public boolean checkReverseEqual(String s1, String s2) {
		if (s1 == null || s2 == null || s1.length() != s2.length()) 		return false;
		
		for (int i = 0; i < s1.length(); ++i){
			if (s2.charAt(i) == s1.charAt(0)) {
				String str1x = s1.substring(0, s1.length() - i);
				String str1y = s1.substring(s1.length()-i);
				String str2x = s2.substring(0, i);
				String str2y = s2.substring(i);
				
				if (str1x.equals(str2y) && str1y.equals(str2x)) {
					return true;
				}
			}
		}
		
		return false;
	}
}
