package alg122;

/**
 * @author LaZY(李志一)
 * @create 2019-05-16 12:52
 */
public class Soulution {
    public int maxProfix(int[] prices) {
        if (prices == null || prices.length == 0 || prices.length == 1) {
            return 0;
        }

        int[][] dp = new int[prices.length][2];
        dp[0][0] = 0;
        dp[0][1] = -7;
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[prices.length - 1][0];
    }

    public static void main(String[] args) {
        System.out.println(new Soulution().maxProfix(new int[]{7, 1, 5, 3, 6, 4}));
    }
}
