package alg121;

/**
 * 121. 买卖股票的最佳时机
 * @author LaZY(李志一)
 * @create 2019-03-19 10:52
 */
public class Soulution {
    public int maxProfit(int[] prices){
        int max = 0;
        if (prices == null || prices.length<=1){
            return 0;
        }
        for (int i = 0; i < prices.length; i++) {
            for (int j = i+1; j < prices.length; j++) {
                int mon = prices[j]-prices[i];
               max = max > mon ? max: mon;
            }
        }
        return max;
    }
    public int maxProfit2(int[] prices){
        if (prices == null || prices.length<=1){
            return 0;
        }
        int a[][]= new int[prices.length][2];
        a[0][0] = 0;//第i天获得的最高利润
        a[0][1] = prices[0];//前i天最低价
        for (int i = 1; i < prices.length; i++) {
            a[i][0] = Math.max(a[i-1][0],prices[i]-a[i-1][1]);
            a[i][1] = Math.min(a[i-1][1],prices[i]);
        }
        return a[prices.length-1][0];
    }

}
