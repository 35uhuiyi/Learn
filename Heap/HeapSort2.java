package Heap;

public class HeapSort2 {
    //判断是否小于
    private static boolean less(Comparable[] heap,int i,int j){
        return heap[i].compareTo(heap[j])<0;
    }
    //交换值
    private static void exch(Comparable[] heap,int i,int j){
        Comparable temp=heap[i];
        heap[i]=heap[j];
        heap[j]=temp;
    }
    //对target处的元素下沉，范围是0-range
    private static void sink(Comparable[] heap,int target,int range){
        //还存在子节点
        while (2*target<=range){
            //选出target的较大子节点
            int maxIndex;
            if(2*target+1<=range){//如果还有右子节点
                if(less(heap,2*target,2*target+1)){
                    maxIndex=2*target+1;
                }else {
                    maxIndex=2*target;
                }
            }else {
                maxIndex=2*target;
            }
            //比较target与其子节点大小
            if(!less(heap,target,maxIndex)){
                //如果大跳出循环
                break;
            }
            //交换
            exch(heap,target,maxIndex);
            //继续逐层交换
            target=maxIndex;
        }
    }
    public static void sort(Comparable[] source){
        int N=source.length;
        //有序化堆
        for(int k=N/2;k>=1;k--){
            sink(source,k,N);
        }
        while (N>1){
            exch(source,1,N--);
            sink(source,1,N);
        }
    }
}
