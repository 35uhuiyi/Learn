package alg4.offer.array;

import java.util.Arrays;

/**
 * @author yang
 * @version 1.0
 * @date 2021/4/12 20:11
 */
public class findNumberIn2DArray {

    public boolean f(int[][] matrix, int target) {
        if(matrix==null){
            return false;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        int row=0,col=cols-1;
        while(row<=rows&&col>=0){
            int t = matrix[row][col];
            if(t==target){
                return true;
            }else if(t>target){
                col--;
            }else{
                row++;
            }
        }
        return false;
    }

    public int findBST(int[] m,int target){

        int l=0,h=m.length-1;
        while(l<=h){
            int mid = (l+h)/2;
            if(m[mid]==target){
                return mid;
            }else if(m[mid]>target){
                h = mid-1;
            }else {
                l = mid+1;
            }
        }
        return l;
    }



    public static void main(String[] args) {
        int[][] matrix = {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
        findNumberIn2DArray findNumberIn2DArray = new findNumberIn2DArray();
        System.out.println(findNumberIn2DArray.f(matrix, 5));
    }
}
