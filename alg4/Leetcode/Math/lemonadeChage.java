package alg4.Leetcode.Math;

public class lemonadeChage {
    public boolean f(int[] bills) {
        if(bills[0]==10||bills[0]==20) return false;
        int yu5 = 0;
        int yu10 = 0;
        for(int i=0;i<bills.length;i++){
            if(bills[i]==5){
                yu5 += 1;
            }else if(bills[i]==10){
                if(yu5>0){
                    yu10 += 1;
                    yu5 -= 1;
                }else{
                    return false;
                }
            }else{
                if(yu5>0&&yu10>0){
                    yu5 -= 1;
                    yu10 -= 1;
                }else if(yu5 >= 3){
                    yu5 -= 3;
                }
                else{
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums = {5,5,10,20,5,5,5,5,5,5,5,5,5,10,5,5,20,5,20,5};
        boolean f = new lemonadeChage().f(nums);
        System.out.println(f);
    }
}
