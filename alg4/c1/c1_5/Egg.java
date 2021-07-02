package alg4.c1.c1_5;

import edu.princeton.cs.algs4.StdOut;

public class Egg {
    public static void rankLgN(int N,int f)
    {
        if(N<1) return;
        if(f<1) return;
        if (f>N) return;
        //
        int lo=1;
        int hi=N;
        int mid=1;
        int runTimes=0;
        while(lo<hi)
        {
            mid=(lo+hi)/2;
            if(mid>=f)
                hi=mid;
            else
                lo=mid+1;
            runTimes++;
        }
        StdOut.printf("Algs lgN runTimes=%d,lo=%d\n",runTimes,lo);
    }

    public static void rank2LgF(int N,int f)
    {
        if(N<1) return;
        if(f<1) return;
        if (f>N) return;
        //
        int floor=1;
        int  runTimes=0;
        while(floor<f)
        {
            floor=2*floor;
            runTimes++;
        }
        //
        int lo=floor/2;
        int hi=floor;
        int mid=lo;
        while(lo<hi)
        {
            mid=(lo+hi)/2;
            if(mid>=f)
                hi=mid;
            else
                lo=mid+1;
            runTimes++;
        }
        StdOut.printf("Algs 2lgF runTimes=%d,lo=%d\n",runTimes,lo);
    }
    public static void main(String[] args)
    {
        int N=10;
        int f=10;
        rankLgN(N,f);
        rank2LgF(N,f);
    }
}
