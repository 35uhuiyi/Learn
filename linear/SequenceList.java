package linear;

import java.util.Iterator;

//顺序表
public class SequenceList<T> implements Iterable {
    //存储元素的数组
    private T[] eles;
    //记录当前顺序表中的元素个数
    private int N;

    //构造方法
    public SequenceList(int capacity){
        //初始化数组
        this.eles = (T[])new Object[capacity];
        this.N=0;
    }

    //将一个线性表置为空表
    public void clear(){
        this.N=0;
    }
    //判断当前线性表是否为空表
    public boolean isEmpty(){
        return N==0;
    }
    //获取线性表的长度
    public int length(){
        return N;
    }

    //获取指定位置的元素
    public T get(int i){
        return eles[i];
    }
    //根据参数newSize，重置eles的大小
    public void resize(int newSize){
       T[] temp = eles;
       eles =  (T[])new Object[newSize];
        for (int i = 0; i < N; i++) {
            eles[i]=temp[i];
        }
    }

    //向线型表中添加元素t,
    public void insert(T t){
        /*if(N==eles.length){
            resize(2*eles.length);//扩容
        }*/
        N++;
        resize(N+1);
        eles[N]=t;
    }
    //在i元素处插入元素t
    public void insert(int i,T t){
        N++;
        resize(N+1);
        for (int j = i+1; j < N+1; j++) {
            eles[j]=eles[j-1];
        }
        eles[i]=t;
    }

    @Override
    public Iterator iterator() {
        return null;
    }

}
