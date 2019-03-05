package alg8;

/**
 * 题目：字符串转整数
 * @author LaZY(李志一)
 * @create 2019-03-05 9:04
 */
public class Solution {
    public int myAtoi(String str){
        //检查空串
        if (str.length()<0){
            return 0;
        }
        //过滤空格
        int index = 0;
        while(index < str.length() && (str.charAt(index)) == ' '){
            index ++;
        }
        //过滤后的字符串
        str = str.substring(index,str.length());
        //过滤后可能为空串
        if ("".equals(str)){
            return 0;
        }

        boolean symbol = true;//t:正号 f:负号

        //检查开头是否为有效字符,并截取有效字符串
        char first = str.charAt(0);
        if(first < '0' || first > '9'){
            if (first != '+' && first != '-'){
                return 0;
            }
            if (first == '-'){
                symbol = false;
                str = getNumStr(str.substring(1,str.length()));
            }
            if (first == '+'){
                symbol = true;
                str = getNumStr(str.substring(1,str.length()));
            }
        }else {
            str = getNumStr(str);
        }
        //过滤数据部分为空串的情况（截取后为空串）
        if ("".equals(str)) {
            return 0;
        }

        //先转化为long，因为直接转成int会直接改变结果，且不能发现

        //过滤掉数据超出long的情况
        if (str.length() > 10) {
            if (symbol) {
                return Integer.MAX_VALUE;
            } else {
                return Integer.MIN_VALUE;
            }
        }

        //转化数值
        long num = Long.parseLong(str);
        if (!symbol) {
            num = -num;
        }

        //根据结果范围返回数值
        if (num < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        if (num > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }

        return (int) num;
    }
    /**
     * 截取字符串的开头数值
     *
     * @param s 字符串
     * @return 数值字符串
     */
    private String getNumStr(String s) {
        StringBuilder num = new StringBuilder();
        boolean isStart = true;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                if (isStart && s.charAt(i) == '0') {
                    continue;
                }
                isStart = false;
                num.append(s.charAt(i));
            } else {
                break;
            }
        }

        return num.toString();
    }

    public static void main(String[] args) {
        new Solution().myAtoi("");
    }
}
