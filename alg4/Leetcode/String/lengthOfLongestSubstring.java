package alg4.Leetcode.String;
//给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
//
//示例 1:
//
//输入: "abcabcbb"
//输出: 3
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
//方法：滑动窗口

import java.util.HashMap;
import java.util.HashSet;

public class lengthOfLongestSubstring {
    public static void main(String[] args) {
        String s = "pwwkew";
        //把每个字符与位置记录
        HashMap<Character, Integer> map = new HashMap<>();
        int left=0;
        int max = 0;
        for(int i=0;i<s.length();i++){
            if(map.containsKey(s.charAt(i))){
                //如果遇到重复字符，更新left为
                left = Math.max(left,map.get(s.charAt(i))+1);
            }
            map.put(s.charAt(i),i);
            max = Math.max(max,i-left+1);
        }
        System.out.println(max);
    }
}
