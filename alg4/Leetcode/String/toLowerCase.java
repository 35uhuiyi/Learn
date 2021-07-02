package alg4.Leetcode.String;
/*709. 转换成小写字母
        实现函数 ToLowerCase()，该函数接收一个字符串参数 str，并将该字符串中的大写字母转换成小写字母，之后返回新的字符串。



        示例 1：

        输入: "Hello"
        输出: "hello"*/
public class toLowerCase {
    public String toLowerCasef(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }
        char[] ans = str.toCharArray();
        for (int i = 0; i < ans.length; i++) {
            int b = ans[i];
            if(b>=65&&b<=90){
                ans[i] = (char)(b+32);
            }
        }
        return new String(ans);
    }

    public static void main(String[] args) {
        String str="Hello";
        toLowerCase toLowerCase = new toLowerCase();
        String s = toLowerCase.toLowerCasef(str);
        System.out.println(s);
    }
}
