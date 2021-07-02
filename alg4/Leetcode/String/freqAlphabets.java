package alg4.Leetcode.String;

import java.util.Deque;
import java.util.Queue;

/*1309. 解码字母到整数映射
        给你一个字符串 s，它由数字（'0' - '9'）和 '#' 组成。我们希望按下述规则将 s 映射为一些小写英文字符：

        字符（'a' - 'i'）分别用（'1' - '9'）表示。
        字符（'j' - 'z'）分别用（'10#' - '26#'）表示。
        返回映射之后形成的新字符串。

        题目数据保证映射始终唯一。


        示例 1：

        输入：s = "10#11#12"
        输出："jkab"
        解释："j" -> "10#" , "k" -> "11#" , "a" -> "1" , "b" -> "2".*/
public class freqAlphabets {
    public String freqAlphabetsf(String s) {
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = chars.length-1; i >=0; i--) {
            if(chars[i]=='#'){
                sb.append((char)(chars[--i] - 48 + (chars[--i] - 48) * 10 + 96));
            }else {
                int i1 = chars[i] - 48;//真实的数字
                sb.append((char)(i1+96));
            }
        }
        return sb.reverse().toString();

    }
    public static void main(String[] args) {
        String str = "10#11#12";
        freqAlphabets freqAlphabets = new freqAlphabets();
        String s = freqAlphabets.freqAlphabetsf(str);
        System.out.println(s);
        System.out.println((int)'2');
    }
}
