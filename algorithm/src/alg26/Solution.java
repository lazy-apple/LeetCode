package alg26;

/**
 * 数组去重
 * @author LaZY(李志一)
 * @create 2019-04-21 18:17
 */
public class Solution {
    public int removeDuplicates(int[] nums){
        int count = 1;
        if(nums == null){
            return 0;
        }else if(nums.length == 1){
            return 1;
        }
        int lenth = nums.length - 1;
        for (int i = 0; i < lenth; i++) {
            if(nums[i] < nums[i + 1]){
                count ++;
            }else {
                toEnd(nums,i + 1);
                lenth -- ;
                i --;
            }
        }
        return count;
    }

    public void toEnd(int[] nums,int index){
        for (int i = index; i < nums.length - 1; i++) {
            int t = nums[i];
            nums[i] = nums[i + 1];
            nums[i + 1] = t;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().removeDuplicates(new int[]{0,0,1,1,1,2,2,3,3,4}));
    }
}
class leetcode26 {
    public static void main(String[] args) {
        leetcode26 lt = new leetcode26();
        int []num = {0,1,1,2,2,3,3,4};
        System.out.println(lt.removeDuplicates(num));
    }

    // 扔进去AC了他
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0)
            return 0;
        //判断无输入
        int number = 0;//标记计数(记录数组中不同元素个数（-1），同时记录里数组中相同元素的第一个位置)
        for (int i=0; i < nums.length ; i++) {
            if ( nums[i] != nums[number] ) {
                number++;
                nums[number] = nums[i];
            }
        }
        number+=1; //标记+1即为数字个数
        return number;
    }

}
