package alg4.Leetcode.DFS;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 减枝
 * @author yang
 * @version 1.0
 * @date 2021/4/22 21:48
 */
public class combinationSum {

    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> f(int[] candidates, int target) {
        dfs(candidates,0,target,new ArrayList<>());
        return res;
    }
    private void dfs(int[] candidates,int begin, int target, List<Integer> list){
        if(target>=0){
            if(0==target){
                res.add(new ArrayList<>(list));
            }
            for (int i = begin; i < candidates.length; i++) {
                list.add(candidates[i]);
                dfs(candidates,i+1,target-candidates[i],list);
                list.remove(list.size()-1);
            }
        }
    }
    public static void main(String[] args) {
        combinationSum combinationSum = new combinationSum();
        int[] nums = {10,1,2,7,6,1,5};
        List<List<Integer>> f = combinationSum.f(nums, 8);
        for (List<Integer> integers : f) {
            for (Integer integer : integers) {
                System.out.print(integer+" ");
            }
            System.out.println();
        }
    }


}
