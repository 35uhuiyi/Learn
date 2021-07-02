package sort;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author yang
 * @version 1.0
 * @date 2021/5/26 22:05
 */
public class SelectSort {

    //选择排序是每次都选出最小的,一共需要n-1遍，每遍从首元素开始，比较得出剩下所有中最小元素的索引，将其与首元素交换
    public void sort(int[] arr){
        for(int i=0;i<arr.length-1;i++){
            int minIndex = i;
            for(int j=i+1;j<arr.length;j++){
                if(arr[j]<arr[minIndex]){
                    minIndex = j;
                }
            }
            exch(arr, minIndex, i);
            System.out.println("第"+i+ "遍：" + Arrays.toString(arr));
        }
    }
    private void exch(int[] arr, int x, int y){
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

    public static void main(String[] args) {
        SelectSort a = new SelectSort();
        int[] arr = {3,5,1,6,3};
        System.out.println("原数组："+Arrays.toString(arr));
        a.sort(arr);
    }
}
