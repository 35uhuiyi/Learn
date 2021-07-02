package alg4.Leetcode.String;

public class lengthOfLastWord {
    public int lengthOfLastWordf(String s) {
        int end = s.length()-1;
        while (end>0&&s.charAt(end)==' '){
            end--;
        }
        if(end<0) return 0;
        int start = end;
        while(start>0&&s.charAt(start)!=' '){
            start--;
        }
        return end-start;
    }

    public static void main(String[] args) {
        String s = "";
        lengthOfLastWord lengthOfLastWord = new lengthOfLastWord();
        int i = lengthOfLastWord.lengthOfLastWordf(s);
        System.out.println(i);
    }
}
