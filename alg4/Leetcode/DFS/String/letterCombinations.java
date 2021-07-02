package alg4.Leetcode.DFS.String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author yang
 * @version 1.0
 * @date 2021/4/27 21:49
 */
public class letterCombinations {

    private String[] map = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    private List<String> res = new ArrayList<>();
    public List<String> f(String digits) {
        dfs(digits,0,new StringBuilder());
        return res;
    }
    private void dfs(String digits,int depth, StringBuilder sb){
        if(depth==digits.length()){
            res.add(sb.toString());
            return;
        }
        String next = map[digits.charAt(depth)-'0'];
        for (int i = 0; i < next.length(); i++) {
            sb.append(next.charAt(i));
            dfs(digits, depth + 1, sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }


    public static void main(String[] args) {
        letterCombinations letterCombinations = new letterCombinations();
        List<String> f = letterCombinations.f("22");
        for (String s : f) {
            System.out.println(s);
        }
    }
}
