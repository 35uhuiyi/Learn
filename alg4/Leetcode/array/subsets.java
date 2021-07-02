package alg4.Leetcode.array;

import java.util.ArrayList;
import java.util.List;

/*面试题 08.04. 幂集
        幂集。编写一种方法，返回某集合的所有子集。集合中不包含重复的元素。

        说明：解集不能包含重复的子集。

        示例:

        输入： nums = [1,2,3]
        输出：
        [
        [3],
        [1],
        [2],
        [1,2,3],
        [1,3],
        [2,3],
        [1,2],
        []
        ]*/
public class subsets {
    public List<List<Integer>> subsetsf1(int[] nums) {
        List<List<Integer>> answer = new ArrayList<List<Integer>>();
        //先加一个空集合
        answer.add(new ArrayList<>());
        //在原来的基础上再加入新元素
        for (int num : nums) {
            //需要加的次数
            int length = answer.size();
            for (int i = 0; i < length; i++) {
                List<Integer> lists = new ArrayList<>();
                lists.addAll(answer.get(i));//把之前的先放进去
                lists.add(num);
                answer.add(lists);
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        subsets subsets = new subsets();
        List<List<Integer>> subsetsf1 = subsets.subsetsf1(nums);
        for (List<Integer> integers : subsetsf1) {
            System.out.println(integers);
        }
    }
}
