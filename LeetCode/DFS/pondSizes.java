package LeetCode.DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author yang
 * @version 1.0
 * @date 2021/4/1 21:44
 */
public class pondSizes {

    public int[] func(int[][] land) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land[0].length; j++) {
                int dfs = dfs(land, i, j);
                if(dfs!=0) {list.add(dfs);}
            }
        }
        int[] ints = list.stream().mapToInt(Integer::valueOf).toArray();
        Arrays.sort(ints);
        return ints;
    }
    int dfs(int[][] land, int i, int j) {
        List<List<Integer>> arrayLists = new ArrayList<>();
        arrayLists.remove(arrayLists.get(arrayLists.size()-1));

        int sum = 0;
        if (i < 0 || j < 0 || i >= land.length || j >= land[0].length || land[i][j] != 0) {
            return sum;
        }
        sum ++;
        land[i][j] = -1;
        sum += dfs(land, i + 1, j);
        sum += dfs(land, i - 1, j);
        sum += dfs(land, i, j + 1);
        sum += dfs(land, i, j - 1);
        sum += dfs(land, i + 1, j + 1);
        sum += dfs(land, i + 1, j - 1);
        sum += dfs(land, i - 1, j + 1);
        sum += dfs(land, i - 1, j - 1);
        return sum;
    }
    public static void main(String[] args) {
        int[][] ints = {
                {0, 2, 1, 0},
                {0, 1, 0, 1},
                {1, 1, 0, 1},
                {0, 1, 0, 1}};
        pondSizes pondSizes = new pondSizes();
        int[] func = pondSizes.func(ints);
        System.out.println(Arrays.toString(func));
    }
}