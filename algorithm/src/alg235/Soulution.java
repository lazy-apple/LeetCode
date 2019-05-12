package alg235;

/**二叉树最近公共祖先
 * @author LaZY(李志一)
 * @create 2019-05-12 12:16
 */
public class Soulution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(p.val > q.val){
            return lca(root, q, p);
        }else{
            return lca(root, p, q);
        }
    }

    public TreeNode lca(TreeNode root, TreeNode small, TreeNode large){
        if(root.val < small.val){
            return lca(root.right, small, large);
        }else if(root.val > large.val){
            return lca(root.left, small, large);
        }
        return root;
    }

}
