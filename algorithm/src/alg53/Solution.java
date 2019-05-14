package alg53;

/**
 * @author LaZY(李志一)
 * @create 2019-05-14 10:05
 */
public class Solution {
    int max = Integer.MIN_VALUE;
    public int maxSubArray(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        if(nums.length == 1){
            return nums[0];
        }
        maxSum(nums,nums.length - 1);
        return max;
    }

    /***
     * 返回包含当前点在内的连续的最大自序和
     * @param nums
     * @param i 当前遍历到的位置
     * @return
     */
    public int maxSum(int[] nums,int i){
        if(i == 0){
            max = nums[0];
            return nums[0];
        }
//        包含当前点在内的最大自序和 = 该点之前连续的最大和 + 该点值 或 该点值
        int preMax = maxSum(nums,i - 1);
        int currMax = Math.max(preMax + nums[i],nums[i]);
        max = Math.max(currMax,max);
        return currMax;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }
}
