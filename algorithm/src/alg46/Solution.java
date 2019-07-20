package alg46;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author LaZY(李志一)
 * @create 2019-05-23 17:00
 */
public class Solution {
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> permute (int[] nums) {

        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        backtrack(0, list);

        return ans;
    }

    private void backtrack (int current, List list) {
        if (current == list.size()) {
            ans.add(list);
        }

        for (int i = current; i < list.size(); i++) {
            Collections.swap(list, current, i);
            backtrack(current + 1,list);
            Collections.swap(list, current, i); // 使数组回到原来的样子重新操作
        }

    }

    public static void main(String[] args) {
        System.out.println(new Solution().permute(new int[]{1, 2, 3}));
//        ArrayList<Integer> integers = new ArrayList<>();
//        integers.add(1);
//        integers.add(2);
//        integers.add(3);
//        Collections.swap(integers, 0, 1);
//
//        for (Integer integer : integers) {
//            System.out.println(integer);
//        }
    }

}
