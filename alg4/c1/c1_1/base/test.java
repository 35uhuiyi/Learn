package alg4.c1.c1_1.base;


public class test {
    private static boolean huihuanS(String s1,String s2){
        return s1.concat(s1).indexOf(s2)>=0;
    }
    public static String mystery(String s) {
        int N = s.length();
        if (N <= 1) {
            return s;
        }
        String a = s.substring(0, N / 2);
        String b = s.substring(N / 2, N);
        System.out.println(a);
        System.out.println(b);
        return mystery(b) + mystery(a);
    }
    public static void main(String[] args) {
        String s1="ACTGACG";
        System.out.println(mystery(s1));
    }
}
