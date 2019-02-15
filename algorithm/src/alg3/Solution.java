package alg3;

import java.util.HashSet;
import java.util.Set;

/**
 * 问题：
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * @author LaZY(李志一)
 * @create 2019-02-15 8:49
 */
public class Solution {
    /***
     * 暴力法：使用双层for循环，遍历所有子序列
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s){
        int len = 0;//最长子串的长度
        int length = s.length();//字符串长度
        for (int i = 0; i < length; i++) {//i:起始点
            for (int j = i+1; j <=length ; j++) {//j：结束点
                if (allUnque(s, i, j)){
                    len = Math.max(len,j-i);//j-i:当前子串长度，不加1的原因：i从0开始
                }
            }
        }
        return len;
    }

    /***
     * 用于检查子串中是否有重复字符
     * @param s 子串
     * @param start 检查的启示点
     * @param end   检查的结束点
     * @return  t:无重复
     */
    public static boolean allUnque(String s,int start,int end){
        Set<Character> set = new HashSet<Character>();
        for (int i = start; i < end ; i++) {
            char c = s.charAt(i);
            if (set.contains(c)){
                return false;
            }
            set.add(c);
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }
}
