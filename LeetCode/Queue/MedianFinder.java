package LeetCode.Queue;

import java.util.PriorityQueue;

/**
 * @author yang
 * @version 1.0
 * @date 2021/4/16 21:44
 */
public class MedianFinder {

    PriorityQueue<Integer> minStack;
    PriorityQueue<Integer> maxStack;

    /** initialize your data structure here. */
    public MedianFinder() {
        this.minStack = new PriorityQueue<>();
        this.maxStack = new PriorityQueue<>((o1, o2)->o2-o1);
    }

    public void addNum(int num) {
        minStack.offer(num);
        maxStack.offer(minStack.poll());
        if(minStack.size()<maxStack.size()){
            minStack.offer(maxStack.poll());
        }
    }

    public double findMedian() {
        if(minStack.size()==maxStack.size()){
            return (minStack.peek()+maxStack.peek())/2.0;
        }
        return (double)minStack.peek();
    }

    public void print(){
        System.out.println("minStack:");
        minStack.forEach(integer -> System.out.print(integer+" "));
        System.out.println();
        System.out.println("maxStack:");
        maxStack.forEach(integer -> System.out.print(integer+" "));
    }


    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        medianFinder.addNum(3);
        medianFinder.addNum(4);
        medianFinder.addNum(5);
        medianFinder.addNum(6);
        medianFinder.print();
    }
}
