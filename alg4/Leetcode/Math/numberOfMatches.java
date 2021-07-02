package alg4.Leetcode.Math;

public class numberOfMatches {
    public int f(int n) {
        int ans = 0;
        while(n>1){
            if(n%2==0){
                ans += (n/2);
                n /=2 ;
            }else{
                ans += (n/2);
                n = (n/2)+1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {

        numberOfMatches numberOfMatches = new numberOfMatches();
        int f = numberOfMatches.f(7);
        System.out.println(f);
    }
}
