package alg4.Leetcode.String;

public class findTheDifference {
    private char f(String s,String t){
        int ssum = 0;
        int tsum = 0;
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i);
            ssum += c;
        }
        for (int i = 0; i < t.length(); i++) {
            int d = t.charAt(i);
            tsum += d;
        }
        char a = (char)(tsum-ssum);
        return a;
    }

    public static void main(String[] args) {
        findTheDifference findTheDifference = new findTheDifference();
        System.out.println(findTheDifference.f("abcd", "abcda"));

    }
}
