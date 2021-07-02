package sort;

import java.util.Arrays;

//希尔排序
//改进版本的插入排序
public class Shell {
    public static void sort(Comparable[] a){
        //确定h
        int h=1;
        while (h<a.length/2){
            h=2*h+1;
        }
        while (h>=1){
            System.out.println(h);
            //排序
            for (int i = h; i < a.length; i++) {//后面的未排序元素
                for (int j = i; j >=h; j-=h) {//前面的已排序元素，j-h
                    if(greater(a[j-h],a[j])){
                        exch(a,j-h,j);
                    }else {
                        break;
                    }
                }

            }
            h /= 2;
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

    public static void main(String[] args) {
        Integer[] arr = {4,6,8,9,1,12,35,253,356,2,21,2,3,0,5,98};
        Shell.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
