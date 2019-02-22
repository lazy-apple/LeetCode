package alg5;

/**
 * @author LaZY(李志一)
 * @create 2019-02-16 10:42
 */
public class Solution2 {
    /***
     * 动态规划法：
     *  公式：如果子串是回文，那么子串的子串也是回文。求所有字符个数的回文子串长度，最终为最长回文子串长度。
     *  步骤：  1.初始化1个字符的回文子串，标识为1，放入备忘表；
     *          2.求从2到长度，的回文子串长度，并放入备忘表。
     *              先检验两端是否相等，再从备忘表中检验子串是否为回文子串。
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {

        if (s == null || s.length() < 2) {
            return s;
        }

        int maxLength = 0;
        String longest = null;

        int length = s.length();
        boolean[][] table = new boolean[length][length];

        // 单个字符都是回文
        for (int i = 0; i < length; i++) {
            table[i][i] = true;
            longest = s.substring(i, i+1);
            maxLength = 1;
        }

        // 判断两个字符是否是回文
        for (int i = 0; i < length - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                table[i][i+1] = true;
                longest = s.substring(i, i + 2);
                maxLength = 2;
            }
        }

        // 求长度大于2的字串是否是回文串
        for (int len = 3; len <= length; len++) {
            for (int i = 0, j; (j = i + len - 1) <= length - 1; i++) {
                if (s.charAt(i) == s.charAt(j)) {
                    table[i][j] = table[i + 1][j - 1];
                    if(table[i][j] && maxLength < len) {
                        longest = s.substring(i, j + 1);
                        maxLength = len;
                    }
                }else {
                    table[i][j] = false;
                }
            }
        }

        return longest;
    }

}
