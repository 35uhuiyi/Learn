package alg4.c1.test;

import alg4.c1.c1_3.Dequeue;

public class DequeueTest {
    public static void main(String[] args) {
        Dequeue<Integer> integers = new Dequeue<>();

        integers.pushLeft(3);
        integers.pushLeft(2);
        integers.pushLeft(1);
        integers.pushLeft(0);
        integers.pushRight(4);
        integers.pushRight(5);
        integers.pushRight(6);
        integers.pushRight(7);



        integers.print();
        System.out.println(integers.popRight());
        System.out.println(integers.popRight());
        System.out.println(integers.popRight());
        System.out.println(integers.popRight());
        System.out.println(integers.popLeft());
        System.out.println(integers.popLeft());
        System.out.println(integers.popLeft());
        System.out.println(integers.popLeft());

    }
}
