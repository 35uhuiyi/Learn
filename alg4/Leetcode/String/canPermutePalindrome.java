package alg4.Leetcode.String;
/*面试题 01.04. 回文排列
        给定一个字符串，编写一个函数判定其是否为某个回文串的排列之一。

        回文串是指正反两个方向都一样的单词或短语。排列是指字母的重新排列。

        回文串不一定是字典当中的单词。



        示例1：

        输入："tactcoa"
        输出：true（排列有"tacocat"、"atcocta"，等等）*/
public class canPermutePalindrome {
    public boolean canPermutePalindromef(String s) {
        int cnt = 0;
        int[] chars = new int[256];
        for(int i=0;i<s.length();i++){
            if((chars[s.charAt(i)]++ & 1) ==1){
                cnt--;
            }else{
                cnt++;
            }
        }
        System.out.println(cnt);
        return cnt<2;
    }
    private boolean fun2(String s){
        int[] map = new int[256];
        int count = 0;
        for (char c : s.toCharArray()) {
            if ((map[c]++ & 1) == 1) {
                count--;
            } else {
                count++;
            }
        }
        return count <= 1;
    }

    public static void main(String[] args) {
        String s = "carerac";
        canPermutePalindrome canPermutePalindrome = new canPermutePalindrome();
        boolean b = canPermutePalindrome.canPermutePalindromef(s);
        System.out.println(b);

    }
}
