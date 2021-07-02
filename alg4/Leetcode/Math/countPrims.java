package alg4.Leetcode.Math;

import java.util.Arrays;

//204. 计数质数
//        统计所有小于非负整数 n 的质数的数量。
//
public class countPrims {
    public int f(int n) {
        int ans = 0;
        for(int i=2;i<n;i++){
            ans += isPrime(i) ? 1:0;
        }
        return ans;
    }

    /**
     * 对每个数从sqrt2开始枚举
     * @param x
     * @return
     */
    private boolean isPrime(int x){
        for(int i=2;i*i<=x;i++){
            if(x%i==0){
                return false;
            }
        }
        return true;
    }


    /**
     * 方法二：埃氏筛
     * 如果 xx 是质数，那么大于 xx 的 xx 的倍数 2x,3x,,… 一定不是质数。
     我们设isPrime[i] 表示数 i 是不是质数，如果是质数则为 1，否则为 0。
     从小到大遍历每个数，如果这个数为质数，则将其所有的倍数都标记为合数（除了该质数本身），即 0，这
     样在运行结束的时候我们即能知道质数的个数。

     按上文说的我们从 2x 开始标记其实是冗余的，
     应该直接从 x⋅x 开始标记，因为 2x,3x,… 这些数一定在 xx 之前就被其他数的倍数标记过了。

     * @param n
     */
    private int _countPrims(int n){
        int[] isPrims = new int[n];
        Arrays.fill(isPrims,1);
        int ans = 0;
        for(int i=2;i<n;i++){//0和1时输出0，2为质数，开始标记
            if(isPrims[i]==1){
                ans += 1;
                if((long)i*i<n){
                    //标记倍数
                    for(int j=i*i;j<n;j+=i){
                        System.out.println(j);
                        isPrims[j] = 0;
                    }
                }
            }
        }
        return ans;
    }





    public static void main(String[] args) {
        countPrims countPrims = new countPrims();
        int f = countPrims._countPrims(10);
        System.out.println(f);
    }

}
