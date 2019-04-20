package alg88;

/**
 * 合并两个有序数组
 * @author LaZY(李志一)
 * @create 2019-04-20 18:02
 */
public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        //从两个数组(有元素的)末尾开始遍历
        //结果大的元素存放在nums1的最末尾，同时两个指针向前移动
        //其中一个数组的指针移动到开头，则将另一个数组剩下的元素填充到nums1的开头。

        int i = m -1;//数组1，的元素指针（索引）
        int j = n -1;//数组2，的元素指针（索引）
        int index = m + n - 1;//

        while (i >= 0 && j >= 0){
            if(nums1[i] > nums2[j]){
                nums1[index --] = nums1[i --];
            }else {
                nums1[index --] = nums2[j --];
            }
        }

        while(j >= 0){
            nums1[index --] = nums2[j --];
        }
    }

}
