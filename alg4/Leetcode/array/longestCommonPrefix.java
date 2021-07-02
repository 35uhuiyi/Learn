package alg4.Leetcode.array;

/*14. 最长公共前缀
        难度
        简单

        编写一个函数来查找字符串数组中的最长公共前缀。

        如果不存在公共前缀，返回空字符串 ""。

        示例 1:

        输入: ["flower","flow","flight"]
        输出: "fl"
        示例 2:

        输入: ["dog","racecar","car"]
        输出: ""
        解释: 输入不存在公共前缀。
        说明:
        所有输入只包含小写字母 a-z 。*/
public class longestCommonPrefix {
    private String longestCommonPrefixf(String[] strs) {
        if(strs.length<=0||strs==null){
            return "";
        }
        int length = strs[0].length();
        int count = strs.length;
        for (int i = 0; i < length; i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < count; j++) {
                if(strs[j].length()==i||strs[j].charAt(i)!=c){
                    return strs[0].substring(0,i);
                }
            }
        }
        return strs[0];
    }

    public static void main(String[] args) {
        longestCommonPrefix longestCommonPrefix = new longestCommonPrefix();
        String[] strs = {"flower","flow","flight"};
        String s = longestCommonPrefix.longestCommonPrefixf(strs);
        System.out.println(s);
        System.out.println("flight".substring(0,3));//fli
    }
}
