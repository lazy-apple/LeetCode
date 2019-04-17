package alg;

import java.util.Arrays;

/**
 * 只出现一次的数组
 * @author LaZY(李志一)
 * @create 2019-04-17 11:31
 */
public class Solution {
    public int singleNumber(int[] nums){
        if(nums.length == 1){
            return nums[0];
        }
        Arrays.sort(nums);
        for (int i = 1; i < nums.length-1; i++) {
            if(nums[i] != nums[i + 1] && nums[i] != nums[i -1]){
                return nums[i];
            }
            if(i == nums.length - 2 && nums[i] != nums[i+1]){
                return nums[i+1];
            }
            if(i ==1 && nums[i] != nums[i-1]){
                return nums[i -1 ];
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().singleNumber(new int[]{17,12,5,-6,12,4,17,-5,2,-3,2,4,5,16,-3,-4,15,15,-4,-5,-6}));
    }
}
