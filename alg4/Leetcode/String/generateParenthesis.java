package alg4.Leetcode.String;

import java.util.ArrayList;
import java.util.List;

/*面试题 08.09. 括号
        括号。设计一种算法，打印n对括号的所有合法的（例如，开闭一一对应）组合。

        说明：解集不能包含重复的子集。

        例如，给出 n = 3，生成结果为：

        [
        "((()))",
        "(()())",
        "(())()",
        "()(())",
        "()()()"
        ]*/
public class generateParenthesis {

    List<String> ans;
    public List<String> generateParenthesis(int n) {
        ans = new ArrayList();
        char[] cs = new char[n * 2];
        dfs(cs, 0, n, n);
        return ans;
    }
    public void dfs(char[] cs, int k, int leftCnt, int rightCnt){
        if(leftCnt == 0 && rightCnt == 0){
            ans.add(new String(cs));
            return ;
        }

        if(leftCnt > 0){
            cs[k] = '(';
            dfs(cs, k + 1, leftCnt - 1, rightCnt);
        }

        if(rightCnt > 0 && rightCnt > leftCnt){//右边')'必须有足够的'('匹配
            cs[k] = ')';
            dfs(cs, k + 1, leftCnt, rightCnt - 1);
        }
    }

    public static void main(String[] args) {
        generateParenthesis generateParenthesis = new generateParenthesis();
        List<String> strings = generateParenthesis.generateParenthesis(3);
        System.out.println(strings);
    }




}
