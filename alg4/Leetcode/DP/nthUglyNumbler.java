package alg4.Leetcode.DP;
/*我们把只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。

        示例:

        输入: n = 10
        输出: 12
        解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。*/

import edu.princeton.cs.algs4.In;

import java.util.ArrayList;
import java.util.Arrays;

public class nthUglyNumbler {
    public int f(int n) {
        int a=0,b=0,c=0;//2，3，5指针，从1开始，加倍后移
        int[] dp = new int[n];  //dp[i]为第i个丑数
        dp[0] = 1;  //第一个丑数
        for (int i = 1; i < n; i++) {
            int n2 = 2*dp[a];
            int n3 = 3*dp[b];
            int n5 = 5*dp[c];
            dp[i] = Math.min(Math.min(n2,n3),n5);
            if(dp[i]==n2) a++;
            if(dp[i]==n3) b++;
            if(dp[i]==n5) c++;
        }
        return dp[n-1];
    }

    public static void main(String[] args) {
        nthUglyNumbler nthUglyNumbler = new nthUglyNumbler();
        System.out.println(nthUglyNumbler.f(10));
        System.out.println("*****************");
    }
}
