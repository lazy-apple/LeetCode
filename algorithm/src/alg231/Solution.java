package alg231;

/**
 * @author LaZY(李志一)
 * @create 2019-04-16 8:35
 */
public class Solution {
    public static boolean isPowerOfTwo(int n) {
        if(n == 1){
            return true;
        }
        if(n < 1){
            return false;
        }
        if(n % 2 > 0){
            return false;
        }
        n = n >> 1;
        return isPowerOfTwo(n);
    }
    public static boolean isPowerOfTwo2(int n) {
        if(n < 0 || n == 0){
            return false;
        }
        return (n & (n - 1)) == 0;
    }


    public static void main(String[] args) {
        System.out.println(isPowerOfTwo2(16));
    }
}