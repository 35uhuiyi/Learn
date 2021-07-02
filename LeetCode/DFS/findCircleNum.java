package LeetCode.DFS;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author yang
 * @version 1.0
 * @date 2021/4/6 20:58
 */
public class findCircleNum {

    public int f(int[][] M) {
        int p = M.length;
        boolean[] visted = new boolean[p];
        int circle=0;
        for(int i=0;i<p;i++){
            if(!visted[i]){
                dfs(M,visted,i);
                circle++;
            }
        }
        return circle;
    }
    void dfs(int[][] M, boolean[] visted,int i){
        for(int j=0;j<M.length;j++){
            if(M[i][j]==1&&!visted[j]){
                visted[j] = true;
                dfs(M,visted,j);
            }
        }
    }

    public static void main(String[] args) {
        int[][] M={{1,1,0},{1,1,0},{0,0,1}};
        findCircleNum findCircleNum = new findCircleNum();
        System.out.println(findCircleNum.f(M));
    }
}
