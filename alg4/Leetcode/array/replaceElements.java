package alg4.Leetcode.array;

import java.util.Arrays;

/*1299. 将每个元素替换为右侧最大元素
        给你一个数组 arr ，请你将每个元素用它右边最大的元素替换，如果是最后一个元素，用 -1 替换。

        完成所有替换操作后，请你返回这个数组。



        示例：

        输入：arr = [17,18,5,4,6,1]
        输出：[18,6,6,6,1,-1]


        提示：

        1 <= arr.length <= 10^4
        1 <= arr[i] <= 10^5*/
public class replaceElements {
    public int[] replaceElementsf(int[] arr) {
        //从后向前走，每个值与后面的max值逐次比较
        int max = -1;
        for(int i=arr.length-1;i>=0;i--){
            int cur = arr[i];
            arr[i] = max;
            max = Math.max(cur,max);
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {17,18,5,4,6,1};
        replaceElements replaceElements = new replaceElements();
        int[] ints = replaceElements.replaceElementsf(arr);
        System.out.println(Arrays.toString(ints));
    }
}
