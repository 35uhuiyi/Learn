package alg4.Leetcode.array;

public class vaildMoutainArray {
    public boolean f(int[] arr) {
        if (arr.length==0) return false;
        if(arr.length==1) return false;
        if(arr.length==2) return arr[0]==arr[1];
        int L = 0;
        int R = arr.length-1;
        while(L+1<R){
            if (arr[L] < arr[L+1]) {
                L++;
            }else break;
        }
        while(R>0){
            if (arr[R] < arr[R-1]) {
                R--;
            }
            else break;
        }
        System.out.println(L);
        System.out.println(R);
        return L==R &&L >0 &&R<arr.length-1;
    }

    public static void main(String[] args) {
        int[] ints = {9,8,7,6,5,4,3,2,1,0};
        vaildMoutainArray arr = new vaildMoutainArray();
        System.out.println(arr.f(ints));
    }
}
