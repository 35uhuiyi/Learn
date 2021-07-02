package alg4.Leetcode.DFS.String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author yang
 * @version 1.0
 * @date 2021/4/28 20:46
 */
public class letterCasePermutation {

    List<String> res = new ArrayList<>();

    public List<String> f(String S) {
        char[] chars = S.toCharArray();
        dfs(chars,0);
        return res;
    }

    void dfs(char[] chars, int depth){
        if(depth==chars.length){
            res.add(new String(chars));
            return;
        }
        //是单词，变
        if(Character.isLetter(chars[depth])){
            chars[depth] ^= 1<<5;
            dfs(chars, depth+1);
            chars[depth] ^= 1<<5;
        }
        //不是单词，
        dfs(chars,depth+1);
    }



    public static void main(String[] args) {
        letterCasePermutation lcp = new letterCasePermutation();
        List<String> list = lcp.f("a1b2");
        System.out.println(Arrays.toString(list.toArray()));
    }
}
