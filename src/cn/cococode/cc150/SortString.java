package cn.cococode.cc150;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class SortString {
    public ArrayList<String> sortStrings(String[] str, int n) {
    	ArrayList<String> ret = new ArrayList<>();
    	Map<String, String> map = new HashMap<>();
    	for (String string : str) {
			String countStr = sort(string);
					//getStringCount(string);
			String curStr = map.get(countStr);
			if (curStr == null || (curStr.compareTo(string) > 0)) {
				map.put(countStr, string);
			}
		}
    	
    	
    	for (String string : map.values()) {
			ret.add(string);
		}
    	
    	Collections.sort(ret);
    	
    	return ret;
    }
    
    
   public String sort(String s){
       char[] tmp=s.toCharArray();
       Arrays.sort(tmp);
       return new String(tmp);
   }
    
    public String getStringCount(String str){
    	StringBuilder sb = new StringBuilder();
    	
    	Map<Character, Integer> map = new TreeMap<>();
    	for (Character ch : str.toCharArray()) {
    		Integer times= map.get(ch);
			map.put(ch, times == null ? 1 : ++times);
		}
    	
    	for (Entry<Character, Integer> entry : map.entrySet()){
    		sb.append(entry.getKey()).append(entry.getValue());
    	}
    	
    	return sb.toString();
    }
}
