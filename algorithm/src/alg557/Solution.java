package alg557;

/**
 * @author LaZY(李志一)
 * @create 2019-04-17 10:10
 */
public class Solution {
    public String reverseWords(String s){
        if(s == null ){
            return null;
        }
        String res = "";
        String[] words = s.split(" ");
        for (int i = 0; i < words.length; i++) {
         res = res + new String(change(words[i].toCharArray()));
         if(i == words.length - 1){
             continue;
         }
         res +=  " ";
        }
        return res;
    }

    public char[] change(char[] word){
        int i = 0;int j = word.length - 1;
        for (; i < word.length && j >= 0;) {
            if(i>=j){
                return word;
            }
            char t = word [i];
            word[i] = word[j];
            word[j] = t;
            i ++;
            j --;
        }
        return word;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().reverseWords(""));
    }
}
