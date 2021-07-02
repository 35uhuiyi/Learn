package alg4.Leetcode.Math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*1282. 用户分组
        难度
        中等
        35

        有 n 位用户参加活动，他们的 ID 从 0 到 n - 1，每位用户都 恰好 属于某一用户组。给你一个长度为 n 的数组 groupSizes，其中包含每位用户所处的用户组的大小，请你返回用户分组情况（存在的用户组以及每个组中用户的 ID）。

        你可以任何顺序返回解决方案，ID 的顺序也不受限制。此外，题目给出的数据保证至少存在一种解决方案。

         

        示例 1：

        输入：groupSizes = [3,3,3,3,3,1,3]
        输出：[[5],[0,1,2],[3,4,6]]
        解释：
        其他可能的解决方案有 [[2,1,6],[5],[0,4,3]] 和 [[5],[0,6,2],[4,3,1]]。
        示例 2：

        输入：groupSizes = [2,1,3,3,3,2]
        输出：[[1],[0,5],[2,3,4]]*/
public class groupThePeople {
    public List<List<Integer>> groupThePeoplef(int[] groupSizes) {
        ArrayList<List<Integer>> lists = new ArrayList<>();
        int length = groupSizes.length;
        int[] bucket = new int[7];
        int index=1;
        for (int i = 0; i < length; i++) {
            System.out.println(bucket[groupSizes[i]]);
            if(bucket[groupSizes[i]]==0||lists.get(bucket[groupSizes[i]]-1).size()==groupSizes[i]){
                lists.add(new ArrayList<Integer>());
                bucket[groupSizes[i]]=index++;
            }
            lists.get(bucket[groupSizes[i]]-1).add(i);
            System.out.println(Arrays.toString(bucket));
        }
        return lists;
    }

    public static void main(String[] args) {
        int[] groupSizes={3,3,3,3,3,1,3};
        groupThePeople groupThePeople = new groupThePeople();
        List<List<Integer>> lists = groupThePeople.groupThePeoplef(groupSizes);
        for (List<Integer> list : lists) {
            for (Integer integer : list) {
                System.out.print(integer+" ");
            }
            System.out.println();
        }
    }
}
