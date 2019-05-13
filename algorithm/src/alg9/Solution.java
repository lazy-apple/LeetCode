package alg9;

/**9. 回文数
 * @author LaZY(李志一)
 * @create 2019-05-13 8:51
 */
public class Solution {
    public static boolean isPalindrome(int x){
        if(x < 0){
            return false;
        }
        int converse = 0;//反转数
        int ini = x;//保存原始数

        while (x != 0){
            int num = x % 10;
            converse = converse * 10 + num;
            x /= 10;
        }

        return converse == ini ? true : false;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
    }
}
