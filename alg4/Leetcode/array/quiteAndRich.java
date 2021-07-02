package alg4.Leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;

/*851. 喧闹和富有
        在一组 N 个人（编号为 0, 1, 2, ..., N-1）中，每个人都有不同数目的钱，以及不同程度的安静（quietness）。

        为了方便起见，我们将编号为 x 的人简称为 "person x "。

        如果能够肯定 person x 比 person y 更有钱的话，我们会说 richer[i] = [x, y] 。注意 richer 可能只是有效观察的一个子集。

        另外，如果 person x 的安静程度为 q ，我们会说 quiet[x] = q 。

        现在，返回答案 answer ，其中 answer[x] = y 的前提是，在所有拥有的钱不少于 person x 的人中，person y 是最安静的人（也就是安静值 quiet[y] 最小的人）。

        示例：

        输入：richer = [[1,0],[2,1],[3,1],[3,7],[4,3],[5,3],[6,3]], quiet = [3,2,5,4,6,1,7,0]
        输出：[5,5,2,5,4,5,6,7]
        解释：
        answer[0] = 5，
        person 5 比 person 3 有更多的钱，person 3 比 person 1 有更多的钱，person 1 比 person 0 有更多的钱。
        唯一较为安静（有较低的安静值 quiet[x]）的人是 person 7，
        但是目前还不清楚他是否比 person 0 更有钱。

        answer[7] = 7，
        在所有拥有的钱肯定不少于 person 7 的人中(这可能包括 person 3，4，5，6 以及 7)，
        最安静(有较低安静值 quiet[x])的人是 person 7。

        其他的答案也可以用类似的推理来解释。*/
public class quiteAndRich {
    private  int[] answer;
    private  ArrayList<Integer>[] rich;
    private  int[] quiet;
    private  int[] loudAndRich(int[][] richer, int[] quiet) {
        int N = quiet.length;//真正的人数
        answer = new int[N];
        rich = new ArrayList[N];
        this.quiet = quiet;
        for (int i = 0; i < N; i++) {
            rich[i] = new ArrayList<Integer>();
        }
        Arrays.fill(answer,-1);
        for (int[] ints : richer) {
            rich[ints[1]].add(ints[0]);
        }
        for (int i = 0; i < N; i++) {
            dfs(i);
        }
        return answer;
    }
    private int dfs(int i){
        if(answer[i] ==-1){
            answer[i] = i;//默认为自己
            for (Integer integer : rich[i]) {//遍历搜索
                int x = dfs(integer);
                if(quiet[x]<=quiet[answer[i]]){//quiet表示第x个人的安静数，answer[i]表示比第i个人更安静有钱的人
                    answer[i] = x;
                }
            }
        }
        return answer[i];
    }
    public static void main(String[] args) {
        int[][] richer = {{1,0},{2,1},{3,1},{3,7},{4,3},{5,3},{6,3}};
        int[] quiet = {3,2,5,4,6,1,7,0};
        quiteAndRich quiteAndRich = new quiteAndRich();
        int[] ints = quiteAndRich.loudAndRich(richer, quiet);
        System.out.println(Arrays.toString(ints));
    }
}

