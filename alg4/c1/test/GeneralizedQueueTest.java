package alg4.c1.test;

import alg4.c1.c1_3.GeneralizedQueue;

public class GeneralizedQueueTest {
    public static void main(String[] args) {
        GeneralizedQueue<String> queue = new GeneralizedQueue<>();
        queue.insert("a");
        queue.insert("b");
        queue.insert("c");
        queue.insert("d");
        System.out.println(queue.delete(3));
        System.out.println(queue.size());
    }
}
