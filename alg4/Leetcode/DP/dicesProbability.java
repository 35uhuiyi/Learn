package alg4.Leetcode.DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class dicesProbability {
    public double[] f(int n) {
        //n个骰子点总数【n：6n】
        double[][] dp = new double[n + 1][6 * n + 1];//dp[i][j]表示i个骰子总点数为j的概率
        //初始化
        for (int i = 1; i <= 6; i++) {
            dp[1][i] = (double) 1 / 6;
        }
        //动态规划
        for (int i = 2; i <= n; i++) {//n个骰子
            int curMax = 6 * i; //当前个骰子的最大总点数
            for (int j = i; j <= curMax; j++) {//【i,6i】
                for (int k = 1; k <= 6; k++) {//6个面
                    //等于前i-1个的总点数为j-k,然后这一个是k  的概率相乘
                    if (j - k <= 0) {
                        continue;
                    }
                    dp[i][j] += dp[1][k] * dp[i - 1][j - k];
                }
            }
        }
        for (double[] doubles : dp) {
            for (double aDouble : doubles) {
                System.out.print(aDouble + " ");
            }
            System.out.println();
        }


        //【n,6n】之间共有【6n-n+1】个数
        double[] res = new double[5 * n + 1];
        int index = n;//最少的总点数，开头
        for (int i = 0; i < res.length; i++) {
            res[i] = dp[n][index++];
        }
        return res;
    }

    public static void main(String[] args) {
        dicesProbability dicesProbability = new dicesProbability();
        double[] doubles = dicesProbability.f(2);
        System.out.println(Arrays.toString(doubles));


    }
}