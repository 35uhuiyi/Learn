package alg4.Leetcode.DP;

public class maxProfit {
    public int f(int[] prices, int fee) {
        int l = prices.length;
        int[][] dp = new int[l][2];
        dp[0][0] = 0;//0和1两种状态，0表示当前手上没有的-最大利润
        dp[0][1] = -prices[0];//1表示当前手上有股票的-最大利润
        for(int i=1;i<l;i++){
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]+prices[i]-fee);
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0]-prices[i]);
        }
        return dp[l-1][0];
    }

    public static void main(String[] args) {
        int[] prices = {1, 2};
        int fee = 0;
        maxProfit maxProfit = new maxProfit();
        System.out.println(maxProfit.f(prices, fee));
    }
}
