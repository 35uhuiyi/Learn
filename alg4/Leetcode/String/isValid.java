package alg4.Leetcode.String;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

/*20. 有效的括号
        给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。

        有效字符串需满足：

        左括号必须用相同类型的右括号闭合。
        左括号必须以正确的顺序闭合。
        注意空字符串可被认为是有效字符串。

        示例 1:

        输入: "()"
        输出: true
        示例 2:

        输入: "()[]{}"
        输出: true
        示例 3:

        输入: "(]"
        输出: false*/
public class isValid {
    public boolean isValidf(String s) {
        if(s.length()%2==1){
            return false;
        }
        HashMap<Character, Character> map = new HashMap<>();
        map.put(')','(');
        map.put(']','[');
        map.put('}','{');
        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(map.containsKey(c)){
                if(stack.isEmpty()||map.get(c)!=stack.peek()){
                    //有右边没了左边
                    return false;
                }
                stack.pop();
            }else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
    public static void main(String[] args) {

        isValid test = new isValid();
        boolean validf = test.isValidf("(]");
        System.out.println(validf);
    }
}
