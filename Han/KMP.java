package Han;

import java.util.Arrays;

//KMP字符串匹配问题
public class KMP {
    /**
     *
     * @param s 输入字符串
     * @return 生成s的next表（最大前缀后缀数）
     */
    private static int[] next(String s){
        int[] next = new int[s.length()];
        next[0] = 0;
        for (int i = 1,j=0; i < s.length(); i++) {
            while (j>0&&s.charAt(i)!=s.charAt(j)){
                //KMP算法核心
                j=next[j-1];
            }
            if(s.charAt(i)==s.charAt(j)){
                j++;
            }
            next[i]=j;
        }
        return next;
    }
    private static int KMPSearch(String s,String p,int[] next){
        for (int i = 0, j=0; i < s.length(); i++) {
            while (j>0&&s.charAt(i)!=p.charAt(j)){
                j=next[j-1];
            }
            if(s.charAt(i)==p.charAt(j)){
                j++;
            }
            if(j==p.length()){
                return i-j+1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        String p = "ABCDABD";
        String s = "BBC ABCDAB ABCDABCDABDE";
        int[] n = next(p);
        System.out.println("next:"+Arrays.toString(n));
        int res = KMPSearch(s,p,n);
        System.out.println(res);
    }
}
