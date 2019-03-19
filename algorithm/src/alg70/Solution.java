package alg70;

/**
 * 题目描述：
 *
 * 假设你正在爬楼梯。需要 n 步你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * 注意：给定 n 是一个正整数。
 *
 * 这道题目实际上跟斐波那契数列非常相似，假设梯子有n层，那么如何爬到第n层呢，
 * 因为每次只能爬1或2步，那么爬到第n层的方法要么是从第n-1层一步上来的，要不就是从n-2层2步上来的，
 * 所以递推公式非常容易的就得出了：dp[n] = dp[n-1] + dp[n-2]。
 * @author LaZY(李志一)
 * @create 2019-03-19 10:12
 */
public class Solution {
    public int climbStairs(int n){
        if(n<1){
            return 0;
        }
        if (n==1){
            return 1;
        }
        if(n==2){
            return 2;
        }
        int arr[] = new int[n];
        arr[0] = 1;
        arr[1] = 2;
        for (int i = 2; i < n; i++) {
            arr[i] = arr[i-1] + arr[i-2];
        }
        return arr[n-1];
    }

}
