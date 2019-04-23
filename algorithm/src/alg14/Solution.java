package alg14;

/**LeetCode14.最长公共前缀
 * @author LaZY(李志一)
 * @create 2019-04-23 10:22
 */
public class Solution {
    public String longestCommonPrefix(String[] strs){
        if(strs == null || strs.length == 0){
            return "";
        }
        return longestCommonPrefix(strs,0,strs.length - 1);
    }
    public String longestCommonPrefix(String[] strs,int left,int right){
        if(left == right){
            return strs[left];
        }
        int mid = left + ((right - left) >> 1);
        String s1 = longestCommonPrefix(strs,left,mid);
        String s2 = longestCommonPrefix(strs,mid + 1,right);
        return merge(s1,s2);
    }

    private String merge(String s1, String s2) {
        int min = Math.min(s1.length(),s2.length());
        for (int i = 0; i < min; i++) {
            if(s1.charAt(i) != s2.charAt(i)){
                return s1.substring(0,i);
            }
        }
        return s1.substring(0,min);
    }
}
