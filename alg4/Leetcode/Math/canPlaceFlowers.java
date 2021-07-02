package alg4.Leetcode.Math;

public class canPlaceFlowers {
    public boolean canPlaceFlowersf(int[] flowerbed, int n) {
        int i=0,cnt=0;
        while(i<flowerbed.length){
            //i==0必须在前面
            if(flowerbed[i]==0&&(i==0||flowerbed[i-1]==0)&&(i==flowerbed.length-1||flowerbed[i+1]==0)){
                flowerbed[i++] =1;
                cnt++;
                if(cnt>=n) return true;
            }
            i++;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] a = {1,0,0,0,1};
        canPlaceFlowers canPlaceFlowers = new canPlaceFlowers();
        boolean b = canPlaceFlowers.canPlaceFlowersf(a, 2);
        System.out.println(b);
    }
}
//flowerbed[i] == 0 && (i == 0 || flowerbed[i - 1] == 0) && (i == flowerbed.length - 1 || flowerbed[i + 1] == 0)
