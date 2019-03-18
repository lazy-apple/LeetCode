package alg62;

/**题目：
 *
 * 机器人位于一个 m x n 网格的左上角, 在下图中标记为“Start” (开始)。

 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角，在下图中标记为“Finish”(结束)。

 问有多少条不同的路径？

 例如，上图是一个3 x 7网格。有多少可能的路径？

 注意: m 和 n 的值均不超过 100。
 * @author LaZY(李志一)
 * @create 2019-03-18 10:12
 */
public class Solution {
    public int uniquePaths(int m,int n){
        if(m<=0 || n<0 || m>100 || n>100){
           return 0;
        }
        int fun[][] = new int[m][n];//每一个点存放到这个点的路径数【m-1】【n-1】为最终结果
        for (int i = 0; i < m; i++) {
            fun[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            fun[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {//公式：ways[i][j] = ways[i-1][j] + ways[i][j-1];
            for (int j = 1; j < n; j++) {
                fun[i][j] = fun[i-1][j] + fun[i][j-1];
            }
        }
        return fun[m-1][n-1];
    }
}
