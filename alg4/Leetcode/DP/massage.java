package alg4.Leetcode.DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*17.16. 按摩师
        一个有名的按摩师会收到源源不断的预约请求，每个预约都可以选择接或不接。在每次预约服务之间要有休息时间，
        因此她不能接受相邻的预约。给定一个预约请求序列，替按摩师找到最优的预约集合（总预约时间最长），返回总的分钟数。
        注意：本题相对原题稍作改动
        示例 1：

        输入： [1,2,3,1]
        输出： 4
        解释： 选择 1 号预约和 3 号预约，总时长 = 1 + 3 = 4。*/
public class massage {
    int ff = 0;
    public int f(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        ////////状态变量是接当前x时的最大时长！
        //初始化
        int dp0 = 0; //不接第一个的时长，dp0表示的是上一个不接，dp1表示上一个接了
        int dp1 = nums[0]; //接第一个的时长；
        for(int i=1;i<nums.length;i++){//从第二个开始，每个都有两种选择
            //dp0 表示不接这一个的时长，所有总时长是之前的（接或不接的最大值）
            int t0 = Math.max(dp0,dp1);
            //dp1 表示接这一个的时长，则前一个必不能接
            int t1 = dp0+nums[i];
            dp0 = t0;
            dp1 = t1;
        }
        return Math.max(dp0,dp1);
    }

    public static void main(String[] args) {
        String a = "abd";
        List<String> l = new ArrayList<>();
        l.add(String.valueOf(a.charAt(0)));
        l.add(String.valueOf(a.charAt(1)));
        String[] strings = l.toArray(new String[l.size()]);
        System.out.println(Arrays.toString(strings));


/*        int nums[] = {1,2,3,1};
        massage massage = new massage();
        System.out.println(massage.f(nums));*/
    }
}
