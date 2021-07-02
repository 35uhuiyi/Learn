package alg4.Leetcode.String.offer;

/**
 * @author yang
 * @version 1.0
 * @date 2021/5/17 21:09
 */
public class isMatch {
    public boolean f(String s, String p) {
        int m = s.length();
        int n = p.length();
        //dp[i][j] 表示s前i个 能否匹配 p前j个
        boolean[][] dp = new boolean[m+1][n+1];
        //初始化：空串空正则是匹配的
        dp[0][0] = true;
        for (int i = 0; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                //动态规划从前向后
                //不是*,
                if(p.charAt(j-1)!='*'){
                    if(matches(s,p,i,j)){
                        dp[i][j] = dp[i-1][j-1];
                    }
                }else{
                    //是*
                    dp[i][j] = dp[i][j-2];
                    if(matches(s,p,i,j-1)){
                        dp[i][j] =  dp[i][j]||dp[i-1][j];
                    }
                }
            }
        }
        return dp[m][n];
    }
    //是否匹配 前i个 和前j个
    private boolean matches(String s, String p, int i,int j){
        //空串一定不能匹配
        if(i==0){
            return false;
        }
        //.匹配任意
        if(p.charAt(j-1)=='.'){
            return true;
        }
        return s.charAt(i-1)==p.charAt(j-1);
    }

    public static void main(String[] args) {
        isMatch isMatch = new isMatch();
        String s = "aa";
        String p = "a*";
        System.out.println(isMatch.f(s,p));
        System.out.println(~2);
    }
}
