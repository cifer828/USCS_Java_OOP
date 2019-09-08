package test;

import java.util.HashMap;
import java.util.Map;

public class Test {
    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Map<Character, Integer> map = new HashMap<>();
        int i = 0, j = 0, result = 0;
        for (j = 0; j < n; j++){
            if(map.containsKey(s.charAt(j)))
                i = map.get(s.charAt(j)) + 1;
            result = Math.max(result, j - i + 1);
            map.put(s.charAt(j), j);
        }
        return result;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double val = 0.012;
		double psum = val + val + val;
		System.out.println("psum is :" + psum);
	}

}