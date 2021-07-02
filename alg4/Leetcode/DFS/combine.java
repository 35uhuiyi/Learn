package alg4.Leetcode.DFS;

import java.util.*;

/**
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 * @author yang
 * @version 1.0
 * @date 2021/4/23 21:06
 */
public class combine {

    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> func(int n, int k) {
        boolean[] v = new boolean[n];
        dfs(n,k,new ArrayList<>(),1);
        return res;
    }
    void dfs(int n,int k,List<Integer> path, int begin){
        if(path.size()==k){
            ArrayList<Integer> list = new ArrayList<>(path);
            res.add(list);
        }
        for (int i = begin; i <= n; i++) {
            path.add(i);
            dfs(n,k,path,i+1);
            path.remove(path.size()-1);
        }
    }

    public static void main(String[] args) {
        combine combine = new combine();
        List<List<Integer>> func = combine.func(4, 2);
        for (List<Integer> integers : func) {
            for (Integer integer : integers) {
                System.out.print(integer+" ");
            }
            System.out.println();
        }
    }

}
