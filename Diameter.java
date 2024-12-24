//  Definition for a binary tree node.
//  public class TreeNode {
//  int val;
//  TreeNode left;
//  TreeNode right;
//  TreeNode() {}
//  TreeNode(int val) { this.val = val; }
//  TreeNode(int val, TreeNode left, TreeNode right) {
//  this.val = val;
//  this.left = left;
//  this.right = right;
//  }
//  }

//543. Diameter of Binary Tree
class Diameter {
    private int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        traverseTree(root);
        return max;

    }

    public int traverseTree(TreeNode root) {
        if (root == null)
            return 0;

        int left = traverseTree(root.left);
        int right = traverseTree(root.right);

        int returnValue = right;
        if (left > right) {
            returnValue = left;
        }

        int sum = left + right;
        if (sum > max)
            max = sum;

        return returnValue + 1;

    }
}