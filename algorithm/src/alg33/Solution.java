package alg33;

/**
 * @author LaZY(李志一)
 * @create 2019-03-06 10:32
 */
public class Solution {
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end){
            //循环的出口
            if(target == nums[start]){
                return start;
            }
            if(target == nums[end]){
                return end;
            }
            int mid = (end + start)/2;
            if(target == nums[mid]){
                return mid;
            }
            //序列包含旋转点
            if(nums[start] > nums[mid]){
                if(target > nums[mid] && target < nums[start]){
                    start = mid + 1;
                }else {
                    end = mid - 1;
                }
            }else {//序列不包含旋转点
                if(target<nums[mid] && target>nums[start]){
                    end = mid- 1;
                }else {
                    start = mid + 1;//不能写mid++
                }
            }
        }
        return -1;
    }
}
