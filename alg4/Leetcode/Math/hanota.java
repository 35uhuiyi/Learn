package alg4.Leetcode.Math;

import java.util.ArrayList;
import java.util.List;

/*面试题 08.06. 汉诺塔问题
        在经典汉诺塔问题中，有 3 根柱子及 N 个不同大小的穿孔圆盘，盘子可以滑入任意一根柱子。一开始，所有盘子自上而下按升序依次套在第一根柱子上(即每一个盘子只能放在更大的盘子上面)。移动圆盘时受到以下限制:
        (1) 每次只能移动一个盘子;
        (2) 盘子只能从柱子顶端滑出移到下一根柱子;
        (3) 盘子只能叠在比它大的盘子上。

        请编写程序，用栈将所有盘子从第一根柱子移到最后一根柱子。

        你需要原地修改栈。

        示例1:

        输入：A = [2, 1, 0], B = [], C = []
        输出：C = [2, 1, 0]
        示例2:

        输入：A = [1, 0], B = [], C = []
        输出：C = [1, 0]
        提示:

        A中盘子的数目不大于14个。*/
public class hanota {
    public static void hanotaf(List<Integer> A, List<Integer> B, List<Integer> C) {
        fun( A,B, C,A.size());
    }
    private static void fun(List<Integer> A, List<Integer> B, List<Integer> C, int n){
        if(n==1){
            C.add(A.remove(A.size()-1));
            return;
        }
        //把上面的n-1个看作一组，从A借助于C移动到B
        fun(A,C,B,n-1);
        //把最下面的一个看作一组，从A移动到C
        C.add(A.remove(A.size()-1));
        //再把那n-1个从B->C
        fun(B,A,C,n-1);
    }

    public static void main(String[] args) {
        List<Integer> A = new ArrayList<>();
        List<Integer> B = new ArrayList<>();
        List<Integer> C = new ArrayList<>();
        A.add(2);
        A.add(1);
        A.add(0);
        hanotaf(A,B,C);
        for (Integer integer : C) {
            System.out.println(integer);
        }
        for (Integer integer : A) {
            System.out.println(integer+"");
        }
    }

}
