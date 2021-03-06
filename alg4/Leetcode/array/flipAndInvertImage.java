package alg4.Leetcode.array;
/*832. 翻转图像
        给定一个二进制矩阵 A，我们想先水平翻转图像，然后反转图像并返回结果。

        水平翻转图片就是将图片的每一行都进行翻转，即逆序。例如，水平翻转 [1, 1, 0] 的结果是 [0, 1, 1]。

        反转图片的意思是图片中的 0 全部被 1 替换， 1 全部被 0 替换。例如，反转 [0, 1, 1] 的结果是 [1, 0, 0]。

        示例 1:

        输入: [[1,1,0],[1,0,1],[0,0,0]]
        输出: [[1,0,0],[0,1,0],[1,1,1]]
        解释: 首先翻转每一行: [[0,1,1],[1,0,1],[0,0,0]]；
        然后反转图片: [[1,0,0],[0,1,0],[1,1,1]]
        示例 2:

        输入: [[1,1,0,0],[1,0,0,1],[0,1,1,1],[1,0,1,0]]
        输出: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
        解释: 首先翻转每一行: [[0,0,1,1],[1,0,0,1],[1,1,1,0],[0,1,0,1]]；
        然后反转图片: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
        说明:

        1 <= A.length = A[0].length <= 20
        0 <= A[i][j] <= 1*/
public class flipAndInvertImage {
    public static int[][] flipAndInvertImagef(int[][] A) {
        int h = A.length;
        int l = A[0].length;
        for (int i = 0; i < h; i++) {
            A[i] = Invert(A[i]);
            A[i] = flip(A[i]);
        }
        return A;
    }
    private static int[] flip(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            arr[i]=arr[i]==1?0:1;
        }
        return arr;
    }

    private static int[] Invert(int[] arr){
        int length = arr.length;
        for (int i = 0,j=length-1; i < j; i++,j--) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        return arr;
    }

    public static void main(String[] args) {
        int[][] arr = {{1,1,0,0},{1,0,0,1},{0,1,1,1},{1,0,1,0}};
        int[][] ints = flipAndInvertImagef(arr);
        for (int[] anInt : ints) {
            for (int i : anInt) {
                System.out.print(i+" ");
            }
            System.out.println();
        }


    }
}
