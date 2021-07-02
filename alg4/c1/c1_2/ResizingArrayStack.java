package alg4.c1.c1_2;

import java.util.Iterator;

//用数组实现可变长度栈
public class ResizingArrayStack<Item> implements Iterable<Item> {
    private Item[] item;
    private int N;

    public ResizingArrayStack(int n) {
        this.item = (Item[])new Object[n];
        this.N = 0;
    }
    //栈大小
    public int size(){
        return N;
    }
    //是否为空
    public boolean isEmpty(){
        return N==0;
    }
    //调整数组大小为max
    private void resize(int max){
        Item[] temp = (Item[])new Object[max];
        for (int i = 0; i < N; i++) {
            temp[i]=item[i];
        }
        item = temp;
    }
    //压栈
    public void push(Item t){
        if(N==item.length){
            resize(2*item.length);
        }
        item[N++]=t;
    }
    //弹栈
    public Item pop(){
        Item t = item[--N];
        item[N]=null;//避免对象游离
        if(N>0&&N==item.length/4){
            resize(item.length/2);//缩短一半长度
        }

        return t;
    }


    @Override
    public Iterator<Item> iterator() {
        return new SIterator();
    }
    private class SIterator implements Iterator{

        private int i;
        private SIterator(){
            this.i=N;
        }
        @Override
        public boolean hasNext() {
            return i>0;
        }

        @Override
        public Object next() {
            return item[--i];
        }
    }
}
