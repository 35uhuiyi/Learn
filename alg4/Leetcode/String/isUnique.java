package alg4.Leetcode.String;

import java.util.HashMap;
import java.util.HashSet;

/*实现一个算法，确定一个字符串 s 的所有字符是否全都不同。

        示例 1：

        输入: s = "leetcode"
        输出: false
        示例 2：

        输入: s = "abc"
        输出: true
        限制：

        0 <= len(s) <= 100*/
public class isUnique {
    public boolean isUniquef(String astr) {
        int mark =0;
        char[] chars = astr.toCharArray();
        for (char aChar : chars) {
            int num = (1 << (aChar - 'a'));
            if((num&mark)!=0){
                return false;
            }else {
                mark |= num;
            }
        }
        return true;
    }
    public boolean isUniquef2(String astr) {
        HashSet<Character> set = new HashSet<>();
        for(char c : astr.toCharArray()){
            set.add(c);//重复元素不会添加
        }
        return set.size() == astr.length();
    }
    public static void main(String[] args) {
        String s = "letcod";
        isUnique isUnique = new isUnique();
        boolean uniquef = isUnique.isUniquef(s);
        System.out.println(uniquef);
    }



}
