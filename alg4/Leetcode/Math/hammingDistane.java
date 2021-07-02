package alg4.Leetcode.Math;

import edu.princeton.cs.algs4.In;

/*461. 汉明距离
        两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。

        给出两个整数 x 和 y，计算它们之间的汉明距离。

        注意：
        0 ≤ x, y < 231.

        示例:

        输入: x = 1, y = 4

        输出: 2

        解释:
        1   (0 0 0 1)
        4   (0 1 0 0)
        ↑   ↑

        上面的箭头指出了对应二进制位不同的位置。*/
public class hammingDistane {
    public static void main(String[] args) {
        int x=1;
        int y=4;
        System.out.println(x^y);
        int i = Integer.bitCount(x ^ y);


        int ans=0;
        while (true){
            if(x==0&&y==0){
                break;
            }
            if((x&1)!=(y&1)){
                ans++;
            }
            x >>= 1;
            y >>= 1;
        }

        System.out.println(i);

        System.out.println(ans);
    }
}
