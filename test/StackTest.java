package test;

import linear.Stack;

public class StackTest {
    public static void main(String[] args) {
        Stack<String> stringStack = new Stack<>();
        stringStack.push("a");
        stringStack.push("b");
        stringStack.push("c");
        stringStack.push("d");
        for (String o : stringStack) {
            System.out.println(o);
        }
        stringStack.pop();
        System.out.println("************");
        for (String s : stringStack) {
            System.out.println(s);
        }
        System.out.println(stringStack.size());
    }
}
