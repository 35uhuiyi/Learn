package alg4.Leetcode.Math;

public class calculate {
    public int calculatef(String s) {
        int x=1,y=0;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c=='A'){
                x = 2*x+y;
            }else{
                y = 2*y+x;
            }
        }
        return x+y;
    }

    public static void main(String[] args) {
        calculate calculate = new calculate();
        int ab = calculate.calculatef("AB");
        System.out.println(ab);
    }
}
