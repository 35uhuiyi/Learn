package alg4.c1.test;

import alg4.c1.c1_2.ResizingArrayStack;

public class ResizingArrayStackTest {
    public static void main(String[] args) {
        ResizingArrayStack<String> stack = new ResizingArrayStack<String>(1);

        stack.push("a");
        stack.push("b");
        stack.push("c");

        for (String s : stack) {
            System.out.println(s);
        }
        System.out.println(stack.size());

        System.out.println("____________________");
        String pop = stack.pop();
        System.out.println("pop:"+pop);
        for (String s : stack) {
            System.out.println(s);
        }
        System.out.println(stack.size());


    }
}
