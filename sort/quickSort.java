package sort;

import java.util.Arrays;

/**
 * @author yang
 * @version 1.0
 * @date 2021/5/25 21:23
 */
public class quickSort {

    public void sort(int[] arr){
        sort(arr, 0, arr.length-1);
    }
    private void sort(int[] arr, int l, int r){
        if(l<r){
            int index = p(arr, l, r);
            sort(arr, l, index - 1);
            sort(arr, index + 1, r);
        }
    }
    private int p(int[] arr, int l, int r){
        int i=l, j=r+1;
        //切分元素
        int item = arr[l];
        //寻找
        while(true){
            while(arr[++i]<=item){
                if(i==r){
                    break;
                }
            }
            while(arr[--j]>=item){
                if(j==l){
                    break;
                }
            }
            if(i>=j){
                break;
            }
            exch(arr, i, j);
        }
        exch(arr, l, j);
        return j;
    }
    private void exch(int[] arr, int x, int y){
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {3,2,1,4,5,62,3,0};
        quickSort quickSort = new quickSort();
        quickSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
