package sort;
//基数排序，桶排序
public class RadixSort {
    private static void sort(int[] arr){
        //找到待排序元素中最大数
        int max = arr[0];
        for (int i : arr) {
            if(i>max) max=i;
        }
        //计算最大数字的位数（即需要排序的轮次）
        //【计算位数技巧】
        int maxd = (max+"").length();
        //定义10个桶(0~9)存放数据，情况最差时，某数位全部相同
        int[][] bucket = new int[10][arr.length];
        //每个桶中已存放数据的个数
        int[] bucketCount = new int[10];
        //遍历每个位，排序
        for (int i = 0, n=1; i < maxd; i++, n*=10) {
            //对每个数进行排序
            for(int j=0;j<arr.length;j++){
                int digtal = arr[j] / n % 10;//该轮次要排序的位
                //放入对应数字的桶中
                bucket[digtal][bucketCount[digtal]] = arr[j];
                bucketCount[digtal]++;
            }
            //取出每个桶中的数据
            int index=0;
            //遍历存放进数据的每个桶
            for (int i1 = 0; i1 < bucketCount.length; i1++) {
                if(bucketCount[i1]!=0){
                    //遍历这个桶中的数据
                    for (int i2 = 0; i2 < bucketCount[i1]; i2++) {
                        arr[index++] = bucket[i1][i2];
                    }
                }
                //计数置0
                bucketCount[i1]=0;
            }
        }
    }
    public static void main(String[] args) {
        int[] arr = {4,78,597,3,598,583,593,0};
        for (int i : arr) {
            System.out.print(i+" ");
        }
        System.out.println();
        sort(arr);
        for (int i : arr) {
            System.out.print(i+" ");
        }
    }


}
