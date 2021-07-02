package Heap;

import java.util.Collections;

//堆排序
public class HeapSort<T extends Comparable<T>> {
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
    //根据原数组，构造出堆
    private static void createHeap(Comparable[] source, Comparable[] heap){
        //拷贝原数组到heap
        System.arraycopy(source,0,heap,1,source.length);//废弃堆的0号元素
        //下沉调整--》有序
        for (int i=(heap.length)/2;i>0;i--){
            sink(heap,i,heap.length-1);
        }
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



    //从小到大排序
    public static void sort(Comparable[] source){
        //构建堆
        Comparable[] heap = new Comparable[source.length+1];
        createHeap(source,heap);
        //定义一个变量，记录未排序的元素中最大的索引
        int N = heap.length-1;
        //通过循环，交换1索引处的元素和排序的元素中最大的索引处的元素
        while(N!=1){
            //交换元素
            exch(heap,1,N);
            //排序交换后最大元素所在的索引，让它不要参与堆的下沉调整
            N--;
            //需要对索引1处的元素进行对的下沉调整
            sink(heap,1, N);
        }
        //把heap中的数据复制到原数组source中
        System.arraycopy(heap,1,source,0,source.length);
    }
}
