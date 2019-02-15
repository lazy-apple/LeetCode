package alg3;

import java.util.HashSet;
import java.util.Set;

/**滑动窗口法
 * @author LaZY(李志一)
 * @create 2019-02-15 16:16
 */
public class Solution2 {
    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0,i = 0,j = 0;
        while(i < n && j < n){
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));//注意j++问题
                ans = Math.max(ans,j - i);
            }else {
                set.remove(s.charAt(i++));
                //当发现重复字符，截止当前位置子串已达到最大位置，
                // 需要改变起始位置来发现新的子串
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abccdb"));
    }
}
