package alg4.Leetcode.DFS;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author yang
 * @version 1.0
 * @date 2021/4/23 22:02
 */
public class subsets {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> f(int[] nums) {

        dfs(nums, new ArrayList<>(),0);
        return res;
    }
    void dfs(int[] nums, List<Integer> path, int begin){
        if(path.size()<=nums.length){
            res.add(new ArrayList(path));
            for(int i=begin;i<nums.length;i++){

                path.add(nums[i]);

                dfs(nums,path,i+1);

                path.remove(path.size()-1);
            }
        }
    }

    public static void main(String[] args) {
        subsets subsets = new subsets();
        int[] nums = {1,2,3};
        List<List<Integer>> f = subsets.f(nums);
        for (List<Integer> integers : f) {
            String collect = integers.stream().mapToInt(Integer::valueOf).mapToObj(String::valueOf).collect(Collectors.joining(",", "[", "]"));
            System.out.println(collect);
        }
    }

}
