package alg43;

/**字符串相乘
 * 步骤：
 *  1.验证长度；
 *  2.获取理想结果长度；
 *  3.双for循环：从低位模拟乘法；
 *  4.每一位的结果进行保存；
 *  5.去（头）零
 *  6.输出结果
 * @author LaZY(李志一)
 * @create 2019-03-11 10:04
 */
public class Solution {

    public String multiply(String num1, String num2) {

        int n1 = num1.length()-1;
        int n2 = num2.length()-1;
        if(n1 < 0 || n2 < 0) return "";//验证字符串
        int[] mul = new int[n1+n2+2];//+2：因为上上步中，n1和n2都已经-1

        for(int i = n1; i >= 0; --i) {
            for(int j = n2; j >= 0; --j) {//模拟乘法，从低位开始算
                int bitmul = (num1.charAt(i)-'0') * (num2.charAt(j)-'0');
                bitmul += mul[i+j+1]; // 先加低位判断是否有新的进位
                mul[i+j] += bitmul / 10;
                mul[i+j+1] = bitmul % 10;//不用+=：高位在上上步已经累加
            }
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        // 去掉前导0，因为结果长度可能没达到理想长度，所以最终结果要去掉开头的0
        while(i < mul.length-1 && mul[i] == 0)
            i++;
        for(; i < mul.length; ++i)
            sb.append(mul[i]);
        return sb.toString();
    }
}
