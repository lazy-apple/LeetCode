package alg217;

import java.util.HashSet;

/**
 * 存在重复元素
 * @author LaZY(李志一)
 * @create 2019-04-18 19:58
 */
public class Solution {
    public boolean containsDuplicate(int[] nums){
        if(nums == null){
            return false;
        }
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if(set.contains(nums[i])){
                return true;
            }else {
                set.add(nums[i]);
            }
        }
        return false;
    }
}
