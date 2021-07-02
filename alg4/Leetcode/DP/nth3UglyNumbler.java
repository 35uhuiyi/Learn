package alg4.Leetcode.DP;
/*请你帮忙设计一个程序，用来找出第 n 个丑数。

        丑数是可以被 a 或 b 或 c 整除的 正整数。*/
public class nth3UglyNumbler {
    public int f(int n, int a, int b, int c) {
        int ab = lcm(a,b);
        int ac = lcm(a,c);
        int bc = lcm(b,c);
        int lcm = lcm(ab, c);
        int min = Math.min(Math.min(a,b),c);
        int left = min, right = (int)Math.pow(min,n);
        while(left<=right){
            int mid = left + (right-left)/2;
            int count = mid/a + mid/b + mid/c - mid/ab - mid/ac - mid/bc + mid/lcm; //mid之前一共所包含的丑数
            if(count==n){
                left = mid;
                break;
            }else if(count > n){
                right = mid-1;
            }else{
                left = mid +1;
            }
        }
        return (int)(left-Math.min(Math.min(left%a,left%b), left%c));
    }
    //求最大公因数
    private int gcd(int a,int b){
        if(a == 0) return b;
        return gcd(b%a, a);
    }
    //求最小公倍数
    private int lcm(int a, int b){
        return a*b/gcd(a,b);
    }
    public static void main(String[] args) {
        nth3UglyNumbler nth3UglyNumbler = new nth3UglyNumbler();
        System.out.println(nth3UglyNumbler.f(3,2,3,5));
    }
}
