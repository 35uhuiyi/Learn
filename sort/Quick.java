package sort;

public class Quick {

    public static void sort(Comparable[] a){
        int lo=0;
        int hi=a.length-1;
        sort(a,lo,hi);
    }
    //重载，对一部分排序
    private static void sort(Comparable[] a,int lo, int hi){
        //安全校验,出口
        if(hi<=lo){
            return;
        }
        //需要对lo-hi索引分组（左子组，右子组）
        int partition = partition(a,lo,hi);//返回的时分组的分界值索引，位置变换后的索引
        //左子组有序
        sort(a,lo,partition-1);
        //右子组有序
        sort(a,partition+1,hi);
    }

    private static int partition(Comparable[] a, int lo ,int hi){
        //确定分界值
        Comparable key = a[lo];
        //定义两个指针
        int left = lo;
        int right = hi+1;
        //切分
        while(true){
            //移动right,找到小的元素
            while (less(key,a[--right])){
                if(right==lo){
                    break;
                }
            }
            //移动left，找到大的元素
            while (less(a[++left],key)){
                if(left==hi){
                    break;
                }
            }
            //判断交换
            if(left>=right){
                break;
            }else {
                exch(a,left,right);
            }
        }
        exch(a,lo,right);
        return right;
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
