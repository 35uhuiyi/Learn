package alg4.Leetcode.DFS;
/*给定一个 没有重复 数字的序列，返回其所有可能的全排列。

        示例:

        输入: [1,2,3]
        输出:
        [
        [1,2,3],
        [1,3,2],
        [2,1,3],
        [2,3,1],
        [3,1,2],
        [3,2,1]
        ]*/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

public class permute {
    public List<List<String>> f(int[] nums) {
        List<List<String>> ans = new ArrayList<>();
        int len = nums.length;
        List<String> path = new ArrayList<>();
        boolean[] used = new boolean[len];
        dfs(nums, len, 0, path, used, ans);
        return ans;
    }
    private void dfs(int[] nums, int len, int depth, List<String> path, boolean[] used, List<List<String>> ans){
        if(depth==len){
            ans.add(new ArrayList<>(path));
        }
        for(int i=0;i<len;i++){
            if(!used[i]){
                path.add(nums[i]+"");
                used[i] = true;
                dfs(nums, len, depth+1, path, used, ans);
                used[i] = false;
                path.remove(path.size()-1);
            }
        }
    }


    public static void main(String[] args) {
        int[] nums = {1,2,3};
        permute permute = new permute();
        List<List<String>> f = permute.f(nums);
        for (List<String> integers : f) {
            String str = integers.stream().collect(Collectors.joining());
            System.out.println(str);
        }
    }
}
