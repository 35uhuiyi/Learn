package alg4.Leetcode.Back;

import java.util.ArrayList;
import java.util.List;

public class combine {
    private List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> f(int n, int k) {
        getCombine(n, k, 1, new ArrayList<>());
        return ans;
    }

    public void getCombine(int n, int k, int start, List<Integer> list) {
        if(k == 0) {
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int i = start;i <= n - k + 1;i++) {
            list.add(i);
            getCombine(n, k - 1, i+1, list);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        combine combine = new combine();
        List<List<Integer>> f = combine.f(4, 2);
        for (List<Integer> integers : f) {
            for (Integer integer : integers) {
                System.out.print(integer+" ");
            }
        }
    }


}
