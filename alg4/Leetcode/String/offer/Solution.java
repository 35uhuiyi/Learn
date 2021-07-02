package alg4.Leetcode.String.offer;

class Solution {
    public int strToInt(String str) {
        if(str==null||str.length()==0) return 0;
        int bj = Integer.MAX_VALUE/10;
        int i=0,res=0;
        int len = str.length();
        //去除前端空白
        while(i<len){
            if(str.charAt(i)==' '){
                i++;
            }else{
                break;
            }
        }
        //全白
        if(i==len) return 0;
        //判断符号位
        //默认为正数
        int sign = 1;
        if(str.charAt(i)=='-') sign=-1;
        if(str.charAt(i)=='-'||str.charAt(i)=='+') i++;
        //数字判断
        for(int j=i;j<len;j++){
            //非数字直接return
            int c = str.charAt(j)-'0';
            System.out.println(c);
            if(c<0||c>9) break;
            //越界判断
            if(res>bj||(res==bj&&c>7)){
                return sign==1?Integer.MAX_VALUE:Integer.MIN_VALUE;
            }
            res = res *10 + c;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.strToInt("4193 with words");
        System.out.println(i);
    }
}