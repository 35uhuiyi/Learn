package alg4.Leetcode.array;
/*1266. 访问所有点的最小时间
        平面上有 n 个点，点的位置用整数坐标表示 points[i] = [xi, yi]。请你计算访问所有这些点需要的最小时间（以秒为单位）。

        你可以按照下面的规则在平面上移动：

        每一秒沿水平或者竖直方向移动一个单位长度，或者跨过对角线（可以看作在一秒内向水平和竖直方向各移动一个单位长度）。
        必须按照数组中出现的顺序来访问这些点。*/
public class minTimeToVisitAllPoints {
    private int minTimeToVisitAllPointsf(int[][] points) {
        int numPoints = points.length;
        int ans=0;
        for (int i = numPoints-1; i >0; i--) {
            int t = i-1;
            ans += twoPint(points[i], points[t]);
        }
        return ans;
    }
    private int twoPint(int[] a,int[] b){
        int h = Math.abs(b[1]-a[1]);
        int w = Math.abs(b[0]-a[0]);
        return h>=w?h:w;
    }
    public static void main(String[] args) {
        int[][] points = {{1,1},{3,4},{-1,0}};
        minTimeToVisitAllPoints minTimeToVisitAllPoints = new minTimeToVisitAllPoints();
        int i = minTimeToVisitAllPoints.minTimeToVisitAllPointsf(points);
        System.out.println(i);
    }
}
