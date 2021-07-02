package LeetCode.DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author yang
 * @version 1.0
 * @date 2021/4/24 21:01
 */
public class getPermutation {
    int[] fac;
    int k;
    int n;
    public String f(int n, int k) {
        boolean[] v= new boolean[n];
        factorial(n);
        this.n=n;
        this.k=k;
        StringBuilder sb = new StringBuilder();
        dfs(0,sb,v);
        return sb.toString();
    }
    void dfs(int depth,StringBuilder path,boolean[] v){
        if(n==depth){
            return;
        }
        int cnt = fac[n-1-depth];
        for (int i = 1; i <= n; i++) {
            if(v[i-1]){
                continue;
            }
            if(cnt<k){
                k -= cnt;
                continue;
            }
            path.append(i);
            v[i-1] = true;
            dfs(depth+1,path,v);
            return;
        }

    }
    void factorial(int n){
        fac = new int[n+1];
        fac[0] = 1;
        for (int i = 1; i <= n; i++) {
            fac[i] = i*fac[i-1];
        }
    }
    public static void main(String[] args) {
        getPermutation getPermutation = new getPermutation();
        System.out.println(getPermutation.f(3,3));
    }
}
