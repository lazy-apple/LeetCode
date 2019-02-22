package alg7;

/**给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。

 示例 1:

 输入: 123
 输出: 321
 示例 2:

 输入: -123
 输出: -321
 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 * @author LaZY(李志一)
 * @create 2019-02-22 12:41
 */
public class Soulution {
    public int reverse(int x){
        int rev = 0;
        while(x != 0){
            int pop = x % 10;
            x = x / 10;//取x的最后一位，并让x缩小10倍（用于取前一位）
            //判断溢出
            if(rev > Integer.MAX_VALUE/10 || rev == Integer.MAX_VALUE/10 && pop > 7){
                return 0;
            }
            if(rev < Integer.MIN_VALUE/10 || rev == Integer.MIN_VALUE/10 && pop < -8){
                return 0;
            }
            int temp = pop * 10 + rev;
            rev = temp;//累加
        }
        return rev;
    }
}
