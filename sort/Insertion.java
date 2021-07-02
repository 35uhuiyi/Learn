package sort;
//插入排序--O(n^2)
public class Insertion {


    public static void sort(Comparable[] a){
        for (int i = 1; i < a.length; i++) {//待排序元素,从第二个开始
            for(int j=i;j>0;j--){//已排序元素，倒序遍历
                if(greater(a[j-1],a[j])){//与前一个比较和交换
                    exch(a,j,j-1);
                }else {
                    break;
                }
            }
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
