package alg4.Leetcode.String;

public class maxRepeating {
    public int f(String sequence, String word) {
        int ans = 0;
        int l = word.length();
        while (sequence.length()>0){
            int index = sequence.indexOf(word);
            if(index == -1) break;
            ans += 1;
            sequence = sequence.substring(index+l,sequence.length());
            System.out.println(sequence);
        }
        return ans;

    }

    public static void main(String[] args) {
        maxRepeating maxRepeating = new maxRepeating();
        System.out.println(maxRepeating.f("aaabaaaabaaabaaaabaaaabaaaabaaaaba","aaaba"));
    }
}
