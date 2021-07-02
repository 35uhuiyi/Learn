package test;

import linear.Stack;
import sort.Insertion;

//逆波兰表达式
public class StackDemo {
    public static void main(String[] args) {
        String[] notation ={"3","17","15","-","*","18","6","/","+"};
        int result = caculate(notation);
        System.out.println("结果为："+result);
    }

    private static int caculate(String[] notation) {
        Stack<Integer> operators = new Stack<>();//用栈来存储操作数
        int result;
        int o1;
        int o2;
        for (int i = 0; i < notation.length; i++) {
            String s = notation[i];
            switch (s){
                case "+":
                    o1 = operators.pop();
                    o2 = operators.pop();
                    result = o2+o1;
                    operators.push(result);
                    break;
                case "-":
                    o1 = operators.pop();
                    o2 = operators.pop();
                    result = o2-o1;
                    operators.push(result);
                    break;
                case "*":
                    o1 = operators.pop();
                    o2 = operators.pop();
                    result = o2*o1;
                    operators.push(result);
                    break;
                case "/":
                    o1 = operators.pop();
                    o2 = operators.pop();
                    result = o2/o1;
                    operators.push(result);
                    break;
                default:
                    operators.push(Integer.parseInt(s));
                    break;
            }
        }
        result = operators.pop();
        return result;
    }
}
