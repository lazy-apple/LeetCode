package alg78;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LaZY(李志一)
 * @create 2019-05-22 13:44
 */
public class Solution2 {
    int[] nums;
    List<List<Integer>> result;
    public void find(int index,List<Integer> last){
        if(index>=nums.length)
            return ;
        ArrayList<Integer> integers = new ArrayList<>();
        integers.addAll(last);
        integers.add(nums[index]);
        this.result.add(integers);
        find(index + 1,last);
        find(index + 1,integers);
    }
    public List<List<Integer>> subsets(int[] nums) {
        this.nums = nums;
        this.result = new ArrayList<List<Integer>>();
        int i = 0;
        ArrayList<Integer> list = new ArrayList<>();
        this.result.add(list);
        find(i,list);
        return this.result;
    }

    public static void main(String[] args) {
        for (List<Integer> subset : new Solution2().subsets(new int[]{1, 2, 3})) {
            for (Integer integer : subset) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }
}
