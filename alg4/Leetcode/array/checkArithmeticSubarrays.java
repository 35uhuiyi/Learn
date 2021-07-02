package alg4.Leetcode.array;
//如果一个数列由至少两个元素组成，且每两个连续元素之间的差值都相同，那么这个序列就是 等差数列 。更正式地，数列 s 是等差数列，只需要满足：对于每个有效的 i ， s[i+1] - s[i] == s[1] - s[0] 都成立。

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class checkArithmeticSubarrays {
    public List<Boolean> f(int[] nums, int[] l, int[] r) {
        List<Boolean> ans = new ArrayList<>();
        for(int i=0;i<l.length;i++){
            int[] t = new int[r[i]-l[i]+1];
            int i1 = 0;
            for(int j=l[i];j<=r[i];j++){
                t[i1++] = nums[j];
            }
            Arrays.sort(t);
            if(t.length<=2){
                ans.add(true);
            }else{
                int m = 2;
                for(int k=1;k<t.length-1;k++){
                    if(t[k+1]-t[k]==t[1]-t[0]){
                        m += 1;
                    }
                }
                if(m==t.length) ans.add(true);
                else ans.add(false);

            }

        }
        return ans;
    }

    public static void main(String[] args) {

        checkArithmeticSubarrays checkArithmeticSubarrays = new checkArithmeticSubarrays();
        int[]  nums = {-12,-9,-3,-12,-6,15,20,-25,-20,-15,-10};
        int[] l = {0,1,6,4,8,7};
        int[] r = {4,4,9,7,9,10};
        List<Boolean> f = checkArithmeticSubarrays.f(nums, l, r);
        for (Boolean aBoolean : f) {
            System.out.println(aBoolean);
        }
    }
}
