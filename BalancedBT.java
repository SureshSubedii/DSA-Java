/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
// 110. Balanced Binary Tree
class BalancedBT {
    public int findHeight(TreeNode root){
        if(root == null) return 0;

        int left = findHeight(root.left);
        int right = findHeight(root.right);

        if(left == -1 || right == -1) return -1;

        if(Math.abs(left - right) > 1) return -1;

        return left > right? left + 1: right + 1;
    }
    public boolean isBalanced(TreeNode root) {
        return findHeight(root) != -1;

        
    }
}
