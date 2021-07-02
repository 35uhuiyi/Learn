package sort;

import java.util.Comparator;

//冒泡排序--O(n^2)
public class Bubble {

    public static void sort(Comparable[] a){
        for (int i = a.length-1; i >0; i--) {//一共要进行n轮次，从后向前
            for(int j=0;j<i;j++){//逐个比较，从前向后
                if(greater(a[j],a[j+1])) {
                    exch(a, j, j + 1);
                }
            }
        }
    }
    //比较元素是否大于w
    public static boolean greater(Comparable v,Comparable w){
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
