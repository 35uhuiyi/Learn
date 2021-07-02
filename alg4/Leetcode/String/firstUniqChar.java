package alg4.Leetcode.String;

import java.util.LinkedHashMap;
import java.util.Map;

public class firstUniqChar {
    public char firstUniqCharf(String s) {
        LinkedHashMap<Character, Boolean> map = new LinkedHashMap<>();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            map.put(c, !map.containsKey(c));
        }
        for (Map.Entry<Character, Boolean> entry : map.entrySet()) {
            if(entry.getValue())return entry.getKey();
        }
        return ' ';
    }

    public static void main(String[] args) {
       String s = "abaccdeff";
        firstUniqChar firstUniqChar = new firstUniqChar();
        System.out.println(firstUniqChar.firstUniqCharf(s));
    }
}
