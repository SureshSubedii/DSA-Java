// 235. Lowest Common Ancestor of a Binary Search Tree
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class LCA {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return findLcaNode(root, p, q);
    }

    public TreeNode findLcaNode(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q)
            return root;

        TreeNode left = findLcaNode(root.left, p, q);
        TreeNode right = findLcaNode(root.right, p, q);

        if (left != null && right != null)
            return root;

        return (left != null) ? left : right;
    }
}
