package alg4.Leetcode.Math;
/*1323. 6 和 9 组成的最大数字
        给你一个仅由数字 6 和 9 组成的正整数 num。
        你最多只能翻转一位数字，将 6 变成 9，或者把 9 变成 6 。
        请返回你可以得到的最大数字。
        示例 1：
        输入：num = 9669
        输出：9969
        解释：
        改变第一位数字可以得到 6669 。
        改变第二位数字可以得到 9969 。
        改变第三位数字可以得到 9699 。
        改变第四位数字可以得到 9666 。
        其中最大的数字是 9969 。
        示例 2：

        输入：num = 9996
        输出：9999
        解释：将最后一位从 6 变到 9，其结果 9999 是最大的数。
        示例 3：

        输入：num = 9999
        输出：9999
        解释：无需改变就已经是最大的数字了。*/
public class maximun69Number {
    public int maximum69Numberf (int num) {
        String s = num + "";
        int n=0;
        char[] ans = new char[s.length()];
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)=='6'){
                n=i;
                break;
            }
        }
        return Integer.parseInt(s.substring(0,n)+"9"+s.substring(n+1,s.length()));
    }
    public int fun2(int num){
        return Integer.valueOf(String.valueOf(num).replaceFirst("6","9"));
    }

    public static void main(String[] args) {
        maximun69Number maximun69Number = new maximun69Number();
        int i = maximun69Number.maximum69Numberf(9996);
        System.out.println(i);
    }



}
