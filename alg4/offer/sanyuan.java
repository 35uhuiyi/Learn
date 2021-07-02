package alg4.offer;

import java.io.UnsupportedEncodingException;
import java.util.*;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author yang
 * @version 1.0
 * @date 2021/6/2 21:36
 */
public class sanyuan {

    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        ArrayList<ArrayList<Integer>> res=new ArrayList<>();

        if(num==null || num.length<3){
            return res;
        }
        Arrays.sort(num);// 排序
        for(int i=0;i<num.length-2;i++){
            if(num[i]>0){
                break;// 如果当前数字大于0，则三数之和一定大于0，所以结束循环
            }
            if(i>0 && num[i]==num[i-1]){
                continue;// 去重
            }
            int L=i+1;
            int R=num.length-1;

            while(L<R){
                int sum=num[i]+num[L]+num[R];
                if(sum==0){
                    ArrayList<Integer> list=new ArrayList<>();
                    list.add(num[i]);
                    list.add(num[L]);
                    list.add(num[R]);
                    while(L<R && num[L]==num[L+1]){
                        L++;
                    }
                    while(L<R && num[R]==num[R-1]){
                        R--;
                    }
                    L++;
                    R--;
                }
                else if(sum>0){
                    R--;
                }
                else if(sum<0){
                    L++;
                }
            }
        }
        return res;
    }
    //k=0~9
    private int fun(int k,int n){
        int res = 0, t= 0;
        for(int i=0, a = 1;i<n;i++, a*=10){
            t = a*k+t;
            res += t;
        }
        return res;
    }

    public static void main(String[] args) throws UnsupportedEncodingException {
        /*sanyuan s = new sanyuan();
        int[] num = {-10,0,10,20,-10};
        ArrayList<ArrayList<Integer>> arrayLists = s.threeSum(num);
        for (ArrayList<Integer> arrayList : arrayLists) {
            for (Integer integer : arrayList) {
                System.out.print(integer+" ");
            }
            System.out.println();
        }*/
        String str = "aaa";
        String tempStr = new String(str.getBytes("ISO-8859-1"), "GBK");
        System.out.println(tempStr);
        sanyuan s = new sanyuan();
        System.out.println(s.fun(1, 3));
    }
}
