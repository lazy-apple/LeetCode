package alg78;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LaZY(李志一)
 * @create 2019-05-22 13:44
 */
public class Solution {
    int[] nums;
    List<List<Integer>> result;
    public void find(int index,List<Integer> last){
        if(index>=nums.length)
            return ;
        ArrayList<Integer> item=new ArrayList<Integer>();
        item.addAll(last);
        item.add(nums[index]);
        result.add(item);
        find(index+1,last);
        find(index+1,item);


    }
    public List<List<Integer>> subsets(int[] nums) {

        this.nums=nums;
        this.result=new ArrayList<List<Integer>>();
        int i=0;
        ArrayList<Integer> tmp=new ArrayList<Integer>();
        result.add(tmp);
        find(i,tmp);
        return result;


    }

    public static void main(String[] args) {
        for (List<Integer> subset : new Solution().subsets(new int[]{1, 2, 3})) {
            for (Integer integer : subset) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }
}
