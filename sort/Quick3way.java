package sort;

import edu.princeton.cs.algs4.StdRandom;
//【当元素中有大量的重复元素，分为小于，等于，大于三份】
//3向切分的快速排序
public class Quick3way {
    public static void sort(Comparable[] a){
        StdRandom.shuffle(a);//可以防止出现最坏情况
        sort(a,0,a.length-1);
    }
    private static void sort(Comparable[] a,int lo,int hi){
        if(hi<=lo) return;
        int lt=lo,i=lo+1,gt=hi;//维护3个指针
        //将数组分为三份：【0...lt-1】【lt...gt】【gt+1...hi】
        Comparable v = a[lo];//依旧选用首元素lo比较
        while (i<=gt){//向右扫描
            int cmp = a[i].compareTo(v);
            if(cmp<0){
                //如果右面的元素比v小，则交换，交换完毕后，处理第三个元素，两个指针都向后继续移动
                exch(a,lt++,i++);
            }else if(cmp>0){
                //如果右面的元素本来就比v要大，则把该元素放到末尾(末尾元素与该元素交换，)，让gt指针--，
                // i不用继续向后移动，因为此时i处的元素被交换为原末尾元素
                exch(a,i,gt--);
            }else {
                //重复元素，不处理，继续向右移动
                //lt不动因为只有，cmp<0时lt才移动
                i++;
            }
            sort(a,lo,lt-1);
            sort(a,gt+1,hi);
        }
    }
    //交换ij位置
    private static void exch(Comparable[] a,int i, int j){
        Comparable temp;
        temp=a[i];
        a[i]=a[j];
        a[j]=temp;
    }
    //比较元素是否小于w
    private static boolean less(Comparable v,Comparable w){
        return v.compareTo(w)<0;
    }
}
