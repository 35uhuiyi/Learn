package alg4.Leetcode.DFS;

import java.util.*;

/**
 * N皇后问题
 * @author yang
 * @version 1.0
 * @date 2021/4/22 20:12
 */
public class solveNQueens {

    private List<List<String>> res = new ArrayList<>();

    private List<List<String>> func(int n) {
        int[] queens = new int[n];
        Arrays.fill(queens,-1);
        HashSet<Integer> col = new HashSet<>();
        HashSet<Integer> d1 = new HashSet<>();
        HashSet<Integer> d2 = new HashSet<>();
        dfs(n,0,queens,col,d1,d2);
        return res;
    }
    private void dfs(int n, int row, int[] queens, HashSet<Integer> col,HashSet<Integer> d1, HashSet<Integer> d2){
        if(row==n){
            List<String> r = convert(queens, n);
            res.add(r);
            return;
        }
        for (int i = 0; i < n; i++) {
            if(col.contains(i)){
                continue;
            }
            int dd1 = row - i;
            if(d1.contains(dd1)){
                continue;
            }
            int dd2 = row + i;
            if(d2.contains(dd2)){
                continue;
            }
            queens[row] = i;
            col.add(i);
            d1.add(dd1);
            d2.add(dd2);
            dfs(n,row+1,queens,col,d1,d2);
            queens[row] = -1;
            col.remove(i);
            d1.remove(dd1);
            d2.remove(dd2);
        }
    }
    private List<String> convert(int[] queens, int n){
        System.out.println("L: "+Arrays.toString(queens));
        List<String> list = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            char[] chars = new char[n];
            Arrays.fill(chars,'.');
            chars[queens[i]] = 'Q';
            list.add(String.valueOf(chars));
        }
        return list;
    }

    public static void main(String[] args) {
        solveNQueens solveNQueens = new solveNQueens();
        List<List<String>> func = solveNQueens.func(4);
        for (List<String> strings : func) {
            for (String string : strings) {
                System.out.print(string+" ");
            }
            System.out.println();
        }
    }

}
