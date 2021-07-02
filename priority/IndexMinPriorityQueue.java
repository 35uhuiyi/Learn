package priority;
//索引优先队列实现堆（最小堆实现）
public class IndexMinPriorityQueue<T extends Comparable<T>> {
    private T[] items;
    private int[] pq;//保存items的索引（堆有序时）
    private int[] qp;//pq逆序
    private int N;
    public IndexMinPriorityQueue(int capacity){
        this.items=(T[])new Comparable[capacity+1];
        this.pq = new int[capacity+1];
        this.qp = new int[capacity+1];
        for (int i = 0; i < qp.length; i++) {
            qp[i]=-1;//初始-1代表为空
        }
    }
    //判断堆中索引i处的元素是否小于j处
    private boolean less(int i,int j){
        return items[pq[i]].compareTo(items[pq[j]])<0;
    }
    //获取个数
    public int size(){
        return N;
    }
    //判断队列是否为空
    public boolean isEmpty(){
        return N==0;
    }
    //判断k对应元素是否存在
    public boolean contains(int k){
        return qp[k]!=-1;
    }
    //最小元素关联的索引
    public int minIndex(){
        return pq[1];
    }
    //交换堆中值
    private void exch(int i,int j){
        //实际上交换的时pq中的值
        int temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;
        //pq变化就要更新qp
        qp[pq[i]]=i;
        qp[pq[j]]=j;
    }
    //上浮算法
    private void swim(int k){
        while (k>1){
            if(less(k,k/2)){
                exch(k,k/2);
            }
            k /= 2;
        }
    }
    //下沉算法
    private void sink(int k){
        while (k*2<=N){
            int min;
            if(k*2+1<=N){
                if(less(k*2,k*2+1)){
                    min=k*2;
                }else {
                    min=k*2+1;
                }
            }else {
                min=k*2;
            }
            if(less(k,min)){
                break;
            }
            exch(k,min);
            k=min;
        }
    }
    //删除队列中最小的元素，并返回该元素关联的索引
    public int delMin(){
        //最小的元素即pq[1]
        int minIndex = pq[1];
        //items中删除
        items[minIndex]=null;
        //pq中删除，交换最大索引
        exch(1,N);
        pq[N]=-1;
        //元素减1
        N--;
        //qp中删除
        qp[pq[N]]=-1;
        //堆调整，即pq调整
        //swim(1);
        sink(1);
        return minIndex;
    }
    //删除索引i关联的元素
    //(i与其关联的元素存在pq中，pq中的元素与items中的元素实质上是一个，，而qp与items实际相当）
    public void delete(int i){
        //首先要查查找i在pq中的位置
        int k = qp[i];
        items[k]=null;

        exch(k,N);
        pq[N]=-1;
        qp[pq[N]]=-1;

        N--;
        sink(k);
        swim(k);
    }
    //队列中插入一个元素，并关联i
    public void insert(int i,T t){
        if(contains(i)){
            System.out.println("已有关联元素");
            return;
        }
        N++;
        items[i]=t;
        pq[N]=i;
        qp[i]=N;
        swim(N);
    }
    //把与索引i关联的元素修改为t
    public void changeItem(int i,T t){
        items[i]=t;
        //查找i在pq中索引
        int k = qp[i];
        swim(k);
        sink(k);
    }
    public void printItem(){
        for (int i = 0; i < items.length; i++) {
            System.out.print(items[i]+" ");
        }
    }
    public void printpq(){
        for (int i = 0; i < pq.length; i++) {
            System.out.print(pq[i]+" ");
        }
    }
    public void printqp(){
        for (int i = 0; i < qp.length; i++) {
            System.out.print(qp[i]+" ");
        }
    }
}
