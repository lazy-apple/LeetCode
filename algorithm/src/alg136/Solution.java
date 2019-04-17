package alg136;

import java.util.Arrays;

/**
 * 只出现一次的数字
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

    /***
     * 最优解 异或运算
     *  值相同的数异或运算为0
     *  0和任何数异或运算都为本身
     * @param nums
     * @return
     */
    public int singleNumber1(int[] nums){
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res ^= nums[i];
        }
        return res;
    }
    public static void main(String[] args) {
        System.out.println(new Solution().singleNumber(new int[]{17,12,5,-6,12,4,17,-5,2,-3,2,4,5,16,-3,-4,15,15,-4,-5,-6}));
    }
}
