package alg230;

/**
 * @author LaZY(李志一)
 * @create 2019-04-24 9:19
 */
 class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x){val = x;}
}

/***
 * 二叉搜索树中第K小的元素
 * 题目分析：
 * 二叉搜索树特点：左孩子值小于根节点，根节点值小于右孩子。
 * 那么树中最小节点一定是根节点最左边孩子。
 *
 * 思路：
 * 如果根节点的左子树数量为k-1，那么第k小的为根节点。
 * 如果根节点左子树的数量大于k-1，说明第k小的节点在左子树中，使用递归，查找其左子树。
 * 如果根节点左子树的数量小于k-1,说明第k小的节点在右子树中，使用递归，查找右子树。
 *  但是要查找的是在右子树中第[k-根节点的左子树节点数-1]小的节点。
 */
public class Solution {


    /***
     * 返回第k小的值。
     * @param root
     * @param k
     * @return
     */
    public int kthSmallest(TreeNode root,int k){
        int count = calculate(root.left);
        if(count == k - 1){return root.val;}
        if(count > k - 1){return kthSmallest(root.left,k);}
//      if (count < k - 1){return kthSmallest(root.right,k - count - 1);}
        else {return kthSmallest(root.right,k - count - 1);}
    }

    /***
     * 计算当前树中的节点个数=根节点 + 左子树节点数 + 右子树节点数
     * @param root
     * @return 当前节点为根节点的树的所有节点的个数
     */
    public int calculate(TreeNode root){
        if(root == null){
            return 0;
        }
        return 1 + calculate(root.left) + calculate(root.right);
    }

}
