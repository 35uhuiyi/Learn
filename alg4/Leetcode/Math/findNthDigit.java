package alg4.Leetcode.Math;

/**
 * @author yang
 * @version 1.0
 * @date 2021/4/19 22:30
 */
public class findNthDigit {
    public static int f(int n) {
        if(n<10) return n;
        int digit = 1;
        long start = 1;
        long count = 9;
        //寻找是十位还是百位。。。
        while(n>count){
            n -= count;
            digit += 1;
            start *= 10;
            count = 9*start*digit;
        }
        //寻找十几还是二十几
        long num = start + (n - 1) / digit;
        //寻找具体位
        return Integer.parseInt(String.valueOf(String.valueOf(num).charAt((n - 1) % digit)));
    }

    public static void main(String[] args) {
        int f = f(10000);
        System.out.println(f);
    }
}
