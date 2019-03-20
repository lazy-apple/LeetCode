package alg15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *15.三数之和
 * 难点1：时间；难点2：重复元素。
 *解题步骤：
 * 1.数组排序。
 * 2.设置固定点，前指针和后指针。
 * 每一次固定点不动，前指针后移，后指针前移，三数之和为0，即为需要找的元素。
 * 前后指针之和大于固定点，后指针前移（因为已排序）
 * 同理，处理小于情况。
 * （以上都为节省时间服务）
 * 每一次指针移动都要提前判断后面的值是否与当前指针元素相同，避免向集合加入相同元素。
 *
 * @author LaZY(李志一)
 * @create 2019-03-20 11:29
 */
public class Solution {
    public List<List<Integer>> threeSum(int[] nums){
        List<List<Integer>> list = new ArrayList<>();
        if (nums == null || nums.length<3){
            return list;
        }
        int length = nums.length;
        int fix = 0;//固定点
        int start ;//前指针
        int end ;//后指针
        Arrays.sort(nums);//原数组排序
        for (int i = fix; i < length-2; i++) {//-2原因：不能包括前后指针
            if(i == 0 ||(i > 0 && nums[i] != nums[i-1])  ){//去重
                start = i + 1;
                end = length -1;
                while (start<end){
                    if (nums[start] + nums[end] == -nums[i]){
                        list.add(Arrays.asList(nums[start],nums[end],nums[i]));
                        while (start<end && nums[start] == nums[start + 1]){start++;}//去重
                        while (start<end && nums[end] == nums[end - 1]){end--;}//去重
                        start++;
                        end--;
                    }else if (nums[start] + nums[end] > -nums[i]){
                        while (start<end && nums[end] == nums[end - 1]){end--;}//去重
                        end--;
                    }else if (nums[start] + nums[end] < -nums[i]){
                        while (start<end && nums[start] == nums[start + 1]){start++;}//去重
                        start++;
                    }

                }
            }
        }
        return list;
    }
}
