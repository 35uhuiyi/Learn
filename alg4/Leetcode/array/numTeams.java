package alg4.Leetcode.array;
/*1395. 统计作战单位数
        n 名士兵站成一排。每个士兵都有一个 独一无二 的评分 rating 。

        每 3 个士兵可以组成一个作战单位，分组规则如下：

        从队伍中选出下标分别为 i、j、k 的 3 名士兵，他们的评分分别为 rating[i]、rating[j]、rating[k]
        作战单位需满足： rating[i] < rating[j] < rating[k] 或者 rating[i] > rating[j] > rating[k] ，其中  0 <= i < j < k < n
请你返回按上述条件可以组建的作战单位数量。每个士兵都可以是多个作战单位的一部分。



        示例 1：

        输入：rating = [2,5,3,4,1]
        输出：3
        解释：我们可以组建三个作战单位 (2,3,4)、(5,4,1)、(5,3,1) 。
        示例 2：

        输入：rating = [2,1,3]
        输出：0
        解释：根据题目条件，我们无法组建作战单位。
        示例 3：

        输入：rating = [1,2,3,4]
        输出：4

        提示：
        n == rating.length
        1 <= n <= 200
        1 <= rating[i] <= 10^5*/
public class numTeams {
    public int numTeamsf(int[] rating) {
        int ans=0;
        int n = rating.length;
        for (int i = 0; i < n; i++) {
            for(int j=0;j<i;j++){
                for(int k=0;k<j;k++){
                    if((rating[i]<rating[j]&&rating[j]<rating[k])||(rating[i]>rating[j]&&rating[j]>rating[k])) ans++;
                }
            }

        }
        return ans;
    }
    private int f2(int[] rating){
        int ans=0;
        //中间值j从第二个到倒数第二个
        for(int j=1;j<rating.length-1;j++){
            int less_j=0,more_j=0;//左小和左大
            int j_less=0,j_more=0;//右小和右大

            //j左循环
            for(int l=0;l<j;l++){
                if(rating[l]>rating[j]){
                    more_j++;
                }else if(rating[l]<rating[j]){
                    less_j++;
                }
            }

            //j右循环
            for(int r=j+1;r<rating.length;r++){
                if(rating[r]>rating[j]){
                    j_more++;
                }else if(rating[r]<rating[j]){
                    j_less++;
                }
            }
            ans += less_j*j_more+more_j*j_less;
        }
        return ans;
    }


    public static void main(String[] args) {
        int[] rating = {1,2,3,4};
        numTeams numTeams = new numTeams();
        int i = numTeams.f2(rating);
        System.out.println(i);
    }
}
