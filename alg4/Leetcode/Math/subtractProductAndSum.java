package alg4.Leetcode.Math;
/*1281. 整数的各位积和之差
        给你一个整数 n，请你帮忙计算并返回该整数「各位数字之积」与「各位数字之和」的差。



        示例 1：

        输入：n = 234
        输出：15
        解释：
        各位数之积 = 2 * 3 * 4 = 24
        各位数之和 = 2 + 3 + 4 = 9
        结果 = 24 - 9 = 15*/
public class subtractProductAndSum {
    public int subtractProductAndSumf(int n) {
        int m=1;
        int a=0;
        while (n>0){
            m*=n%10;
            a+=n%10;
            n/=10;
        }
        return m-a;
    }
    public static void main(String[] args) {
        subtractProductAndSum subtractProductAndSum = new subtractProductAndSum();
        int i = subtractProductAndSum.subtractProductAndSumf(234);
        System.out.println(i);
    }
}
