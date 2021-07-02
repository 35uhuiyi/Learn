package test;

import priority.MinPriorityQueue;

public class MinPriorityQueueTest {
    public static void main(String[] args) {
        //创建优先队列
        MinPriorityQueue<String> queue = new MinPriorityQueue<>(10);

        //往队列中存储元素
        queue.insert("A");
        queue.insert("B");
        queue.insert("C");
        queue.insert("D");
        queue.insert("F");
        queue.insert("G");
        queue.insert("E");

        //通过循环从队列中获取最小的元素
        while(!queue.isEmpty()){
            String max = queue.delMin();
            System.out.print(max+" ");
        }
    }
}
