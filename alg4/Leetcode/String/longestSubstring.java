package alg4.Leetcode.String;

import java.util.HashMap;
import java.util.Map;

public class longestSubstring {
    //该函数是寻找s中的最长子字符串
    public int longestSubstringf(String s, int k) {
        if(s.length()<k) return 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0)+1);
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if(entry.getValue()<k){
                //切分
                String[] split = s.split(String.valueOf(entry.getKey()));
                int res = 0;
                for (String s1 : split) {
                    res = Math.max(longestSubstringf(s1, k), res);
                }
                return res;
            }
        }
        return s.length();
    }

    public static void main(String[] args) {
        longestSubstring longestSubstring = new longestSubstring();
        System.out.println(longestSubstring.longestSubstringf("ababbc",2));

        String s = "ababbc";
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0)+1);
        }
        map.forEach((k,v)-> System.out.println(k+"->"+v));




    }



}
