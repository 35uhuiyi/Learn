package priority;
//与最大堆相反
//首元素最小，父节点《=子节点
public class MinPriorityQueue<T extends Comparable<T>> {
    private T[] items;
    private int N;
    public MinPriorityQueue(int capacity){
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
        //如果子节点小于父节点，交换
        while (k>1){
            if(less(k,k/2)){
                exch(k/2,k);
            }
            k /= 2;
        }
    }
    //删除
    public T delMin(){
        T minItem = items[1];
        exch(1,N);
        //items[N]=null;
        N--;
        sink(1);
        return minItem;
    }
    //下沉算法
    private void sink(int k){
        while (k*2<=N){
            int min;
            if(k*2+1<=N){
                if(less(k*2,k*2+1)){
                    min=k*2;
                }else {
                    min = k*2+1;
                }
            }else {
                min=k*2;
            }

            if(!less(min,k)){
                break;
            }
            exch(k,min);
            k=min;
        }
    }
}
