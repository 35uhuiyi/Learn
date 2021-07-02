package alg4.Leetcode.String;

import java.util.Arrays;

public class dayBetweenDates {
    public int fun(String date1, String date2) {
        String[] d1 = date1.split("-");
        String[] d2 = date2.split("-");
        return Math.abs(sumday(d2)-sumday(d1));
    }
    private int sumday(String[] d1){
        int d1sum = 0;
        int d1year = Integer.parseInt(d1[0]);
        int d1month = Integer.parseInt(d1[1]);
        int d1day = Integer.parseInt(d1[2]);
        for(int i=1971;i<d1year;i++){
            int[] ryear = ryear(i);
            d1sum += sum(ryear);
        }
        int[] ryear = ryear(d1year);
        if(d1month==1) return d1sum+=d1day;
        else{
            for(int j=0;j<=d1month-2;j++){
                d1sum += ryear[j];
            }
            d1sum += d1day;
            return d1sum;
        }
    }
    private int[] ryear(int year){
        if((year%4==0&&year%100!=0)||(year%400==0)){
            return new int[]{31,29,31,30,31,30,31,31,30,31,30,31};
        }else {
            return new int[]{31,28,31,30,31,30,31,31,30,31,30,31};
        }
    }
    private int sum(int[] a){
        int r=0;
        for (int i : a) {
            r += i;
        }
        return r;
    }

    public static void main(String[] args) {
        String date1 = "1971-06-29";
        String date2 = "2010-09-23";
        dayBetweenDates dayBetweenDates = new dayBetweenDates();
        int fun = dayBetweenDates.fun(date1, date2);
        System.out.println(fun);
    }
}
