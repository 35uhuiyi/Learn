package sort;
//选择排序--O(n^2)
public class Selection {
    public static void sort(Comparable[] a){
        for (int i = 0; i < a.length-1; i++) {//共n-1轮次
            int minindex = i;//设定每轮最小标，从前向后
            for(int j=i+1;j<a.length;j++){//最小标元素与后面元素对比
                if(greater(a[minindex],a[j])){
                    minindex=j;//交换最小标
                }
            }
            exch(a,i,minindex);//交换
        }
    }
    //比较元素是否大于w
    private static boolean greater(Comparable v,Comparable w){
        return v.compareTo(w)>0;

    }
    //交换ij位置
    private static void exch(Comparable[] a,int i, int j){
        Comparable temp;
        temp=a[i];
        a[i]=a[j];
        a[j]=temp;
    }
}
