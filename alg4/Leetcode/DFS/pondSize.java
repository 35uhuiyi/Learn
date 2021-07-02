package alg4.Leetcode.DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*你有一个用于表示一片土地的整数矩阵land，该矩阵中每个点的值代表对应地点的海拔高度。若值为0则表示水域。由垂直、水平或对角连接的水域为池塘。池塘的大小是指相连接的水域的个数。编写一个方法来计算矩阵中所有池塘的大小，返回值需要从小到大排序。

        示例：

        输入：
        [
        [0,2,1,0],
        [0,1,0,1],
        [1,1,0,1],
        [0,1,0,1]
        ]
        输出： [1,2,4]*/
public class pondSize {
    int[][] map = {{-1,-1},{-1,0},{-1,1},{0,1},{0,-1},{1,-1},{1,0},{1,1}};
    public int[] f(int[][] land) {
        int n = land.length;
        int m = land[0].length;
        int size = 0;
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                size = dfs(land, i, j);
                if(size!=0) ans.add(size);
            }
        }
        //list转怕[]
        int[] res = ans.stream().mapToInt(Integer::valueOf).toArray();
        Arrays.sort(res);
        return res;
    }
    private int dfs(int[][] land, int i, int j){
        int num=0;
        if(i<0||j<0||i>=land.length||j>=land[0].length||land[i][j]!=0){
            return num;
        }
        land[i][j] = -1;
        num ++;
        for (int i1 = 0; i1 < map.length; i1++) {
           num += dfs(land, i+map[i1][0], j+map[i1][1]);
        }
//        num += dfs(land,i-1,j+1);
//        num += dfs(land,i-1,j);
//        num += dfs(land,i-1,j-1);
//        num += dfs(land,i,j-1);
//        num += dfs(land,i,j+1);
//        num += dfs(land,i+1,j+1);
//        num += dfs(land,i+1,j);
//        num += dfs(land,i+1,j-1);
        return num;
    }

    public static void main(String[] args) {
        int[][] land = {{0,2,1,0},{0,1,0,1},{1,1,0,1},{0,1,0,1}};
        pondSize pondSize = new pondSize();
        System.out.println(Arrays.toString(pondSize.f(land)));
        StringBuilder sb = new StringBuilder();
        sb.append('c');
    }
}
