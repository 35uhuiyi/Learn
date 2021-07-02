package alg4.Leetcode.Math;

import java.util.stream.Stream;

/**
 * @author yang
 * @version 1.0
 * @date 2021/5/15 21:27
 */
public class countDigitOne {

    public int f(int n) {
        int res = 0;
        //数字总位数
        String str = String.valueOf(n);
        int len = str.length();
        //从个位开始像上数，累加结果
        for(int i=1;i<=len;i++){
            int high = (int) (n / (Math.pow(10, i)));
            res += high*Math.pow(10,i-1);
            //该位数字
            int x = (int) (n/Math.pow(10,i-1)%10);
            if(x>1){
                res += Math.pow(10,i-1);
            }else if(x==1){
                res += n%Math.pow(10,i-1)+1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
//        countDigitOne countDigitOne = new countDigitOne();
//        System.out.println(countDigitOne.f(12));
    }
}
