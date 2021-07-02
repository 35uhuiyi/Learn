package alg4.Leetcode.String;

import java.util.Arrays;

/*557. 反转字符串中的单词 III
        给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。



        示例：

        输入："Let's take LeetCode contest"
        输出："s'teL ekat edoCteeL tsetnoc"*/
public class reversewords {
    public static void main(String[] args) {
        String s = "Let's take LeetCode contest";
        String[] split = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < split.length; i++) {
            String word = split[i];
            String ss = swapWord(word);
            sb.append(ss);
            if(i<split.length-1) sb.append(" ");
        }
        System.out.println(sb.toString());
    }
    private static String swapWord(String word){
        char[] swap = new char[word.length()];
        for(int i=word.length()-1;i>=0;i--){
            swap[word.length()-i-1]=word.charAt(i);
        }
        return new String(swap);
    }
}
