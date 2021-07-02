package alg4.offer;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author yang
 * @version 1.0
 * @date 2021/6/4 22:07
 */
public class test {

    public int calculate(String s) {
        s = s.trim();
        Deque<Integer> stack = new ArrayDeque<>();
        int number = 0;
        char sign = '+';
        char[] charArray = s.toCharArray();
        for (int i = 0, n = charArray.length; i < n; i++) {
            char c = charArray[i];
            if (c == ' ') {
                continue;
            }
            if (Character.isDigit(c)) {
                number = number * 10 + c - '0';
            }
            if (c == '(') {
                int j = i + 1;
                int counterPartition = 1;
                while (counterPartition > 0) {
                    if (charArray[j] == '(') {
                        counterPartition++;
                    }
                    if (charArray[j] == ')') {
                        counterPartition--;
                    }
                    j++;
                }
                number = calculate(s.substring(i + 1, j - 1));
                i = j - 1;
            }
            if (!Character.isDigit(c) || i == n - 1) {
                if (sign == '+') {
                    stack.push(number);
                } else if (sign == '-') {
                    stack.push(-1 * number);
                } else if (sign == '*') {
                    stack.push(stack.pop() * number);
                } else if (sign == '/') {
                    stack.push(stack.pop() / number);
                }
                number = 0;
                sign = c;
            }
        }
        int ans = 0;
        while (!stack.isEmpty()) {
            ans += stack.pop();
        }
        return ans;
    }

    private int fun2(String s){
        s = s.trim();
        char sign = '+';  //初始符号
        int number = 0;  //初始
        char[] cs = s.toCharArray();
        Stack<Integer> stack = new Stack<>();
        int n = cs.length;
        for (int i = 0; i < n; i++) {
            if(cs[i]==' '){
                continue;
            }
            if(Character.isDigit(cs[i])){
                number = number * 10 + cs[i] -'0';
            }
            if (cs[i] == '(') {
                int j = i + 1;
                int counterPartition = 1; //括号数量
                while (counterPartition > 0) {
                    if (cs[j] == '(') {
                        counterPartition++;
                    }
                    if (cs[j] == ')') {
                        counterPartition--;
                    }
                    j++;
                }
                //必须返回计算后的括号内的结果，number
                number = calculate(s.substring(i + 1, j - 1));  //递归调用
                //i需要进步到下个括号外
                i = j - 1;
            }
            //不是数字或是到了最后一个字符
            if (!Character.isDigit(cs[i]) || i == n - 1) {
                if (sign == '+') {
                    stack.push(number);
                } else if (sign == '-') {
                    stack.push(-1 * number);
                } else if (sign == '*') {
                    stack.push(stack.pop() * number);
                } else if (sign == '/') {
                    stack.push(stack.pop() / number);
                }
                number = 0;
                sign = cs[i];
            }
        }
        int res =0;
        while(!stack.isEmpty()){
            res += stack.pop();
        }
        return res;
    }


    //输出4，0
    public static void main(String[] args) {
        test test = new test();
        int fun = test.fun2("(2*(3-4))*5");
        System.out.println(fun);
    }
}
