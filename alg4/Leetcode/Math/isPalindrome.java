package alg4.Leetcode.Math;
//9.判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
//
//        示例 1:
//
//        输入: 121
//        输出: true
public class isPalindrome {
    public static void main(String[] args) {
        int s = -1;
        if(s<0||s>0&&s%10==0){
            System.out.println("false");
            return;
        }
        //截取后一般的数字
        int rNum = 0;
        while (s>rNum){
            rNum = rNum *10 + s % 10;
            s /= 10;
        }
        if(s==rNum||s==rNum/10){
            System.out.println("true");
        }else {
            System.out.println("false");
        }
    }
}
