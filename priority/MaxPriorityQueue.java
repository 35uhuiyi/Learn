package priority;
//最大优先队列实现
public class MaxPriorityQueue<T extends Comparable<T>> {
    private T[] items;
    private int N;
    public MaxPriorityQueue(int capacity){
        this.items = (T[])new Comparable[capacity+1];
        this.N=0;
    }
    private boolean less(int i,int j){
        return items[i].compareTo(items[j])<0;
    }
    private void exch(int i ,int j){
        T temp = items[i];
        items[i] =items[j];
        items[j] = temp;
    }
    public boolean isEmpty(){
        return N==0;
    }
    public int size(){
        return N;
    }

    public void insert(T t){
        items[++N]=t;
        swim(N);
    }
    //上浮算法
    private void swim(int k){
        while (k>1){
            if(less(k/2,k)){
                exch(k/2,k);
            }
            k /= 2;
        }
    }
    //删除
    public T delMax(){
        T maxItem = items[1];
        exch(1,N);
        //items[N]=null;
        N--;
        sink(1);
        return maxItem;
    }
    //下沉算法
    private void sink(int k){
        while (k*2<=N){
            int max;
            if(k*2+1<=N){
                if(less(k*2,k*2+1)){
                    max=k*2+1;
                }else {
                    max = k*2;
                }
            }else {
                max=k*2;
            }

            if(!less(k,max)){
                break;
            }
            exch(k,max);
            k=max;
        }
    }
}
