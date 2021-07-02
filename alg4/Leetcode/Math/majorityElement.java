package alg4.Leetcode.Math;

public class majorityElement {
    public int fun(int[] nums) {
        int ans=0;
        int cnt=0;
        for (int i = 0; i < nums.length; i++) {
            if(cnt==0) ans = nums[i];
            cnt += ans==nums[i]?1:-1;
        }
        return ans;
    }
    public static void main(String[] args) {
        majorityElement majorityElement = new majorityElement();
        int fun = majorityElement.fun(new int[]{6,6,6,7,7,7});
        System.out.println(fun);
    }
}
