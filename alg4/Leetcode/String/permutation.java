package alg4.Leetcode.String;

import java.util.ArrayList;
import java.util.List;

/*面试题 08.07. 无重复字符串的排列组合
        无重复字符串的排列组合。编写一种方法，计算某字符串的所有排列组合，字符串每个字符均不相同。

        示例1:

        输入：S = "qwe"
        输出：["qwe", "qew", "wqe", "weq", "ewq", "eqw"]
        示例2:

        输入：S = "ab"
        输出：["ab", "ba"]
        提示:

        字符都是英文字母。
        字符串长度在[1, 9]之间。*/
public class permutation {
    private boolean[] used;
    private List<String> ans;
    private int len;
    private String[] fun1(String s){
        len = s.length();
        used = new boolean[len];
        ans = new ArrayList<>();
        dfs(s, new StringBuilder(),0);
        //List<String> ans-->String[]
        String[] strings = ans.toArray(new String[0]);
        return strings;
    }

    /**
     *
     * @param s
     * @param sb
     * @param cnt 当前第几个
     */
    private void dfs(String s, StringBuilder sb,int cnt){
        if(len==cnt){
            String string = sb.toString();
            if(!ans.contains(string)) ans.add(string);
            return;
        }
        for (int i = 0; i < len; i++) {
            //还没用过
            if(!used[i]){
                used[i] = true;
                sb.append(s.charAt(i));
                dfs(s,sb,cnt+1);//dfs直到return；
                //然后回退
                used[i] = false;
                sb.deleteCharAt(cnt);
            }
        }
    }



    public static void main(String[] args) {
        String s = "qqe";
        permutation permutation = new permutation();
        String[] permutation1 = permutation.fun1(s);
        for (String s1 : permutation1) {
            System.out.println(s1);
        }
    }





}
