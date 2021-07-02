package alg4.Leetcode.DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author yang
 * @version 1.0
 * @date 2021/4/22 21:39
 */
public class permuteUnique {

    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> f(int[] nums) {
        Arrays.sort(nums);
        ArrayList<Integer> path = new ArrayList<>();
        boolean[] map = new boolean[nums.length];
        dfs(nums, map, 0, path);
        return res;
    }
    void dfs(int[] nums, boolean[] map,int depth, ArrayList<Integer> path){
        if(depth==nums.length){
            res.add(new ArrayList<>(path));
        }
        for(int i=0;i<nums.length;i++){
            if(map[i]){
                continue;
            }
            if(i> 0&& nums[i]==nums[i-1]&& !map[i-1]){
               continue;
            }
            path.add(nums[i]);
            map[i] = true;
            dfs(nums,map,depth+1,path);
            map[i] = false;
            path.remove(path.size()-1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,1,2};
        permuteUnique permuteUnique = new permuteUnique();
        List<List<Integer>> f = permuteUnique.f(nums);
        for (List<Integer> integers : f) {
            for (Integer integer : integers) {
                System.out.print(integer+" ");
            }
            System.out.println("");
        }
    }
}
