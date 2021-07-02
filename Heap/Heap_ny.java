package Heap;
//堆的实现
public class Heap_ny<T extends Comparable<T> > {
    private T[] items;
    private int N;
    public Heap_ny(int capacity){
        this.items = (T[])new Comparable[capacity+1];//废弃0号索引
        this.N = 0;
    }
    //判断堆中索引处i的元素是否小于j处
    private boolean less(int i,int j){
        return items[i].compareTo(items[j])<0;
    }
    //交换堆中i索引j索引处的值
    private void exch(int i,int j){
        T temp = items[i];
        items[i] = items[j];
        items[j] = temp;
    }
    //往堆中插入一个元素
    public void insert(T t){
        items[++N]=t;//废弃0号元素，先加1
        swim(N);
    }
    //使用上浮算法，使索引k处的元素能在堆中处于正确位置
    private void swim(int k){
        //与其父节点比较，若比其大则交换
        while(k>1){
            if(less(k/2,k)){
                exch(k/2,k);
            }
            k /= 2;//逐层比较
        }
    }
    //删除堆中最大的元素，并返回该元素
    public T delMax(){
        //将最大元素与最大索引元素交换
        T max = items[1];
        exch(1,N);
        items[N]=null;//删除
        N--;
        sink(1);//下沉
        return max;
    }
    //使用下沉算法，使索引k处的元素能在堆中处于正确位置
    private void sink(int k){
        //该元素与其子节点中的较大者进行比较，并交换，逐层进行
        while(2*k<=N){
            //选出子节点中的较大者
            int maxIndex;
            if(2*k+1<=N){//该节点有右子节点
                if(less(2*k,2*k+1)){
                    maxIndex=2*k+1;
                }else {
                    maxIndex =2*k;
                }
            }else {
                maxIndex = 2*k;
            }
            //比较
            if(less(k,maxIndex)){
                exch(k,maxIndex);
            }
            /*if(!less(k,maxIndex)){
                break;//跳出
            }
            //交换
            exch(k,maxIndex);*/
            //逐层进行
            k=maxIndex;
        }
    }
}
