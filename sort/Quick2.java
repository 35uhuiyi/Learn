package sort;
//快速排序
import edu.princeton.cs.algs4.StdRandom;

public class Quick2 {
    public static void sort(Comparable[] a){
        StdRandom.shuffle(a);//可以防止出现最坏情况
        sort(a,0,a.length-1);
    }
    private static void sort(Comparable[] a,int lo,int hi){
        if(hi<=lo){
            return;
        }
        /*   快排改进
        *    少量元素排序，插入最快
        *
        int M = 5;//一般为5~15之间
        if(hi<=lo+M){
            Insertion.sort(a);
        }
        */
        int j=partition(a,lo,hi);
        sort(a,lo,j-1);//左边递归排序
        sort(a,j+1,hi);//右边递归排序
    }
    //寻找切分元素，并且左边都比j小，右边都比j大
    private static int partition(Comparable[] a,int lo,int hi){
        //将数组切为[lo..i-1],[i],[i+1...hi]
        int i=lo,j=hi+1;//左右扫描指针
        Comparable v = a[lo];//将第一个元素确定为切分元素lo，不动
        while (true){
            while (less(a[++i],v)){ //++i从左向右扫描，找到比v大的元素
                if(i==hi) break;
            }
            while (less(v,a[--j])){//--j从右向左扫描，找到比v小的元素
                if(j==lo) break;
            }
            if(i>=j) break;//指针重合时退出---即指针重合位置处向左的元素都比v小，重合位置向右的元素都比v大！
            exch(a,i,j);//交换
        }
        exch(a,lo,j);//把第一个元素即切分元素lo，放到合适的中间位置j处
        return j;
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
