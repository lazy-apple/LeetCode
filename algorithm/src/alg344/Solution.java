package alg344;

/**
 * 字符串反转
 * @author LaZY(李志一)
 * @create 2019-04-16 13:25
 */
public class Solution {
    public void reverseString(char[] s){
        if(s == null || s.length == 0){
            return;
        }
        int i = 0;int j = s.length - 1;
        for (; i < s.length && j >= 0;) {
                if(i>=j){
                    return;
                }
                char t = s [i];
                s[i] = s[j];
                s[j] = t;
                i ++;
                j --;
        }
    }

    public static void main(String[] args) {
        new Solution().reverseString(new char[]{'h','e','l','l','o'});
    }
}
