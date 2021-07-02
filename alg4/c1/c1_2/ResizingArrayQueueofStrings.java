package alg4.c1.c1_2;

import java.util.Iterator;

public class ResizingArrayQueueofStrings implements Iterable {
    private String[] queue;
    private int N;
    public ResizingArrayQueueofStrings(int n) {
        this.queue = new String[n];
        N = 0;
    }
    public boolean isEmpty(){
        return N==0;
    }
    public int size(){
        return N;
    }
    private void resize(int max){
        //扩充数组为max
        String[] temp = new String[max];
        for (int i = 0; i < N; i++) {
            temp[i]=queue[i];
        }
        queue=temp;
    }
    public void enqueue(String s){
        if(N==queue.length){
            resize(2*queue.length);
        }
        queue[N++]=s;
    }
    public String dequeue(){
        if(N>0&&N==queue.length/4){
            resize(queue.length/2);
        }
        String s = queue[0];
        //向前移动1
        for (int i = 0; i < N-1; i++) {
            queue[i]=queue[i+1];
        }
        queue[N]=null;
        N--;
        return s;
    }
    @Override
    public Iterator iterator() {
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
            return queue[--i];
        }
    }
}
