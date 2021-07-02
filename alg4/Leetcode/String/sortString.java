package alg4.Leetcode.String;

import java.util.Arrays;

/*1370. 上升下降字符串
        给你一个字符串 s ，请你根据下面的算法重新构造字符串：

        从 s 中选出 最小 的字符，将它 接在 结果字符串的后面。
        从 s 剩余字符中选出 最小 的字符，且该字符比上一个添加的字符大，将它 接在 结果字符串后面。
        重复步骤 2 ，直到你没法从 s 中选择字符。
        从 s 中选出 最大 的字符，将它 接在 结果字符串的后面。
        从 s 剩余字符中选出 最大 的字符，且该字符比上一个添加的字符小，将它 接在 结果字符串后面。
        重复步骤 5 ，直到你没法从 s 中选择字符。
        重复步骤 1 到 6 ，直到 s 中所有字符都已经被选过。
        在任何一步中，如果最小或者最大字符不止一个 ，你可以选择其中任意一个，并将其添加到结果字符串。

        请你返回将 s 中字符重新排序后的 结果字符串 。



        示例 1：

        输入：s = "aaaabbbbcccc"
        输出："abccbaabccba"
        解释：第一轮的步骤 1，2，3 后，结果字符串为 result = "abc"
        第一轮的步骤 4，5，6 后，结果字符串为 result = "abccba"
        第一轮结束，现在 s = "aabbcc" ，我们再次回到步骤 1
        第二轮的步骤 1，2，3 后，结果字符串为 result = "abccbaabc"
        第二轮的步骤 4，5，6 后，结果字符串为 result = "abccbaabccba"*/
public class sortString {
    public static void main(String[] args) {
        String s = "aaaabbbbcccc";
        int[] bucket = new int[26];
    /*    char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int j = chars[i] - 'a';
            bucket[j]++;
        }*/
        for (int i = 0; i < s.length(); i++) {
            bucket[s.charAt(i)-'a']++;
        }
        StringBuilder sb = new StringBuilder();
        while (sb.length()<s.length()) {
            for (int i = 0; i < 26; i++) {
                if (bucket[i] > 0) {
                    bucket[i]--;
                    sb.append((char) (97 + i));
                }
            }
            for (int i = 25; i >= 0; i--) {
                if (bucket[i] > 0) {
                    bucket[i]--;
                    sb.append((char) (97 + i));
                }
            }
        }
        System.out.println(sb.toString());
    }
}
