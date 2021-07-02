package alg4.c1.test;

import alg4.c1.c1_2.ResizingArrayQueueofStrings;

public class ResizingArrayQueueTest {
    public static void main(String[] args) {
        ResizingArrayQueueofStrings stack = new ResizingArrayQueueofStrings(1);

        stack.enqueue("a");
        stack.enqueue("b");
        stack.enqueue("c");

        System.out.println(stack.size());

        System.out.println(stack.dequeue());
        System.out.println(stack.dequeue());
        System.out.println(stack.dequeue());
        System.out.println(stack.size());


    }
}

