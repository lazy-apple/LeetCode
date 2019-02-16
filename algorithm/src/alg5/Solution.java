package alg5;

/**
 * 题目：
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 * 示例 1：
 *
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 *
 * 输入: "cbbd"
 * 输出: "bb"
 * @author LaZY(李志一)
 * @create 2019-02-16 9:42
 */
public class Solution {
    /***
     * 暴力法：
     * 1.遍历所有子串：双for循环；
     * 2.验证回文：从子串两头向中间缩；
     * 3.是回文，则比较子串长度。
     * @return
     */
    public static String longestPalindrome(String s){
        if (s.isEmpty())return null;
        if (s.length()==1)return s;
        int start = 0;//结果子串起始坐标;
        int maxlenth = 0;//结果子串的长度；
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length() ; j++) {//双for循环：遍历所有子串

                for (int ksta = i,kend = j; ksta <kend ; ksta++,kend--) {//ksta:子串的起始坐标，kend：子串的末尾坐标
                    if (s.charAt(ksta) != s.charAt(kend)){
                        break;
                    }
                    if (maxlenth<j-i+1){
                        maxlenth = j-i+1;
                        start = i;
                    }
                }
            }
        }
        return s.substring(start,start+maxlenth);
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));//0,3
        System.out.println(longestPalindrome("cbbd"));//1,2
    }
}
