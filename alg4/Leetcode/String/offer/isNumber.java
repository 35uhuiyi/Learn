package alg4.Leetcode.String.offer;

import java.sql.DriverManager;
import java.util.HashMap;
import java.util.Map;

/**
 * @author yang
 * @version 1.0
 * @date 2021/5/3 16:18
 */
public class isNumber {
    public boolean f(String s) {
        //定义状态转移表
        Map[] states = {
                //0状态的转移情况
                new HashMap(){{put(' ',0);put('s',1);put('d',2);put('.',4);}},
                //1状态的转移情况
                new HashMap(){{put('d',2);put('.',4);}},
                new HashMap(){{put('d',2);put('.',3);put(' ',8);put('e',5);}},
                new HashMap(){{put('d',3);put('e',5);put(' ',8);}},
                new HashMap(){{put('d',3);}},
                new HashMap(){{put('s',6);put('d',7);}},
                new HashMap(){{put('d',7);}},
                new HashMap(){{put('d',7);put(' ',8);}},
                new HashMap(){{put(' ',8);}},
        };
        int p=0;
        char t;
        for (char c : s.toCharArray()) {
            if(c-'0'>=0&&c-'0'<=9){
                t = 'd';
            }else if(c=='e'||c=='E'){
                t = 'e';
            }else if(c=='.'||c==' '){
                t = c;
            }else if(c=='+'||c=='-'){
                t = 's';
            }else{
                t = '?';
            }
            if(!states[p].containsKey(t)){
                return false;
            }
            //状态更新
            p = (int)states[p].get(t);
        }
        return p==2||p==3||p==7||p==8; //合法状态
    }

    public static void main(String[] args) {
        isNumber isNumber = new isNumber();
        System.out.println(isNumber.f(".2e+4"));
    }
}
