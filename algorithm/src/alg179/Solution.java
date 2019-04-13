package alg179;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 最大数
 * @author LaZY(李志一)
 * @create 2019-04-13 10:58
 */
public class Solution<T> {

    public static class MyCom implements Comparator<String> {
        @Override
        public int compare(String a, String b) {
            return (a + b).compareTo(b + a);
        }
    }
        public String largestNumber(int[] nums) {
            if (nums == null || nums.length == 0) {
                return null;
            }
            String strings[] = new String[nums.length];
            for (int i = 0; i < nums.length; i++) {
                strings[i] = Integer.toString(nums[i]);
            }
            Arrays.sort(strings, new MyCom());
            String res = "";
            for (int i = strings.length-1; i >=0; i--) {
                if(strings[i].equals("0") && res.equals("0")){
                    continue;
                }
                res += strings[i];
            }
            return res;
        }
}


