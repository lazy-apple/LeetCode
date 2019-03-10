package alg236;

/**
 * 二叉树的最近公共祖先
 * @author LaZY(李志一)
 * @create 2019-03-10 11:09
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left == null && right == null) return null;
        else if(left != null && right != null)return root;
        else return left == null ? right : left ;
    }


}
