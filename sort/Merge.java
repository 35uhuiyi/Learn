package sort;
//归并排序--O(nlogn)
public class Merge {
    private static Comparable[] assist;
    private static int count;
    public static void sort(Comparable[] a){
        //初始化辅助数组
        assist = new Comparable[a.length];
        int lo = 0;
        int hi = a.length-1;
        //调用sort重载方法
        sort(a,lo,hi);
    }
    private static void sort(Comparable[] a,int lo, int hi){
        //安全校验，递归出口
        if(hi<=lo){
            return;
        }
        //mid中间数
        int mid = lo+(hi-lo)/2;
        sort(a,lo,mid);//左子组-排序归并
        sort(a,mid+1,hi);//右子组-排序归并
        //两组归并
        merge(a,lo,mid,hi);
    }
    private static void merge(Comparable[] a, int lo,int mid,int hi){
        int i=lo;   //当前位置
        int p1=lo;  //从左开始
        int p2=mid+1;
        //遍历，移动p1p2指针，找到小的放到辅助数组中
        while(p1<=mid && p2<=hi){
            if(less(a[p1],a[p2])){
                assist[i++] = a[p1++];

            }else {
                count += (mid-p1+1);
                assist[i++] = a[p2++];
            }
        }
        //遍历，如果p1没走完，顺序移动p1，放入辅助数组
        while(p1<=mid){
            assist[i++]=a[p1++];
        }
        //遍历，如果p2没走完，顺序移动p2，放入辅助数组
        while(p2<=hi){
            assist[i++]=a[p2++];
        }
        //把辅助数组拷贝到原数组
        for (int j = lo; j <= hi; j++) {
            a[j]=assist[j];
        }
    }
    //比较元素是否小于w
    private static boolean less(Comparable v,Comparable w){
        return v.compareTo(w)<0;
    }

    public static int getCount(){
        return count;
    }

}
