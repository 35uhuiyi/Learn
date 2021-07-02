package alg4.Leetcode.Math;

import java.util.Arrays;

//有一个同学在学习分式。他需要将一个连分数化成最简分数，
public class fraction {
    public int[] f(int[] cont) {
        if (cont.length == 1) {
            return new int[]{cont[0], 1};
        }
        int n = cont[cont.length - 1];
        int m = 1;
        for (int i = cont.length - 2; i >= 0; --i) {
            int tmp = n;
            n = cont[i] * n + m; ////计算实际是分子，赋值给分母，以便下一次计算
            System.out.println(n);
            m = tmp;
            System.out.println(m);
        }
        return new int[]{n, m};
    }

    public static void main(String[] args) {
        int nums[] = new int[]{3,2,0,2};
        fraction fraction = new fraction();
        int[] f = fraction.f(nums);
        System.out.println(Arrays.toString(f));
    }
}
