package test;

import linear.Queue_ny;

public class QueueTest {
    public static void main(String[] args) {
        Queue_ny<String> strings = new Queue_ny<>();
        strings.enqueue("a");
        strings.enqueue("b");
        strings.enqueue("c");
        strings.enqueue("d");
        for (String string : strings) {
            System.out.println(string);
        }
        System.out.println("____________");
        String s = strings.dequeue();
        System.out.println(s);
        System.out.println(strings.size());
        strings.enqueue("e");
        strings.dequeue();
        System.out.println("__________________");
        for (String string : strings) {
            System.out.println(string);
        }






    }
}
