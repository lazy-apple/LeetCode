package alg122;

/**122. 买卖股票的最佳时机 II
 * @author LaZY(李志一)
 * @create 2019-05-16 10:53
 */
public class Solution {

    /***
     * 贪心算法：只要第二天的价格比今天高，就第一天买，第二天卖
     * @param prices
     * @return
     */
    public int maxProfix(int[] prices) {
        if (prices == null || prices.length == 0 || prices.length == 1) {
            return 0;
        }
        int max = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if(prices[i+1] - prices[i] > 0){
                max += prices[i + 1] - prices[i];
            }
        }
        return max;
    }



    public static void main(String[] args) {
        System.out.println(new Solution().maxProfix(new int[]{7, 1,5,3,6, 4}));
    }
}
